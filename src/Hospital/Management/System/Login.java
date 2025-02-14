package Hospital.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField textField;
    JPasswordField PasswordField;
    JButton b1,b2;



    Login(){

        JLabel namelabel = new JLabel("USERNAME➜");
        namelabel.setBounds(120,300,100,30);
        namelabel.setFont(new Font("Merriweather",Font.BOLD,14));
        namelabel.setForeground(Color.BLACK);
        add(namelabel);

        JLabel password = new JLabel("PASSWORD➜");
        password.setBounds(120,350,100,30);
        password.setFont(new Font("Merriweather",Font.BOLD,14));
        password.setForeground(Color.BLACK);
        add(password);

        textField = new JTextField();
        textField.setBounds(225,300,150,30);
        textField.setFont(new Font("Merriweather",Font.PLAIN,14));
        textField.setBackground(new Color(240,240,240));
        add(textField);

        PasswordField = new JPasswordField();
        PasswordField.setBounds(225,350,150,30);
        PasswordField.setFont(new Font("Merriweather",Font.PLAIN,14));
        PasswordField.setBackground(new Color(240,240,240));
        add(PasswordField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(50,-30,400,300);
        add(label);

        b1 = new JButton("Login");
        b1.setBounds(250,400,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(110,400,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);





        getContentPane().setBackground(new Color(227,242,253));
        setSize(500,600);
        setLocation(700,200);
        setLayout(null);
        setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                conn c = new conn();
                String user = textField.getText();
                String Pass = PasswordField.getText();

                String q = "select * from login where ID = '" + user + "' and PW = '" + Pass + "'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if (resultSet.next()) {
                    new Reception();
                    setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null, "invalid");

                }


            }catch (Exception E) {
                E.printStackTrace();
            }
        }else {
            System.exit(10);
        }

    }


    public static void main(String[] args) {
        new Login();

    }
}
















