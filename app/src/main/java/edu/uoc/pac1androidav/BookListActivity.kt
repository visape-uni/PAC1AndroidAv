package edu.uoc.pac1androidav

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_book_detail.*
import kotlinx.android.synthetic.main.activity_book_list.*

class BookListActivity : AppCompatActivity() {

    companion object {
        const val  LIST_SIZE = 15
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        omplirLlista()

        listView.setOnItemClickListener { parent, view, position, id ->
            val element = parent.getItemAtPosition(position)

            if (frameLayoutList != null) {
                supportFragmentManager.beginTransaction().replace(frameLayoutList.id, BookDetailFragment())
            } else {
                supportFragmentManager.beginTransaction().replace(frameLayoutDetail.id, BookDetailFragment())
                val intent = Intent(this, BookListActivity::class.java)
                startActivity(intent)
            }
        }
    }

    fun omplirLlista() {
        val listItems = arrayOfNulls<String>(LIST_SIZE)
        for (i in 1..LIST_SIZE) {
            listItems[i] = "item $i"
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = adapter
    }
}