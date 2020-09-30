package com.nick.mowen.adtproject.location

import com.google.gson.annotations.SerializedName

class Location {

    @SerializedName("id")
    var id: Long = 0

    @SerializedName("name")
    var name: String = ""

    @SerializedName("type")
    var type: String = ""

    @SerializedName("dimension")
    var dimension: String = ""

    @SerializedName("residents")
    var residents: List<String> = emptyList()
}