package com.ejbjsf.ejbs;


import com.ejbjsf.interfaces.DuplicateLicenceException;
import com.ejbjsf.interfaces.VehicleRemote;
import com.ejbjsf.persistence.entities.Vehicle;
import com.ejbjsf.services.VehicleService;

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
    public Vehicle addVehicle(Vehicle vehicle) throws DuplicateLicenceException {
        if (vehicle.getLicenceNumber().equals("34AFZ955"))
            throw new DuplicateLicenceException("Duplicate vehicle found");
        return vehicleService.addVehicle(vehicle);
    }
}