package com.valdiviezo.anahi.thesimpsonsquotes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.valdiviezo.anahi.thesimpsonsquotes.api.TheSimpsonsQuoteRetriver
import com.valdiviezo.anahi.thesimpsonsquotes.model.TheSimpsonsQuote
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_thesimpsonsquotes.layoutManager = LinearLayoutManager(this)
        rv_thesimpsonsquotes.hasFixedSize()
        var quotes : List<TheSimpsonsQuote>?

        val retrieverRandomQuote = TheSimpsonsQuoteRetriver()

        var callbackRandomQuote = object : Callback<List<TheSimpsonsQuote>> {
            override fun onFailure(call: Call<List<TheSimpsonsQuote>>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<List<TheSimpsonsQuote>>?, response: Response<List<TheSimpsonsQuote>>?) {
                quotes = response?.body()
                rv_thesimpsonsquotes.adapter = TheSimpsonsQuoteAdapter(quotes)
            }
        }
        //retrieverRandomQuote.getTheSimpsonsRandomQuote(callbackRandomQuote)

        var callbackQuoteList = object : Callback<List<TheSimpsonsQuote>> {
            override fun onFailure(call: Call<List<TheSimpsonsQuote>>?, t: Throwable?) {
                val message: String = "There was a failure."
            }

            override fun onResponse(call: Call<List<TheSimpsonsQuote>>?, response: Response<List<TheSimpsonsQuote>>?) {
                quotes = response?.body()
                rv_thesimpsonsquotes.adapter = TheSimpsonsQuoteAdapter(quotes)            }

        }

        retrieverRandomQuote.getTheSimpsonsQuotesList(callbackQuoteList)
    }
}
