package com.test.assignment.adapters

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.test.assignment.R

/**
 * @author swapnil-tml on 26-06-2020.
 * ViewHolder for Country List items
 */

class CountryDetailViewHolder(itemView: View, var onCountryListener: OnCountryClickListener) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    @JvmField
    var title: TextView = itemView.findViewById(R.id.title)
    @JvmField
    var description: TextView = itemView.findViewById(R.id.description)
    @JvmField
    var image: AppCompatImageView = itemView.findViewById(R.id.image)

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        //for showing detail page.
    }
}