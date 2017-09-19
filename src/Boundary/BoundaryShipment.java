package Boundary;

import Control.ShipmentControl;
import Entity.Shipment;
import Enums.ShipmentStatus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoundaryShipment extends JFrame {

    JLabel lbl_message;
    JPanel panel1, panel2, panel3;
    JLabel ID, place, shipper, date, status, place_txt, shipper_txt, date_txt, status_txt;
    JTextField ID_txt;
    JButton check;
    ShipmentControl controller;


    public BoundaryShipment() {
        super("Controlla Spedizione");
        panel1 = new JPanel(); //COntiene dati
        panel2 = new JPanel(); //Contiene String
        panel3 = new JPanel(); //Contiene ID
        lbl_message = new JLabel(" ");
        lbl_message.setForeground(Color.RED);
        lbl_message.setVisible(true);
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(true);
        ID = new JLabel("ID");
        place = new JLabel("PLACE");
        shipper = new JLabel("SHIPPER");
        date = new JLabel("DATE");
        status = new JLabel("STATUS");
        ID_txt = new JTextField(30);
        place_txt = new JLabel("PLACE TXT");
        shipper_txt = new JLabel("SHIPPER TXT");
        date_txt = new JLabel("DATE TXT");
        status_txt = new JLabel("STATUS TXT");
        check = new JButton("CHECK");
        panel1.setLayout(new GridLayout(4, 2));
        panel2.setLayout(new FlowLayout());
        panel3.setLayout(new GridLayout(1, 2));
        panel2.add(lbl_message);
        panel3.add(ID);
        panel3.add(ID_txt);
        panel1.add(place);
        panel1.add(place_txt);
        panel1.add(shipper);
        panel1.add(shipper_txt);
        panel1.add(date);
        panel1.add(date_txt);
        panel1.add(status);
        panel1.add(status_txt);
        panel3.add(check);
        check.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                control_shipment();
            }
        });

        panel1.setBackground(Color.LIGHT_GRAY);
        panel2.setBackground(Color.LIGHT_GRAY);
        panel3.setBackground(Color.LIGHT_GRAY);

        getContentPane().add(BorderLayout.SOUTH, panel2);
        getContentPane().add(BorderLayout.CENTER, panel1);
        getContentPane().add(BorderLayout.NORTH, panel3);

        pack();
        this.setSize(300, 200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(((int) dim.getWidth() - this.getWidth()) / 2, ((int) dim.getHeight() - this.getHeight()) / 2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        controller = new ShipmentControl();
    }

    public void control_shipment() {

        if (ID_txt.getText().isEmpty()) {
            panel2.setVisible(true);
            lbl_message.setText("Il campo ID è vuoto");
            return;
        }

        lbl_message.setText("");
        control();
    }

    public void control() {

        String ID = ID_txt.getText();

        Shipment s = new Shipment(ID, null, null, null, null);

        if (controller.control_shipment(s) != null) {
            panel1.setVisible(true);
            panel2.setVisible(true);
            lbl_message.setForeground(Color.GREEN);
            lbl_message.setText("Spedizione trovata!");
            place_txt.setText(s.getPlace());
            date_txt.setText(String.valueOf(s.getDate_shipment()));
            shipper_txt.setText(s.getShipper().getName());
            if(s.getStatus() == ShipmentStatus.NOT_SENT) {
                status_txt.setText("Non spedito");
            }
            if(s.getStatus() == ShipmentStatus.NOT_FOUND) {
                status_txt.setText("Non trovato");
            }
            if(s.getStatus() == ShipmentStatus.SENT) {
                status_txt.setText("Spedito");
            }
            if(s.getStatus() == ShipmentStatus.DELIVERED) {
                status_txt.setText("Consegnato");
            }

        } else {
            panel1.setVisible(false);
            panel2.setVisible(true);
            lbl_message.setForeground(Color.RED);
            lbl_message.setText("Spedizione non trovata");
        }
    }
}