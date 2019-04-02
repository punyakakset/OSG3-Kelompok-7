package osg3.eudeka.tujuh.app.data

import osg3.eudeka.tujuh.app.data.remote.response.IncidentsResponse

interface IAppRepository {
    fun getRecentIncidents(callback: GetRecentIncidentsCallback)
    interface GetRecentIncidentsCallback {
        fun onLoaded(incidentListResponse: List<IncidentsResponse.Incident>)
        fun onError(error: String)
    }
}