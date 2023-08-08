package com.example.betapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.betapp.databinding.ActivitySplashBinding
import android.content.Intent

class SplashActivity : AppCompatActivity() {

    // definieren der viewBinding Klasse
    private  lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // initialisieren der viewBinding Instanz, inflate ist eine Methode die xml Dateien in tatsächliche Objekte umwandelt, der layoutInflater ist der Systemdienst der dies ermöglicht
        binding = ActivitySplashBinding.inflate(layoutInflater)

        // setzt den Inhalt der Ansicht, "root" ist das oberste Layout der xml-Layout Datei
        setContentView(binding.root)

        // setzt das Maximum der ProgressBar auf 100
        binding.ladestatusSplashPB.max = 100

        // starten der eingebauten Countdown Timer Klasse, läuft nach 3 Sekunden ab
        object: CountDownTimer(3500,30) {
            override fun onTick(millisUntilFinished: Long) {
            // "onTick" die Methode wird jede 30 millisekunden aufgerufen und aktualisiert den Fortschritt der Progressbar
            val progress = ((3500 - millisUntilFinished) / 30).toInt()
            binding.ladestatusSplashPB.progress = progress
            }

            // Methode wird aufgerufen wenn der Countdown abgelaufen ist, die MainActivity startet hier und die SplashActivity wird beendet
            override fun onFinish() {
                //  die Progressbar ist voll wenn der Timer abgelaufen ist
                binding.ladestatusSplashPB.progress = 100
                startActivity(Intent(this@SplashActivity,WelcomeActivity::class.java))
                finish()
            }
        }.start()   // startet den Timer
    }
}