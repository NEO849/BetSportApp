package com.example.betapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.example.betapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    // Definieren der viewBinding Klasse
    private  lateinit var binding: ActivityLoginBinding

    // Dies ist der Einstiegspunkt für die Aktivität. Hier werden die UI-Komponenten initialisiert und Event-Listener eingerichtet.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialisieren die viewBinding Instanz, inflate ist eine Methode die xml Dateien in tatsächliche Objekte umwandelt, der layoutInflater ist der Systemdienst der dies ermöglicht
        binding = ActivityLoginBinding.inflate(layoutInflater)

        // Setzt die Inhaltsansicht für diese Aktivität
        setContentView(binding.root)

        // Toolbar und Actionbar einrichten
        setupToolbar()

        // Klicklistener für die UI-Komponenten einrichten
        setupClickListeners()
    }

    // Richtet die Toolbar und setzt sie als Actionbar
    private fun setupToolbar () {
        // Initialisiere und setze die benutzdefinierte Toolbar
        val toolbar: Toolbar = binding.loginTB
        setSupportActionBar(toolbar)

        // Actionbar konfigurieren
        supportActionBar?.apply {
            setDisplayShowHomeEnabled(true)          // Zeigt das Appsymbol an
            setDisplayHomeAsUpEnabled(false)         // Verbirgt den Standartmäßig gesetzten Zurück-Pfeil
            setDisplayShowTitleEnabled(false)        // Verbirgt das Standartmäßig gesetzte Appnamen Textfeld
        }
    }

    // Richtet die Klick-Listener für die Klickbaren Objekte ein
    private fun setupClickListeners () {
        // Ich verwende das Binding um den OnClickListener auf den Zurück-Pfeil zu setzen
        binding.backArrowIBT.setOnClickListener {
            finish()
        }

        // Ich verwende das Binding um den OnClickListener auf den login Button zu setzen
        binding.loginBT.setOnClickListener {
            // Die Konstante intent erstellen und definieren,(Intent represäntiert eine "Absicht", eine Aktion auszuführen) das bei Betätigen des Login Button von der LoginActivity zur MainActivity gewechselt wird
            val intent = Intent(this, MainActivity::class.java)
            // die Activity mit dem gerade erstellten Intent starten
            startActivity(intent)
            // finish() // Optional: Die LoginActivity schliessen, damit nach erfolgreichem Login nicht zur LoginActivity zurück gekehrt werden kann, wird jetzt noch nicht benötigt
        }
    }

    // Die Methode wird aufgerufen wenn in der Toolbar auf den Zurück- Pfeil gedrückt wird, sie gibt den passenden Boolean zurück
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            // Überprüft, ob das ausgewählte Menüelement der "Zurück"-Pfeil ist und gibt dieses via return zurück
            android.R.id.home -> {
                finish()
                true
            }
            // Wenn das ausgewählte Menüelement nicht der "Zurück"-Pfeil ist, wird die übergeordnete Methode aufgerufen, das stellt sicher, wenn ich keinen Code für die anderen Element definiert habe,
            // wird das Standartverhalten der übergeordneten Klasse aufgerufen (für Lupe und Burgermenu)
            else -> super.onOptionsItemSelected(item)
        }
    }
}