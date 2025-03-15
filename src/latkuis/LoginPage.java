package latkuis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame {
    public void LoginPage() {
        setTitle("Halaman Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        
        //Username segment
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(20, 20, 80, 25);
        add(lblUsername);
        
        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(100, 20, 150, 25);
        add(txtUsername);
        
        // Password Segment
        JLabel lblPass = new JLabel("Password:");
        lblPass.setBounds(20, 60, 80, 25);
        add(lblPass);
        
        JPasswordField txtPass = new JPasswordField();
        txtPass.setBounds(100, 60, 150, 25);
        add(txtPass);
        
        //Button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 100, 80, 25);
        add(loginButton);
        
        loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String Username = txtUsername.getText();
                String Password = new String(txtPass.getPassword());
                
                if(Username.equals("123230110") && Password.equals("ifkelasg")){
                    JOptionPane.showMessageDialog(LoginPage.this, "Login Berhasil");
                    dispose();
                    new InputNilai().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Username atau password salah!");
                }
            }        
        });

        setVisible(true); // Jangan lupa menampilkan frame
    }
}
