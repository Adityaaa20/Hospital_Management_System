package Hospital.Management.System;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {

    Reception(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(500,5,1400,990);
        panel.setBackground(new Color(227,242,253));
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,485,990);
        panel1.setBackground(new Color(84,122,151));
        add(panel1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Patient.jpg"));
        Image image = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);
        JLabel label = new JLabel(i2);
        label.setBounds(0,0,150,150);
        panel1.add(label);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/amb.png"));
        Image image1 = i11.getImage().getScaledInstance(300,175,image.SCALE_DEFAULT);
        ImageIcon i22 = new ImageIcon(image1);
        JLabel label1 = new JLabel(i22);
        label1.setBounds(175,0,300,175);
        panel1.add(label1);



        JButton btn1 = new JButton("ADD PATIENT");
        btn1.setBounds(125,175,250,50);
        btn1.setFont(new Font("Arvo",Font.BOLD,15));
        btn1.setBackground(new Color(246,215,118));
        btn1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        panel1.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NEW_PATIENT();

            }
        });


        JButton btn2 = new JButton("ROOMS");
        btn2.setBounds(125,250,250,50);
        btn2.setFont(new Font("Arvo",Font.BOLD,15));
        btn2.setBackground(new Color(246,215,118));
        btn2.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        panel1.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();

            }
        });

        JButton btn3 = new JButton("DEPARTMENT");
        btn3.setBounds(125,325,250,50);
        btn3.setFont(new Font("Arvo",Font.BOLD,15));
        btn3.setBackground(new Color(246,215,118));
        btn3.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        panel1.add(btn3);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Department();

            }
        });

        JButton btn4 = new JButton("ALL EMPLOYEE INFO");
        btn4.setBounds(125,400,250,50);
        btn4.setFont(new Font("Arvo",Font.BOLD,15));
        btn4.setBackground(new Color(246,215,118));
        btn4.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        panel1.add(btn4);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Employee_info();

            }
        });

        JButton btn5 = new JButton("PATIENT INFO");
        btn5.setBounds(125,475,250,50);
        btn5.setFont(new Font("Arvo",Font.BOLD,15));
        btn5.setBackground(new Color(246,215,118));
        btn5.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        panel1.add(btn5);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new All_Patient_Info();

            }
        });

        JButton btn6 = new JButton("DISCHARGE PATIENT");
        btn6.setBounds(125,550,250,50);
        btn6.setFont(new Font("Arvo",Font.BOLD,15));
        btn6.setBackground(new Color(246,215,118));
        btn6.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        panel1.add(btn6);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Patient_Discharge();

            }
        });

        JButton btn7 = new JButton("UPDATE PATIENT DETAILS");
        btn7.setBounds(125,625,250,50);
        btn7.setFont(new Font("Arvo",Font.BOLD,15));
        btn7.setBackground(new Color(246,215,118));
        btn7.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        panel1.add(btn7);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Update_Patient_Details();

            }
        });

        JButton btn8 = new JButton("AMBULANCES");
        btn8.setBounds(125,700,250,50);
        btn8.setFont(new Font("Arvo",Font.BOLD,15));
        btn8.setBackground(new Color(246,215,118));
        btn8.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        panel1.add(btn8);
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ambulance();

            }
        });

        JButton btn9 = new JButton("ROOM INFO");
        btn9.setBounds(125,775,250,50);
        btn9.setFont(new Font("Arvo",Font.BOLD,15));
        btn9.setBackground(new Color(246,215,118));
        btn9.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        panel1.add(btn9);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Search_Room();

            }
        });

        JButton btn10 = new JButton("LOGOUT");
        btn10.setBounds(125,850,250,50);
        btn10.setFont(new Font("Arvo",Font.BOLD,15));
        btn10.setForeground(new Color(255,255,255));
        btn10.setBackground(new Color(255,76,76));
        btn10.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        panel1.add(btn10);
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();

            }
        });



        setSize(1920,1080);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Reception();
    }
}
