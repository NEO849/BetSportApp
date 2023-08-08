# Top 100 - Sport/Wett und Statistik App

### Hallo zusammen...
### Das ist mein erster ernstzunehmender Versuch eine App in Android Studio zu Programmieren. 

### Was bis jetzt in Funktion ist:
    1. Splashscreen, läuft Automatisch... ;-)
    2. Login/Register Button
    3. Musik Button, läßt sich wie vermutet Musik zur App ein und ausschalten
    4. erster Screen (Login), Login/Register-Button Klickbar, Recyclerview Horizontal scroolen
    5. zweiter Scrren (Welcome), Login-Button Klickbar und in der Actionar der Zurück Pfeil mit Funktion
    6. dritter Scrren (Main), linke Recyclerview kann man Sportarten auswaählen, wobei lediglich Tennis Klickbar ist -> Weltrangliste
        die rechte Recyclerview läßt sich vertical scrollen, simuliert Wetten, ohne Funktion bei Klick
        und der Zurückpfeil ist mit Funktion
    7. Tennisactivity, zeigt die Tennisweltrangliste, von 1-100 mit Rang, Länderflagge aus dem Internet per Picasso, Name und Punktzahl
    8. Backlink als Danke für die Länderflagen, verweist auf die Webseite des Anbieters -> https://flagpedia.net
    9. Link zum Anbiter des Kostenlosen Back Image, falls man die Webseite verlinkt -> <a href="https://www.flaticon.com/free-icons/link" title="link icons">Link icons erstellt von bqlqn - Flaticon</a>

### Wie und Was:

Hier kommt noch, warum ich so programmiert habe...

Theme geändert, dadurch kann man Farbe, Hintergrund, etc von Buttons und den anderen Komponenten ändern

I. View Binding in der "build.gradle(Modul:app)" Datei aktivieren
        
    1. dazu füge ich den "viewBinding" Block innerhalb des "android" Blocks hinzu und synchronisiere das Projekt
    2. jetzt generiert AS automatisch eine Binding Klasse für jede xml-Layoutdatei
    3. Erstellen einer Instanz der generierten Binding-Klasse z.B.   private ActivityMainBinding binding;
       jetzt kann man ohne "findViewById" auf die Views zugreifen

II. Splash Screen ertsellen

    1. eigenes App Logo in res/drawable gespeichert
    2. im MainActivity Ordner - "Empty Activity" erstellen und unter "SplashActivity" speichern
    3. in der activity_splash.xml, definiere ich das Layout vom Splashscreen
    4. in der AndroidManifest.xml ändere ich den Einstiegspunkt der App von MainActivity zur SplashActivity 
        (inten-filter verschieben, "/"-versetzen und "exported" -Zustand bei beiden ändern. Anwendung von außerhalb Ausführbar, oder nicht.)

III. Logik in der SplashActivity.kt definieren 

    1. um viewBinding zu nutzen muß in jeder .kt die dafür generierte Binding Klasse importiert werden:
        * import com.example.betapp.databinding.ActivitySplashBinding
    2. immer wenn man zwischen zwei Komponenten wie Activities zu wechseln muß immer die "Intent" Klasse importiert werden
        * import android.content.Intent
    3. eine Instanz der viewBinding Klasse definieren, "lateinit" weil:
        * Vermeidung von NUll Sicherheitsprüfungen, indem ich dem Compiler "VERSPRECHE" 😂 die Variable zu initialisieren bevor ich sie Aufrufe
        * dadurch kann man die Initialisierung verzögern bis dei Variable tatsächlich benötigt wird
        * Effizienz, wenn eine Initialisierung Rechenintensiv ist, kann es sinnvoll sein, diese zu verzögern
    4. Initialisieren der viewBinding Instanz und setzen des Layouts, indem ich die "onCreate" Methode überschreibe

IV. Welcomescreen 
    Der Benutzer kann hat die Möglichkeit sich über den Button ein zu Loggen, bzw. sich zu Registrieren, als kleines Gimik, kann man Musik einschalten, COMING SOON... 😅

    1. WelcomeActivity.kt über new / activity/ empty viewActivity erstellt, dadurch wird automatisch die dazugehörige xml Datei erstellt
    2. in der SplashActivity die WelcomeActivity als Folgescreen von der SplasActivity gesetzt
    3. Layout definieren, anschließend den Login/Register Button setzen
    4. Horizontal Scrollview mit 7 Sportartenbildern gesetzt

V. LogIn / Register Screen
    Der Benutzer hat die Möglichkeit, sich mit Username und Passwort anzumelden und anschließend den Login Button wählen

    1. activity_logIn.xml erstellt und Layout definiert
    2. Top App Bar definiert, mit Back Pfeil und Burger Menu
    3. Textinputfelder, sowie "Login, "Passwort vergessen" und "Register here"

VI. Main- Datei definieren, wird der Haupt - Auswahlscreen der App

    1. activity_main.xml layout definiert 
        * vertikale RecyclerView für die Sportartauswahl erstellt
        * Sportauswahl-Adapter erstellt, der die horizontal angeordneten Bilder und Textfelder definiert
        * Layout für die einzelnen RV-Elemente (Bild und Textfeld) erstellen und in res/drawable abspeichern (sportartauswahl.xml)
    2. Auswahlmöglichkeiten anbieten
    3. Werbung, Infos, Cardviews, etc
    4. alles in der MainActivity.kt alles intialisieren und die Adapter setzen

