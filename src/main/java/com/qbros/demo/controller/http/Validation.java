package com.qbros.demo.controller.http;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */
public final class Validation {

    //correct date format: yyyy-mm-dd
    //https://www.regextester.com/
    public final static String DATE_REGEX = "((gt)|(ls)):([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
    public final static String DIGIT_REGEX = "[0-9]+";
//    public final static String DIGIT_REGEX = "[\\d]";
    public final static String DATE_INVALID_MSG = "No proper date format";
    public final static String USER_INVALID_MSG = "No proper user id format";
    public final static String RESOURCE_INVALID_ID = "No proper resource id format (positive numbers)";

}
