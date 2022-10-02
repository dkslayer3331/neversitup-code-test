package com.dazai.neversitupcodetest

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.dazai.neversitupcodetest.databinding.ActivityMainBinding
import com.dazai.neversitupcodetest.presentation.adapters.HistoryAdapter
import com.dazai.neversitupcodetest.presentation.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    private val  viewModel by viewModels<MainViewModel>()

    private val adapter: HistoryAdapter by lazy {
        HistoryAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvHistories.adapter = adapter

        viewModel.loadHistories()

        binding.btnConverter.setOnClickListener {
            startActivity(ConverterActivity.onNewIntent(this))
        }

        lifecycleScope.launchWhenStarted {
            viewModel.state.collect{
                binding.progressIndicator.isVisible = it.isLoading
                binding.tvError.isVisible = it.error != null
                it.error?.let {
                    binding.tvError.text = it
                }
                if(it.data.isNotEmpty()){
                    Log.d("listSize","${it.data.size}")
                    binding.rvHistories.visibility = View.VISIBLE
                    adapter.submitList(it.data)
                }
                else{
                    binding.rvHistories.visibility = View.GONE
                }
            }
        }


    }
}