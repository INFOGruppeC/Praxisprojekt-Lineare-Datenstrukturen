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
    // Queue an Patienten, die das Wartezimmer representiert
    patienten = new Queue<Patient>();
    patientenzahl = 0;
    leerlaufzeit = 0;
  }

  private void zeittakt() {

    /*
     * Hier findet die eigentliche Simulation der Behanlung ab (main loop des
     * Programmes)
     * 
     * Patient wird mit zufälligen Zeibedarf erstellt und an die Liste angefügt
     * Die If-Abfrage garantiert eine Normalverteilung der Patientenanzahl um den
     * Erwartungswerte der Patienten (prognosezahl) zu erreichen.
     */
    // float r = zufall.nextFloat(1);

    // System.out.println("random: " + r + " und p= " + ((float)prognosezahl /
    // oeffnungszeit));
    // System.out.println("oeffnungs" + oeffnungszeit + " prognose" + prognosezahl);

    if (zufall.nextFloat(1) <= ((float) prognosezahl / oeffnungszeit)) {
      Patient p = new Patient(zufall.nextInt(10) + 5);
      patienten.enqueue(p);
      // Patientenzahl wird jeweils gespeichert
      patientenzahl++;
    }

    // Wenn der Arzt gerade frei ist, wird ein neuer Patient behandelt
    if (derArzt.istFrei()) {
      if (patienten.isEmpty()) {
        // Leerlaufzeit wird jeweils gespeichert
        leerlaufzeit++;
      } else {
        derArzt.neuerPatient(patienten.front().gibZeitbedarf());
        patienten.dequeue();
      }

    } else {
      derArzt.behandlePatient();
    }

  }

  public void simulierePraxis() {
    for (int i = 0; i <= oeffnungszeit; i++) {
      zeittakt();
    }
  }

  public String gibAuswertung() {
    int patientenzahlEnde = 0;
    int behandlungszeit = 0;

    // Hier wird die Liste (!Queue) Durchgangang um die Simulationsdaten aufsummiert
    while (!patienten.isEmpty()) {
      behandlungszeit += patienten.front().gibZeitbedarf();
      patientenzahlEnde++;
      patienten.dequeue();
    }

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
