
//Programma Java per impostare una connessione ed estrarre i dati dal database
import java.sql.*;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Connector {
  public static void main(String arg[])
  {
      Connection connection;
      try {

        // carico il driver JDBC di MySQL 
            Class.forName("com.mysql.cj.jdbc.Driver");
          // linee utili per connettersi al database
        final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/MagazzinoResistenze";
          // creo la connessione
          connection = DriverManager.getConnection(
              "jdbc:mysql://localhost:3306/MagazzinoResistenze",
              "root", "1234");

          // MagazzinoResistenze è il database
          // root è lo username per il database
          // 1234 è la password per il database

        System.out.println("Connessione avvenuta con successo");

          // creo lo statement
            Statement statement;
          statement = connection.createStatement();
          ResultSet resultSet;
          // gli faccio eseguire una query che estrae tutto dal database
          resultSet = statement.executeQuery(
              "select * from designation");
          int code;
          String title;
          while (resultSet.next()) {
              code = resultSet.getInt("code");
              title = resultSet.getString("title").trim();
              System.out.println("Code : " + code
                                 + " Title : " + title);
          }
          resultSet.close();
          statement.close();
          connection.close();
      }
      
      // eccezioni da gestire -- DA FINIRE
      catch (Exception exception) {
          System.out.println(exception);
      }
  }
} 