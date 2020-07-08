package com.test.assignment.bindingutil

import android.view.View

interface RecyclerViewItemClickListener {
    fun onItemClick(view: View, position: Int)
}