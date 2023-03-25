package com.fundatec.macdonalds.service;

import com.fundatec.macdonalds.model.Macdonalds;
import com.fundatec.macdonalds.repository.MacdonaldsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MacdonaldsService {

    @Autowired
    private MacdonaldsRepository macdonaldsRepository;

    public void criarPedido(Macdonalds pedido) {
        macdonaldsRepository.save(pedido);
    }

    public Optional<Macdonalds> buscarPorPedido(Integer numeroPedido) {
        return macdonaldsRepository.findById(numeroPedido);
    }

    public void deletarPorPedido(Integer numeroPedido) {
        macdonaldsRepository.deleteById(numeroPedido);
    }

    public void atualizarPedido(Integer id, Macdonalds macdonaldsNovo) {
        Optional<Macdonalds> macdonaldsAntigo = macdonaldsRepository.findById(id);
        macdonaldsNovo.setNumeroPedido(macdonaldsAntigo.get().getNumeroPedido());
        this.macdonaldsRepository.save(macdonaldsNovo);
    }
}
