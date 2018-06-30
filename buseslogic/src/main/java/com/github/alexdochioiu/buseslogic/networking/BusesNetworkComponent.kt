package com.github.alexdochioiu.buseslogic.networking

import com.github.alexdochioiu.networking.MainNetworkComponent

import dagger.Component

/**
 * Created by Alexandru Iustin Dochioiu on 6/30/2018
 */
@BusesNetworkScope
@Component(dependencies = [MainNetworkComponent::class], modules = [BusesNetworkModule::class])
interface BusesNetworkComponent
