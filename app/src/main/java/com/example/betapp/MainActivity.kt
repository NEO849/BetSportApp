package com.example.betapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.betapp.databinding.ActivityMainBinding
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    // Definieren der ViewBinding Klasse
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialisieren der viewBinding Instanz
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialisiert die Toolbar und setzt die ActionBar
        setupToolbar()

        // OnClickListener für den selbst erstellten Zurück-Pfeil setzen
        setupBackButton()

        // Daten für den SportauswahlAdapter erstellen und RecyclerView konfigurieren
        setupSportauswahlRecyclerView()

        // Daten für den WettenFussballAdapter erstellen und RecyclerView konfigurieren
        setupWettenRecyclerView()
    }

    // Richtet die Toolbar und setzt sie als Actionbar
    private fun setupToolbar () {
        // Initialisiere und setze die benutzdefinierte Toolbar
        val toolbar: Toolbar = binding.mainTB
        setSupportActionBar(toolbar)

        // Konfiguriere die Toolbar
        supportActionBar?.setDisplayShowHomeEnabled(true)           // Zeigt das Appsymbol an
        supportActionBar?.setDisplayHomeAsUpEnabled(false)          // Verbirgt den Standartmäßig gesetzten Zurück-Pfeil
        supportActionBar?.setDisplayShowTitleEnabled(false)         // Verbirgt das Standartmäßig gesetzte Appnamen Textfeld
    }

    // Setzt und Richtet den onClickListener für den selbstdefinierten Zurück-Pfeil
    private fun setupBackButton () {
        binding.backArrowIBT.setOnClickListener {
            finish()
        }
    }

    // Daten für den Adapter erstellen und RecyclerView konfigurieren
    private fun setupSportauswahlRecyclerView() {

        val sportartenListe = listOf(
            SportartAuswahlAdapter.Item(R.drawable.baseline_sports_tennis_24, "Tennis"),
            SportartAuswahlAdapter.Item(R.drawable.baseline_sports_soccer_24, "Fußball"),
            SportartAuswahlAdapter.Item(R.drawable.baseline_sports_football_24, "Football"),
            SportartAuswahlAdapter.Item(R.drawable.baseline_sports_motorsports_24, "Rennrad"),
            SportartAuswahlAdapter.Item(R.drawable.baseline_sports_kabaddi_24, "Gewichte"),
            SportartAuswahlAdapter.Item(R.drawable.baseline_sports_score_24, "Golf"),
            SportartAuswahlAdapter.Item(R.drawable.baseline_skateboarding_24, "Skaten"),
            SportartAuswahlAdapter.Item(R.drawable.baseline_surfing_24, "Surfen"),
            SportartAuswahlAdapter.Item(R.drawable.baseline_sports_cricket_24, "Tisch-T"),
            SportartAuswahlAdapter.Item(R.drawable.baseline_sports_tennis_24, "Tennis"),
            SportartAuswahlAdapter.Item(R.drawable.baseline_sports_soccer_24, "Fußball"),
            SportartAuswahlAdapter.Item(R.drawable.baseline_sports_football_24, "Football"),
            SportartAuswahlAdapter.Item(R.drawable.baseline_sports_motorsports_24, "Rennrad"),
            SportartAuswahlAdapter.Item(R.drawable.baseline_sports_kabaddi_24, "Gewichte"),
            SportartAuswahlAdapter.Item(R.drawable.baseline_sports_score_24, "Golf"),
            SportartAuswahlAdapter.Item(R.drawable.baseline_skateboarding_24, "Skaten"),
            SportartAuswahlAdapter.Item(R.drawable.baseline_surfing_24, "Surfen"),
            SportartAuswahlAdapter.Item(R.drawable.baseline_sports_cricket_24, "Tisch-T")
        )
        // Setzen von LayoutManager und Adapter für die RecyclerView
        binding.sportartAuswahlRV.layoutManager = LinearLayoutManager(this)
        binding.sportartAuswahlRV.adapter = SportartAuswahlAdapter(sportartenListe)
    }
    // Daten für den WettenFussballAdapter erstellen und RecyclerView konfigurieren
    private fun setupWettenRecyclerView() {
        val wettenListe = listOf(
            WettenFussballAdapter.Wette("Bayern", "Schalke", "1.2", "2.3", "3.1"),
            WettenFussballAdapter.Wette("Bremen", "Loh", "1.2", "5.3", "8.6"),
            WettenFussballAdapter.Wette("Ulm", "Winzer", "2.2", "2.3", "3.4"),
            WettenFussballAdapter.Wette("Gera", "Schalke", "4.2", "5.9", "7.9"),
            WettenFussballAdapter.Wette("Bayern", "Bremen", "1.6", "2.1", "1.3"),
            WettenFussballAdapter.Wette("Schalke", "Loh", "4.2", "7.4", "3.6"),
            WettenFussballAdapter.Wette("Winzer", "Juve", "1.7", "4.2", "6.8"),
            WettenFussballAdapter.Wette("Bayern", "Gera", "2.2", "2.3", "2.4"),
            WettenFussballAdapter.Wette("Schalke", "Bremen", "1.9", "1.8", "4.1"),
            WettenFussballAdapter.Wette("Loh", "Winzer", "7.2", "2.0", "3.4"),
            WettenFussballAdapter.Wette("Bayern", "Bremen", "1.6", "2.1", "1.3"),
            WettenFussballAdapter.Wette("Schalke", "Loh", "4.2", "7.4", "3.6"),
            WettenFussballAdapter.Wette("Winzer", "Juve", "1.7", "4.2", "6.8"),
            WettenFussballAdapter.Wette("Bayern", "Gera", "2.2", "2.3", "2.4"),
            WettenFussballAdapter.Wette("Schalke", "Bremen", "1.9", "1.8", "4.1"),
            WettenFussballAdapter.Wette("Loh", "Winzer", "7.2", "2.0", "3.4"),
            WettenFussballAdapter.Wette("Bayern", "Schalke", "1.2", "2.3", "3.1"),
            WettenFussballAdapter.Wette("Bremen", "Loh", "1.2", "5.3", "8.6"),
            WettenFussballAdapter.Wette("Ulm", "Winzer", "2.2", "2.3", "3.4"),
            WettenFussballAdapter.Wette("Gera", "Schalke", "4.2", "5.9", "7.9"),
            WettenFussballAdapter.Wette("Bayern", "Bremen", "1.6", "2.1", "1.3"),
            WettenFussballAdapter.Wette("Schalke", "Loh", "4.2", "7.4", "3.6"),
            WettenFussballAdapter.Wette("Winzer", "Juve", "1.7", "4.2", "6.8"),
            WettenFussballAdapter.Wette("Bayern", "Gera", "2.2", "2.3", "2.4"),
            WettenFussballAdapter.Wette("Schalke", "Bremen", "1.9", "1.8", "4.1"),
            WettenFussballAdapter.Wette("Loh", "Winzer", "7.2", "2.0", "3.4"),
            WettenFussballAdapter.Wette("Bayern", "Bremen", "1.6", "2.1", "1.3"),
            WettenFussballAdapter.Wette("Schalke", "Loh", "4.2", "7.4", "3.6"),
            WettenFussballAdapter.Wette("Winzer", "Juve", "1.7", "4.2", "6.8"),
            WettenFussballAdapter.Wette("Bayern", "Gera", "2.2", "2.3", "2.4"),
            WettenFussballAdapter.Wette("Schalke", "Bremen", "1.9", "1.8", "4.1"),
            WettenFussballAdapter.Wette("Loh", "Winzer", "7.2", "2.0", "3.4"),
            WettenFussballAdapter.Wette("Bayern", "Schalke", "1.2", "2.3", "3.1"),
            WettenFussballAdapter.Wette("Bremen", "Loh", "1.2", "5.3", "8.6"),
            WettenFussballAdapter.Wette("Ulm", "Winzer", "2.2", "2.3", "3.4"),
            WettenFussballAdapter.Wette("Gera", "Schalke", "4.2", "5.9", "7.9"),
            WettenFussballAdapter.Wette("Bayern", "Bremen", "1.6", "2.1", "1.3"),
            WettenFussballAdapter.Wette("Schalke", "Loh", "4.2", "7.4", "3.6"),
            WettenFussballAdapter.Wette("Winzer", "Juve", "1.7", "4.2", "6.8"),
            WettenFussballAdapter.Wette("Bayern", "Gera", "2.2", "2.3", "2.4"),
            WettenFussballAdapter.Wette("Schalke", "Bremen", "1.9", "1.8", "4.1"),
            WettenFussballAdapter.Wette("Loh", "Winzer", "7.2", "2.0", "3.4"),
            WettenFussballAdapter.Wette("Bayern", "Bremen", "1.6", "2.1", "1.3"),
            WettenFussballAdapter.Wette("Schalke", "Loh", "4.2", "7.4", "3.6"),
            WettenFussballAdapter.Wette("Winzer", "Juve", "1.7", "4.2", "6.8"),
            WettenFussballAdapter.Wette("Bayern", "Gera", "2.2", "2.3", "2.4"),
            WettenFussballAdapter.Wette("Schalke", "Bremen", "1.9", "1.8", "4.1"),
            WettenFussballAdapter.Wette("Loh", "Winzer", "7.2", "2.0", "3.4"),
            WettenFussballAdapter.Wette("Bayern", "Schalke", "1.2", "2.3", "3.1"),
            WettenFussballAdapter.Wette("Bremen", "Loh", "1.2", "5.3", "8.6"),
            WettenFussballAdapter.Wette("Ulm", "Winzer", "2.2", "2.3", "3.4"),
            WettenFussballAdapter.Wette("Gera", "Schalke", "4.2", "5.9", "7.9"),
            WettenFussballAdapter.Wette("Bayern", "Bremen", "1.6", "2.1", "1.3"),
            WettenFussballAdapter.Wette("Schalke", "Loh", "4.2", "7.4", "3.6"),
            WettenFussballAdapter.Wette("Winzer", "Juve", "1.7", "4.2", "6.8"),
            WettenFussballAdapter.Wette("Bayern", "Gera", "2.2", "2.3", "2.4"),
            WettenFussballAdapter.Wette("Schalke", "Bremen", "1.9", "1.8", "4.1"),
            WettenFussballAdapter.Wette("Loh", "Winzer", "7.2", "2.0", "3.4"),
            WettenFussballAdapter.Wette("Bayern", "Bremen", "1.6", "2.1", "1.3"),
            WettenFussballAdapter.Wette("Schalke", "Loh", "4.2", "7.4", "3.6"),
            WettenFussballAdapter.Wette("Winzer", "Juve", "1.7", "4.2", "6.8"),
            WettenFussballAdapter.Wette("Bayern", "Gera", "2.2", "2.3", "2.4"),
            WettenFussballAdapter.Wette("Schalke", "Bremen", "1.9", "1.8", "4.1"),
            WettenFussballAdapter.Wette("Loh", "Winzer", "7.2", "2.0", "3.4"),
        )
        val adapter = WettenFussballAdapter(wettenListe)

        binding.wettenLiveRV.layoutManager = LinearLayoutManager(this)
        binding.wettenLiveRV.adapter = adapter
    }
}
