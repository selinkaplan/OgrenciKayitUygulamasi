package Forms;

import Model.Ders;
import Model.Ogrenci;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class OgrenciKayitForm {
    private JFrame frame;
    private JTextField txtOgrenciNo;
    private JTextField txtOgrenciAd;
    private JTextField txtOgrenciSoyad;
    private JComboBox<String> cmbOgrenciBolum;
    private JComboBox<String> cmbDersler;
    private JComboBox<Integer> cmbDersDonem;
    private JButton btnKaydet;

    public OgrenciKayitForm() {
        frame = new JFrame("Öğrenci Kayıt Formu");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 400);

        txtOgrenciNo = new JTextField();
        txtOgrenciAd = new JTextField();
        txtOgrenciSoyad = new JTextField();
        cmbOgrenciBolum = new JComboBox<>(getBolumList());
        cmbDersler = new JComboBox<>();
        cmbDersDonem = new JComboBox<>(new Integer[]{1, 2, 3, 4});
        btnKaydet = new JButton("Kaydet");

        btnKaydet.setBackground(new Color(255, 153, 0));
        btnKaydet.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        btnKaydet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kaydet();
            }
        });

        updateDerslerList();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 10, 10));
        panel.setBackground(new Color(204, 255, 204));

        panel.add(new JLabel("Öğrenci No:"));
        panel.add(txtOgrenciNo);
        panel.add(new JLabel("Öğrenci Adı:"));
        panel.add(txtOgrenciAd);
        panel.add(new JLabel("Öğrenci Soyadı:"));
        panel.add(txtOgrenciSoyad);
        panel.add(new JLabel("Öğrenci Bölümü:"));
        panel.add(cmbOgrenciBolum);
        panel.add(new JLabel("Ders Seçimi:"));
        panel.add(cmbDersler);
        panel.add(new JLabel("Dönem Seçimi:"));
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
        Ogrenci ogrenci = new Ogrenci();
        ogrenci.setOgrenciNo(Integer.parseInt(txtOgrenciNo.getText()));
        ogrenci.setOgrenciAd(txtOgrenciAd.getText());
        ogrenci.setOgrenciSoyad(txtOgrenciSoyad.getText());
        ogrenci.setOgrenciBolum((String) cmbOgrenciBolum.getSelectedItem());

        String selectedDers = (String) cmbDersler.getSelectedItem();
        String[] dersParts = selectedDers.split(" - ");
        Ders ders = new Ders();
        ders.setDersKodu(dersParts[0]);
        ders.setDersAd(dersParts[1]);
        ders.setDersDonem((Integer) cmbDersDonem.getSelectedItem());

        ogrenci.getOgrenciDersler().add(ders);

        String content = ogrenci.getOgrenciNo() + "," + ogrenci.getOgrenciAd() + "," +
                ogrenci.getOgrenciSoyad() + "," + ogrenci.getOgrenciBolum() + "," +
                ders.getDersKodu() + "," + ders.getDersAd() + "," + ders.getDersDonem();
        FileIO.appendToFile("data/ogrenciler.csv", content);

        JOptionPane.showMessageDialog(frame, "Öğrenci kaydedildi!");
        frame.dispose();
    }


    private String[] getBolumList() {
        return new String[]{"Bilgisayar Mühendisliği","Bilgisayar Programcılığı" , "Elektrik Elektronik Mühendisliği", "Makine Mühendisliği",
                "İnşaat Mühendisliği", "Endüstri Mühendisliği", "Matematik"};
    }

    private void updateDerslerList() {
        List<String> dersListesi = FileIO.readFromFile("data/dersler.csv");
        if (dersListesi != null) {
            for (String line : dersListesi) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    cmbDersler.addItem(parts[0] + " - " + parts[1] + " - Dönem: " + parts[2]);
                } else {
                    System.err.println("Geçersiz ders satırı: " + line);
                }
            }
        }
    }
}
