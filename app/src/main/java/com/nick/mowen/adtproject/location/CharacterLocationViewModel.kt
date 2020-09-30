package com.nick.mowen.adtproject.location

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nick.mowen.adtproject.client.RickAndMortyClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterLocationViewModel : ViewModel() {

    private val client: RickAndMortyClient by lazy { RickAndMortyClient() }
    private val location: MutableLiveData<Location> = MutableLiveData()

    fun getLocation(locationId: Long): LiveData<Location> {
        viewModelScope.launch(Dispatchers.Default) { location.postValue(client.getLocation(locationId) ?: return@launch) }
        return location
    }
}