package com.cubo1123.cryptoportfolio.domain.use_case.get_coin

import com.cubo1123.cryptoportfolio.common.Resource
import com.cubo1123.cryptoportfolio.data.remote.dto.toCoin
import com.cubo1123.cryptoportfolio.data.remote.dto.toCoinDetail
import com.cubo1123.cryptoportfolio.domain.model.Coin
import com.cubo1123.cryptoportfolio.domain.model.CoinDetail
import com.cubo1123.cryptoportfolio.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase@Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        }catch (e : HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error ocurred"))
        }catch (e: IOException){
            emit((Resource.Error("Couldnt reach server. Check your internet connection")))
        }
    }
}