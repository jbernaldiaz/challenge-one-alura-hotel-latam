package jdbc.controller;

import jdbc.DAO.HuespedDao;
import jdbc.factory.ConnectionFactory;
import jdbc.modelo.Huespedes;

import java.util.List;
import java.util.Map;

public class HuespedController {
    private HuespedDao huespedDao;

    public HuespedController(){
        var factory = new ConnectionFactory();
        this.huespedDao = new HuespedDao(factory.recuperaConexion());
    }
    public void Eliminar(Integer id) {
        this.huespedDao.Eliminar(id);
    }
    public List<Huespedes> listarHuespedes() {
        return this.huespedDao.listarHuespedes();
    }

    public List<Huespedes> listarHuespedesId(String id) {
        return this.huespedDao.buscarId(id);
    }

    public void actualizar(String nombre, String apellido, String fechaN, String nacionalidad, String telefono, Integer idReserva, Integer id) {
        this.huespedDao.Actualizar(nombre, apellido, fechaN, nacionalidad, telefono, idReserva, id);
    }

    public void guardar(Huespedes huespedes) {
        HuespedDao.guardar(huespedes);
    }
}
