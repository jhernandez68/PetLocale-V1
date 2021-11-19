package com.example.proyecto

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.item_servicio.view.*

class ServiciosAdapter(private val mContext: Context, private val listaServicios: List<Servicio>) : ArrayAdapter<Servicio>(mContext, 0, listaServicios) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_servicio, parent, false   )

        val servicio = listaServicios[position]

        layout.nombreService.text = servicio.nombre
        layout.precioService.text = "#" + servicio.precio + "Servicios"
        layout.imageViewService.setImageResource(servicio.imagen)

        return layout
    }
}