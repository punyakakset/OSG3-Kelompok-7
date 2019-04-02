package osg3.eudeka.tujuh.app.data

import osg3.eudeka.tujuh.app.data.remote.ApiService
import osg3.eudeka.tujuh.app.data.remote.response.IncidentsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object AppRepository : IAppRepository {
    val apiService = ApiService.create()

    override fun getRecentIncidents(callback: IAppRepository.GetRecentIncidentsCallback) {
        apiService.getRecentIncidents().enqueue(object : Callback<IncidentsResponse> {
            override fun onFailure(call: Call<IncidentsResponse>, t: Throwable) {
                callback.onError(t.localizedMessage)
            }

            override fun onResponse(call: Call<IncidentsResponse>, response: Response<IncidentsResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        callback.onLoaded(it)
                    }
                }
            }

        })
    }
}