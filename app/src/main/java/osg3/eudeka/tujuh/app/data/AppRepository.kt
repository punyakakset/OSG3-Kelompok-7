package osg3.eudeka.tujuh.app.data

import android.util.Log
import com.google.gson.Gson
import osg3.eudeka.tujuh.app.data.remote.ApiService
import osg3.eudeka.tujuh.app.data.remote.response.IncidentsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object AppRepository : IAppRepository {
    private val TAG = this.javaClass.simpleName
    private val apiService = ApiService.create()

    override fun getRecentIncidents(callback: IAppRepository.GetRecentIncidentsCallback) {
        apiService.getRecentIncidents().enqueue(object : Callback<IncidentsResponse> {
            override fun onFailure(call: Call<IncidentsResponse>, t: Throwable) {
                callback.onError(t.localizedMessage)
            }

            override fun onResponse(call: Call<IncidentsResponse>, response: Response<IncidentsResponse>) {
                Log.d(TAG, "response " + response.isSuccessful)
                if (response.isSuccessful) {
                    Log.d(TAG, "response " + Gson().toJson(response.body()))
                    response.body()?.let {
                        it.incidents?.let { incident ->
                            callback.onLoaded(incident)
                        }
                    }
                }
            }

        })
    }
}