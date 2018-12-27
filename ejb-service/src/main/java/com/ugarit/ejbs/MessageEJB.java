package com.ugarit.ejbs;


import com.ugarit.persistence.entities.Request;
import com.ugarit.util.PersistenceUtils;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class MessageEJB {

    @Asynchronous
    public void logMessage(ServiceCall serviceCall) {
        EntityManager entityManager = PersistenceUtils.getEntityManager();
        entityManager.getTransaction().begin();
        Request request = new Request();
        request.setMethodName(serviceCall.getMethodName());
        request.setTime(serviceCall.getTime());
        entityManager.persist(request);
        entityManager.getTransaction().commit();
    }
}
