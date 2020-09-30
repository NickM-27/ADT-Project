package com.nick.mowen.adtproject.character

import com.google.gson.annotations.SerializedName

class CharacterData {

    @SerializedName("info")
    var characterInfo: CharacterInfo? = null

    @SerializedName("results")
    var characters: List<Character> = emptyList()

    class CharacterInfo {

        @SerializedName("count")
        var count: Int = 0

        @SerializedName("pages")
        var pages: Int = 0

        @SerializedName("next")
        var next: String = ""
    }
}