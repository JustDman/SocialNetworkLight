import java.util.ArrayList;

public class Einsendung {

    protected String benutzername; // Benutzername des Senders
    protected long zeitstempel;
    protected int gefielWieOft = 0;
    protected ArrayList<String> kommentare = new ArrayList<>();

    public Einsendung(String benutzername) {
        this.benutzername = benutzername;
        this.zeitstempel = System.currentTimeMillis();
    }

    /**
    * Halte fest, dass die Nachricht von einem Benutzer mit 'gefaellt' bewertet 
    * wurde.
    */
    public void gefaellt() {
        gefielWieOft++;
    }

    /**
     * Halte fest, dass ein Benutzer seine 'gefaellt'-Bewertung zurueckgezogen hat.
     */
    public void gefaelltNicht() {
        if (gefielWieOft > 0) {
            gefielWieOft--;
        }
    }

    /**
     * Fuege der Einsendung einen Kommentar hinzu.
     * 
     * @param text  der neu hinzuzufuegende Kommentar.
     */
    public void erfasseKommentar(String text) {
        kommentare.add(text);
    }

    public String gibBenutzername() {
        return benutzername;
    }

    /**
     * Liefere die Zeit, zu der die Einsendung erstellt wurde.
     * 
     * @return die Zeit, zu der die Einsendung erstellt wurde (als Systemzeit-Wert)..
     */
    public long gibZeitstempel() {
        return zeitstempel;
    }

    @Override
    public String toString() {
        String ret = "";

        ret += benutzername + "\n";
        ret += zeitString(zeitstempel);

        if (gefielWieOft > 0) {
            ret += "  -  " + gefielWieOft + " Person(en) gefaellt dies.\n";
        } else {
            ret += "\n";
        }

        if (kommentare.isEmpty()) {
            ret += "   Keine Kommentare.\n";
        } else {
            ret += "   " + kommentare.size() + " Kommentar(e). Zum Einsehen hier klicken.\n";
        }

        return ret;
    }

    /**
    * Zeige die Details der Einsendung an.
    * 
    * (Aktuell werden die Daten auf die Konsole ausgegeben, wodurch momentan die 
    * Anzeige im Webbrowser simuliert werden soll.)
    */
    public void anzeigen() {
        System.out.println(toString());
    }

    /**
    * Erzeuge einen String, der einen in der Vergangenheit liegenden Zeitpunkt im 
    * Vergleich zur aktuellen Zeit beschreibt, also beispielsweise "vor 30 Sekunden" 
    * oder "vor 7 Minuten". Derzeit werden nur Sekunden und Minuten für den String 
    * verwendet.
    * 
    * @param zeit  der umzuwandelnde Zeitwert (in System-Millisekunden)
    * @return      eine relative Zeitbeschreibung fuer den gegebenen Zeitwert
    */
    private String zeitString(long zeit) {
        long aktuell = System.currentTimeMillis();
        long vergangeneMillis = aktuell - zeit; // vergangene Zeit in Millisekunden
        long sekunden = vergangeneMillis / 1000;
        long minuten = sekunden / 60;
        if (minuten > 0) {
            return "vor " + minuten + " Minuten";
        } else {
            return "vor " + sekunden + " Sekunden";
        }
    }

}