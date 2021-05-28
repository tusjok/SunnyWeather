package com.tujsok.sunnyweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.tujsok.sunnyweather.logic.Repository
import com.tujsok.sunnyweather.logic.model.Place

class PlaceViewModel : ViewModel() {

    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }

    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }

    fun savePlace(place: Place) {
        Repository.savePlace(place)
    }

    fun getPlace(): Place {
        return Repository.getPlace()
    }

    fun isPlaceSaved() = Repository.isPlaceSaved()
}