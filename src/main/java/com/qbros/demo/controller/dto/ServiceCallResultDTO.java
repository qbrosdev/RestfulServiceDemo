package com.qbros.demo.controller.dto;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */
public class ServiceCallResultDTO extends BaseDTO {

    private String taskId = "NA";
    private String resURI = "NA";
    private ServiceCallResult serviceCallResult;


    public static ServiceCallResultDTO CREATED(String resURI) {
        return new ServiceCallResultDTO().setServiceCallResult(ServiceCallResult.CREATED).setResURI(resURI);
    }

    public static ServiceCallResultDTO SUCCESS() {
        return new ServiceCallResultDTO().setServiceCallResult(ServiceCallResult.SUCCESS);
    }

    public static ServiceCallResultDTO FAIL() {
        return new ServiceCallResultDTO().setServiceCallResult(ServiceCallResult.FAIL);
    }

    public static ServiceCallResultDTO PARTIAL_COMPLETE(int taskId) {
        return new ServiceCallResultDTO().setServiceCallResult(ServiceCallResult.PARTIAL_COMPLETE).setTaskId(taskId);
    }

    public String getTaskId() {
        return taskId;
    }

    private ServiceCallResultDTO setTaskId(int taskId) {
        this.taskId = "" + taskId;
        return this;
    }

    public String getResURI() {
        return resURI;
    }

    private ServiceCallResultDTO setResURI(String resURI) {
        this.resURI = resURI;
        return this;
    }

    public ServiceCallResult getServiceCallResult() {
        return serviceCallResult;
    }

    public ServiceCallResultDTO setServiceCallResult(ServiceCallResult serviceCallResult) {
        this.serviceCallResult = serviceCallResult;
        return this;
    }

    //todo add description field
    public enum ServiceCallResult {
        SUCCESS, FAIL, PARTIAL_COMPLETE, CREATED;
    }
}
