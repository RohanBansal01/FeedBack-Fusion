package com.feedbackfusion.repository;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Utility class for managing database connections.
 * <p>
 * This class loads database configuration properties from the
 * {@code db.properties} file located on the classpath root
 * and provides a static method to obtain JDBC connections.
 * </p>
 *
 * <h2>Usage:</h2>
 * <pre>{@code
 * Connection conn = DBConnection.getConnection();
 * }</pre>
 *
 * The {@code db.properties} file must contain:
 * <ul>
 *   <li><b>db.url</b> - JDBC URL of the database</li>
 *   <li><b>db.user</b> - database username</li>
 *   <li><b>db.password</b> - database password</li>
 * </ul>
 *
 * If the properties file is not found or cannot be loaded,
 * the connection attempt will fail.
 */
public class DBConnection {
    private static final Properties props = new Properties();

    static {
        try (InputStream in = DBConnection.class.getResourceAsStream("/db.properties")) {
            if (in == null) {
                System.err.println("db.properties not found on classpath root.");
            } else {
                props.load(in);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates and returns a new {@link Connection} using the
     * properties loaded from {@code db.properties}.
     *
     * @return a valid JDBC {@link Connection} instance
     * @throws SQLException if a database access error occurs
     *                      or required properties are missing
     */
    public static Connection getConnection() throws SQLException {
        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String pass = props.getProperty("db.password");
        return DriverManager.getConnection(url, user, pass);
    }
}
