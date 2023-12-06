package Forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Anasayfa {
    private JFrame frame;
    private JButton btnDersKayit;
    private JButton btnOgrenciKayit;
    private JButton btnCikis;

    public Anasayfa() {
        frame = new JFrame("Öğrenci Kayıt Uygulaması");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);

        btnDersKayit = createButton("Ders Kayıt", new Color(0, 153, 76));
        btnOgrenciKayit = createButton("Öğrenci Kayıt", new Color(255, 153, 0));
        btnCikis = createButton("Çıkış", new Color(255, 51, 51));

        btnDersKayit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DersKayitForm().showForm();
            }
        });

        btnOgrenciKayit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OgrenciKayitForm().showForm();
            }
        });

        btnCikis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3, 10, 10));
        panel.setBackground(new Color(204, 204, 255)); 

        panel.add(btnDersKayit);
        panel.add(btnOgrenciKayit);
        panel.add(btnCikis);

        frame.add(panel);
    }

    public void showForm() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JButton createButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        button.setForeground(Color.WHITE); 
        button.setFont(new Font("Arial", Font.BOLD, 14)); 

        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Anasayfa().showForm();
            }
        });
    }
}
