
//Programma Java per impostare una connessione ed estrarre i dati dal database
import java.sql.*;
import java.util.Scanner;

@SuppressWarnings("unused")

public class Connector {
  public static void main(String arg[], String lotto)
  {
      Connection connection = null;

      // dichiaro resultSet e statement fuori dal blocco try per poterli chiudere nel finally
      ResultSet resultSet = null; 
      Statement statement = null;

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
          statement = connection.createStatement();

          // prima query per estrarre l'id dell'articolo
          String queryArticolo = "SELECT id FROM articoli WHERE codice = ?";
          statement = connection.prepareStatement(queryArticolo);
          ((PreparedStatement) statement).setString(1, "codiceArticolo");

          // eseguo la query
          resultSet = statement.executeQuery(queryArticolo);
          
          
          int idArticolo = 0;

          if (resultSet.next()) {
              idArticolo = resultSet.getInt("id");            
          }
          if (resultSet != null) resultSet.close();
          if (statement != null) statement.close();

          // seconda query per verificare se esiste già 
          // una locazione per l'articolo e il lotto
          String queryLocazioneEsistente = "SELECT id_locazione FROM movimenti WHERE id_articolo = ? AND lotto = ?";
          statement = connection.prepareStatement(queryLocazioneEsistente);
          ((PreparedStatement) statement).setInt(1, idArticolo);
          ((PreparedStatement) statement).setString(2, lotto);
          resultSet = statement.executeQuery(queryLocazioneEsistente);

          int idLocazione = 0;
          if (resultSet.next()) {
              idLocazione = resultSet.getInt("id_locazione");
          }
          if (resultSet != null) resultSet.close(); 
          if (statement != null) statement.close();

          if (idLocazione == 0) {

              // terza query per trovare una locazione libera
              String queryLocazioneLibera = "SELECT lo.id FROM locazioni lo " +
                                            "LEFT JOIN movimenti mo ON lo.id = mo.id_locazione " +
                                            "WHERE mo.id_locazione IS NULL " +
                                            "ORDER BY locazione " +
                                            "LIMIT 1";
              statement = connection.prepareStatement(queryLocazioneLibera);
              resultSet = statement.executeQuery(queryLocazioneLibera);

              int idLocazioneIns = 0;
              if (resultSet.next()) {
                  idLocazioneIns = resultSet.getInt("id");
              }
              if (resultSet != null) resultSet.close();
              if (statement != null) statement.close();            
          

          // quarta query per inserire il nuovo movimento
          String quertyInserisciMovimento = "INSERT INTO movimenti (id_articolo, lotto, id_locazione) VALUES (?, ?, ?)";
          statement = connection.prepareStatement(quertyInserisciMovimento);
          ((PreparedStatement) statement).setInt(1, idArticolo);
          ((PreparedStatement) statement).setString(2, lotto);
          ((PreparedStatement) statement).setInt(3, idLocazioneIns);
          statement.executeUpdate(quertyInserisciMovimento);
        
        } else {
          
          // logica da eseguire se la locazione esiste già
          System.out.println("Articolo con lotto " + lotto + "già presente nella locazione con ID: " + idLocazione);
        }

      } catch (ClassNotFoundException e) {
        System.err.println("Driver JDBC MySQL non trovato!");
        e.printStackTrace();
    } catch (SQLException e) {
        System.err.println("Errore durante l'operazione sul database: " + e.getMessage());
        e.printStackTrace();
    } finally {

        // chiudo le risorse nel blocco finally per garantire che vengano sempre rilasciate
        try {
            if (statement != null) statement.close();
            if (statement != null) resultSet.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            System.err.println("Errore durante la chiusura della connessione: " + e.getMessage());
        }
    }
}

  /*
  public static void locazioneLotto(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Inserisci il lotto: ");
    String lotto = scanner.nextLine();
    locazioneLotto(args, lotto);
    scanner.close();
  } 
  */

}
