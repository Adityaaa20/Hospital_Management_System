package Hospital.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Search_Room extends JFrame {

    Choice choice;
    JTable table;

    Search_Room(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(84,122,151));
        panel.setLayout(null);
        add(panel);

        JLabel For = new JLabel("Search For Rooms");
        For.setBounds(250,11,186,31);
        For.setForeground(Color.WHITE);
        For.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(For);

        JLabel status = new JLabel("Status :");
        status.setBounds(70,70,80,20);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(status);

        choice = new Choice();
        choice.setBounds(170,70,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table = new JTable();
        table.setBounds(0,187,700,210);
        table.setBackground(new Color(84,122,151));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            conn c = new conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel RNO = new JLabel("Room Number");
        RNO.setBounds(15,162,150,20);
        RNO.setForeground(Color.WHITE);
        RNO.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(RNO);

        JLabel AVL = new JLabel("Availability");
        AVL.setBounds(175,162,150,20);
        AVL.setForeground(Color.WHITE);
        AVL.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(AVL);

        JLabel price = new JLabel("Price");
        price.setBounds(350,162,150,20);
        price.setForeground(Color.WHITE);
        price.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(price);

        JLabel BTY = new JLabel("Bed Type");
        BTY.setBounds(525,162,150,20);
        BTY.setForeground(Color.WHITE);
        BTY.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(BTY);

        JButton search = new JButton("Search");
        search.setBounds(380,420,120,25);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        panel.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from room where Availability = '"+choice.getSelectedItem()+"'";
                try{
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(200,420,120,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });





        setUndecorated(true);
       setSize(700,500);
       setLayout(null);
       setLocation(800,250);
       setVisible(true);


    }
    public static void main(String[] args) {
        new Search_Room();

    }
}
