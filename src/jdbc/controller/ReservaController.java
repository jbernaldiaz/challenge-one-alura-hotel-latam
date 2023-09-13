package jdbc.controller;
import jdbc.DAO.ReservaDao;
import jdbc.factory.ConnectionFactory;
import jdbc.modelo.Reservas;

import java.sql.Connection;
import java.util.List;

public class ReservaController {
    private ReservaDao reservaDao;

    public ReservaController() {
        Connection connection = new ConnectionFactory().recuperaConexion();
        this.reservaDao = new ReservaDao(connection);
    }

    public void guardar(Reservas reserva) {
        this.reservaDao.guardar(reserva);
    }

    public List<Reservas> buscar() {
        return this.reservaDao.buscar();
    }

    public List<Reservas> buscarId(String id) {
        return this.reservaDao.buscarId(id);
    }

    public void actualizar(String fechaE, String fechaS, Double valor, String formaPago, Integer id) {
        this.reservaDao.Actualizar(fechaE, fechaS, valor, formaPago, id);
    }

    public void Eliminar(Integer id) {
        this.reservaDao.Eliminar(id);
    }
}
