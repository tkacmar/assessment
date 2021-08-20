package com.ribs.api.rest;

import com.ribs.api.rest.dao.ArticlesDAO;
import com.ribs.api.rest.model.Article;
import com.ribs.api.rest.model.SearchArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
@RequestMapping(path = "/articles")
public class ApiService {

    @Autowired
    private ArticlesDAO articleDAO;

    @PostMapping(path = "/article", consumes = "application/json", produces = "application/json")
    public Article getArticle(@RequestBody SearchArticle toSearchArticle)
            throws Exception {
        return articleDAO.getArticle(toSearchArticle);
    }






}
