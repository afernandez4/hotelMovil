package ec.com.movildev.hotel.util

import android.app.DatePickerDialog
import android.content.Context
import android.view.View
import android.widget.EditText
import java.util.*

class Utilitario() {

    var BARRA = "/"
    var CERO = "0"
    var c = Calendar.getInstance()
    var mes = c.get(Calendar.MONTH)
    var dia = c.get(Calendar.DAY_OF_MONTH)
    var anio = c.get(Calendar.YEAR)

    fun obtenerFecha(et: View, context: Context) {
        val dpd = DatePickerDialog(context, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            mes = monthOfYear + 1
            val mesFormateado = if (mes < 10) CERO + mes else "" + mes
            val diaFormateado = if (dayOfMonth < 10) CERO + dayOfMonth else "" + dayOfMonth
            if (et is EditText)
                et.setText("" + diaFormateado + BARRA + mesFormateado + BARRA + year)
        }, anio, mes, dia)
        dpd.show()
    }

}