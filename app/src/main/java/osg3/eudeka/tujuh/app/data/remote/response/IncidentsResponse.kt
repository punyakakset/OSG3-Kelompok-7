package osg3.eudeka.tujuh.app.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class IncidentsResponse {

    @SerializedName("incidents")
    @Expose
    var incidents: List<Incident>? = null

    inner class Incident {
        @SerializedName("id")
        @Expose
        var id: Int = 0
        @SerializedName("title")
        @Expose
        var title: String? = null
        @SerializedName("description")
        @Expose
        var description: String? = null
        @SerializedName("address")
        @Expose
        var address: String? = null
        @SerializedName("occurred_at")
        @Expose
        var occurredAt: Long = 0L
        @SerializedName("updated_at")
        @Expose
        var updatedAt: Long = 0L
        @SerializedName("url")
        @Expose
        var url: String = ""
        @SerializedName("source")
        @Expose
        var source: Source? = null
        @SerializedName("media")
        @Expose
        var media: Media? = null
        @SerializedName("location_type")
        @Expose
        var locationType: String? = null
        @SerializedName("location_description")
        @Expose
        var locationDescription: String? = null
        @SerializedName("type")
        @Expose
        var type: String = ""
        @SerializedName("type_properties")
        @Expose
        var typeProperties: String? = null
    }

    inner class Media {
        @SerializedName("image_url")
        @Expose
        var imageUrl: String? = null
        @SerializedName("image_url_thumb")
        @Expose
        var imageUrlThumb: String? = null
    }

    inner class Source {
        @SerializedName("name")
        @Expose
        var name: String? = null
        @SerializedName("html_url")
        @Expose
        var htmlUrl: String? = null
        @SerializedName("api_url")
        @Expose
        var apiUrl: String? = null
    }

}