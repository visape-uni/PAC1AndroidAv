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
        setContentView(R.layout.activity_book_list)

        omplirLlista()

        listView.setOnItemClickListener { parent, view, position, id ->
            val element = position

            if (frameLayoutList != null) {
                supportFragmentManager.beginTransaction().replace(frameLayoutList.id, BookDetailFragment.newInstance(
                    element.toString()
                )).commit()
            } else {
                val newIntent = Intent(this, BookDetailActivity::class.java)
                newIntent.putExtra("element", element.toString())
                startActivity(newIntent)
            }
        }
    }

    fun omplirLlista() {
        val listItems = arrayOfNulls<String>(LIST_SIZE)
        for (i in 0..LIST_SIZE-1) {
            listItems[i] = "item $i"
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = adapter
    }
}