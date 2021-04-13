package com.example.mvvm.data

class QuoteRepository private constructor(private val quoteDao: QuoteDao){

    fun addQuote(quote: Quote){
        quoteDao.addQuote(quote)
    }

    fun getQuote() = quoteDao.getQuote()

    // singleton
    companion object{
        @Volatile private var instance: QuoteRepository? = null

        fun getInstance(mQuoteDao: QuoteDao) =
            instance ?: synchronized(lock = this) {
                instance ?: QuoteRepository(mQuoteDao).also { instance = it }
            }
    }
}