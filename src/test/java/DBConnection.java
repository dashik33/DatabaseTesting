import java.sql.*;

public class DBConnection {
    public static void main(String[] args) throws SQLException {
        //connection String usually provided by DBA
        String dbURL = "jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        ////jdbc Java api that contains all the interface and classes
        ////mysql This is the name of the database that we will be working with
        ////3.237.189.167 Ip of the server where we have the database
        ////3306 port on which the database is active
        ////syntaxhrm_mysql name of the database or schema
        String userName = "syntax_hrm";
        String password = "syntaxhrm123";
        Connection connection= DriverManager.getConnection(dbURL, userName, password);
        //statement is responsible for taking your quires executing on the DB and bringing the results back
        Statement statement=connection.createStatement();
        String query ="select * from employee";
        ResultSet resultSet= statement.executeQuery(query);
        while (resultSet.next()){
            String empId=resultSet.getString("empId");
            String salary=resultSet.getString("salary");
            String grade=resultSet.getString("grade");
            String department=resultSet.getString("department");
            System.out.println(empId+" "+salary+" "+grade+" "+department);
        }
    }
}
