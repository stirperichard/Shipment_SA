package Control;

import Entity.Shipment;

public class ShipmentControl {

    private DatabaseSingleton database_singleton = DatabaseSingleton.getInstance();


    public Shipment add_shipment(Shipment s){
        for (int i=0; i < database_singleton.getSize(); i++){
            if (s.getId().equals(database_singleton.get(i).getId())){
                return null;
            }
        }
        database_singleton.addShipment(s);
        return s;
    }

    public Shipment control_shipment(Shipment s){
        for (int i=0; i < database_singleton.getSize(); i++){
            if (s.getId().equals(database_singleton.get(i).getId())){
                s.setDate_shipment(database_singleton.get(i).getDate_shipment());
                s.setPlace(database_singleton.get(i).getPlace());
                s.setShipper(database_singleton.get(i).getShipper());
                s.setStatus(database_singleton.get(i).getStatus());
                return s;
            }
        }
        return null;
    }
}
