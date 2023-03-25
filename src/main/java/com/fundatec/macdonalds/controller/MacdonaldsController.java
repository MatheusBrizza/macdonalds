package com.fundatec.macdonalds.controller;

import com.fundatec.macdonalds.model.Macdonalds;
import com.fundatec.macdonalds.service.MacdonaldsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/macdonalds")
public class MacdonaldsController {

    @Autowired
    private MacdonaldsService macdonaldsService;

    @PostMapping
    public ResponseEntity<Void> criarPedido(@RequestBody Macdonalds macdonalds) {
        macdonaldsService.criarPedido(macdonalds);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Macdonalds>> buscarPedidoPorId(@PathVariable("id") Integer id) {
        Optional<Macdonalds> macdonalds = macdonaldsService.buscarPorPedido(id);
        return ResponseEntity.status(HttpStatus.OK).body(macdonalds);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedidoPorId(@PathVariable("id") Integer id) {
        macdonaldsService.deletarPorPedido(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarPedido(@PathVariable("id") Integer id, @RequestBody Macdonalds macdonalds) {
        this.macdonaldsService.atualizarPedido(id, macdonalds);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
