package br.com.carlos.reservas.repository;

import br.com.carlos.reservas.model.Reservas;
import java.util.ArrayList;
import java.util.List;

public class ReservaRepository {
    private List<Reservas> todasAsReservas = new ArrayList<>();

    public void salvar(Reservas reserva) {
    	todasAsReservas.add(reserva);
    }

    public List<Reservas> buscarTodas() {
        return todasAsReservas;
    }

    public Reservas buscarPorCpf(String cpfCliente) {
        for (Reservas r : todasAsReservas) {
            if (r.getCliente().getCpfCliente().equalsIgnoreCase(cpfCliente)) {
                return r;
            }
        }
        return null;
    }

    public boolean remover(Reservas reserva) {
        return todasAsReservas.remove(reserva);
    }
}