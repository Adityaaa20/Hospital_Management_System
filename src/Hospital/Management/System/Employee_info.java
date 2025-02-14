package Hospital.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_info extends JFrame {


    Employee_info(){



        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(84,122,151));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,34,980,450);
        table.setBackground(new Color(84,122,151));
        table.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(table);

        try{
            conn c = new conn();
            String q = "select * from EMP_INFO";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Name");
        label1.setBounds(15,7,70,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label1);

        JLabel label2 = new JLabel("AGE");
        label2.setBounds(175,7,70,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label2);

        JLabel label3 = new JLabel("Phone Number");
        label3.setBounds(335,7,120,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label3);

        JLabel label4 = new JLabel("Salary");
        label4.setBounds(510,7,70,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label4);

        JLabel label5 = new JLabel("Gmail");
        label5.setBounds(670,7,70,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label5);

        JLabel label6 = new JLabel("Aadhar Number");
        label6.setBounds(830,7,120,20);
        label6.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label6);

        JButton button = new JButton("BACK");
        button.setBounds(800,500,120,50);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });










        setUndecorated(true);
        setSize(1000,600);
        setLocation(800,250);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Employee_info();

    }
}
