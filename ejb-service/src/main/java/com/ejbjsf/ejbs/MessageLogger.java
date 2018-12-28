package com.ejbjsf.ejbs;

import com.ejbjsf.persistence.entities.Request;
import com.ejbjsf.util.PersistenceUtils;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import java.util.Date;

public class MessageLogger {

    @AroundInvoke
    public Object logMessage(InvocationContext invocationContext) throws Exception {
        EntityManager entityManager = PersistenceUtils.getEntityManager();
        entityManager.getTransaction().begin();
        Request request = new Request();
        request.setMethodName(invocationContext.getMethod().getName());
        request.setTime(new Date());
        entityManager.persist(request);
        entityManager.getTransaction().commit();
        return invocationContext.proceed();
    }
}
