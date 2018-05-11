package com.d3dgrin.exchangerateskotlin

import android.app.Application
import com.d3dgrin.exchangerateskotlin.di.component.AppComponent
import com.d3dgrin.exchangerateskotlin.di.component.DaggerAppComponent
import com.d3dgrin.exchangerateskotlin.di.module.AppModule
import com.d3dgrin.exchangerateskotlin.di.module.NetModule

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .netModule(NetModule("https://api.privatbank.ua/p24api/"))
                .build()
    }
}