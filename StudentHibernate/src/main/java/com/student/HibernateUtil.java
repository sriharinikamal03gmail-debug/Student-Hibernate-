package com.student;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {

            Properties properties = new Properties();

            properties.put("hibernate.connection.driver_class",
                    "com.mysql.cj.jdbc.Driver");

            properties.put("hibernate.connection.url",
                    "jdbc:mysql://localhost:3306/studentdb");

            properties.put("hibernate.connection.username",
                    "root");

            properties.put("hibernate.connection.password",
                    "Minako007@");

            properties.put("hibernate.dialect",
                    "org.hibernate.dialect.MySQLDialect");

            properties.put("hibernate.hbm2ddl.auto", "update");

            properties.put("hibernate.show_sql", "true");

            Configuration configuration = new Configuration();

            configuration.setProperties(properties);
            configuration.addAnnotatedClass(Student.class);

            sessionFactory = configuration.buildSessionFactory();
        }

        return sessionFactory;
    }
}