VII. Logik definieren

    1. in der WelcomeActivity.kt den Login/Register Button definieren, bei Betätigen wird der Benutzer zum Loginscreen weitergeleitet
        * viewBinding deklarieren und initialisieren
        * die Binding-Klasse verwendet um einen OnClickListener hinzuzufügen und auf den Login/Register Button gesetzt
        * Konstante "intent" erstellen und definieren

    2. in der LoginActivity.kt den Login Button definieren, bei Betätigen wird der Benutzer zum Haupt-Screen (Mainactivity) witergeleitet
        * viewBinding deklarieren und initialisieren
        * die Binding-Klasse verwendet um einen OnClickListener hinzuzufügen und auf den Login Button gesetzt
        * Konstante "intent" erstellen und definieren
        * OPTIONAL: die LoginActivity mit "finish()" schliessen, damit der Benutzer nach erfolgreicher Anmeldung daran gehindert wird mit der zurück taste zur "LoginActivity" zurück zu kehren
    
    3. SportAuswahlAdapter.kt erstellen, wird benötigt um die Daten zu verarbeiten und diese in der Recaclerview anzuzeigen
        * override fun onCreateViewHolder(): Das Layout für ein einzelnes Item aufblasen 
        * override fun onBindViewHolder():   Holt das aktuelle Item basierend auf der Position
        * holder.icon.setImageResource(): Setzt die Daten des aktuellen Items (icon und text) in die Views des ViewHolders
        * größe der itemLiist zurückgeben und die item Data Klasse deklarieren
        * die Recyclerview in der MainActivity mittels viewBinding, initialisieren und konfigurieren
        * Daten für Adapter erstellen, die Sportarten die wählbar sind + passendes Image 
        * LayoutManager und Adapter für die Recyclerview setzen
        * Vector Asset für die Sportarten in der SportartenasuwahlRV erstellt
        * Daten via "sportliste" gesetzt
    
    4. ToolBar zurück Pfeil klickbar machen, in der LoginActivity.kt und MainActivity.kt
        * Definieren und Initialisieren der viewBinding Instanz
        * Funktion/Methoden für das einrichten/definieren der Toolbar und für das setup der Klicklistener erstellt
    
    5. Zusätzliche Recyclerviews in der MainActivity gesetzt
        * itam_xml dateien erstellt und die Elemente der Recyclerview definiert
        * dazugehörigen Adapter erstellen und definieren

    6. weitere Logik in der MainActivity.kt definiert
        * Infos anbieten, mit Klick Weiterleitung zu Wikipedia
        * Fussball Wetten anbieten
        * Tennis Sportart auswählbar
        * Clicklistener setzen und so definieren das man auf die Tennis Activity.kt weiter geleitet wird
        * Adapter und Daten Klassen erstellen
        
    7. Sportart Tennis Klickbar machen
        * In der Sportartasuwahl.kt einen OnClickListener zur "onBindViewHolder" Methode hinzugefügt, um anschließend zur TennisActivity zu gelangen
        * Tennisactivity in der Androidmanifest deklarieren

    8. Sportart Tennis Klickbar machen
        * TennisActivity screen und layout mit Recyclerview einrichten
        * Picasso Bibliothek im gradle einbinden
        * Internetberechtigung erteilen:     <uses-permission android:name="android.permission.INTERNET" />

VIII. MP3 einbinden

    1. Musikdatei in res/raw speichern
    2. Androidmanifest Berechtigung erteilen ist NUR erforderlich, wenn man Musik aus dem externen Speicher abspielen möchte, ist hier NICHT der Fall
    3. Welcomeactivity Code ändern
        * MediaPlayer Instanz erstellen
        * onClickListener für Musik Button
        * onDestroy Methode, ist Wichtig um ressourcen freizugeben, wenn sie nicht mehr benötigt werden


## Zwischenschritt: wenn ein Button Betätigt wird, dann wird die Hintergrundfarbe geändert, eine "State List Drawable" Xml Datei erstellt und das Hintergrundfrarben Attribut der Buttons entsprechend aktualisieren

## Fragen:
1. Tag/Nacht Modus
2. Bilder richtig speichern
3. LinearLayout - indem sich eine ImagView und eine TextView befindet, kann man diesen LinearLayout durch einen einzigen TextView ersetzen und das Bild als Compound Drawable des TextView setzen
4. Logcat - Nachrichten
   

   ```
   Vorher:
   <LinearLayout
    android:orientation="horizontal">

    <ImageView
        android:id="@+id/image"
        android:src="@drawable/my_icon"/>

    <TextView
        android:id="@+id/text"
        android:text="My Text" />
    </LinearLayout>
    ```

    ```
   Nachher:
   <TextView
    android:id="@+id/text_with_icon"
    android:text="My Text"
    android:drawableStart="@drawable/my_icon"/>
    ```


## Tag´s - Lesezeichen

| Tag | Was                  | Warum                                                                         |
|-----| -------------------- | ----------------------------------------------------------------------------- |
| 1   |                      |                                                                               |
| 2   |                      |                                                                               |
| 3   |                      |                                                                               |
| 4   |                      |                                                                               |
| 5   |                      |                                                                               |
| 6   |                      |                                                                               |
| 7   |                      |                                                                               |
| 8   |                      |                                                                               |
| 9   |                      |                                                                               |
| 10  |                      |                                                                               |
    



    


