/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * laboratorio 7 Mora-Jimenez
 */
package edu.eci.pdsw.samples.services;

import com.google.inject.Injector;
import edu.eci.pdsw.samples.services.impl.ServiciosAlquilerItemsImpl;
import org.mybatis.guice.XMLMyBatisModule;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;


/**
 *
 * @author hcadavid
 */
public class ServiciosAlquilerFactory {

    private static ServiciosAlquilerFactory instance = new ServiciosAlquilerFactory();

    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                bind(ServiciosAlquiler.class).to(ServiciosAlquilerItemsImpl.class);
            }
        });
    }

    private ServiciosAlquilerFactory(){
        optInjector = Optional.empty();
    }

    public ServiciosAlquiler getServiciosAlquiler(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(ServiciosAlquiler.class);
    }


    public ServiciosAlquiler getServiciosAlquilerTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }

        return optInjector.get().getInstance(ServiciosAlquiler.class);
    }



    public static ServiciosAlquilerFactory getInstance(){
        return instance;
    }

}
