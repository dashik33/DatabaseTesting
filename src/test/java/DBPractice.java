import java.sql.*;

public class DBPractice {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        String userName = "syntax_hrm";
        String password = "syntaxhrm123";
        Connection connection = DriverManager.getConnection(dbUrl, userName, password);
        Statement statement = connection.createStatement();
        String query = "select * from person";
        ResultSet resultSet = statement.executeQuery(query);
        //metadata contains info about result set such as number, types and properties of ResultSet object's columns.
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) { //in DB column's index starts with 1
            System.out.print(resultSetMetaData.getColumnLabel(i)+" ");
        }
        //while loop - go through the rows one by one
        while (resultSet.next()) {//it gives you true and move your cursor to the line
            // for loop - go through columns one by one
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) { //in DB column's index starts with 1
                String columnName = resultSetMetaData.getColumnLabel(i);
                String columnValue = resultSet.getString(columnName);
                System.out.print(columnValue +" ");
            }
            System.out.println();
        }
    }
}
