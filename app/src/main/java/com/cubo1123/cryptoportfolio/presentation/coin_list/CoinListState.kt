package com.cubo1123.cryptoportfolio.presentation.coin_list

import com.cubo1123.cryptoportfolio.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
