package br.com.carlos.reservas.service;

import br.com.carlos.reservas.model.Reservas;
import br.com.carlos.reservas.repository.ReservaRepository;
import java.util.List;

public class ReservaService {
    private ReservaRepository repository = new ReservaRepository();

    public void finalizarReserva(Reservas reserva, int diasPrazo) {
        // Calcula a data antes de mandar salvar
        reserva.dataPrevistaParaEntregar(diasPrazo);
        repository.salvar(reserva);
    }

    public List<Reservas> listarReservas() {
        return repository.buscarTodas();
    }

    public Reservas encontrarReserva(String cpf) {
        return repository.buscarPorCpf(cpf);
    }
    
    public boolean excluirReserva(String cpf) {
        Reservas r = repository.buscarPorCpf(cpf);
        if (r != null) {
            return repository.remover(r);
        }
        return false;
    }
    
    public void removerItemDaReserva(String cpf, int indiceItem) {
    	Reservas r = repository.buscarPorCpf(cpf);
    	if(r != null) {
    		r.removerProdutoPorIndice(indiceItem);
    	}
	}
}
