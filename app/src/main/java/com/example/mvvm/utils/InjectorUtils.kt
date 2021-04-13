package com.example.mvvm.utils

import com.example.mvvm.data.Database
import com.example.mvvm.data.QuoteRepository
import com.example.mvvm.ui.quotes.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory() : QuotesViewModelFactory {
        val mQuoteRepository = QuoteRepository.getInstance(Database.getInstance().mQuoteDao)

        return QuotesViewModelFactory(mQuoteRepository)
    }
}