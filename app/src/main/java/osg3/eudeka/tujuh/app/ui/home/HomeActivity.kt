package osg3.eudeka.tujuh.app.ui.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import osg3.eudeka.tujuh.app.R
import osg3.eudeka.tujuh.app.data.Model.Incident
import osg3.eudeka.tujuh.app.viewmodel.HomeActivityViewModel

class HomeActivity : AppCompatActivity() {

    lateinit var model: HomeActivityViewModel
    lateinit var adapter: IncidentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Init RV
        rv_home_incidents.layoutManager = LinearLayoutManager(this)
        // Init Viewmodel
        model = ViewModelProviders.of(this).get(HomeActivityViewModel::class.java)

    }

    override fun onResume() {
        super.onResume()
        model.getRecentIncidents().observe(this, Observer<List<Incident>> { incidents ->
            adapter = IncidentsAdapter(this, incidents)
            if (incidents.isNullOrEmpty()) {
                hideList()
            } else {
                showList()
                rv_home_incidents.adapter = adapter
            }
        })
    }

    fun showList() {
        tv_empty_view.visibility = View.GONE
        rv_home_incidents.visibility = View.VISIBLE
    }

    fun hideList() {
        tv_empty_view.visibility = View.VISIBLE
        rv_home_incidents.visibility = View.GONE
    }
}
