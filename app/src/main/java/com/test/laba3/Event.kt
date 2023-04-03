package com.test.laba3

sealed interface Event{
    class Number(val number: Int):Event
    interface Action :Event {
        object Plus : Action
        object Minus : Action
        object Divide : Action
        object Multiply : Action
        object Equals : Action
    }
}