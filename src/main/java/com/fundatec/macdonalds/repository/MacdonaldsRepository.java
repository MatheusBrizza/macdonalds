package com.fundatec.macdonalds.repository;

import com.fundatec.macdonalds.model.Macdonalds;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MacdonaldsRepository extends MongoRepository<Macdonalds, Integer> {
}
