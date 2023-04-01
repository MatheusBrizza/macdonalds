package com.fundatec.macdonalds.repository;

import com.fundatec.macdonalds.model.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends MongoRepository<Pedido, Integer> {
}
