package com.dazai.neversitupcodetest.presentation.screens

import com.dazai.neversitupcodetest.domain.models.History

data class MainScreenState(
    val data: List<History> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)