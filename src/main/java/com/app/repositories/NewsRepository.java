package com.app.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.app.models.Comment;
import com.app.models.News;

public interface NewsRepository extends MongoRepository<News, String> {
	
	@Query("{'user.login': ?0}")
	List<News> findByLogin(String login);
	 boolean existsByURL(String URL);
	 News findByURL(String URL);
	 @Query("{'user.login': ?0}")
	 List<News> findByLoginOrderByScoreTotalDesc(String login);
	 
      

}
