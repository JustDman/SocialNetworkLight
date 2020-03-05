class App {

    public static void main(String[] args) {

        new Kommandozeilenmenue().start();

        NewsFeed feed = new NewsFeed();
        NachrichtenEinsendung nes = new NachrichtenEinsendung("User1", "Hallo Welt!");
        feed.erfasseEinsendung(nes);
        sleep(1000);
        feed.erfasseEinsendung(new NachrichtenEinsendung("User3", "Test Nachricht"));
        sleep(4000);
        feed.erfasseEinsendung(new FotoEinsendung("Pictrueguy1337", "tolles_bild.jpg", "Was vuer ein wunderfolles bild."));
        feed.erfasseEinsendung(new FotoEinsendung("User3", "lenny.png", "( ͡° ͜ʖ ͡°)"));

        sleep(4000);
        System.out.println("Liste aller Benutzer: ");
        for(String user : feed.alleBenutzer()) {
            System.out.println(" " + user);
        }

        System.out.println("\nNachrichten von User3: ");
        feed.ausgebenBenutzer("User3");

        sleep(2000);
        System.out.println("\nGesamten Feed anzeigen:");
        feed.zeigen();

        System.out.println("Loesche Nachricht via Index.");
        feed.loescheNachricht(3);
        System.out.println("Loesche Nachricht via Objekt.");
        feed.loescheNachricht(nes);

        sleep(1000);
        System.out.println("Nochmals gesamten Feed anzaigen:");
        feed.zeigen();
    }

    private static void sleep(long ms) {
        System.out.println("Sleeping for "+ms+" ms...");
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}