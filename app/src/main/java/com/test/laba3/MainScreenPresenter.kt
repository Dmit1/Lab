package com.test.laba3

interface MainScreenPresenter  {
    fun setView(view: MainScreenView)
    fun reset()
    fun addEvent(action: Event)
}