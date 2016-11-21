import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by 47276138y on 21/11/16.
 */
public class Movie {

    int id=0;
    String name="";
    String date="";
    ArrayList<Movie> movies  = new ArrayList<>();

    public Movie(int id, String name, String date){
        this.id = id;
        this.name = name;
        this.date = date;
        movies.add(this);
    }

    public void insertMovies() throws SQLException, ClassNotFoundException {

        for (int i = 0; i < movies.size(); i++) {
            insertSQLite.insertMovie(movies.get(i).getId(), movies.get(i).getName(), movies.get(i).getDate());
        }


    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name;}
    public String getDate() {return date;}
    public void setDate(String date) {this.date = date;}

}
