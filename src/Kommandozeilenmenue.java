import java.util.Scanner;

public class Kommandozeilenmenue {

	Scanner scan = new Scanner(System.in);
	NewsFeed feed = new NewsFeed();

	/**
	 * Gibt das Menue mit den Nachrichten aus.
	 */
	private void MenueAnzeigen() {

		System.out.println("MENUE");
		System.out.println("1) Nachricht erstellen");
		System.out.println("2) Nachricht löschen"); // Benutzer als String eingeben -> nachricht auswählen -> löschen ?
		System.out.println("3) Alle Nachrichten ausgeben");
		System.out.println("4) Alle Nachrichten eines Benutzers ausgeben");
		System.out.println("x) exit");
	}

	/**
	 * Die Funktionalität des Menues.
	 */
	public void start() {

		String s = "-";
		while (!s.equals("x")) {
			MenueAnzeigen();
			s = scan.nextLine();
			switch (s) {
				case "1":
					this.erstellen();
					break;
				case "2":
					this.loeschen(); // deled dis
					break;
				case "3":
					this.ausgabeAlle();
					break;
				case "4":
					this.vonBenutzerSuchen();
					break;
				default:
					if (!s.equals("x"))
						this.fehler();
					break;
			}
		}
		scan.close();
	}

	/**
	 * Erstellt eine neue Einsendung.
	 */
	private void erstellen() {

		String s = "-";
		String username = "";
		String in = "";

		while (!s.equals("x")) {
			System.out.println("1) Text Einsendung");
			System.out.println("2) Foto Einsendung");
			System.out.println("x) Zurueck");
			s = scan.nextLine();
			switch (s) {
				case "1":
					System.out.print("Nutzername> ");
					username = scan.nextLine();
					System.out.print("Nachricht> ");
					feed.erfasseEinsendung(new NachrichtenEinsendung(username, scan.nextLine()));
					System.out.println("Erstellt");
					break;
				case "2":
					System.out.print("Nutzername> ");
					username = scan.nextLine();
					System.out.print("Überschrift;Dateiname> ");
					in = scan.nextLine();
					String[] input = in.split(";", 2);
					if (input.length != 2)
						continue;
					feed.erfasseEinsendung(
							new FotoEinsendung(username, input[1] /* Dateiname */, input[0] /* Ueberschrift */));
					System.out.println("Erstellt");
					break;
				default:
					if (!s.equals("x"))
						this.fehler();
					break;
			}
		}

	}

	/**
	 * Löscht eine Nachricht eines Benutzers.
	 */
	private void loeschen() {

		vonBenutzerSuchen();
		int g = 0;
		System.out.println("Welche Nachricht wollen Sie löschen?");
		g = scan.nextInt();
		feed.loescheNachricht(g);

		System.out.println("Geloescht");
	}

	/**
	 * Gibt alle Einsendungen aus.
	 */
	private void ausgabeAlle() {

		feed.zeigen();
		System.out.println();
	}

	/**
	 * Gibt alle Nachrichten eines Benutzers aus.
	 */
	private void vonBenutzerSuchen() {

		String s = "-";
		System.out.println("Von welchem Benutzer wollen Sie Nachrichten lesen?");
		feed.alleBenutzer().forEach(e -> System.out.print(e + "; "));
		System.out.print("> ");
		do {
			System.out.println("Geben Sie einen Benutzer ein!");
			s = scan.nextLine();
		} while (!feed.alleBenutzer().contains(s));
		feed.ausgebenBenutzer(s);
	}

	/**
	 * Fehler
	 */
	private void fehler() {

		System.out.println("Fehlerhafte Eingabe!"); // ENGLISCH DO YOU SPEAK IT !?
	}

}
