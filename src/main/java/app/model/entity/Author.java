package app.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * User: admin
 * Date: 17.08.13
 * Time: 19:29
 */
@Entity
@Table(name="authors")
public class Author implements app.model.entity.Entity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "bookTitle")
    private String bookTitle;

    public Author () {
    }

    public Author (String name, String bookTitle) {
        this.name = name;
        this.bookTitle = bookTitle;
    }

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getBookTitle () {
        return bookTitle;
    }

    public void setBookTitle (String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @Override
    public String toString () {
        return "Автор: \n" +
                "id - " + id +
                "\nимя - '" + name + '\'' +
                "\nкнига - '" + bookTitle + '\'' +
                '\n';
    }
}
