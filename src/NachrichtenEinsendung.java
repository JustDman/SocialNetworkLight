/**
 * Diese Klasse speichert Informationen ueber eine Einsendung innerhalb eines sozialen
 * Netzwerks. Der Hauptteil der Einsendung besteht aus einer (moeglicherweise 
 * mehrzeiligen) Textnachricht. Weitere Daten, wie Autor und Datum, werden ebenfalls 
 * gespeichert.
 */
public class NachrichtenEinsendung extends Einsendung {
    private String nachricht; // eine beliebig lange, mehrzeilige Nachricht

    /**
     * Konstruktor fuer Objekte der Klasse NachrichtenEinsendung.
     * 
     * @param autor    der Benutzername des Einsenders.
     * @param text      der Text dieser Einsendung.
     */
    public NachrichtenEinsendung(String autor, String text) {
        super(autor);
        nachricht = text;
    }

    /**
     * Liefere den Text dieser Einsendung.
     * 
     * @return den Text der Einsendung.
     */
    public String gibText() {

        return nachricht;
    }

    @Override
    public String toString() {

        String ret = super.toString();
        ret += "  " + nachricht;
        return ret;
    }

}
