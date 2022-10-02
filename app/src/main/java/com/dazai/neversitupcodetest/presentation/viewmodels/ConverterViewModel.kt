package com.dazai.neversitupcodetest.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dazai.neversitupcodetest.domain.repositories.MainRepository
import com.dazai.neversitupcodetest.presentation.screens.CurrencyConverterScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConverterViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val _state = MutableStateFlow(CurrencyConverterScreen())

    val state : StateFlow<CurrencyConverterScreen>
    get() = _state

    init {
        loadLatestCurrency()
    }

    fun loadLatestCurrency(){
        viewModelScope.launch {
          repository.getLastRecord().also { history ->
              _state.update {
                  it.copy(currencies = listOf(history.eur, history.gbp, history.usd))
              }
          }
        }
    }

}