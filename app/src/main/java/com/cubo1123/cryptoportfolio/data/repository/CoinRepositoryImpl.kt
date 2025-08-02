package com.cubo1123.cryptoportfolio.data.repository

import com.cubo1123.cryptoportfolio.data.remote.CoinPaprikaApi
import com.cubo1123.cryptoportfolio.domain.repository.CoinRepository
import com.cubo1123.cryptoportfolio.data.remote.dto.CoinDetailDto
import com.cubo1123.cryptoportfolio.data.remote.dto.CoinDto
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api : CoinPaprikaApi) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}