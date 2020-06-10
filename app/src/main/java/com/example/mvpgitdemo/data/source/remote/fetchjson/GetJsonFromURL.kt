package com.example.mvpgitdemo.data.source.remote.fetchjson

import android.os.AsyncTask
import com.example.mvpgitdemo.data.source.remote.OnFetchDataJsonListener
import com.example.mvpgitdemo.utils.Constant
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


class GetJsonFromURL<T> constructor(
    private val listener: OnFetchDataJsonListener<T>,
    private val keyEntity: String
) : AsyncTask<String?, Void?, String?>() {

    private var exception: Exception? = null

    override fun doInBackground(vararg params: String?): String {
        val content = StringBuilder()
        val url = URL(params[0])
        val urlConnection = url.openConnection() as HttpURLConnection
        urlConnection.let {
            it.readTimeout = TIME_OUT
            it.requestMethod = METHOD_GET
        }
        val inputStreamReader = InputStreamReader(urlConnection.inputStream)
        val bufferedReader = BufferedReader(inputStreamReader)
        var line: String? = ""

        try {
            do {
                line = bufferedReader.readLine()
                if (line != null) {
                    content.append(line)
                }
            } while (line != null)
            bufferedReader.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return content.toString()
    }

    override fun onPostExecute(data: String?) {
        super.onPostExecute(data)
        if (data != null && !data.isBlank()) {
            val jsonObject = JSONObject(data)
            jsonObject.getString(keyValues)
            @Suppress("UNCHECKED_CAST")
            listener.onSuccess(ParseJsonToObject().parseJsonToData(jsonObject, keyValues) as T)
        } else exception?.let { listener.onError(it) }
    }

    companion object {
        private const val TIME_OUT = 15000
        private const val METHOD_GET = "GET"
        private const val keyValues = Constant.KEY_VALUE
    }
}