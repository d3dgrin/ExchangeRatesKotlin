package com.d3dgrin.exchangerateskotlin.ui.base

interface BasePresenter<V> {
    fun attachView(baseView: V)
    fun detachView()
}