package com.example.tinkoffproject.presentation.mainPagePackage

sealed interface UIState {
    class Protein(
        val value: String
    ) : UIState

    class Fat(
        val value: String
    ) : UIState

    class Carbohydrates(
        val value: String
    ) : UIState

    class Calories(
        val value: String
    ) : UIState
}