package com.cubo1123.cryptoportfolio.domain.use_case.get_coins

import com.cubo1123.cryptoportfolio.common.Resource
import com.cubo1123.cryptoportfolio.data.remote.dto.toCoin
import com.cubo1123.cryptoportfolio.domain.model.Coin
import com.cubo1123.cryptoportfolio.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsUseCase@Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        }catch (e : HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error ocurred"))
        }catch (e: IOException){
            emit((Resource.Error("Couldnt reach server. Check your internet connection")))
        }
    }
}