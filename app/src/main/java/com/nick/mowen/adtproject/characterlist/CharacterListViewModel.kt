package com.nick.mowen.adtproject.characterlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nick.mowen.adtproject.character.Character
import com.nick.mowen.adtproject.character.CharacterData
import com.nick.mowen.adtproject.client.RickAndMortyClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterListViewModel : ViewModel() {

    private val client: RickAndMortyClient by lazy { RickAndMortyClient() }
    private lateinit var characterData: CharacterData
    private val characters: MutableLiveData<List<Character>> = MutableLiveData()

    fun getCharacters(): LiveData<List<Character>> {
        viewModelScope.launch(Dispatchers.Default) {
            characterData = client.getCharacterInfo() ?: return@launch
            characters.postValue(characterData.characters)
        }

        return characters
    }
}