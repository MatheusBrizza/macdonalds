package com.fundatec.macdonalds.service;

import com.fundatec.macdonalds.model.Pedido;
import com.fundatec.macdonalds.repository.PedidoRepository;
import com.fundatec.macdonalds.service.exception.CamposVaziosException;
import com.fundatec.macdonalds.service.exception.ListaPedidosVaziaException;
import com.fundatec.macdonalds.service.exception.PedidoJaExistenteException;
import com.fundatec.macdonalds.service.exception.PedidoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido criarPedido(Pedido pedido) {
        validarCampos(pedido);
        validarPedidoExistentePorNumeroPedido(pedido.getNumeroPedido());
        return pedidoRepository.save(pedido);
    }

    public Optional<Pedido> buscarPedidoPorId(Integer numeroPedido) {
        validarPedidoNaoEncontradoPorNumeroPedido(numeroPedido);
        return pedidoRepository.findById(numeroPedido);
    }

    public List<Pedido> buscarTodosPedidos() {
        validarListaPedidosEstaVazia();
        return pedidoRepository.findAll();
    }

    public void deletarPedidoPorId(Integer numeroPedido) {
        validarPedidoNaoEncontradoPorNumeroPedido(numeroPedido);
        pedidoRepository.deleteById(numeroPedido)
        ;
    }

    public Pedido atualizarPedido(Integer id, Pedido pedidoNovo) {
        Optional<Pedido> pedidoAntigo = pedidoRepository.findById(id);
        pedidoNovo.setNumeroPedido(pedidoAntigo.get().getNumeroPedido());
        return pedidoRepository.save(pedidoNovo);
    }

    private void validarPedidoExistentePorNumeroPedido(Integer numeroPedido) throws PedidoJaExistenteException{
        Optional<Pedido> pedidoExistente = pedidoRepository.findById(numeroPedido);

        if (!pedidoExistente.isEmpty()) {
            throw new PedidoJaExistenteException(
                    HttpStatus.BAD_REQUEST,
                    String.format("Pedido de número %s já existe.", numeroPedido)
            );
        }
    }

    private void validarPedidoNaoEncontradoPorNumeroPedido(Integer numeroPedido) throws PedidoNaoEncontradoException {
        Optional<Pedido> PedidoExistente = pedidoRepository.findById(numeroPedido);

        if (PedidoExistente.isEmpty()) {
            throw new PedidoNaoEncontradoException(
                    HttpStatus.BAD_REQUEST,
                    String.format("Pedido de número %s não encontrado", numeroPedido)
            );
        }
    }

    private void validarListaPedidosEstaVazia() {
        List<Pedido> listaPedidos = pedidoRepository.findAll();

        if(listaPedidos.isEmpty()) {
            throw new ListaPedidosVaziaException(
                    HttpStatus.EXPECTATION_FAILED,
                    String.format("Lista está vazia"));
        }
    }

    private void validarCampos(Pedido pedido) {
        if(pedido.getNumeroPedido() == null ||
                pedido.getQuantidade() == null ||
                pedido.getValor() == null) {
            throw new CamposVaziosException(
                    HttpStatus.BAD_REQUEST,
                    String.format("Obrigatório preencher todos os campos")
            );
        }
    }
}
