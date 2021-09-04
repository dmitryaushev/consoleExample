package config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConnector {

    private final HikariDataSource ds;

    public DatabaseConnector() {

        HikariConfig config = new HikariConfig();
        Properties properties = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream resourceAsStream = classLoader.getResourceAsStream("application.properties")) {
            properties.load(resourceAsStream);
        } catch (Exception e) {
            throw new RuntimeException("Error loading application.properties", e);
        }

        try {
            Class.forName(properties.getProperty("jdbc.driver"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error loading postgres driver", e);
        }

        config.setJdbcUrl(properties.getProperty("jdbc.url"));
        config.setUsername(properties.getProperty("jdbc.username"));
        config.setPassword(properties.getProperty("jdbc.password"));
        ds = new HikariDataSource(config);
        ds.setMaximumPoolSize(Integer.parseInt(properties.getProperty("jdbc.connection.pool.max.size")));

    }

    public DataSource getDataSource() {
        return ds;
    }
}
