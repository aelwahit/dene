
import org.testng.annotations.Test;

import java.sql.*;
import java.util.*;
import java.util.List;
import java.util.Map;


public class JdbcConnection {


    String oracleDbUrl = "jdbc:oracle:thin:@ec2-52-15-120-141.us-east-2.compute.amazonaws.com:1521:xe";
    String oracleDbUsername = "hr";
    String oracleDbUserPassword = "hr";

    @Test
    public void test() throws Exception {


        Connection connection = DriverManager.getConnection(oracleDbUrl,oracleDbUsername,oracleDbUserPassword);
 Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        //       Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from countries");
//      resultSet.next();
//     System.out.println(resultSet.getString(1));
//       System.out.println(resultSet.getString("country_name"));
//      System.out.println( resultSet.getString("region_id"));


//        resultSet.next();


//        while (resultSet.next()){
//            System.out.println( resultSet.getString(1)+"--"+
//                    resultSet.getString("country_name")+"--"
//                    +resultSet.getString("region_id"));
//        }


        resultSet.last();
        int rowsCount = resultSet.getRow();
       System.out.println("Number of Rows"+ rowsCount);

       resultSet.beforeFirst();
       while (resultSet.next()){
           System.out.println(resultSet.getString(1) + "-" + resultSet.getString("country_name" )+ "-" + resultSet.getString("region_id")  );   }


        resultSet.close();
       statement.close();
        connection.close();
    }
@Test
    public void jdbcMetadata() throws Exception {
    Connection connection = DriverManager.getConnection(oracleDbUrl, oracleDbUsername, oracleDbUserPassword);
    Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

    String sql = "select employee_id, last_name ,job_id ,salary from employees";
    ResultSet resultSet = statement.executeQuery(sql);

    DatabaseMetaData dbMetadata = connection.getMetaData();
    System.out.println("User:" + dbMetadata.getUserName());
    System.out.println("Database type:" + dbMetadata.getDatabaseProductName());


    ResultSetMetaData rsMetadata = resultSet.getMetaData();
    System.out.println(rsMetadata.getColumnCount());
    System.out.println(rsMetadata.getColumnName(1));


    for (int i = 1; i <= rsMetadata.getColumnCount(); i++) {
        System.out.println(i + "---" + rsMetadata.getColumnName(i));
    }

    resultSet.close();
    statement.close();
    connection.close();

}
    public void test2() throws Exception {
      Connection  connection = DriverManager.getConnection(oracleDbUrl, oracleDbUsername, oracleDbUserPassword);
      Statement  statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);


        String sql = "select employee_id, last_name ,job_id ,salary from employees";
        ResultSet resultSet = statement.executeQuery(sql);
        List<Map<String, Object>> list = new ArrayList<>();
        ResultSetMetaData rsMetadata =resultSet.getMetaData();
        int colCount = rsMetadata.getColumnCount();
        while(resultSet.next()){
        Map<String,Object> rowMap = new HashMap<>();
        list.add(rowMap);

        }



        resultSet.close();
        statement.close();
        connection.close();

    }
    @Test
    public void test3() throws Exception {
        DBUtility.establishConnection(DBUtility.DBType.ORACLE);
    }

}

