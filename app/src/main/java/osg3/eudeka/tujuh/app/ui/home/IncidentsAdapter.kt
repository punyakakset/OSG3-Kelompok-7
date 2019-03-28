package osg3.eudeka.tujuh.app.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_home_incidents.view.*
import osg3.eudeka.tujuh.app.R

class IncidentsAdapter(val context: Context, val incidents: ArrayList<String>) :
    RecyclerView.Adapter<IncidentsAdapter.IncidentsViewHolder>() {

    override fun getItemCount(): Int {
        return incidents.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncidentsViewHolder {
        return IncidentsViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home_incidents, parent, false))
    }

    override fun onBindViewHolder(holder: IncidentsViewHolder, position: Int) {
        holder.tvIncidentTitle.text = incidents[position]
    }

    class IncidentsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvIncidentTitle: TextView = view.tv_incident_title
    }
}