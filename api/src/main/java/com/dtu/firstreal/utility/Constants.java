package com.dtu.firstreal.utility;

public class Constants {

    public static final String URI_API = "/api";
    public static final String URI_PROJECTS = "/projects";
    public static final String URI_EMPLOYEES = "/employees";
    public static final String URI_PROJECT_DETAIL ="/detail" ;
    public static final String URI_EMPLOYEE_ID = "/employee/{id}";
    public static final String URI_EMPLOYEE_USERNAME = "/employee/username={username}";
    public static final String URI_EMPLOYEE = "/employee";
    public static final String URI_PROJECT_ID = "/project/{id}";
    public static final String URI_PROJECT = "/project";
    public static final String URI_PROJECT_DETAIL_ID = "/detail/{id}";
    public static final String URI_PROJECT_DETAIL_ID_UPDATE = "detail/update/{id}";
    public static final String URI_CUSTOMER = "/customer";
    public static final String URI_EMPLOYEE_LOGIN = "/login";
    public static final String URI_TRANSACTION = "/transaction";
    public static final String URI_PROJECT_DETAIL_STATISTICAL = "/statistical";

    private Constants() {
        throw new InstantiationError( "Must not instantiate this class" );
    }

}
