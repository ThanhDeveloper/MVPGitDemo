package com.example.mvpgitdemo.data

import com.example.mvpgitdemo.data.model.CoronaVirus
import com.example.mvpgitdemo.data.source.remote.OnFetchDataJsonListener

interface CoronaVirusDataSource {
    /**
     * Local
     */
    interface Local

    /**
     * Remote
     */
    interface Remote {
        fun getCoronaVirusInfo(listener: OnFetchDataJsonListener<MutableList<CoronaVirus>>)
    }
}