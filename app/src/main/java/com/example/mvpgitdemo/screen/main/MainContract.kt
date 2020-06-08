package com.example.mvpgitdemo.screen.main

import com.example.mvpgitdemo.data.model.CoronaVirus
import com.example.mvpgitdemo.utils.BasePresenter

class MainContract {
    /**
     * View
     */
    interface View {
        fun onGetInfoSuccess(info: MutableList<CoronaVirus>)
        fun onError(exception: Exception?)
    }

    /**
     * Presenter
     */
    interface Presenter : BasePresenter<View> {
        fun getInfo()
    }
}