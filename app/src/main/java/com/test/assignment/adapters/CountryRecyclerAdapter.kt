package com.test.assignment.adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.test.assignment.R
import com.test.assignment.models.Country
import java.util.*

/**
 * @author swapnil-tml on 26-06-2020.
 * Recycler view for Country List items
 */


class CountryRecyclerAdapter(private val mOnCountryClickListener: OnCountryClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mCategory: List<Country>

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RecyclerView.ViewHolder {
        var view: View?
        return when (i) {
            LOADING_TYPE -> {
                view = LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_loading_list_item, viewGroup, false)
                LoadingViewHolder(view)
            }
            else -> {
                view = LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_country_list_item, viewGroup, false)
                CountryDetailViewHolder(view, mOnCountryClickListener)
            }
        }
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, i: Int) {
        val itemViewType = getItemViewType(i)
        if (itemViewType == RECIPE_TYPE) { // set the image
            val options = RequestOptions()
                    .centerCrop()
                    .error(R.drawable.ic_launcher_background)
            val path = Uri.parse(mCategory[i].getImageHref())
            Glide.with((viewHolder as CountryDetailViewHolder).itemView)
                    .setDefaultRequestOptions(options)
                    .load(path)
                    .into(viewHolder.image)
            viewHolder.title.text = mCategory[i].getTitle()
            viewHolder.description.text = mCategory[i].getDescription()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == mCategory.size  && position != 0 && mCategory[position].getTitle() != "EXHAUSTED...") {
                LOADING_TYPE
            } else {
                RECIPE_TYPE
            }
    }

    override fun getItemCount(): Int {
        return mCategory.size
    }

    fun displayLoading() {
        if (!isLoading) {
            val recipe = Country()
            recipe.setTitle("LOADING...")
            val loadingList: MutableList<Country> = ArrayList()
            loadingList.add(recipe)
            mCategory = loadingList
            notifyDataSetChanged()
        }
    }

    private val isLoading: Boolean
        get() {
            if (mCategory.isNotEmpty()) {
                if (mCategory[mCategory.size - 1].getTitle() == "LOADING...") {
                    return true
                }
            }
            return false
        }

    fun setRecipes(recipes: List<Country>) {
        mCategory = recipes
        notifyDataSetChanged()
    }

    companion object {
        private const val RECIPE_TYPE = 1
        private const val LOADING_TYPE = 2
    }

    init {
        mCategory = ArrayList()
    }
}