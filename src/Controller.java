import java.sql.*;
import java.util.Scanner;

public class Controller {
    public static void getAllCustomer() throws SQLException {

        //goi dt connection tu lop khac
        Connection connection = MySQLConnectionDb.getMySQLConnection();
        //tap Statement de thuc thi truy van
        Statement statement = connection.createStatement();
        //cau lenh truy van csdl
        String query = "select * from customer";
        //thuc thi truy van, ket thuc tra ve resultSet
        ResultSet resultSet = statement.executeQuery(query);
        //doc bang ghi den het
        while (resultSet.next()) {
            System.out.println("==================");
            System.out.println("Customer ID: " + resultSet.getInt(1));
            System.out.println("Customer First Name: " + resultSet.getString(2));
            System.out.println("Customer Last Name: " + resultSet.getString(3));
            System.out.println("Customer Email: " + resultSet.getString(4));
        }
        resultSet.close();
    }
    public static void createCustomer() throws SQLException {
      Connection connection = MySQLConnectionDb.getMySQLConnection();
      Scanner scanner = new Scanner(System.in);
      //nhap thong tin
      System.out.println("Enter customer ID: ");
      int id = Integer.parseInt(scanner.nextLine());
      System.out.print("Enter customer First Name: ");
      String firstName = scanner.nextLine();
      System.out.print("Enter customer Last Name: ");
      String lastName = scanner.nextLine();
      System.out.print("Enter customer Email: ");
      String email = scanner.nextLine();
      //truy van sql
      String insertQuery = "INSERT INTO customer (customer_id,first_name,last_name,email) VALUES (?,?,?,?)";
      //thuc hien truy van
      PreparedStatement statement = connection.prepareStatement(insertQuery);
      statement.setInt(1, id);
      statement.setString(2, firstName);
      statement.setString(3, lastName);
      statement.setString(4, email);

      // kiem tra du lieu va tin ra ket qua
      int rowsInserted = statement.executeUpdate();
      if(rowsInserted > 0) {
          System.out.println("Customer has been created");
          statement.close();
      } else {
          System.out.println("Customer not inserted");
          statement.close();
      }

    }
    public static void updateCustomer() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        Scanner scanner = new Scanner(System.in);
        connection = MySQLConnectionDb.getMySQLConnection();
        System.out.println("Enter customer ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter customer First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter customer Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter customer Email: ");
        String email = scanner.nextLine();

        String updateQuery = "update customer set first_name=?,last_name=?,email=? where customer_id=?";
        statement= connection.prepareStatement(updateQuery);
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        statement.setString(3, email);
        statement.setInt(4, id);
        int rowUpdate = statement.executeUpdate();
        if(rowUpdate > 0) {
            System.out.println("Customer has been updated");
            statement.close();

        } else {
            System.out.println("Customer not updated");
            statement.close();
        }
    }
    public static void deleteCustomer() throws SQLException {
        Connection connection = MySQLConnectionDb.getMySQLConnection();
        PreparedStatement statement = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        String deleteQuery = "delete from customer where customer_id=?";
        statement = connection.prepareStatement(deleteQuery);
        statement.setInt(1, id);
        int rowDeleted = statement.executeUpdate();
        if(rowDeleted > 0) {
            System.out.println("Customer has been deleted");
            statement.close();
        }else {
            System.out.println("Customer not deleted");
            statement.close();
        }
    }
}
