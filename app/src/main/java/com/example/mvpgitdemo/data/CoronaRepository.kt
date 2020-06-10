package com.example.mvpgitdemo.data

import com.example.mvpgitdemo.data.model.CoronaVirus
import com.example.mvpgitdemo.data.source.remote.CoranaVirusRemoteDatasource
import com.example.mvpgitdemo.data.source.remote.OnFetchDataJsonListener

class CoronaVirusRepository private constructor(private val remote: CoronaVirusDataSource.Remote) {

    private object Holder {
        val INSTANCE = CoronaVirusRepository(
            remote = CoranaVirusRemoteDatasource.instance
        )
    }

    fun getCoronaVirusInfo(listener: OnFetchDataJsonListener<MutableList<CoronaVirus>>) {
        remote.getCoronaVirusInfo(listener)
    }

    companion object {
        val instance: CoronaVirusRepository by lazy { Holder.INSTANCE }
    }
}