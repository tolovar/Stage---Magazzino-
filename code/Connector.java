
//Programma Java per impostare una connessione ed estrarre i dati dal database
import java.sql.*;

public class Connector {
  public static void main(String arg[])
  {
      Connection connection = null;
      try {
          // linee utili per connettere
          Class.forName("com.mysql.cj.jdbc.Driver");
          connection = DriverManager.getConnection(
              "jdbc:mysql://localhost:3306/MagazzinoResistenze",
              "root", "1234");

          // MagazzinoResistenze è il database
          // Magazzinouser è il nome per il database
          // Magazzinouser è la password per il database

          //creo lo statement
          Statement statement;
          statement = connection.createStatement();
          ResultSet resultSet;
          //gli faccio eseguire una query che estrae tutto dal database
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
      
      //Eccezioni da gestire -- DA FINIRE
      catch (Exception exception) {
          System.out.println(exception);
      }
  }
} 