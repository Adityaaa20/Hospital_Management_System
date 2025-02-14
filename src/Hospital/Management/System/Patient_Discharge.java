package Hospital.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Patient_Discharge extends JFrame {

    Patient_Discharge(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(84,122,151));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("CHECK-OUT");
        label.setBounds(100,20,150,20);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.white);
        panel.add(label);

        JLabel label1 = new JLabel("Customer-ID");
        label1.setBounds(30,80,150,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,15));
        label1.setForeground(Color.white);
        panel.add(label1);

        Choice choice = new Choice();
        choice.setBounds(250,80,150,25);
        panel.add(choice);

        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while (resultSet.next()){
                choice.add(resultSet.getString("Number"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label2 = new JLabel("Room Number");
        label2.setBounds(30,130,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,15));
        label2.setForeground(Color.white);
        panel.add(label2);

        JLabel RN = new JLabel();
        RN.setBounds(250,130,150,20);
        RN.setFont(new Font("Tahoma",Font.BOLD,15));
        RN.setForeground(Color.white);
        panel.add(RN);

        JLabel label4 = new JLabel("CHECK IN TIME");
        label4.setBounds(30,180,150,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,15));
        label4.setForeground(Color.white);
        panel.add(label4);

        JLabel CIN = new JLabel();
        CIN.setBounds(250,180,250,20);
        CIN.setFont(new Font("Tahoma",Font.BOLD,15));
        CIN.setForeground(Color.white);
        panel.add(CIN);

        JLabel label5 = new JLabel("CHECK OUT TIME");
        label5.setBounds(30,230,150,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,15));
        label5.setForeground(Color.white);
        panel.add(label5);

        Date date = new Date();

        JLabel COT = new JLabel(""+date);
        COT.setBounds(250,230,250,20);
        COT.setFont(new Font("Tahoma",Font.BOLD,15));
        COT.setForeground(Color.white);
        panel.add(COT);

        JButton discharge = new JButton("Discharge");
        discharge.setBounds(650,80,120,30);
        discharge.setBackground(Color.BLACK);
        discharge.setForeground(Color.white);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try {
                    c.statement.executeUpdate("delete from patient_info where number = '"+choice.getSelectedItem()+"'");
                    c.statement.executeUpdate("update room set Availability = 'Available' where Room_no = '"+RN.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);
                }catch (Exception E){
                    E.printStackTrace();
                }

            }
        });

        JButton check = new JButton("Check");
        check.setBounds(650,230,120,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.white);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try{
                    ResultSet resultSet = c.statement.executeQuery("select * from patient_info where number = '"+choice.getSelectedItem()+"'");
                    while (resultSet.next()){
                       RN.setText(resultSet.getString("Room_Number"));
                       CIN.setText(resultSet.getString("Time"));
                    }

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("BACK");
        back.setBounds(650,300,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });






        setUndecorated(true);
        setSize(800,400);
        setVisible(true);
        setLayout(null);
        setLocation(800,250);


    }




    public static void main(String[] args) {
        new Patient_Discharge();

    }
}
