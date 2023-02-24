package com.cydeo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigCar {

    @Bean
    Car car(){
        Car c = new Car();
        c.setMake("Honda");
        return c;
    }

    /*DirectWiring
    @Bean
    Person person(){
        Person p = new Person();
        p.setName("Mike");
        p.setCar(car());
        return p;
    }
     */

    /*Autowiring*/
    /* Pass an object as method parameter so Spring will automatically will check if the bean has been defined */
    @Bean
    Person person(Car car){
        Person p = new Person();
        p.setName("Mike");
        p.setCar(car);
        return p;
    }
}