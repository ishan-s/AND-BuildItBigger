/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.Ishan.jokr.backend;


import com.example.Jokr;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.sun.org.apache.xpath.internal.operations.Number;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "jokr",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.jokr.Ishan.example.com",
    ownerName = "backend.jokr.Ishan.example.com",
    packagePath=""
  )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "getSpecificJoke", path = "getSpecificJoke")
    public MyBean getSpecificJoke(@Named("number") String number) {
        MyBean response = new MyBean();

        int numberInt = 0;
        try {
            numberInt = Integer.parseInt(number);
        }catch(NumberFormatException nfe){
            response.setData("Error - Invalid joke number specified");
            return response;
        }

        response.setData((new Jokr()).getJoke(numberInt));
        return response;
    }

    @ApiMethod(name = "getJoke", httpMethod = ApiMethod.HttpMethod.GET, path = "getJoke")
    public MyBean getJoke() {
        MyBean response = new MyBean();
        response.setData((new Jokr()).getJoke());

        return response;
    }


}
