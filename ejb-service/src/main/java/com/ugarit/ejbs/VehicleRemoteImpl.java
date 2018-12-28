package com.ugarit.ejbs;


import com.ugarit.interfaces.VehicleRemote;
import com.ugarit.persistence.entities.Vehicle;
import com.ugarit.services.VehicleService;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.List;

@Stateless(name = "vehicle")
@Interceptors(MessageLogger.class)
public class VehicleRemoteImpl implements VehicleRemote {

    private VehicleService vehicleService;

    @PostConstruct
    public void init() {
        vehicleService = new VehicleService();
    }

    @Override
    public Vehicle getVehicle(Long id) {
        return vehicleService.getVehicles().get(0);
    }

    @Override
    public List<Vehicle> getVehicles() {
        return vehicleService.getVehicles();
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleService.deleteVehicle(id);
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleService.addVehicle(vehicle);
    }
}