package ec.com.movildev.hotel.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import ec.com.movildev.hotel.activities.R
import ec.com.movildev.hotel.entidades.Habitacion

class ReservaAdapter : BaseAdapter {

    private var habitacionesList = ArrayList<Habitacion>()
    private var context: Context? = null
    lateinit var layoutInflater: LayoutInflater

    constructor(context: Context, notesList: ArrayList<Habitacion>) : super() {
        this.habitacionesList = notesList
        this.context = context
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val view: View?
        val vh: ViewHolder

        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.item_habitacion, parent, false)
            vh = ViewHolder()
            view.tag = vh
        } else {
            view = convertView
            vh = view.tag as ViewHolder
        }
        vh.tvHab = view!!.findViewById(R.id.tvHabitacion)
        vh.tvHab.text = habitacionesList[position].numHabitacion
        return view
    }

    override fun getItem(position: Int): Any {
        return habitacionesList[position]
    }

    override fun getItemId(position: Int): Long {
        // return item Id by Long datatype
        return position.toLong()
    }

    override fun getCount(): Int {
        return habitacionesList.size
    }

    class ViewHolder() {
        lateinit var tvHab: TextView
    }

}