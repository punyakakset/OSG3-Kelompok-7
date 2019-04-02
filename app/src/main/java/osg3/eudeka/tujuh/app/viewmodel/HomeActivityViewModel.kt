package osg3.eudeka.tujuh.app.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import osg3.eudeka.tujuh.app.data.AppRepository
import osg3.eudeka.tujuh.app.data.IAppRepository
import osg3.eudeka.tujuh.app.data.Model.Incident
import osg3.eudeka.tujuh.app.data.remote.response.IncidentsResponse

class HomeActivityViewModel : ViewModel() {
    private val TAG = this.javaClass.simpleName
    private val _repo = AppRepository
    private var incidents: MutableLiveData<List<Incident>> = MutableLiveData()

    init {
        fetchRecentIncidents()
    }

    private fun fetchRecentIncidents() {
        Log.d(TAG, "fetch data")
        _repo.getRecentIncidents(object : IAppRepository.GetRecentIncidentsCallback {
            override fun onLoaded(incidentListResponse: List<IncidentsResponse.Incident>) {
                Log.d(TAG, "data loaded")
                var incidentList = arrayListOf<Incident>()
                incidentListResponse.forEach {
                    incidentList.add(
                        Incident(
                            it.id,
                            it.title ?: "",
                            it.description ?: "",
                            it.address ?: "",
                            it.occurredAt,
                            it.updatedAt,
                            it.type,
                            it.locationType ?: "",
                            it.media!!.imageUrl ?: ""
                        )
                    )
                }
                incidents.postValue(incidentList)
            }

            override fun onError(error: String) {
                incidents.postValue(emptyList())
                Log.d(TAG, "response " + error)
            }
        })
    }

    fun getRecentIncidents(): LiveData<List<Incident>> {
        return incidents
    }
}