package com.test.assignment

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.assignment.adapters.CountryRecyclerAdapter
import com.test.assignment.adapters.OnCountryClickListener
import com.test.assignment.databinding.ActivityCountryListBinding
import com.test.assignment.util.VerticalSpacingItemDecorator
import com.test.assignment.viewmodels.CountryListViewModel
import kotlinx.android.synthetic.main.activity_country_list.*

/**
 * @author swapnil-tml on 26-06-2020.
 * Main screen where all category is showing
 */

class CountryListActivity : AppCompatActivity(), OnCountryClickListener {

    private var mCountryListViewModel: CountryListViewModel? = null
   // private var mRecyclerView: RecyclerView? = null
   // private var mAdapter: CountryRecyclerAdapter? = null
    private lateinit var binding: ActivityCountryListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
       // setContentView(R.layout.activity_country_list)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_country_list)

        //mRecyclerView = findViewById(R.id.recipe_list)
        mCountryListViewModel = ViewModelProviders.of(this).get(CountryListViewModel::class.java)
        initRecyclerView()

        mCountryListViewModel!!.countryDetail()

        binding.viewMode = mCountryListViewModel
        subscribeObservers()

    }

    private fun subscribeObservers() {
        mCountryListViewModel?.categoryList?.observe(this, Observer { recipes ->
            if (recipes != null) {
                mCountryListViewModel?.setIsPerformingQuery(false)

                mCountryListViewModel?.listOfData?.set(recipes.toMutableList())
                Log.d("page_Name_","TrackAction:categoryList added ${mCountryListViewModel?.listOfData}")
               // mAdapter?.setRecipes(recipes)
            }
        })

        mCountryListViewModel?.countryName?.observe(this, Observer { countryName ->
            if (countryName != null) {
                mCountryListViewModel?.setIsPerformingQuery(false)
                screen_title.text = countryName
            }
        })
    }

    private fun initRecyclerView() {
        val itemDecorator = VerticalSpacingItemDecorator(30)
       // mRecyclerView?.addItemDecoration(itemDecorator)
        /*mAdapter = CountryRecyclerAdapter()

        mRecyclerView?.adapter = mAdapter
        mRecyclerView?.layoutManager = LinearLayoutManager(this)*/
        /*mRecyclerView?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (mRecyclerView?.canScrollVertically(1) != null) { // search for the next page
                    mCountryListViewModel?.searchNextPage()
                }
            }
        })*/
    }

    override fun onCountryClick(category: String?) {
       // mAdapter?.displayLoading()
    }

    private fun displaySearchCategories() {
        mCountryListViewModel!!.isViewingRecipes = false
    }

    override fun onBackPressed() {
        if (mCountryListViewModel!!.onBackPressed()) {
            super.onBackPressed()
        } else {
            displaySearchCategories()
        }
    }

    companion object {
        private const val TAG = "RecipeListActivity"
    }
}