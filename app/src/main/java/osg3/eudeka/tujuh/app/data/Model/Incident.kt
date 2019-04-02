package osg3.eudeka.tujuh.app.data.Model

data class Incident(
    val id: Int,
    val title: String = "",
    val description: String = "",
    val address: String = "",
    val occurredAt: Int = 0,
    val updatedAt: Int = 0,
    val type: String = "",
    val locationType: String = "",
    val imageUrl: String = ""
)