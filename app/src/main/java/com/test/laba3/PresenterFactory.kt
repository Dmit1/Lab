package com.test.laba3

class PresenterFactory {

    fun createPresenter(time:Long):MainScreenPresenter{
        return if(time>100000){
            MainScreenPresenterImpl()
        }
        else{
            FunnyMainScreenPresenter()
        }
    }
}