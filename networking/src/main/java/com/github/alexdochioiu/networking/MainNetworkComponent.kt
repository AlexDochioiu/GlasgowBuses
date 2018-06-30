package com.github.alexdochioiu.networking

import dagger.Component
import retrofit2.Retrofit

/**
 * Created by Alexandru Iustin Dochioiu on 6/30/2018
 *
 */
@MainNetworkScope
@Component(modules = [MainNetworkModule::class])
interface MainNetworkComponent {
    fun getRetrofit(): Retrofit
}