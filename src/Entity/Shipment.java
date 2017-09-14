package Entity;

import Enums.ShipmentStatus;

import java.io.Serializable;
import java.util.Date;

public class Shipment implements Serializable{
    private String id;
    private String place;
    private Date date_shipment;
    private Shipper shipper;
    private ShipmentStatus status;
    private static final long serialVersionUID = 1L;

    public Shipment(String id, String place, Date date_shipment, Shipper shipper, ShipmentStatus status) {
        this.id = id;
        this.place = place;
        this.date_shipment = date_shipment;
        this.shipper = shipper;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getDate_shipment() {
        return date_shipment;
    }

    public void setDate_shipment(Date date_shipment) {
        this.date_shipment = date_shipment;
    }

    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

    public ShipmentStatus getStatus() {
        return status;
    }

    public void setStatus(ShipmentStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shipment)) return false;

        Shipment shipment = (Shipment) o;

        return getId() == shipment.getId();
    }

}
