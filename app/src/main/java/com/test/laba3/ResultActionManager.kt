package com.test.laba3

class ResultActionManager {
    fun processAction(firstValue : Int, secondValue: Int, action: Event.Action ):Int {
        return when (action){
            Event.Action.Minus -> firstValue - secondValue
            Event.Action.Plus -> firstValue + secondValue
            Event.Action.Divide -> firstValue / secondValue
            Event.Action.Multiply -> firstValue * secondValue
            else -> {0}
        }
    }
}