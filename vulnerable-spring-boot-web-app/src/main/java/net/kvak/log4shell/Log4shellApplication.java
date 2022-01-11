package net.kvak.log4shell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Log4shellApplication {

  public static void main(String[] args) {
    // For versions later than JRE/JDK 11.0.1, 8u191, 7u201 and 6u211, the property has to explicitly set to true
    System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
    SpringApplication.run(Log4shellApplication.class, args);
  }

}
