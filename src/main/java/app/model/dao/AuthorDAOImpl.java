package app.model.dao;

import app.model.entity.Author;
import org.springframework.stereotype.Repository;

/**
 * User: admin
 * Date: 18.08.13
 * Time: 18:55
 */
@Repository
public class AuthorDAOImpl extends DAOImpl<Author> implements AuthorDAO {
    protected AuthorDAOImpl() {
        super(Author.class);
    }
}
