package com.example.betapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.betapp.databinding.ItemTennisplayerBinding

// Immportanweisung für die Picasso Bibliothek um Bilder aus dem Internet zu laden und falls das fehlschlägt, dafür das Fehlerbild eingüft
import com.squareup.picasso.Picasso

// ViewHolder, der das Binding für das item_tennisplayer Layout enthält
class TennisPlayerAdapter (private val players: List<Player>) : RecyclerView.Adapter<TennisPlayerAdapter.PlayerViewHolder>() {

    inner class PlayerViewHolder(val binding: ItemTennisplayerBinding) : RecyclerView.ViewHolder(binding.root)

    // Erstellt einen neuen ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding = ItemTennisplayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlayerViewHolder(binding)
    }

    // Bindet die Daten an den ViewHolder
    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        with(holder.binding) {
            val player = players[position]
            rankTennisTV.text = player.rank.toString()
            nameTennisTV.text = player.name
            pointsTennisTV.text = player.points.toString()

            // damit die Flaggenbilder von der URL geladen und in der Imageview angezeigt werden
            // (Bilder lokal erfasst worden) flagIV.setImageResource(player.flagDrawable)
            // Picasso.get().load(player.flagUrl).into(flagIV)

            Picasso.get()
                .load(player.flagUrl)
                .error(R.drawable.error404) // Ressourcen-ID des Fehlerbildes
                .into(flagTennisIV)
        }
    }

    override fun getItemCount():Int {
        return players.size
    }
}
