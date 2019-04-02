package osg3.eudeka.tujuh.app.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_home_incidents.view.*
import osg3.eudeka.tujuh.app.R
import osg3.eudeka.tujuh.app.data.Model.Incident
import java.text.SimpleDateFormat
import java.util.*

class IncidentsAdapter(val context: Context, val incidents: List<Incident>) :
    RecyclerView.Adapter<IncidentsAdapter.IncidentsViewHolder>() {

    override fun getItemCount(): Int {
        return incidents.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncidentsViewHolder {
        return IncidentsViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home_incidents, parent, false))
    }

    override fun onBindViewHolder(holder: IncidentsViewHolder, position: Int) {
        val incident = incidents[position]
        val dateFormat = SimpleDateFormat("dd MMM yyyy, HH:mm:ss")
        holder.tvIncidentTitle.text = if (incident.title.isEmpty()) "No Title" else incident.title
        holder.tvIncidentType.text = incident.type
        holder.tvIncidentAddress.text = if (incident.address.isEmpty()) "No Address" else incident.address
        holder.tvIncidentTime.text =
            if (incident.occurredAt != 0L) "Waktu: ${dateFormat.format(Date(incident.occurredAt * 1000))}" else "Waktu: -"
        if (incident.imageUrl.isNotEmpty())
            Glide.with(context).load(incident.imageUrl).centerCrop().into(holder.ivIncidentImgThumb)
        else
            holder.ivIncidentImgThumb.setImageResource(R.drawable.ic_launcher_background)

        holder.itemView.setOnClickListener {
            Snackbar.make(
                (context as HomeActivity).cl_home_activity,
                "Go to ${incident.id} details screen",
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }

    class IncidentsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvIncidentTitle: TextView = view.tv_incident_title
        val tvIncidentAddress: TextView = view.tv_incident_address
        val tvIncidentType: TextView = view.tv_incident_type
        val tvIncidentTime: TextView = view.tv_incident_time
        val ivIncidentImgThumb: ImageView = view.iv_incident_img_thumb
    }
}