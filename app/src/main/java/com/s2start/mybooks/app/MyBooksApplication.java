package com.s2start.mybooks.app;

import android.app.Application;

import com.s2start.mybooks.services.RestService;
import com.s2start.mybooks.services.ServiceUser;

public class MyBooksApplication extends Application {
    public static final String URL = "http://ec2-3-17-71-86.us-east-2.compute.amazonaws.com/";

    private static MyBooksApplication instance;

    private ServiceUser serviceUser;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        createServices();

    }



    private void createServices(){
        serviceUser = (new RestService(URL)).getService(ServiceUser.class);

    }

        public static MyBooksApplication getInstance() {
            return instance;
        }

    public ServiceUser getServiceUser() {
        return serviceUser;
    }

}
