/**
 * Diese Klasse speichert Informationen über eine Einsendung innerhalb eines sozialen 
 * Netzwerks. Der Hauptteil der Einsendung besteht aus einem Foto und einer Überschrift. 
 * Weitere Daten, wie Autor und Datum, werden ebenfalls gespeichert.
 * 
 */
public class FotoEinsendung extends Einsendung {

    private String dateiname; // der Name der Bilddatei
    private String ueberschrift; // einzeilige Bildüberschrift

    /**
     * Konstruktor fuer Objekte der Klasse FotoEinsendung.
     * 
     * @param autor          der Benutzername des Einsenders.
     * @param dateiname      der Dateiname des Bildes in dieser Einsendung.
     * @param ueberschrift   eine Uebeschrift fuer das Bild
     */
    public FotoEinsendung(String autor, String dateiname, String ueberschrift) {

        super(autor);
        this.dateiname = dateiname;
        this.ueberschrift = ueberschrift;
    }

    /**
     * Liefere den Dateinamen des Bildes aus der Einsendung.
     * 
     * @return den Namen der Bilddatei.
     */
    public String gibBilddateiname() {

        return dateiname;
    }

    /**
     * Liefere die Ueberschrift des Bildes aus der Einsendung.
     * 
     * @return die Ueberschrift des Bildes.
     */
    public String gibUeberschrift() {

        return ueberschrift;
    }

    @Override
    public String toString() {

        String ret = super.toString();
        ret += "  [" + dateiname + "]\n";
        ret += "  " + ueberschrift;
        return ret;
    }
}
