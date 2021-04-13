package com.example.mvvm.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class QuoteDao {
    private val mQuoteList = mutableListOf<Quote>()
    private val mQuotes = MutableLiveData<List<Quote>>()

    init {
        mQuotes.value = mQuoteList
    }

    fun addQuote(quote: Quote) {
        mQuoteList.add(quote)
        mQuotes.value = mQuoteList
    }

    fun getQuote() = mQuotes as LiveData<List<Quote>>
}