package fi.joufa.springwebapp.application;

import fi.joufa.BasePackageMarker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = BasePackageMarker.class)
public class AgileApplication {

  public static void main(String[] args) {
    SpringApplication.run(AgileApplication.class);
  }
}
