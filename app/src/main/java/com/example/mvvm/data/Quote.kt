package com.example.mvvm.data

data class Quote(val mQuoteText: String, val mAuthor: String) {

    override fun toString(): String {
        return "$mQuoteText - $mAuthor"
    }
}