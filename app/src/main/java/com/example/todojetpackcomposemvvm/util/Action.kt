package com.example.todojetpackcomposemvvm.util

enum class Action {
    ADD,
    UPDATE,
    DELETE,
    DELETE_ALL,
    UNDO,
    NO_ACTION
}

// Convert String to Action
fun String?.toAction(): Action {
    return if (this.isNullOrEmpty())
        Action.NO_ACTION
    else
        Action.valueOf(this)
}