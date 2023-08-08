package com.example.betapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import android.util.Log

// Importiert das generierte Binding für das item_layout
import com.example.betapp.databinding.ItemMainWettenfussballBinding

// Adapter erstellt ViewHolder-Objekte, um den Inhalt bestimmter "items" in der RecyclerView darzustellen.
class WettenFussballAdapter(private val wettenListe: List<Wette>) : RecyclerView.Adapter<WettenFussballAdapter.ViewHolder>() {

    // Der ViewHolder definiert einen Container für die Ansicht eines einzelnen Listeneintrags
    class ViewHolder(private val binding: ItemMainWettenfussballBinding) : RecyclerView.ViewHolder(binding.root) {
        // Direkter Zugriff auf die Views im Layout über das Binding-Objekt
        fun bind(wette: Wette) {
            binding.heimManschaftTV.text = wette.heimMannschaft
            binding.gastManschaftTV.text = wette.gastMannschaft
            binding.quoteFussballHeimTV.text = wette.quoteHeim
            binding.quoteFussballRemiTV.text = wette.quoteRemi
            binding.quoteFussballGastTV.text = wette.quoteGast
        }
    }

    // Diese Methode wird aufgerufen, um einen neuen ViewHolder zu erstellen.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Erstellt ein neues Binding-Objekt für das Layout wetten_fussbal.xml.
        val binding = ItemMainWettenfussballBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // Diese Methode bindet die Daten an den ViewHolder.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Holt die Daten für die aktuelle Position aus der Liste.
        val aktuelleWette = wettenListe[position]
        holder.bind(aktuelleWette)

        // Log-Nachricht hinzufügen, um den Ladevorgang zu überwachen
        Log.d("DataBinding", "Daten geladen für: " + aktuelleWette.heimMannschaft + " vs " + aktuelleWette.gastMannschaft)
    }

    // Gibt die Gesamtanzahl der Einträge in der Liste zurück.
    override fun getItemCount() = wettenListe.size

    // Datenklasse, die die Daten für einen einzelnen Listeneintrag repräsentiert.
    data class Wette(
        val heimMannschaft: String,
        val gastMannschaft: String,
        val quoteHeim: String,
        val quoteRemi: String,
        val quoteGast: String
    )
}