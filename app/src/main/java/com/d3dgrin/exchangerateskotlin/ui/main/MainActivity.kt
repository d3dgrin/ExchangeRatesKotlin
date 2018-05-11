package com.d3dgrin.exchangerateskotlin.ui.main

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.d3dgrin.exchangerateskotlin.App
import com.d3dgrin.exchangerateskotlin.R
import com.d3dgrin.exchangerateskotlin.data.CurrencyData
import com.d3dgrin.exchangerateskotlin.ui.main.adapter.CurrencyAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject
import com.google.gson.reflect.TypeToken



class MainActivity : AppCompatActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    private var adapter: CurrencyAdapter = CurrencyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        App.appComponent.inject(this)

        rv_currencies.layoutManager = LinearLayoutManager(this)
        rv_currencies.hasFixedSize()
        rv_currencies.adapter = adapter

        presenter.attachView(this)

        if(savedInstanceState != null) {
            val currencies: String? = savedInstanceState.getString("currencies")
            val token = object : TypeToken<List<CurrencyData>>() {}.type
            adapter.setCurrencies(Gson().fromJson(currencies, token))
        }
        else {
            presenter.setCurrencies()
        }

        fab.setOnClickListener { presenter.setCurrencies() }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        val currency: String = Gson().toJson(adapter.getCurrencies())
        outState?.putString("currencies", currency)
    }

    override fun showLoading() {
        rv_currencies.visibility = View.GONE
        fab.visibility = View.GONE
        pb_loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        rv_currencies.visibility = View.VISIBLE
        fab.visibility = View.VISIBLE
        pb_loading.visibility = View.GONE
    }

    override fun showError(msg: String) {
        Snackbar.make(fab, msg, Snackbar.LENGTH_LONG).show()
    }

    override fun setCurrencies(currencies: List<CurrencyData>) {
        adapter.setCurrencies(currencies)
    }

}
