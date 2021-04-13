package com.example.mvvm.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvm.R
import com.example.mvvm.data.Quote
import com.example.mvvm.utils.InjectorUtils
import java.lang.StringBuilder

class QuotesMain : AppCompatActivity() {

//    private lateinit var text_view_quote: TextView
//    private lateinit var edit_text_quote: EditText
//    private lateinit var edit_text_author: EditText
//    private lateinit var button_save: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes_main)

        findViewById<TextView>(R.id.text_view_display)
        var button_save = findViewById(R.id.button_save) as Button
        initialize()
    }

    private fun initialize() {
        val mFactory = InjectorUtils.provideQuotesViewModelFactory()
        val mViewModel = ViewModelProviders.of(this, mFactory).get(QuotesViewModel:: class.java)

        val button_save = findViewById<Button>(R.id.button_save)
        val text_view_display = findViewById<TextView>(R.id.text_view_display)
        val edit_text_quote = findViewById<EditText>(R.id.edit_text_quote)
        val edit_text_author = findViewById<EditText>(R.id.edit_text_author)

        mViewModel.getQuote().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach{ quote ->
                stringBuilder.append("$quote\n\n")
            }
            text_view_display.text = stringBuilder.toString()
        })


        button_save.setOnClickListener {
            val quote = Quote(edit_text_quote.text.toString(), edit_text_author.text.toString())
            mViewModel.addQuote(quote)
            edit_text_quote.setText("")
            edit_text_author.setText("")
        }

    }
}