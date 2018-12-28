package com.ugarit.services;


import com.ugarit.persistence.entities.Request;
import com.ugarit.persistence.entities.Vehicle;
import com.ugarit.util.PersistenceUtils;

import javax.enterprise.inject.Default;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.Date;
import java.util.List;

@Named
@Default
public class VehicleService {


    public List<Vehicle> getVehicles() {
        EntityManager entityManager = PersistenceUtils.getEntityManager();
        return entityManager.createQuery("SELECT v FROM Vehicle as v").getResultList();
    }

    public void deleteVehicle(Long id) {
        EntityManager entityManager = PersistenceUtils.getEntityManager();
        Vehicle vehicle = entityManager.find(Vehicle.class, id);
        entityManager.remove(vehicle);
    }


    public Vehicle addVehicle(Vehicle vehicle) {
        EntityManager entityManager = PersistenceUtils.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(vehicle);
        entityManager.getTransaction().commit();
        return vehicle;
    }
}
