package com.app.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.app.models.News;
import com.app.models.Reaction;
import com.app.models.Score;

public interface ReactionRepository extends MongoRepository<Reaction,String> {

	List<Reaction> findByLogin(String login);
	
}
