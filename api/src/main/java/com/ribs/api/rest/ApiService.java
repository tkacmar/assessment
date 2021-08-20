package com.ribs.api.rest;

import com.ribs.api.KafkaConnectionHelper;
import com.ribs.api.rest.dao.ArticlesDAO;
import com.ribs.api.rest.model.Article;
import com.ribs.api.rest.model.SearchArticle;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/articles")
public class ApiService {

    @Autowired
    private ArticlesDAO articleDAO;

    @PostMapping(path = "/article", consumes = "application/json", produces = "application/json")
    public Article getArticle(@RequestBody SearchArticle toSearchArticle)
            throws Exception {
        if (toSearchArticle.getId() != null) {
            articleDAO.getArticleById(toSearchArticle);
        } else {
            articleDAO.getArticleByName(toSearchArticle);
        }
        produce(toSearchArticle);
        return articleDAO.getArticle(toSearchArticle);

    }

    /**
     * @param toSearchArticle
     */
    private void produce(SearchArticle toSearchArticle) {
        new Thread(() -> {
            try {
                Producer<String, String> producer = new KafkaProducer<>(KafkaConnectionHelper.getKafkaProperties());
                producer.send(new ProducerRecord<>(KafkaConnectionHelper.getKafkaTopic(), toSearchArticle.getId(), toSearchArticle.getName()));
                System.out.println(
                        "KafkaExample.produce().new Thread() {...}.run(I) Topic----> " + KafkaConnectionHelper.getKafkaTopic() + "Article id" + toSearchArticle.getId());
            } catch (Exception v) {
                v.printStackTrace();
                System.out.println(v);
            }
        }).start();
    }
}
