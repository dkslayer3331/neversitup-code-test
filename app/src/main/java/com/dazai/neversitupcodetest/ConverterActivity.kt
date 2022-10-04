package com.dazai.neversitupcodetest

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.activity.viewModels
import androidx.annotation.CheckResult
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.lifecycleScope
import com.dazai.neversitupcodetest.databinding.ActivityConverterBinding
import com.dazai.neversitupcodetest.presentation.SealedCurrency
import com.dazai.neversitupcodetest.presentation.viewmodels.ConverterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*

@AndroidEntryPoint
class ConverterActivity : AppCompatActivity() {

    lateinit var binding: ActivityConverterBinding

    private val viewModel by viewModels<ConverterViewModel>()

    lateinit var arrayAdapter: ArrayAdapter<String>

    var selectedAdapterItem = ""

    private fun getLatestPrice() {
        val handler = Handler(Looper.getMainLooper())
        val runnable: Runnable = object : Runnable {
            override fun run() {
                viewModel.getHistories()
                handler.postDelayed(this, 60000)
            }
        }
        handler.postDelayed(runnable, 60000)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConverterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        arrayAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayListOf<String>())

        binding.tvCurrency.setAdapter(arrayAdapter)

        getLatestPrice()

        lifecycleScope.launchWhenStarted {
            viewModel.state.collect {
                if (it.convertedAmount > 0) {
                    binding.tvBTCAmount.text =
                        getString(R.string.converted_btc_amount, it.convertedAmount)
                }
                if (it.currencies.isNotEmpty()) {
                    arrayAdapter.clear()
                    arrayAdapter.addAll(it.currencies)
                    arrayAdapter.notifyDataSetChanged()
                }
            }
        }

        binding.tvCurrency.setOnItemClickListener { adapterView, view, position, id ->
            selectedAdapterItem = adapterView.getItemAtPosition(position) as String
            viewModel.convert(
                binding.etInput.text.toString(),
                SealedCurrency.toSealedClass(selectedAdapterItem)
            )
        }

        binding.etInput.textChanges().debounce(300)
            .onEach {
                viewModel.convert(
                    it.toString(),
                    SealedCurrency.toSealedClass(selectedAdapterItem)
                )
            }
            .launchIn(lifecycleScope)

    }

    companion object {
        fun onNewIntent(context: Context): Intent {
            return Intent(context, ConverterActivity::class.java)
        }
    }

}

@ExperimentalCoroutinesApi
@CheckResult
fun EditText.textChanges(): Flow<CharSequence?> {
    return callbackFlow {
        val listener = doOnTextChanged { text, _, _, _ -> trySend(text) }
        awaitClose { removeTextChangedListener(listener) }
    }.onStart { emit(text) }
}