package com.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.models.Amis;

public interface AmisRepository extends MongoRepository<Amis, String> {
	 Amis findByMoi(String moi);
	 boolean existsByMoi(String moi);
}
