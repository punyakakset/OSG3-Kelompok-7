package osg3.eudeka.tujuh.app.data.remote

import osg3.eudeka.tujuh.app.data.Constants
import osg3.eudeka.tujuh.app.data.remote.response.IncidentsResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("/incidents")
    fun getRecentIncidents(): Call<IncidentsResponse>

    companion object Factory {
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BIKEWISE_BASE_URL)
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}