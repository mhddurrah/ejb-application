package com.ugarit.ejbs;

public class ServiceCall {
    private String methodName;
    private Object[] parameters;
    private long time;
    private String status;

    public static ServiceCall from(String getVehicle, Object[] objects, long currentTimeMillis) {
        ServiceCall call = new ServiceCall();
        call.methodName = getVehicle;
        call.parameters = objects;
        call.time = currentTimeMillis;
        return call;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
