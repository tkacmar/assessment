package com.ribs.api.rest.dao;

import com.ribs.api.rest.model.Article;
import com.ribs.api.rest.model.SearchArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class ArticlesDAO {

    @Autowired
    ResourceLoader resourceLoader;


    public Article getArticle(SearchArticle toSearchArticle) {



        return new Article(Integer.valueOf(1),"Java Spring","Deitel", new Date());
    }



}
