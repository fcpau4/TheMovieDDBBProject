import java.sql.*;

/**
 * Created by 47276138y on 21/11/16.
 */
public class insertSQLite {


    public static void insertMovie(int id, String title, String release_date) throws ClassNotFoundException,
            SQLException {

            Connection conn = null;

            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:themovieProjectDB.db");

            /*Cuando una connexión no esta en modo de confirmación automática sus instrucciones SQL
            se agrupan en transacciones que finalizan con una llamada al método commit o al método rollback.*/
            conn.setAutoCommit(false);


            String movie_insert = "INSERT INTO MOVIE " +
                    "(ID, TITLE, RELEASE) VALUES " +
                    "(?, ?, ?); ";

            PreparedStatement preparedStatement = conn.prepareStatement(movie_insert);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, title);
            preparedStatement.setString(3, release_date);

            preparedStatement.executeUpdate();

        }


    }

