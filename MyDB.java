package pl.lublin.wsei.java.cwiczenia.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Properties;

public class MyDB{

    private String user;
    private String password;
    private String serverName;
    private String portNumber;
    private String database;
    private Connection conn = null;
    private Connection conn = null;
    private Statement statement = null;
    
    public MyDB(String serverName, String portNumber, String database);
        this.serverName = serverName;
        this.database = database;
        this.portNumber = portNumber;

    public ResultSet selectData(String selectStatement) {
        boolean statement;
        if ((conn != null) && (statement != null))
            try {
                return statement.executeQuery(selectStatement);
            } catch (SQLException e) {
                System.out.println("Błąd realizacji zapytania: " + selectStatement + ", " + e.getMessage());
            }
        return null;
    }
}

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private void connect() {
        Properties connectionProps = new Properties();
        connectionProps.put("user", user);
        connectionProps.put("password", password);
        connectionProps.put("serverTimezone","Europe/Warsaw");

        String dbName;
        String host;
        String port;
        String jdbcString = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
        try {
            conn = DriverManager.getConnection(
                    jdbcString, connectionProps);
        }
        catch (SQLException e) {
            System.out.println("Błąd podłączenia do bazy: ")+jdbcString);
            System.out.println("Komunikat błędu: "+e.getMessage());
            conn = null;
        }
        System.out.println("Connected to database "+dbName);
    }
    
    public Connection getConnection() {
    if (conn == null)
        connect();

    return conn;

}

    public void setUSer(String root) {
    }

    public void closeConnection() {
    }

    