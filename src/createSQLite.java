import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by 47276138y on 14/11/16.
 */
public class createSQLite {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection conn=null;
        Statement stm = null;

        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:themovieProjectDB.db");
        System.out.println("Opened database successfully");

        stm = conn.createStatement();

        String sql_movie = "CREATE TABLE IF NOT EXISTS MOVIE " +
            "(ID             INT     PRIMARY KEY," +
            " TITLE          TEXT    NOT NULL, " +
            " RELEASE        TEXT    NOT NULL)";

        String sql_actor = "CREATE TABLE IF NOT EXISTS ACTOR " +
            " (ID   INT     PRIMARY KEY," +
            " NAME  TEXT    NOT NULL," +
            " ARTISTIC_NAME TEXT NOT NULL)";

        String sql_character = "CREATE TABLE IF NOT EXISTS CHARACTER " +
            " (ID   INT     PRIMARY KEY," +
            " NAME  TEXT    NOT NULL)";

        String sql_acting = "CREATE TABLE IF NOT EXISTS ACTING " +
            " (ID_MOVIE         INT     PRIMARY KEY," +
            "  ID_ACTOR         TEXT    NOT NULL," +
            "  ID_CHARACTER     TEXT    NOT NULL)";


        stm.executeUpdate(sql_movie);
        stm.executeUpdate(sql_actor);
        stm.executeUpdate(sql_character);
        stm.executeUpdate(sql_acting);

        stm.close();
        conn.close();
    }
}
