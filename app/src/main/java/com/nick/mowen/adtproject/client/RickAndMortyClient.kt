package com.nick.mowen.adtproject.client

import com.nick.mowen.adtproject.character.Character
import com.nick.mowen.adtproject.character.CharacterData
import com.nick.mowen.adtproject.location.Location
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

@Suppress("BlockingMethodInNonBlockingContext")
class RickAndMortyClient {

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
    private val client: PrivateClient =
        Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build().create(PrivateClient::class.java)

    suspend fun getCharacterInfo(): CharacterData? = withContext(Dispatchers.Default) {
        try {
            client.getCharacters().execute().body()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    suspend fun getLocation(locationId: Long): Location? = withContext(Dispatchers.Default) {
        try {
            client.getLocation(locationId).execute().body()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    private interface PrivateClient {

        @GET("character")
        fun getCharacters(): Call<CharacterData>

        @GET("character/{characterId}")
        fun getCharacter(@Path("characterId") characterId: Long): Call<Character>

        @GET("location/{locationId}")
        fun getLocation(@Path("locationId") locationId: Long): Call<Location>
    }

    companion object {

        private const val BASE_URL = "https://rickandmortyapi.com/api/"
    }
}