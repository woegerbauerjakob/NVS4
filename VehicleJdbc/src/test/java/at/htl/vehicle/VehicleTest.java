package at.htl.vehicle;

import org.apache.derby.client.am.SqlException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static junit.framework.TestCase.fail;

public class VehicleTest {
    public static final String DRIVER_STRING = "org.apache.derby.jdbc.ClientDriver";
    static final String CONNECTION_STRING = "jdbc:derby://localhost:1527/db;create=true";
    static final String USER = "app";
    static final String PASSWORD = "app";
    private static Connection conn;

    @BeforeEach
    public  void initJdbc(){
        try {
            Class.forName(DRIVER_STRING);
            conn = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            System.out.println("Verbindung zur Datenbank nicht möglich:\n" + e.getMessage() + "\n");
            System.exit(1);
        }
    }

    @AfterEach
    public  void teardownJdbc(){
        try{
            if(conn != null || !conn.isClosed()){
                conn.close();
                System.out.println("Goodbye!");
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void ddl(){
        try{
            Statement stmt = conn.createStatement();
            String sql = "Create table vehicle (id int constraint vehicle_pk primary key, brand varchar(255) nor null, type varchar(255) not null)";
            stmt.execute(sql);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void firstTest(){
        fail();
    }




}
