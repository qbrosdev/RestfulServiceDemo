package com.qbros.demo.controller.dto;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */
public class BaseDTO {

    //this has nothing to do with api versioning
    private String description = "NA";

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
