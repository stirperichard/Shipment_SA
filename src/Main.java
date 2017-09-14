import Boundary.BoundaryShipment;
import Control.ShipmentControl;
import Entity.Shipment;
import Enums.ShipmentStatus;
import Entity.Shipper;
import util.Serializza;

import javax.swing.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Richard on 24/12/2016.
 */
public class Main extends JFrame {

    public static void main(String args[]) throws ParseException {
        ShipmentControl sc = new ShipmentControl();
        Shipper shipper = new Shipper("Mauro");

        String start_dt = "2011-01-01";
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");
        Date date = (Date)formatter.parse(start_dt);
        SimpleDateFormat newFormat = new SimpleDateFormat("MM-dd-yyyy");
        String finalString = newFormat.format(date);

        Shipment shipment = new Shipment("012345", "Veroli", date, shipper, ShipmentStatus.NOT_SENT);
        sc.add_shipment(shipment);

        new BoundaryShipment();

        try {
            /**
             *  Serializing the object
             */
            Serializza.serialize(shipment, "serialization.txt");

            /**
             * Deserializing the object
             */
            Shipment newShipment = (Shipment) Serializza.deserialize("serialization.txt");
            System.out.println(newShipment.toString());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
