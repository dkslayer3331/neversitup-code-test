package com.dazai.neversitupcodetest.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dazai.neversitupcodetest.domain.repositories.MainRepository
import com.dazai.neversitupcodetest.domain.usecases.CalculatorUseCase
import com.dazai.neversitupcodetest.domain.usecases.GetHistories
import com.dazai.neversitupcodetest.presentation.SealedCurrency
import com.dazai.neversitupcodetest.presentation.screens.CurrencyConverterScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConverterViewModel @Inject constructor(
    private val repository: MainRepository,
    private val calculatorUseCase: CalculatorUseCase,
    private val getHistories: GetHistories
) : ViewModel() {

    private val _state = MutableStateFlow(CurrencyConverterScreen())

    val state: StateFlow<CurrencyConverterScreen>
        get() = _state

    init {
        loadLatestCurrency()
    }

    fun getHistories(){
        viewModelScope.launch {
            getHistories()
        }
    }

    fun convert(input: String, currency: SealedCurrency?) {
        viewModelScope.launch {
            try {
                val total = calculatorUseCase.execute(input.toFloat(), currency)
                _state.update {
                    it.copy(
                        convertedAmount = total,
                        error = null
                    )
                }
            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        error = e.message
                    )
                }
            }
        }
    }

    fun loadLatestCurrency() {
        viewModelScope.launch {
            repository.getLastRecord().also { history ->
                _state.update {
                    it.copy(
                        currencies = listOf(history.eur.code, history.gbp.code, history.usd.code),
                        currencyObj = listOf(history.eur, history.gbp, history.usd)
                    )
                }
            }
        }
    }

}