package com.example.beachsearch.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.beachsearch.R
import com.example.beachsearch.model.BeachModel

class BeachAdapter(
    private val beaches: MutableList<BeachModel>,
    private val onRemove: (BeachModel) -> Unit
): RecyclerView.Adapter<BeachAdapter.BeachViewHolder>(){

    class BeachViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nomeTextView: TextView = itemView.findViewById<TextView>(R.id.nomePraia)
        val cidadeTextView: TextView = itemView.findViewById<TextView>(R.id.cidade)
        val estadoTextView: TextView = itemView.findViewById<TextView>(R.id.estado)
        val removeButton: ImageButton? = itemView.findViewById<ImageButton>(R.id.btnRemove)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeachViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return BeachViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BeachViewHolder, position: Int) {
        val beach = beaches[position]
        holder.nomeTextView.text = beach.nome
        holder.cidadeTextView.text = beach.cidade
        holder.estadoTextView.text = beach.estado
        holder.removeButton?.setOnClickListener {
            onRemove(beach)
        }

    }

    override fun getItemCount() = beaches.size
}