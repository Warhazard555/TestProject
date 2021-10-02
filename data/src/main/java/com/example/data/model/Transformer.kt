package com.example.data.model

interface Transformer<InputType, OutputType> {
    var convert: (InputType) -> OutputType
}