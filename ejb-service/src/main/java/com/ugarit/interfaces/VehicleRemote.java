package com.ugarit.interfaces;

import com.ugarit.persistence.entities.Vehicle;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface VehicleRemote {
    Vehicle getVehicle(Long id);

    List<Vehicle> getVehicles();

    void deleteVehicle(Long id);

    Vehicle addVehicle(Vehicle vehicle);

}