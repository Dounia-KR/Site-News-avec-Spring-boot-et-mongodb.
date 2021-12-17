package com.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.app.models.Score;

public interface ScoreRepository extends MongoRepository<Score, String> {
	@Query("{'news.id': ?0}")
	Score findByIdNews(String IdNews);

}
