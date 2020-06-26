package com.test.assignment.repositories

import androidx.lifecycle.LiveData
import com.test.assignment.models.Country
import com.test.assignment.requests.CountryApiClient

/**
 * @author swapnil-tml on 26-06-2020.
 * repository for API data handle
 */


class CountryRepository private constructor() {
    private val mCountryApiClient: CountryApiClient? = CountryApiClient.instance

    val categoryName: LiveData<List<Country>?>?
        get() = mCountryApiClient?.category

    val countryName: LiveData<String?>?
        get() = mCountryApiClient?.countryName


    fun countryDetailApi() {
        mCountryApiClient?.countryDetailApi()
    }

    fun searchNextPage() {
        countryDetailApi()
    }

    fun cancelRequest() {
        mCountryApiClient?.cancelRequest()
    }

    companion object {
        var instance: CountryRepository? = null
            get() {
                if (field == null) {
                    field = CountryRepository()
                }
                return field
            }
            private set
    }
}