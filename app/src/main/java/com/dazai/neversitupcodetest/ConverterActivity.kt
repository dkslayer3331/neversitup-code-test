package com.dazai.neversitupcodetest

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.dazai.neversitupcodetest.databinding.ActivityConverterBinding
import com.dazai.neversitupcodetest.presentation.viewmodels.ConverterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConverterActivity : AppCompatActivity() {

    lateinit var binding : ActivityConverterBinding

    private val viewModel by viewModels<ConverterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConverterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object{
        fun onNewIntent(context: Context) : Intent{
            return Intent(context, ConverterActivity::class.java)
        }
    }

}