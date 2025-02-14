package Hospital.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Time;

public class Update_Patient_Details extends JFrame {

    Update_Patient_Details(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(84,122,151));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Update.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(124,11,260,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.white);
        panel.add(label1);

        JLabel label2 = new JLabel("Name :");
        label2.setBounds(25,88,100,15);
        label2.setFont(new Font("Tahoma",Font.PLAIN,15));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248,85,150,25);
        panel.add(choice);

        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while (resultSet.next()){
                choice.add(resultSet.getString("Name"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number :");
        label3.setBounds(25,129,100,14);
        label3.setFont(new Font("Tahoma",Font.PLAIN,14));
        label3.setForeground(Color.white);
        panel.add(label3);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(248,129,150,20);
        panel.add(textFieldR);

        JLabel label4 = new JLabel("In TIME :");
        label4.setBounds(25,174,100,14);
        label4.setFont(new Font("Tahoma",Font.PLAIN,14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JTextField textFieldIT = new JTextField();
        textFieldIT.setBounds(248,174,150,20);
        panel.add(textFieldIT);

        JLabel label5 = new JLabel("Amount Paid :");
        label5.setBounds(25,216,100,14);
        label5.setFont(new Font("Tahoma",Font.PLAIN,14));
        label5.setForeground(Color.white);
        panel.add(label5);

        JTextField textFieldAMT = new JTextField();
        textFieldAMT.setBounds(248,216,150,20);
        panel.add(textFieldAMT);

        JLabel label6 = new JLabel("Pending Amount :");
        label6.setBounds(25,261,150,14);
        label6.setFont(new Font("Tahoma",Font.PLAIN,14));
        label6.setForeground(Color.white);
        panel.add(label6);

        JTextField textFieldPEN = new JTextField();
        textFieldPEN.setBounds(248,261,150,20);
        panel.add(textFieldPEN);

        JButton check = new JButton("CHECK");
        check.setBounds(280,378,89,23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "select * from patient_info where Name = '"+id+"'";
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while (resultSet.next()){
                        textFieldR.setText(resultSet.getString("Room_Number"));
                        textFieldIT.setText(resultSet.getString("Time"));
                        textFieldAMT.setText(resultSet.getString("Deposit"));

                    }
                    ResultSet resultSet1 = c.statement.executeQuery("select * from room where Room_no = '"+textFieldR.getText()+"'");
                    while (resultSet1.next()){
                        String price = resultSet1.getString("Price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textFieldAMT.getText());
                        textFieldPEN.setText(""+amountPaid);
                    }

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton update = new JButton("UPDATE");
        update.setBounds(60,378,89,23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    conn c = new conn();
                    String q = choice.getSelectedItem();
                    String room = textFieldR.getText();
                    String time = textFieldIT.getText();
                    String amount = textFieldAMT.getText();
                    c.statement.executeUpdate("update patient_info set Room_number = '"+room+"', Time = '"+time+"', Deposit = '"+amount+"' where name = '"+q+"'" );
                    JOptionPane.showMessageDialog(null,"Updated Successfully");
                    setVisible(false);

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("BACK");
        back.setBounds(168,378,89,23);
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
        setSize(900,500);
        setLayout(null);
        setLocation(800,250);
        setVisible(true);


    }
    public static void main(String[] args) {
        new Update_Patient_Details();

    }
}
