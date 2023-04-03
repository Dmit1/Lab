package com.test.laba3

class EventActionToStringAdapter {
    fun toString(action:Event.Action) : String{
        return when(action){
         Event.Action.Plus -> "+"
         Event.Action.Minus -> "-"
         Event.Action.Multiply -> "*"
         Event.Action.Divide -> "/"
         Event.Action.Equals -> "="
            else ->"UNKNOWN ACTION"
        }
    }
}