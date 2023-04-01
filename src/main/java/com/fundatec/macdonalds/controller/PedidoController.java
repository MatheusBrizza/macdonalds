package com.fundatec.macdonalds.controller;

import com.fundatec.macdonalds.model.Pedido;
import com.fundatec.macdonalds.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/macdonalds")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        Pedido responsePedido = pedidoService.criarPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }
    @GetMapping
    public ResponseEntity<List<Pedido>> buscarTodosPedidos() {
        List<Pedido> responsePedido = pedidoService.buscarTodosPedidos();
        return ResponseEntity.status(HttpStatus.OK).body(responsePedido);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pedido>> buscarPedidoPorId(@PathVariable("id") Integer id) {
        Optional<Pedido> pedido = pedidoService.buscarPedidoPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedidoPorId(@PathVariable("id") Integer id) {
        pedidoService.deletarPedidoPorId(id);
        return ResponseEntity.status(HttpStatus.GONE).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizarPedido(@PathVariable("id") Integer id, @RequestBody Pedido pedido) {
        Pedido responsePedido = pedidoService.atualizarPedido(id, pedido);
        return ResponseEntity.status(HttpStatus.OK).body(responsePedido);
    }
}
