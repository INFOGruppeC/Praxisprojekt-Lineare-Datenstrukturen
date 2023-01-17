import java.util.*;

public class Praxis {
  private int oeffnungszeit;
  private int prognosezahl;
  private Random zufall;
  private Arzt derArzt;
  private Queue<Patient> patienten;
  private int leerlaufzeit;
  private int patientenzahl;

  public Praxis() {
    oeffnungszeit = 180;
    prognosezahl = 20;
    zufall = new Random();
    derArzt = new Arzt();
    patienten = new Queue<Patient>();
    patientenzahl = 0;
    leerlaufzeit = 0;
  }

  private void zeittakt() {

    // Hier findet die eigentliche Simulation der Behanlung ab
    
    // Patient wird mit zufälligen Zeibedarf erstellt und an die Liste angefügt

    // Wenn der Arzt gerade frei ist, wird ein neuer Patient behandelt

    // Patientenzahl und Leerlaufzeit wird jeweils gespeichert

  }

  public void simulierePraxis() {
    for (int i = 0; i <= oeffnungszeit; i++) {
      zeittakt();
    }
  }

  public String gibAuswertung() {
    int patientenzahlEnde = 0;
    int behandlungszeit = 0;

    // Hier wird die Liste Durchgangang um die Simulationsdaten aufsummiert



    // Euer CODE

    // Ausgabe dann

    String ausgabe = "Auswertung der Praxissimulation" + "\n";
    ausgabe = ausgabe + "Sprechstundenzeit in Minuten: " + oeffnungszeit + "\n";
    ausgabe = ausgabe + "Erwartete Patientenzahl: " + prognosezahl + "\n";
    ausgabe = ausgabe + "Tatsaechliche Patientenzahl: " + patientenzahl + "\n";
    ausgabe = ausgabe + "Leerlaufzeit beim Arzt (in Minuten): " + leerlaufzeit + "\n";

    ausgabe = ausgabe + "\n" + "Situation am Ende der Sprechstundenzeit" + "\n";
    ausgabe = ausgabe + "Patienten im Wartezimmer: " + patientenzahlEnde + "\n";
    ausgabe = ausgabe + "Zeitbedarf für die Patienten im Wartezimmer: " + behandlungszeit + "\n";
    return ausgabe;
  }

  public void setzeOeffnungszeit(int pZeit) {
    oeffnungszeit = pZeit;
  }

  public void setzePrognosezahl(int pPrognosezahl) {
    prognosezahl = pPrognosezahl;
  }

}
