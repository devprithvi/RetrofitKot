package com.devprithvi.retrofitkot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit

/**
 * QuoteList and Result class are created through from json files..
 * QuotesAPI
 * RetrofitHelper
 *
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quotesAPI = RetrofitHelper.getInstance().create(QuotesAPI::class.java)
        GlobalScope.launch {
            val result = quotesAPI.getQuotes(1)
            if (result != null) {

                val quoteList = result.body()
                if (quoteList != null) {
                    quoteList.results.forEach {
                        Log.d("Devprithvi", it.content)
                    }
                }
            }
        }

    }
}