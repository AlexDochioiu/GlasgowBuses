package com.github.alexdochioiu.buseslogic.networking

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by Alexandru Iustin Dochioiu on 6/30/2018
 */
@Module
class BusesNetworkModule {
    @Provides
    @BusesNetworkScope
    internal fun retrofitClient(retrofit: Retrofit): BusesRetrofitClient {
        return retrofit.create(BusesRetrofitClient::class.java)
    }
}