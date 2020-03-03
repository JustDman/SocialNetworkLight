import java.util.ArrayList;
import java.util.HashSet;

/**
 * Die Klasse NewsFeed speichert neue Einsendungen fuer den Newsfeed einer 
 * Sozialen-Netzwerk-Anwendung (wie Facebook oder Google+).
 * 
 * Derzeit wird das Anzeigen der Einsendungen durch die Ausgabe auf die Konsole simuliert.
 * (Spaeter soll die Anzeige in einem Webbrowser erfolgen.)
 * 
 * Diese Version speichert keine Daten auf Festplatte. Auch gibt es keine Unterstuetzung fuer
 * das Durchsuchen oder Anordnen der Einsendungen.
 */
public class NewsFeed {
    private ArrayList<Einsendung> einsendungen = new ArrayList<>();

    /**
     * Fuege dem Newsfeed eine Einsendung hinzu.
     * 
     * @param einsendung  die Einsendung, die hinzugefuegt werden soll.
     */
    public void erfasseEinsendung(Einsendung einsendung) {

        einsendungen.add(einsendung);
    }

    /**
     * Loescht eine Einsendung aus dem Feed.
     * @param einsendung die Einsendung, die geloescht werden soll.
     */
    public void loescheNachricht(Einsendung einsendung) {

        if (einsendungen.contains(einsendung))
            einsendungen.remove(einsendung);
        else
            System.out.println("Nachricht nicht gefunden!");
    }

    /**
     * Loescht eine Einsendung aus dem Feed.
     * @param index der Index der Einsendung im Feed.
     */
    public void loescheNachricht(int index) {
        if (index < einsendungen.size() && index >= 0)
            einsendungen.remove(index);
    }

    /**
     * Alle Einsendungen eines Benutzers bekommen.
     * @param user der Benutzer, dessen Einsendungen ausgegeben werden sollen.
     * @return eine ArrayList mit allen Einsendungen des Benutzers
     */
    public ArrayList<Einsendung> sucheUeberBenutzer(String user) {

        ArrayList<Einsendung> ret = new ArrayList<>();

        for (Einsendung e : einsendungen) {
            if (e.benutzername.equals(user)) {
                ret.add(e);
            }
        }

        return ret;
    }

    /**
     * Alle Benutzer bekommen.
     * @return ein HashSet, welches alle Benutzer beinhaltet.
     */
    public HashSet<String> alleBenutzer() {

        HashSet<String> namen = new HashSet<>();
        for (Einsendung es : einsendungen) {
            namen.add(es.gibBenutzername());
        }
        return namen;
    }

    /**
     * Alle Nachrichten eines Benutzers ausgeben.
     * @param user der Benutzer, dessen Nachrichten ausgegeben werden sollen.
     */
    public void ausgebenBenutzer(String user) {

        sucheUeberBenutzer(user).forEach(e -> {
            System.out.println("Index: " + einsendungen.indexOf(e));
            e.anzeigen();
            System.out.println();
        });
    }

    /**
     * Gib den Newsfeed aus auf die Kommandozeile. Derzeit werden die Details des Newsfeed auf die
     * Konsole ausgegeben. (Noch zu tun: ersetze diesen Code durch die Anzeige im
     * Webbrowser.)
     */
    public void zeigen() {
        // alle Text-Einsendungen anzeigen
        einsendungen.forEach(e -> {
            e.anzeigen();
            System.out.println();
        });
    }
}
