package com.github.alexdochioiu.glasgowbusses

import android.app.Application
import android.content.Context
import com.jeefo.android.jeefologger.JeefoLogger
import com.jeefo.android.jeefologger.LazyLogger
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Qualifier
import javax.inject.Scope

/**
 * Created by Alexandru Iustin Dochioiu on 6/29/2018
 */
class MyApplication : Application() {
    @Inject
    lateinit var context: @ApplicationContext Context;

    lateinit var daggerComponent: MyApplicationComponent
    private set

    override fun onCreate() {
        super.onCreate()

        daggerComponent = DaggerMyApplication_MyApplicationComponent.builder()
                .myApplicationModule(MyApplicationModule(applicationContext))
                .build();

        daggerComponent.inject(this)

        JeefoLogger.initLazyLogger(context)

        LazyLogger.Info("Context is %s", context);

    }

    @Target(AnnotationTarget.TYPE)
    @Qualifier
    annotation class ApplicationContext

    @Scope
    annotation class MyApplicationScope

    @Module
    class MyApplicationModule constructor(private val context: @ApplicationContext Context) {
        @Provides
        fun context(): @ApplicationContext Context {
            return context;
        }
    }

    @MyApplicationScope
    @Component(modules = [MyApplicationModule::class])
    interface MyApplicationComponent {
        fun inject(app: MyApplication)
    }
}