package app.model.db;


import app.model.entity.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 18.08.13
 * Time: 17:29
 * To change this template use File | Settings | File Templates.
 */
public class DBConnector {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public void connect () {
        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/authors_db";
            String username = "root";
            String password = "admin";
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disconnect () {

        try {

            if (resultSet != null) {
                resultSet.close();
            } else {
                System.out.println("result set null");
            }
            if (statement != null) {
                statement.close();
            } else {
                System.out.println("statement null");
            }
            if (connection != null) {
                connection.close();
            } else {
                System.out.println("connection null");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean addAuthor(Author author) {
        try {
            int status = statement.executeUpdate("insert into authors (id, name, bookTitle) values (" + author.getId() + ", '" + author.getName() + "', '" + author.getBookTitle() + "');");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return false;
    }

    public Author getAuthor(Integer id) {
        Author author = new Author();
        try {
            resultSet = statement.executeQuery("select * from authors WHERE id ='" + id + "';");
            while (resultSet.next()) {
                author.setId(resultSet.getInt(1));
                author.setName(resultSet.getString(2));
                author.setBookTitle(resultSet.getString(3));
                return author;
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return author;
    }

    public List<Author> listAuthors() {
        List<Author> authors = new ArrayList<Author>();
        try {
            resultSet = statement.executeQuery("select * from authors;");
            while (resultSet.next()) {
                Author author = new Author();
                author.setId(resultSet.getInt(1));
                author.setName(resultSet.getString(2));
                author.setBookTitle(resultSet.getString(3));
                authors.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return authors;
    }

}
