package osg3.eudeka.tujuh.app.ui.details

import android.animation.LayoutTransition
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_details.*
import osg3.eudeka.tujuh.app.GlideApp
import osg3.eudeka.tujuh.app.R
import osg3.eudeka.tujuh.app.data.Model.Incident
import java.text.SimpleDateFormat
import java.util.*

class DetailsActivity : AppCompatActivity() {

    companion object {
        const val INCIDENT_PARCEL = "incident_parcel"
    }

    val TAG = this.javaClass.simpleName
    lateinit var incident: Incident

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Fetch Incident data from parcel
        incident = intent?.getParcelableExtra(INCIDENT_PARCEL)!!

        // Setup Collapsing Toolbar
        setSupportActionBar(toolbar_details)
        collapsing_toolbar_details.title = "Incident #${incident.id}"
        collapsing_toolbar_details.setCollapsedTitleTextColor(resources.getColor(android.R.color.black))
        collapsing_toolbar_details.setExpandedTitleColor(resources.getColor(android.R.color.white))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Enable layout transition for coordinatorlayout
        cl_detail_activity.layoutTransition = LayoutTransition().apply {
            this.enableTransitionType(LayoutTransition.CHANGING)
        }

        fab_open_nearby_hospital_list.setOnClickListener {
            Snackbar.make(cl_detail_activity, "Open Nearby Hospital List BottomSheet Dialog", Snackbar.LENGTH_SHORT)
                .show()
        }

        // Populate data
        setupUiWithData()


    }

    private fun setupUiWithData() {
        val dateFormat = SimpleDateFormat("dd MMM yyyy, HH:mm:ss", Locale("in"))
        if (incident.imageUrl.isNotEmpty())
            GlideApp.with(this).load(incident.imageUrl).centerCrop().into(iv_details_incident)
        else
            iv_details_incident.setImageResource(R.drawable.ic_launcher_background)
        tv_title.text = if (incident.title.isNotEmpty()) incident.title else "No Title"
        chip_type.text = incident.type
        tv_address.text = if (incident.address.isNotEmpty()) incident.address else "No Address"
        tv_description.text = if (incident.description.isNotEmpty()) incident.description else "No Description"
        tv_occurred_at.text =
            if (incident.occurredAt != 0L) "Waktu: ${dateFormat.format(Date(incident.occurredAt * 1000))}" else "Waktu: -"
        tv_updated_at.text =
            if (incident.updatedAt != 0L) "Update: ${dateFormat.format(Date(incident.updatedAt * 1000))}" else "Update: -"
    }
}
