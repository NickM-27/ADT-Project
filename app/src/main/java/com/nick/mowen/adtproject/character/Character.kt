package com.nick.mowen.adtproject.character

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

class Character {

    @SerializedName("id")
    var id: Long = 0

    @SerializedName("name")
    var name: String = ""

    @SerializedName("status")
    var status: String = ""

    @SerializedName("species")
    var species: String = ""

    @SerializedName("type")
    var type: String = ""

    @SerializedName("gender")
    var gender: String = ""

    @SerializedName("image")
    var image: String = ""

    @SerializedName("url")
    var url: String = ""

    @SerializedName("created")
    var createdAt: String = ""

    @SerializedName("episode")
    var episodes: List<String> = emptyList()

    @SerializedName("origin")
    var origin: Origin? = null

    @SerializedName("location")
    var location: Location? = null

    class Origin {

        @SerializedName("name")
        var name: String = ""

        @SerializedName("url")
        var url: String = ""
    }

    class Location {

        @SerializedName("name")
        var name: String = ""

        @SerializedName("url")
        var url: String = ""
    }

    companion object {

        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Character>() {

            override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean = oldItem.name == newItem.name
        }
    }
}