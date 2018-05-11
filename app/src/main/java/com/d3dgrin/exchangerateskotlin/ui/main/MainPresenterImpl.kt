package com.d3dgrin.exchangerateskotlin.ui.main

import com.d3dgrin.exchangerateskotlin.App
import com.d3dgrin.exchangerateskotlin.network.Privat24Api
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenterImpl : MainPresenter {

    @Inject
    lateinit var privat24Api: Privat24Api

    var view: MainView? = null

    init {
        App.appComponent.inject(this)
    }

    override fun attachView(baseView: MainView) {
        view = baseView
    }

    override fun detachView() {
        view = null
    }

    override fun setCurrencies() {
        view?.showLoading()
        privat24Api.getCurrencies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            view?.hideLoading()
                            view?.setCurrencies(it)
                        },
                        {
                            view?.hideLoading()
                            view?.showError("No internet connection")
                        }
                        )
    }
}