package com.test.assignment.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.test.assignment.models.Country
import com.test.assignment.repositories.CountryRepository

/**
 * @author swapnil-tml on 26-06-2020.
 * view model for list data handling
 */

class CountryListViewModel : ViewModel() {
    private val mCountryRepository: CountryRepository? = CountryRepository.instance
    var isViewingRecipes = false
    private var mIsPerformingQuery: Boolean
    val categoryList: LiveData<List<Country>?>?
        get() = mCountryRepository?.categoryName
    val countryName : LiveData<String?>?
        get() = mCountryRepository?.countryName

    fun countryDetail() {
        isViewingRecipes = true
        mIsPerformingQuery = true
        mCountryRepository?.countryDetailApi()
    }

    fun setIsPerformingQuery(isPerformingQuery: Boolean) {
        mIsPerformingQuery = isPerformingQuery
    }

    fun onBackPressed(): Boolean {
        if (mIsPerformingQuery) {
            mCountryRepository?.cancelRequest()
        }
        if (isViewingRecipes) {
            isViewingRecipes = false
            return false
        }
        return true
    }

    fun searchNextPage() {
        if (!mIsPerformingQuery
                && isViewingRecipes) {
            mCountryRepository?.searchNextPage()
        }
    }

    companion object {
        private const val TAG = "CountryListViewModel"
    }

    init {
        mIsPerformingQuery = false
    }
}