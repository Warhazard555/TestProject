package com.example.data.model

import com.google.gson.annotations.SerializedName

data class CardModel (
    var cardId: String?,
    var id: Int?,
    @SerializedName("name")
    var name: String?,
    var cardSet: String?,
    var type: String?,
    var text: String?,
    var playerClass: String?,
    var locale: String?,
    var mechanics: MutableList<String>?
        )