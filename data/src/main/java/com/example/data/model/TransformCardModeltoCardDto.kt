package com.example.data.model

import com.example.domain.dto.CardDto

class TransformCardModeltoCardDto : Transformer<List<CardModel>, List<CardDto>> {
    override var convert: (List<CardModel>) -> List<CardDto> =
        { data ->
            data.map {
                CardDto(
                    cardId = it.cardId ?: "",
                    dbfId = it.dbfId ?: 0,
                    name = it.name ?: "",
                    cardSet = it.cardSet ?: "",
                    type = it.type ?: "",
                    text = it.text ?: "",
                    playerClass = it.playerClass ?: "",
                    locale = it.locale ?: "",
                    mechanics = it.mechanics ?: mutableListOf()
                )
            }
        }


}