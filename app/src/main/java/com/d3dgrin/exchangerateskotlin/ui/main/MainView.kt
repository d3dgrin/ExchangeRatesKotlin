package com.d3dgrin.exchangerateskotlin.ui.main

import com.d3dgrin.exchangerateskotlin.data.CurrencyData

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showError(msg: String)
    fun setCurrencies(currencies: List<CurrencyData>)
}