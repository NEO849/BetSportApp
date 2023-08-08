package com.example.betapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.betapp.databinding.ActivityTennisBinding
import androidx.recyclerview.widget.LinearLayoutManager

class TennisActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTennisBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialisieren der viewBinding Instanz
        binding = ActivityTennisBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialisiert die Toolbar und setzt die ActionBar
        setupToolbar()

        // OnClickListener für den selbst erstellten Zurück-Pfeil setzen
        setupBackButton()

        // Daten für den TennisPlayerAdapter erstellen und RecyclerView konfigurieren
        setupRecyclerView()
    }

    // Einrichten der Toolbar und setzen als Actionbar
    private fun setupToolbar() {
        // Initialisiere und setze die benutzdefinierte Toolbar
        val toolbar: Toolbar = binding.mainTB
        setSupportActionBar(toolbar)

        // Konfiguriere die Toolbar
        supportActionBar?.setDisplayShowHomeEnabled(true)           // Zeigt das Appsymbol an
        supportActionBar?.setDisplayHomeAsUpEnabled(false)          // Verbirgt den Standartmäßig gesetzten Zurück-Pfeil
        supportActionBar?.setDisplayShowTitleEnabled(false)         // Verbirgt das Standartmäßig gesetzte Appnamen Textfeld
    }

    // Setzt und Richtet den onClickListener für den selbstdefinierten Zurück-Pfeil
    private fun setupBackButton() {
        binding.backArrowIBT.setOnClickListener {
            finish()
        }
    }

    // Setzt den Adapter und den LayoutManager für die RecyclerView
    private fun setupRecyclerView() {
        // Abrufen der Arrays von Spielerdaten aus den Ressourcen (definiert in strings.xml)
        val ranks = resources.getStringArray(R.array.player_ranks)
        val names = resources.getStringArray(R.array.player_names)
        val points = resources.getIntArray(R.array.player_points)
        val flags = resources.getStringArray(R.array.player_flags_urls)

        // Erstellt eine Liste von Player Objekten
        val players = List(ranks.size) { index ->
            Player(
                rank = ranks[index].toInt(),
                name = names[index],
                points = points[index],
                flagUrl = flags[index]
            )
        }

        // Setzt den LayoutManager für die RecyclerView, mittels LinearLayoutManager werden die Elemente angeordnet
        binding.tennisplayerRV.layoutManager = LinearLayoutManager(this)

        // Setzt den Adapter für die RecyclerView, in diesem Fall verwenden wir einen TennisRanglisteAdapter, der jedes Player-Objekt in einem Listenelement anzeigt
        binding.tennisplayerRV.adapter = TennisPlayerAdapter(players)
    }
}