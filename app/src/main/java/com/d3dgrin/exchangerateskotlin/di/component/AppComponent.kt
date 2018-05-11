package com.d3dgrin.exchangerateskotlin.di.component

import com.d3dgrin.exchangerateskotlin.di.module.AppModule
import com.d3dgrin.exchangerateskotlin.di.module.MvpModule
import com.d3dgrin.exchangerateskotlin.di.module.NetModule
import com.d3dgrin.exchangerateskotlin.ui.main.MainActivity
import com.d3dgrin.exchangerateskotlin.ui.main.MainPresenterImpl
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class, MvpModule::class, NetModule::class])
@Singleton
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenterImpl: MainPresenterImpl)
}