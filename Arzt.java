public class Arzt {
    int aktuelleBehandelungszeit;

    public Arzt() {

    }

    // fügt neun Patienten mit entsprechender Behandelungszeit zum Artzt hinzu
    public void neuerPatient(int pBehandlungszeit) {
        aktuelleBehandelungszeit = pBehandlungszeit;
    }

    // jeden aufruf (von Zeittakt) wird eine Minute der aktuellen Behanderlungszeit abgezogen
    public void behandlePatient() {
        aktuelleBehandelungszeit--;
    }
    // gibt zurück ober der Arzt gerade besetzt ist
    public boolean istFrei() {
        return aktuelleBehandelungszeit == 0;
    }

}