package com.ribs.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/articles")
public class ApiService {

    @Autowired
    private ArticlesDAO locationDAO;

}
