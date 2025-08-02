package com.cubo1123.cryptoportfolio.presentation.coin_detail

import com.cubo1123.cryptoportfolio.domain.model.Coin
import com.cubo1123.cryptoportfolio.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
