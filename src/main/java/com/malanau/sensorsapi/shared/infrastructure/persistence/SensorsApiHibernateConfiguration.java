package com.malanau.sensorsapi.shared.infrastructure.persistence;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class SensorsApiHibernateConfiguration {
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(hibernateProperties());
        final List<Resource> mappingFiles = searchMappingFiles();

        sessionFactory.setMappingLocations(mappingFiles.toArray(new Resource[mappingFiles.size()]));

        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager(
            final LocalSessionFactoryBean sessionFactory) {
        final HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory.getObject());

        return transactionManager;
    }

    public DataSource dataSource() {
        final BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(
                "jdbc:mysql://localhost:3306/sensors?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        return dataSource;
    }

    private Properties hibernateProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.put(AvailableSettings.HBM2DDL_AUTO, "none");
        hibernateProperties.put(AvailableSettings.SHOW_SQL, "false");
        hibernateProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

        return hibernateProperties;
    }

    private List<Resource> searchMappingFiles() {
        final String path = "./src/main/java/com/malanau/sensorsapi/";

        final List<String> modules = subdirectoriesFor(path);
        final List<String> goodPaths = new ArrayList<>();

        for (final String module : modules) {
            final String[] files =
                    mappingFilesIn(module + "/infrastructure/persistence/hibernate/");

            for (final String file : files) {
                goodPaths.add(module + "/infrastructure/persistence/hibernate/" + file);
            }
        }

        return goodPaths.stream().map(FileSystemResource::new).collect(Collectors.toList());
    }

    private List<String> subdirectoriesFor(final String path) {

        final String[] files =
                new File(path).list((current, name) -> new File(current, name).isDirectory());

        if (null == files) {
            return Collections.emptyList();
        }

        return Arrays.stream(files).map(file -> path + file).collect(Collectors.toList());
    }

    private String[] mappingFilesIn(final String path) {
        final String[] files =
                new File(path)
                        .list(
                                (current, name) ->
                                        new File(current, name).getName().contains(".hbm.xml"));

        if (null == files) {
            return new String[0];
        }

        return files;
    }
}
