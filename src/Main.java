import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JLabel titleLabel;
    private JLabel countLabel;
    private JTextField countTextField;
    private JButton submitButton;

    public Main() {
        frame = new JFrame("Online Bank Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        titleLabel = new JLabel("Unesite broj artikala:");
        countLabel = new JLabel("Broj artikala:");
        countTextField = new JTextField();
        submitButton = new JButton("Unesi");

        submitButton.addActionListener(this);

        panel.add(titleLabel);
        panel.add(countLabel);
        panel.add(countTextField);
        panel.add(submitButton);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String input = countTextField.getText();
            int brojArtikala = Integer.parseInt(input);

            Artikal[] nizArtikala = new Artikal[brojArtikala];

            for (int i = 0; i < nizArtikala.length; i++) {
                String ime = JOptionPane.showInputDialog(frame, "Unesite ime proizvoda:");
                double cena = Double.parseDouble(JOptionPane.showInputDialog(frame, "Unesite cenu proizvoda:"));
                int kolicina = Integer.parseInt(JOptionPane.showInputDialog(frame, "Unesite kolicinu proizvoda:"));

                Artikal artikal = new Artikal(ime, cena, kolicina);
                nizArtikala[i] = artikal;
            }

            istampajRacun(nizArtikala);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }

    public static void istampajRacun(Artikal[] niz) {
        double konacanZbir = 0;
        double maxCena = 0;
        double maxUkupno = 0;

        for (int i = 0; i < niz.length; i++) {
            Artikal artikal = niz[i];
            double ukupnaCena = artikal.izracunajUkupnuCenuZaArtikal();
            konacanZbir += ukupnaCena;
            artikal.stampajArtikal();
            if (artikal.getCena() > maxCena) {
                maxCena = artikal.getCena();
            }
            if (artikal.getCena() * artikal.getKolicina() * artikal.getPorez() > maxUkupno) {
                maxUkupno = artikal.getCena() * artikal.getKolicina() * artikal.getPorez();
            }
        }

        String message = "Za uplatu: " + konacanZbir + " dinara"
                + "\nNajveca cena artikla je " + maxCena + " dinara"
                + "\nNajveca ukupna cena artikla je " + maxUkupno + " dinara";

        JOptionPane.showMessageDialog(null, message);
    }
}