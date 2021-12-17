package com.app.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.app.models.Comment;
import com.app.models.News;

public interface CommentRepository extends MongoRepository<Comment, String> {
	@Query("{'user.login': ?0}")
	List<Comment> findByLogin(String login);
	
	@Query("{'news.URL': ?0}")
	ArrayList<Comment> findByURL(String URL);
	
}
