package com.chintan.forecastapp.remote

import android.util.Log
import com.chintan.forecastapp.utils.TAG
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteHelper @Inject constructor(private val internetHelper: InternetHelper) {

    suspend fun <T> call(request: suspend () -> T): Flow<Resource<T>> {
        return flow {
            if (internetHelper.isOnline) {
                try {
                    emit(Resource.Loading)
                    val response = request.invoke()
                    emit(Resource.Success(response))
                } catch (e: Exception) {
                    Log.e(TAG, e.message.toString())
                    emit(Resource.Error(e))
                }
            } else {
                emit(Resource.Error(NoInternetException))
            }
        }.flowOn(Dispatchers.IO)
    }

}