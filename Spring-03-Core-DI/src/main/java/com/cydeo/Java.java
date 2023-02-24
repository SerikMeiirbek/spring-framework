package com.cydeo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Java {

    /*@Autowired field injection
    OfficeHours officeHours;*/


    OfficeHours officeHours;

    /*Constructor Injection from Spring 4.3 if there is only one constructor @Autowired can be omitted
    @Autowired
    public Java(OfficeHours officeHours){
        this.officeHours = officeHours;
    }*/

    public void getTeachingHours(){
        System.out.println("Weekly teaching hours: " + (20 + officeHours.getHours()));
    }
}
