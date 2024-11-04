package com.kritica.loose;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationLooseContext.xml");

        Service beanDatabase = (Service) context.getBean("servicedatabaseData");
        System.out.println(beanDatabase.getUserService());
        // Creating object of database and storing in inteface fetch Data
        //FetchData fetchDataFromDB = new DatabaseSql();
        //Service service = new Service(fetchDataFromDB);
        //System.out.println(service.getUserService());

//        FetchData fetchDataWebservice = new WebserviceData();
//        Service webService = new Service(fetchDataWebservice);
//        System.out.println(webService.getUserService());
        Service beanflatfile = (Service) context.getBean("serviceflatfileData");
        System.out.println(beanflatfile.getUserService());

//        FetchData fetchDataflatFile = new FlatFileData();
//        Service flatService = new Service(fetchDataflatFile);
        //    System.out.println(flatService.getUserService());
        Service beanWebservice = (Service) context.getBean("servicewebserviceData");
        System.out.println(beanWebservice.getUserService());
    }
}
