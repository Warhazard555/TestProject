package com.example.domain.dto

class CardDto (
    var cardId: String = "",
    var dbfId: Int = 0,
    var name: String = "",
    var cardSet: String = "",
    var type: String = "",
    var text: String = "",
    var playerClass: String = "",
    var locale: String = "",
    var mechanics: MutableList<String> = mutableListOf("")
        )
