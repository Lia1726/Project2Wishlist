package com.example.project2wishlist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var wishlist: ArrayList<WishList>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Input for the item of choice by the user
        val submit = findViewById<Button>(R.id.submitButton)
        var itemInput = findViewById<EditText>(R.id.itemInput)
        var priceInput = findViewById<EditText>(R.id.priceInput)
        var urlInput = findViewById<EditText>(R.id.urlInput)

        wishlist = ArrayList()
        submit.setOnClickListener{
            var itemEntered = itemInput.text.toString()
            var priceEntered = priceInput.text.toString()
            var urlEntered = urlInput.text.toString()
            wishlist.add(WishList(itemEntered, priceEntered, urlEntered))
            it.hiddenKeyboard()
            itemInput.text.clear()
            priceInput.text.clear()
            urlInput.text.clear()
        }

        // Lookup the RecyclerView in activity layout
        val wishlistsRv = findViewById<RecyclerView>(R.id.itemsRv)
        // Create adapter passing in the list of items for the list
        val adapter = WishListAdapter(wishlist)
        // Attach the adapter to the RecyclerView to populate items
        wishlistsRv.adapter = adapter
        // Set layout manager to position the items
        wishlistsRv.layoutManager = LinearLayoutManager(this)
    }

    /**
     * Hides the keyboard
     */
    fun View.hiddenKeyboard(){
        val hide = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        hide.hideSoftInputFromWindow(windowToken, 0)
    }

}