package com.dazai.neversitupcodetest.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import com.dazai.neversitupcodetest.domain.usecases.GetHistories
import com.dazai.neversitupcodetest.presentation.screens.MainScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getHistories: GetHistories
) : ViewModel() {
    private val _state = MutableStateFlow(MainScreenState())
    val state: StateFlow<MainScreenState>
        get() = _state.asStateFlow()

    init {
        loadHistories()
    }

    fun loadHistories() {
        viewModelScope.launch {
            _state.update {
                MainScreenState(
                    isLoading = true
                )
            }
            getHistories().catch { e ->
                _state.update {
                    MainScreenState(
                        error = e.message,
                        isLoading = false,
                        data = emptyList()
                    )
                }
            }.collect { data ->
                _state.update {
                    it.copy(
                        data = data,
                        isLoading = false,
                        error = null
                    )
                }
            }
        }
    }

}