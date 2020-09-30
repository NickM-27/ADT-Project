package com.nick.mowen.adtproject.location

import androidx.core.net.toUri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nick.mowen.adtproject.character.Character
import com.nick.mowen.adtproject.client.RickAndMortyClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterLocationViewModel : ViewModel() {

    private val client: RickAndMortyClient by lazy { RickAndMortyClient() }
    private val location: MutableLiveData<Location> = MutableLiveData()
    private val residents: MutableLiveData<List<Character>> = MutableLiveData()

    private suspend fun getResidents(location: Location) {
        residents.postValue(location.residents.mapNotNull { client.getCharacter(it.toUri().lastPathSegment!!.toLong()) })
    }

    fun getLocation(locationId: Long): LiveData<Location> {
        viewModelScope.launch(Dispatchers.Default) {
            client.getLocation(locationId)?.let {
                location.postValue(it)
                getResidents(it)
            }

        }
        return location
    }

    fun getLocationResidents(): LiveData<List<Character>> = residents
}