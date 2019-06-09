package fi.joufa.databaserepository.config;

import fi.joufa.databaserepository.model.EntityScanMarker;
import fi.joufa.databaserepository.repository.RepositoryScanMarker;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@EntityScan(basePackageClasses = EntityScanMarker.class)
@EnableJpaRepositories(basePackageClasses = RepositoryScanMarker.class)
public class DatabaseConfiguration {

  @Bean
  @Profile("test")
  public DataSource devDataSource() {
    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
    return builder.setType(EmbeddedDatabaseType.H2).build();
  }
}
