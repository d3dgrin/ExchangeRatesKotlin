package com.d3dgrin.exchangerateskotlin.network

import com.d3dgrin.exchangerateskotlin.data.CurrencyData
import io.reactivex.Observable
import retrofit2.http.GET

interface Privat24Api {
    @GET("pubinfo?json&exchange&coursid=5")
    fun getCurrencies(): Observable<List<CurrencyData>>
}