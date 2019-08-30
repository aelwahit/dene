
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public  class DBUtility {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;


    public static void establishConnection (DBType dbType)throws Exception{

           switch (dbType ){
               case ORACLE:
                   connection = DriverManager.getConnection(ConfigurationReader.getProperty("oracledb.url"),
                           ConfigurationReader.getProperty("oracledb.user"),
                   ConfigurationReader.getProperty("oracledb.password"));
                   break;
               default:
                   connection = null ;

           }


    }






    public enum DBType{

ORACLE, MYSQL , MARIADB ,

    }






}
