package app.controller;


import app.model.dao.AuthorDAO;
import app.model.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class InputController {
    @Autowired
    private AuthorDAO authorDAO;

    @RequestMapping(value = "/test.form", method = RequestMethod.POST)
    @Transactional
    public String test(HttpServletRequest request, @RequestParam("author") String authorName, @RequestParam("book") String bookTitle, ModelMap modelMap) {
        try {
            Author author = new Author(authorName, bookTitle);
            authorDAO.saveOrUpdate(author);

            modelMap.addAttribute("result", author);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.addAttribute("result", "very bad");
        }
        return "isSaved";
    }
}
