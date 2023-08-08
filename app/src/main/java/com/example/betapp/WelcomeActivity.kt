package com.example.betapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.betapp.databinding.ActivityWelcomeBinding
import android.content.Intent
import android.media.MediaPlayer

class WelcomeActivity : AppCompatActivity() {

    // Definieren der viewBinding Klasse
    private  lateinit var binding: ActivityWelcomeBinding

    // MediaPlayer- Instanz erstellen
    private  lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialisieren der viewBinding Instanz, inflate ist eine Methode die xml Dateien in tatsächliche Objekte umwandelt, der layoutInflater ist der Systemdienst der dies ermöglicht
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        // Setzt den Inhalt der Ansicht, "root" ist das oberste Layout der xml-Layout Datei
        setContentView(binding.root)

        // MediaPlayer mit der Musikdatei initialisieren
        mediaPlayer = MediaPlayer.create(this, R.raw.foreverbelieve)

        // OnClickListener für den login Button setzen
        binding.loginregisterBT.setOnClickListener {
            // Die Konstante intent erstellen und definieren,(Intent represänteirt eine "Absicht", eine Aktion auszuführen) das bei Betätigen Login Button von der WelcomeActivity die LoginActivity gestartet wird
            val intent = Intent(this, LoginActivity::class.java)
            // Ich starte die Activity mit dem gerade erstellten Intent
            startActivity(intent)
        }

        // OnClickListener für den Musik Button setzen
        binding.musikBT.setOnClickListener {
            // Überprüfen ob die musik bereits abgespielt wird
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
            } else {
                mediaPlayer.start()
            }
        }
    }

    // MediaPlayer-Ressourcen freigeben, wenn die Activity zerstört wird
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}