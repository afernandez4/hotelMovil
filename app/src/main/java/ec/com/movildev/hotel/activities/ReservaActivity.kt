package ec.com.movildev.hotel.activities

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import ec.com.movildev.hotel.activities.R
import ec.com.movildev.hotel.util.Utilitario
import kotlinx.android.synthetic.main.reserva_activity.*
import java.util.*

class ReservaActivity : AppCompatActivity() {


    var util: Utilitario = Utilitario()
    var habitaciones = arrayOf("Habitación 501", "Habitación 204", "Habitación 202")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reserva_activity)
        etFechaDesde.setOnClickListener { view ->
            util.obtenerFecha(view, this)
        }
        etFechaHasta.setOnClickListener { view ->
            util.obtenerFecha(view, this)
        }
        llenarHabitaciones()
    }

    fun llenarHabitaciones(){
        // Create an ArrayAdapter using a simple spinner layout and languages array
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, habitaciones)
        // Set layout to use when the list of choices appear
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        spHabitaciones!!.setAdapter(aa)
    }
}