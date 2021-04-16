package com.learning.codelab12.datasources

import com.learning.codelab12.models.CountryStats
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class LiveSource {

    fun getSummary() : List<CountryStats> {

        val list = ArrayList<CountryStats>()
        val  response = get("https://api.covid19api.com/summary")

        if(response.isSuccessful) {
            var jsonObject = JSONObject(response.body)
            var countries = jsonObject.getJSONArray("Countries")

            for (i in 0 until countries.length()){
                list.add(CountryStats(
                    countries.getJSONObject(i).getString("Country"),
                    countries.getJSONObject(i).getString("CountryCode"),
                    countries.getJSONObject(i).getInt("TotalConfirmed")
                ))
            }
        }

        return list
    }

    private fun get(endpoint: String): HTTPResponse {

        val url = URL(endpoint)
        val connection = url.openConnection() as HttpURLConnection
        try {
            connection.requestMethod = "GET"

            connection.connect()

            val stream = if (connection.responseCode in 200..300) connection.inputStream else connection.errorStream

            val responseBody = try {
                stream.bufferedReader(Charsets.UTF_8).use { it.readText() }
            } catch (e: Throwable) {
                ""
            }

            return HTTPResponse(connection.responseCode, responseBody)
        } catch (e: Throwable) {
            return HTTPResponse(connection.responseCode, "")
        } finally {
            connection.disconnect()
        }
    }


    class HTTPResponse ( val statusCode: Int, val body : String) {
        val isSuccessful = statusCode in 200..300
    }
}