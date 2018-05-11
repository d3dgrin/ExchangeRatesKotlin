package com.d3dgrin.exchangerateskotlin.ui.main

import com.d3dgrin.exchangerateskotlin.ui.base.BasePresenter

interface MainPresenter : BasePresenter<MainView> {
    fun setCurrencies()
}