package com.fundatec.macdonalds.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Pedido {

    @Id
    private Integer numeroPedido;
    private String item;
    private Integer quantidade;
    private Double valor;

}
