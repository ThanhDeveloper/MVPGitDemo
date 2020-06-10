package com.example.mvpgitdemo.screen.main

import com.example.mvpgitdemo.data.CoronaVirusRepository
import com.example.mvpgitdemo.data.model.CoronaVirus
import com.example.mvpgitdemo.data.source.remote.OnFetchDataJsonListener
import com.example.mvpgitdemo.screen.main.MainContract.Presenter

class MainPresenter internal constructor(private val repository: CoronaVirusRepository?) :
    Presenter {

    private var view: MainContract.View? = null

    override fun onStart() {
        getInfo()
    }

    override fun setView(view: MainContract.View?) {
        this.view = view
    }

    override fun getInfo() {
        repository?.getCoronaVirusInfo(object : OnFetchDataJsonListener<MutableList<CoronaVirus>> {

            override fun onSuccess(data: MutableList<CoronaVirus>) {
                view?.onGetInfoSuccess(data)
            }

            override fun onError(exception: java.lang.Exception) {
                view?.onError(exception)
            }
        })
    }
}