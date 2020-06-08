package com.example.mvpgitdemo.data.source.remote.fetchjson

import android.util.Log
import com.example.mvpgitdemo.data.model.CoronaEntry
import org.json.JSONException
import org.json.JSONObject

class ParseJsonToObject {

    fun parseJsonToData(jsonObject: JSONObject?, keyEntity: String): Any {
        val data = mutableListOf<Any>()
        try {
            var objectFilter = jsonObject?.getJSONObject(keyEntity)
            val item = ParseJsonToObject().parseJsonToObject(objectFilter, keyEntity)
            item?.let {
                data.add(it)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return data
    }

    private fun parseJsonToObject(jsonObject: JSONObject?, keyEntity: String): Any? {
        try {
            jsonObject?.let {
                when (keyEntity) {
                    CoronaEntry.OBJECT -> return ParseJson().coronaVirusParseJson(it)
                    else -> null
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return null
    }
}