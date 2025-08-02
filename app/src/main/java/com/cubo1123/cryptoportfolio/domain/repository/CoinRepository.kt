package com.cubo1123.cryptoportfolio.domain.repository

import com.cubo1123.cryptoportfolio.data.remote.dto.CoinDetailDto
import com.cubo1123.cryptoportfolio.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId:String) : CoinDetailDto
}