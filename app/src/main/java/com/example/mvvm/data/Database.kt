package com.example.mvvm.data

class Database private constructor(){

    var mQuoteDao = QuoteDao()
        private set

    // singleton
    companion object{
        @Volatile private var instance: Database? = null

        fun getInstance() =
            instance ?: synchronized(lock = this) {
                instance ?: Database().also { instance = it }
            }
    }
}