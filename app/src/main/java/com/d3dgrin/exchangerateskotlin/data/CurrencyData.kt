package com.d3dgrin.exchangerateskotlin.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CurrencyData(@SerializedName("ccy")
                        @Expose
                        val ccy: String,
                        @SerializedName("base_ccy")
                        @Expose
                        val baseCcy: String,
                        @SerializedName("buy")
                        @Expose
                        val buy: String,
                        @SerializedName("sale")
                        @Expose
                        val sale: String)