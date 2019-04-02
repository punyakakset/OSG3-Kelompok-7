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
        var id: Int? = null
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
        var occurredAt: Int? = null
        @SerializedName("updated_at")
        @Expose
        var updatedAt: Int? = null
        @SerializedName("url")
        @Expose
        var url: String? = null
        @SerializedName("source")
        @Expose
        var source: Source? = null
        @SerializedName("media")
        @Expose
        var media: Media? = null
        @SerializedName("location_type")
        @Expose
        var locationType: Any? = null
        @SerializedName("location_description")
        @Expose
        var locationDescription: Any? = null
        @SerializedName("type")
        @Expose
        var type: String? = null
        @SerializedName("type_properties")
        @Expose
        var typeProperties: Any? = null
    }

    inner class Media {
        @SerializedName("image_url")
        @Expose
        var imageUrl: Any? = null
        @SerializedName("image_url_thumb")
        @Expose
        var imageUrlThumb: Any? = null
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