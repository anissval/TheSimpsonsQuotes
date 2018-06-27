package com.valdiviezo.anahi.thesimpsonsquotes.api

import com.valdiviezo.anahi.thesimpsonsquotes.model.TheSimpsonsQuote
import retrofit2.Call
import retrofit2.http.GET

/**
 * @author Anahi Valdiviezo
 */
interface TheSimpsonsQuoteAPI {

    @GET("quotes?count=100")
    fun getTheSimpsonsQuotesList() : Call<List<TheSimpsonsQuote>>

    //Random quote
    @GET("quotes")
    fun getTheSimpsonsRandomQuote() : Call<List<TheSimpsonsQuote>>

}