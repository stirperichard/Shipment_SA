package Control;

import Entity.Shipment;

import java.util.HashMap;



public class DatabaseSingleton {

    private static DatabaseSingleton singleton = new DatabaseSingleton( );
    private HashMap<Integer, Shipment> db = new HashMap<Integer, Shipment>();
    private int last_id = 0;

    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private DatabaseSingleton() {
    }

    /* Static 'instance' method */
    public static DatabaseSingleton getInstance( ) {
        return singleton;
    }

    public HashMap<Integer, Shipment> getDb() {
        return db;
    }

    public void addShipment(Shipment s){
        db.put(getId(), s);
    }

    public int getSize(){
        return db.size();
    }

    public Shipment get(int i){
        return db.get(i);
    }

    private synchronized int getId(){
        int tmp = last_id;
        last_id++;
        return tmp;
    }

}
