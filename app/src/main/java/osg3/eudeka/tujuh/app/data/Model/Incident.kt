package osg3.eudeka.tujuh.app.data.Model

data class Incident(
    val id: Int,
    val title: String = "",
    val description: String = "",
    val address: String = "",
    val occurredAt: Long = 0L,
    val updatedAt: Long = 0L,
    val type: String = "",
    val locationType: String = "",
    val imageUrl: String = ""
)