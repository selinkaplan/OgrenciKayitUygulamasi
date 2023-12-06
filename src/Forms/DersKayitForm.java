package Forms;

import Model.Ders;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DersKayitForm {
    private JFrame frame;
    private JTextField txtDersKodu;
    private JTextField txtDersAd;
    private JComboBox<String> cmbDersDonem;
    private JButton btnKaydet;

    public DersKayitForm() {
        frame = new JFrame("Model.Ders Kayıt Formu");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 400);

        txtDersKodu = new JTextField();
        txtDersAd = new JTextField();
        cmbDersDonem = new JComboBox<>(new String[]{"1", "2", "3", "4"});
        btnKaydet = new JButton("Kaydet");

        btnKaydet.setBackground(new Color(0, 153, 76));
        btnKaydet.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        btnKaydet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kaydet();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));


        panel.setBackground(new Color(255, 204, 204));

        panel.add(new JLabel("Ders Kodu:"));
        panel.add(txtDersKodu);
        panel.add(new JLabel("Ders Adı:"));
        panel.add(txtDersAd);
        panel.add(new JLabel("Ders Dönemi:"));
        panel.add(cmbDersDonem);
        panel.add(new JLabel(""));
        panel.add(btnKaydet);

        frame.add(panel);
    }

    public void showForm() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void kaydet() {
        Ders ders = new Ders();
        ders.setDersKodu(txtDersKodu.getText());
        ders.setDersAd(txtDersAd.getText());
        ders.setDersDonem(Integer.parseInt((String) cmbDersDonem.getSelectedItem()));


        String content = ders.getDersKodu() + "," + ders.getDersAd() + "," + ders.getDersDonem();
        FileIO.writeToFile("data/dersler.csv", content);

        JOptionPane.showMessageDialog(frame, "Ders kaydedildi!");
        frame.dispose();
    }
}
