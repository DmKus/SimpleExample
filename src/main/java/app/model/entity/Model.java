package app.model.entity;

import app.model.db.DBConnector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 17.08.13
 * Time: 19:36
 * To change this template use File | Settings | File Templates.
 */
public class Model {

    private List<Author> authors;
    private static Model instance;

    private DBConnector dbConnector = new DBConnector();

    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    public Model() {
        dbConnector.connect();
        this.authors = dbConnector.listAuthors();
    }

    public Model (List<Author> authors) {
        this.authors = authors;
    }

    public boolean addAuthor(Author author) {
        return true;
    }

    public boolean addAuthor(String authorName, String bookTitle) {
        Author author = new Author();
        author.setId(authors.size());
        author.setName(authorName);
        author.setBookTitle(bookTitle);
        authors.add(author);
        return dbConnector.addAuthor(author);
    }

    public List<Author> listAuthors () {
        return dbConnector.listAuthors();
    }

    public void setAuthors (List<Author> authors) {
        this.authors = authors;
    }
}
