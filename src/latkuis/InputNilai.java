
package latkuis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InputNilai extends JFrame{
    private JLabel lblNama,lblNim,lblNilaiTugas,lblNilaiQuiz,lblMataKuliah,lblRadio;
    private JTextField txtNama, txtNim, txtNilaiTugas, txtNilaiQuiz;
    private JRadioButton rbTeori, rbPraktikum;
    private JButton btnSubmit, btnLogout;
    private JComboBox<String> cbMataKuliah;
    
    public InputNilai(){
        setTitle("Halaman Input Nilai");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        
        // Nama
        lblNama = new JLabel("Nama Mahasiswa:");
        lblNama.setBounds(30, 30, 100, 25);
        add(lblNama);
        txtNama = new JTextField();
        txtNama.setBounds(150, 30, 200, 25);
        add(txtNama);
        
        //NIM
        lblNim = new JLabel("NIM Mahasiswa:");
        lblNim.setBounds(30, 70, 100, 25);
        add(lblNim);
        txtNim = new JTextField();
        txtNim.setBounds(150, 70, 200, 25);
        add(txtNim);
        
        //Nilai Tugas
        lblNilaiTugas = new JLabel("Nilai Tugas:");
        lblNilaiTugas.setBounds(30, 110, 100, 25);
        add(lblNilaiTugas);
        txtNilaiTugas = new JTextField();
        txtNilaiTugas.setBounds(150, 110, 200, 25);
        add(txtNilaiTugas);
        
        //Nilai Quiz
        lblNilaiQuiz = new JLabel("Nilai Quiz:");
        lblNilaiQuiz.setBounds(30, 150, 100, 25);
        add(lblNilaiQuiz);
        txtNilaiQuiz = new JTextField();
        txtNilaiQuiz.setBounds(150, 150, 200, 25);
        add(txtNilaiQuiz);
        
        //RadioButton
        lblRadio = new JLabel("Tipe Kelas:");
        lblRadio.setBounds(30, 190, 100, 25);
        add(lblRadio);
        rbTeori = new JRadioButton("Kelas Teori", true);
        rbTeori.setBounds(150, 190, 100, 25);
        add(rbTeori);
        rbPraktikum = new JRadioButton("Kelas Praktikum");
        rbPraktikum.setBounds(260, 190, 130, 25);
        add(rbPraktikum);
        ButtonGroup bgKelas = new ButtonGroup();
        bgKelas.add(rbTeori);
        bgKelas.add(rbPraktikum);
        
        //Combo box
        lblMataKuliah = new JLabel("Mata Kuliah:");
        lblMataKuliah.setBounds(30, 230, 100, 25);
        add(lblMataKuliah);
        String[] matkul = {"PBO", "SCPK", "Algo Lanjut"};
        cbMataKuliah = new JComboBox<>(matkul);
        //Kalau gamau PBO, bisa pakai ini cbMataKuliah.setSelectedIndex(1); otomatis dia jadi scpk
        cbMataKuliah.setBounds(150, 230, 200, 25);
        add(cbMataKuliah);
        
        //Button
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(150, 270, 100, 30);
        add(btnSubmit);
        btnSubmit.addActionListener(e -> handleSubmit());
        
        btnLogout = new JButton("Logout");
        btnLogout.setBounds(300, 270, 100, 30);
        add(btnLogout);
        btnLogout.addActionListener(e -> handleLogout());               
    }
    
    private void handleSubmit(){
        try {
            Mahasiswa mhs = new Mahasiswa(
                txtNama.getText(),
                txtNim.getText(),
                Double.parseDouble(txtNilaiTugas.getText()),
                Double.parseDouble(txtNilaiQuiz.getText()),
                rbTeori.isSelected() ? "Teori" : "Praktikum",
                (String) cbMataKuliah.getSelectedItem()
            );
            new ResultPage().showResult(mhs);
        }catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(InputNilai.this, "Harap masukkan angka yang valid pada nilai tugas dan nilai kuiz!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void handleLogout(){
        int confirm = JOptionPane.showConfirmDialog(InputNilai.this, "Yakin ingin logout?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            dispose();
        }else{
            dispose();
            new LoginPage().setVisible(true);
        }
    }
}
