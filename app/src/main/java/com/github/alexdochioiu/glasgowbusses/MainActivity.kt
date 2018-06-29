package com.github.alexdochioiu.glasgowbusses

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import dagger.Component
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Scope

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerMainActivity_MainActivityComponent.builder()
                .myApplicationComponent((application as MyApplication).daggerComponent)
                .build()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    @Scope
    annotation class MainActivityScope

    @MainActivityScope
    @Component(dependencies = [MyApplication.MyApplicationComponent::class])
    interface MainActivityComponent{
        fun inject(mainActivity: MainActivity)
    }
}
