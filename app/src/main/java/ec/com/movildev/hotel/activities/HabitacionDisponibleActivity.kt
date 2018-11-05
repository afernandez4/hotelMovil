package ec.com.movildev.hotel.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import ec.com.movildev.hotel.adapter.ReservaAdapter
import ec.com.movildev.hotel.entidades.Habitacion
import ec.com.movildev.hotel.util.Utilitario
import kotlinx.android.synthetic.main.habitaciones_disponibles_layout.*

class HabitacionDisponibleActivity : AppCompatActivity() {


    var util: Utilitario = Utilitario()
    private var habitacionesDisponibles = ArrayList<Habitacion>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.habitaciones_disponibles_layout)
        etDesde.setOnClickListener { view ->
            util.obtenerFecha(view, this)
        }
        etHasta.setOnClickListener{ view ->
            util.obtenerFecha(view, this)
        }
        llenarListaHabitaciones()
    }

    fun llenarListaHabitaciones(){
        habitacionesDisponibles.add(Habitacion(1, "Habitación 502"))
        habitacionesDisponibles.add(Habitacion(2, "Habitación 203"))
        habitacionesDisponibles.add(Habitacion(3, "Habitación 404"))
        var reservaAdapter = ReservaAdapter(this,  habitacionesDisponibles)
        lvHabitaciones.adapter = reservaAdapter
        lvHabitaciones.setOnItemClickListener { adapter, view, position, id ->
            Toast.makeText(this, "Seleccionado: "+habitacionesDisponibles[position].numHabitacion, Toast.LENGTH_LONG).show()
        }
    }

}