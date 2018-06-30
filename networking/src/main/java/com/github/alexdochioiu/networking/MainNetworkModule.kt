package com.github.alexdochioiu.networking

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jaxb.JaxbConverterFactory

/**
 * Created by Alexandru Iustin Dochioiu on 6/30/2018
 */
@Module
class MainNetworkModule {
    @Provides
    @MainNetworkScope
    internal fun retrofit(converterFactory: JaxbConverterFactory): Retrofit {
        return Retrofit.Builder().addConverterFactory(converterFactory).build()
    }

    @Provides
    @MainNetworkScope
    internal fun xmlConvertor(): JaxbConverterFactory {
        return JaxbConverterFactory.create()
    }

    @Provides
    @MainNetworkScope
    internal fun okHttpClient(): OkHttpClient {
        return OkHttpClient()
    }
}