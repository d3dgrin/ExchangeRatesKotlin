package com.d3dgrin.exchangerateskotlin.di.module

import com.d3dgrin.exchangerateskotlin.ui.main.MainPresenter
import com.d3dgrin.exchangerateskotlin.ui.main.MainPresenterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MvpModule {

    @Provides
    @Singleton
    fun provideMainPresenter(): MainPresenter = MainPresenterImpl()
}