package com.example.betapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import android.util.Log
import android.content.Intent

// Importiert das generierte Binding für das item_layout
import com.example.betapp.databinding.ItemMainSportartauswahlBinding

// Adapter agiert als Brücke zwischen den Daten und der Recyclerview, er erstellt viewholder um den Inhalt bestimmter "items" in der RV darzustellen
class SportartAuswahlAdapter (private val itemList: List<Item>) : RecyclerView.Adapter<SportartAuswahlAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemMainSportartauswahlBinding) : RecyclerView.ViewHolder(binding.root) {
        val icon: ImageView = binding.sportauswahIV
        val text: TextView = binding.sportauswahlTV
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Das Layout für ein einzelnes Item aufblasen (d.h. in eine View umgewandelt).
        val binding = ItemMainSportartauswahlBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // ich erstelle mir eine Logcat NAchricht, falls es Probeme gibt, kann ich den Fehler leichter identifizieren
        Log.d("onBindViewholdertest", "SportauswahlRV & Friends! 🥹")

        // Holt das aktuelle Item basierend auf der Position
        val item = itemList[position]

        // Setzt die Daten des aktuellen Items (icon und text) in die Views des ViewHolders
        holder.icon.setImageResource(item.iconResource)
        holder.text.text = item.text

        // Setze einen OnClickListener für jedes Element, lediglich "Tennis" wird Klickbar gemacht
        holder.itemView.setOnClickListener {
            // wenn das Element Tennis betätigt wird, wird der intent mit der Absicht, die Tennisactivity aufzurufen erstellt
            if (item.text == "Tennis") {
                val intent = Intent(holder.itemView.context, TennisActivity::class.java)
                holder.itemView.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    data class Item(val iconResource: Int, val text: String)
}

