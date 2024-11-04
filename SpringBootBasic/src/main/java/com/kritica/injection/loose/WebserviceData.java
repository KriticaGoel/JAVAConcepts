package com.kritica.injection.loose;

public class WebserviceData implements FetchData {


    @Override
    public String getUsers() {
        return "Data Fetch from Webservice";
    }
}
