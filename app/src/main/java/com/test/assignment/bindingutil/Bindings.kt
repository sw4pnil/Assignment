package com.test.assignment.util

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.assignment.adapters.CountryRecyclerAdapter
import com.test.assignment.models.Country

@BindingAdapter("adapter")
fun  setItems(recyclerView: RecyclerView, items: MutableList<Country>?) {
    if (items != null){
        if (recyclerView?.adapter == null){

            val adapter = CountryRecyclerAdapter()
            adapter.setRecipes(items)
            recyclerView?.adapter = adapter
        } else {

            (recyclerView.adapter as CountryRecyclerAdapter).setRecipes(items)
        }
    }
}