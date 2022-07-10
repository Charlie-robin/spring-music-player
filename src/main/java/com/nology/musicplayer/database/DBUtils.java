package com.nology.musicplayer.database;

import com.nology.musicplayer.data.StarRating;
import com.nology.musicplayer.exceptions.TrackDatabaseException;

import java.sql.*;

import static com.nology.musicplayer.database.DatabseConstants.JDBC_DATABASE_URL;

public class DBUtils {

    // TO HAVE A FIELD, GETTERS AND SETTERS -> FOR JDBC_DATABASE_URL
    // SET THAT UP IN OUR XML -> "jdbc:h2:~/test";

    private String jdbcDatabaseUrl;

    public void setJdbcDatabaseUrl(String jdbcDatabaseUrl) {
        this.jdbcDatabaseUrl = jdbcDatabaseUrl;
    }

    public void performDBAction(String sql, boolean throwException) {

        try (Connection connection = DriverManager.getConnection(jdbcDatabaseUrl)) {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                boolean result = statement.execute();

            } catch (Exception e) {
                e.printStackTrace();
                if (throwException) {
                    throw new TrackDatabaseException("Exception attempting to perform action: " + sql, e);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TrackDatabaseException("Exception attempting to perform action: " + sql, e);
        }

    }

    public void performDBUpdate(String sql, PreparedStatementSetup statementSetup) {

        try (Connection connection = DriverManager.getConnection(jdbcDatabaseUrl)) {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                statementSetup.beforeExecution(statement);

                statement.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
                throw new TrackDatabaseException("Exception attempting to perform action: " + sql, e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TrackDatabaseException("Exception attempting to perform action: " + sql, e);
        }

    }

    public <T> T performDBQuery(String sql, ResultSetHandler handler) {

        try (Connection connection = DriverManager.getConnection(jdbcDatabaseUrl)) {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                ResultSet resultSet = statement.executeQuery();

                return handler.handleResultSet(resultSet);

            } catch (Exception e) {
                e.printStackTrace();
                throw new TrackDatabaseException("Exception attempting to perform query: " + sql, e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TrackDatabaseException("Exception attempting to perform action: " + sql, e);
        }
    }

}
