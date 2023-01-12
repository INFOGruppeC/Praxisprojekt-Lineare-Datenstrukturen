import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// Autor: %AUTHOR%
// Datum: %DATE%

public class PraxisSim_GUI extends JFrame {
  // Anfang Attribute
  private JLabel jLSimulation = new JLabel();
  private JLabel jLOeffnungszeit = new JLabel();
  private JLabel jLPatientenzahl = new JLabel();
  private JTextField jTFOeffnungszeit = new JTextField();
  private JTextField jTFPatientenanzahl = new JTextField();
  private JButton jBtSimuliere = new JButton();
  private JTextArea jTAErgebnisse = new JTextArea("");
    private JScrollPane jTAErgebnisseScrollPane = new JScrollPane(jTAErgebnisse);
  // Ende Attribute
  
  public PraxisSim_GUI(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 596; 
    int frameHeight = 397;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jLSimulation.setBounds(24, 16, 158, 20);
    jLSimulation.setText("Simulation einer Arztpraxis");
    cp.add(jLSimulation);
    jLOeffnungszeit.setBounds(24, 48, 137, 20);
    jLOeffnungszeit.setText("Öffnungszeit in Minuten");
    cp.add(jLOeffnungszeit);
    jLPatientenzahl.setBounds(24, 80, 140, 20);
    jLPatientenzahl.setText("Erwartete Patientenzahl");
    cp.add(jLPatientenzahl);
    jTFOeffnungszeit.setBounds(216, 48, 150, 20);
    cp.add(jTFOeffnungszeit);
    jTFPatientenanzahl.setBounds(216, 80, 150, 20);
    cp.add(jTFPatientenanzahl);
    jBtSimuliere.setBounds(216, 112, 147, 25);
    jBtSimuliere.setText("simuliere");
    jBtSimuliere.setMargin(new Insets(2, 2, 2, 2));
    jBtSimuliere.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jBtSimuliere_ActionPerformed(evt);
      }
    });
    cp.add(jBtSimuliere);
    jTAErgebnisseScrollPane.setBounds(32, 152, 529, 209);
    cp.add(jTAErgebnisseScrollPane);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public PraxisSim_GUI
  
  // Anfang Methoden
  public void jBtSimuliere_ActionPerformed(ActionEvent evt) {
    String zeitText = jTFOeffnungszeit.getText();
    String anzahlText = jTFPatientenanzahl.getText();
    try { 
      int zeit = Integer.parseInt(zeitText);
      int anzahl = Integer.parseInt(anzahlText);
      Praxis simulation = new Praxis();
      simulation.setzeOeffnungszeit(zeit);
      simulation.setzePrognosezahl(anzahl);
      simulation.simulierePraxis();
      jTAErgebnisse.setText(simulation.gibAuswertung());
      
    } catch(Exception e) {
        System.out.println(e.getMessage());
    } finally {
      
    } // end of try
  } // end of jBtSimuliere_ActionPerformed

  // Ende Methoden
  
  public static void main(String[] args) {
    new PraxisSim_GUI("PraxisSim_GUI");
  } // end of main
  
} // end of class PraxisSim_GUI
