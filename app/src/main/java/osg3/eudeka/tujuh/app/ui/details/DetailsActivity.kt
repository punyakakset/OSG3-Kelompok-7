package osg3.eudeka.tujuh.app.ui.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_details.*
import osg3.eudeka.tujuh.app.GlideApp
import osg3.eudeka.tujuh.app.R
import osg3.eudeka.tujuh.app.data.Model.Incident

class DetailsActivity : AppCompatActivity() {

    companion object {
        const val INCIDENT_PARCEL = "incident_parcel"
    }

    val TAG = this.javaClass.simpleName
    lateinit var incident: Incident

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        setSupportActionBar(toolbar_details)
        collapsing_toolbar_details.title = "Incident Details"
        collapsing_toolbar_details.setCollapsedTitleTextColor(resources.getColor(android.R.color.white))
        collapsing_toolbar_details.setExpandedTitleColor(resources.getColor(R.color.colorPrimary))

        incident = intent?.getParcelableExtra(INCIDENT_PARCEL)!!

        if (incident.imageUrl.isNotEmpty())
            GlideApp.with(this).load(incident.imageUrl).centerCrop().into(iv_details_incident)
        else
            iv_details_incident.setImageResource(R.drawable.ic_launcher_background)

        tv_placeholder.text = incident.toString()


    }
}
