package com.example.mvpgitdemo.data.source.remote.fetchjson

import com.example.mvpgitdemo.data.model.CoronaEntry
import com.example.mvpgitdemo.data.model.CoronaVirus
import org.json.JSONObject

class ParseJson {
    fun coronaVirusParseJson(jsonObject: JSONObject): CoronaVirus {
        return CoronaVirus(
            name = jsonObject.getString(CoronaEntry.NAME),
            description = jsonObject.getString(CoronaEntry.DESC),
            path = jsonObject.getString(CoronaEntry.PATH)
        )
    }
}