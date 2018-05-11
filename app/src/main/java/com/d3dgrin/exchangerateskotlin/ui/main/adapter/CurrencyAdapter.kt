package com.d3dgrin.exchangerateskotlin.ui.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.d3dgrin.exchangerateskotlin.R
import com.d3dgrin.exchangerateskotlin.data.CurrencyData
import kotlinx.android.synthetic.main.currency_card.view.*

class CurrencyAdapter : RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {

    private var currencies: List<CurrencyData> = emptyList()

    fun setCurrencies(currencies: List<CurrencyData>) {
        this.currencies = currencies
        notifyDataSetChanged()
    }

    fun getCurrencies(): List<CurrencyData> = currencies

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.currency_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = currencies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currencies[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(currency: CurrencyData) {
            itemView.tv_ccy.text = currency.ccy
            itemView.tv_buy.text = currency.buy
            itemView.tv_sale.text = currency.sale
        }
    }
}