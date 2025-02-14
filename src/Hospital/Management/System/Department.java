package Hospital.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {


    Department(){


        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        panel.setBackground(new Color(84,122,151));
        add(panel);

        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        table.setBounds(0,40,700,500);
        table.setBackground(new Color(84,122,151));
        table.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(table);

        try{
            conn c = new conn();
            String q= "select * from department";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }


        JLabel label1 = new JLabel("Department");
        label1.setBounds(5,11,105,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label1);

        JLabel label2 = new JLabel("Phone Number");
        label2.setBounds(350,11,120,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label2);

        JButton backButton = new JButton("Back");
        backButton.setBounds(400, 400, 100, 30);  // Adjusted position
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        panel.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Back button clicked!");
                setVisible(false);

            }
        });



        setSize(700,500);
        setLayout(null);
        setLocation(800,250);
        setVisible(true);



    }




    public static void main(String[] args) {
        new Department();

    }
}
