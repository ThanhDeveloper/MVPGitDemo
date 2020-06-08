package com.example.mvpgitdemo.data.source.remote

import android.util.Log
import com.example.mvpgitdemo.data.CoronaVirusDataSource
import com.example.mvpgitdemo.data.model.CoronaEntry
import com.example.mvpgitdemo.data.model.CoronaVirus
import com.example.mvpgitdemo.data.source.remote.fetchjson.GetJsonFromURL
import com.example.mvpgitdemo.utils.Constant

class CoranaVirusRemoteDatasource : CoronaVirusDataSource.Remote{
    private var baseUrl:String = Constant.BASE_URL

    private object Holder {
        val INSTANCE = CoranaVirusRemoteDatasource()
    }

    override fun getCoronaVirusInfo(listener: OnFetchDataJsonListener<MutableList<CoronaVirus>>) {
        GetJsonFromURL(listener, CoronaEntry.OBJECT).execute(baseUrl)
    }

    companion object {
        val instance: CoranaVirusRemoteDatasource by lazy { Holder.INSTANCE }
    }
}