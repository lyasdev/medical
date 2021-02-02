package com.lyaslim.medical.app.conf;

import com.lyaslim.medical.commons.api.conf.EnableCommonsApiModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lyaslim.medical.patient.api.EnablePatientApiModule;
import com.lyaslim.medical.patient.domain.EnablePatientDomainModule;
import com.lyaslim.medical.patient.infra.EnablePatientInfraModule;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnablePatientInfraModule
@EnablePatientDomainModule
@EnablePatientApiModule
@EnableCommonsApiModule
public class AppConfApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(AppConfApplication.class, args);
    }
}
