package com.ugarit.ejbs;


import com.ugarit.interfaces.VehicleRemote;
import com.ugarit.persistence.entities.Vehicle;
import com.ugarit.services.VehicleService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless(name = "vehicle")
public class VehicleRemoteImpl implements VehicleRemote {

    private VehicleService vehicleService;

    @EJB
    private MessageEJB messageEJB;

    @PostConstruct
    public void init() {
        vehicleService = new VehicleService();
    }

    @Override
    public Vehicle getVehicle(Long id) {
        messageEJB.logMessage(ServiceCall.from("getVehicle", new Object[]{id}, System.currentTimeMillis()));
        return vehicleService.getVehicles().get(0);
    }

    @Override
    public List<Vehicle> getVehicles() {
        messageEJB.logMessage(ServiceCall.from("getVehicles", new Object[]{}, System.currentTimeMillis()));

        return vehicleService.getVehicles();
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleService.deleteVehicle(id);
    }
}