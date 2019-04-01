package osg3.eudeka.tujuh.app.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import osg3.eudeka.tujuh.app.R

class HomeActivity : AppCompatActivity() {

    var _dummyIncidents = arrayListOf(
        "incident 1",
        "incident 2",
        "incident 3",
        "incident 4",
        "incident 5",
        "incident 6"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_home_incidents.layoutManager = LinearLayoutManager(this)
        rv_home_incidents.adapter = IncidentsAdapter(this, _dummyIncidents)

    }
}
