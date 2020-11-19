package data_art.tech_leaders_project.JDBC;

import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.time.Year;

@RestController
public class PrintDB {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/movies";
    static final String USER = "Jose";
    static final String PASSWORD = "LoganX$94";

    public static void printDB() throws ClassNotFoundException, SQLException {
        Connection connection;
        Statement statement;
        Class.forName(JDBC_DRIVER);
        System.out.println("Creating database connection...");

        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        statement = connection.createStatement();

        String sql = "SELECT m.name as 'Movie', year, country, last_name as 'Director' FROM movies m LEFT JOIN directors d on m.director_id = d.id";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String movie = resultSet.getString("Movie");
            Date year = resultSet.getDate("Year");
            String country = resultSet.getString("Country");
            String director = resultSet.getString("Director");

            System.out.println("id" + id);
            System.out.println("Movie" + movie);
            System.out.println("Year" + year);
            System.out.println("Country" + country);
            System.out.println("Director" + director);
            System.out.println("\n");
        }
        resultSet.close();
        statement.close();
        connection.close();

    }
}
