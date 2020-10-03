package edu.uoc.pac1androidav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_book_detail.*

class BookDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        val item = intent.getStringExtra("element")
        app_bar.title = "Item " + item
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = ""

        supportFragmentManager.beginTransaction().replace(frameLayoutDetail.id, BookDetailFragment.newInstance(item)).commit()
    }
}