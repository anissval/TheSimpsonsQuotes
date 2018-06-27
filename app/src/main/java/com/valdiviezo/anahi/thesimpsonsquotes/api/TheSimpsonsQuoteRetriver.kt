package com.valdiviezo.anahi.thesimpsonsquotes.api

import com.valdiviezo.anahi.thesimpsonsquotes.model.TheSimpsonsQuote
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Anahi Valdiviezo
 */
class TheSimpsonsQuoteRetriver {

    val service : TheSimpsonsQuoteAPI

    init {
        val retrofit = Retrofit.Builder().baseUrl("https://thesimpsonsquoteapi.glitch.me/").addConverterFactory(GsonConverterFactory.create()).build()
        service = retrofit.create(TheSimpsonsQuoteAPI::class.java)
    }

    fun getTheSimpsonsRandomQuote (callback : Callback<List<TheSimpsonsQuote>>) {
        val call = service.getTheSimpsonsRandomQuote()
        call.enqueue(callback)
    }

    fun getTheSimpsonsQuotesList (callback: Callback<List<TheSimpsonsQuote>>){
        val call = service.getTheSimpsonsQuotesList()
        call.enqueue(callback)
    }
}