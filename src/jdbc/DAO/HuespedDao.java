package jdbc.DAO;

import jdbc.modelo.Huespedes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HuespedDao {

    private static Connection con;

    public HuespedDao(Connection con) {
        this.con = con;
    }



    public static void guardar(Huespedes huesped) {
        try {
            String sql = "INSERT INTO huespedes (nombre, apellido, fecha_nacimiento, nacionalidad, telefono, idReservas) VALUES (?, ?, ?, ?,?,?)";

            try (PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, huesped.getNombre());
                pstm.setString(2, huesped.getApellido());
                pstm.setString(3, huesped.getFecha_nacimiento());
                pstm.setString(4, huesped.getNacionalidad());
                pstm.setString(5, huesped.getTelefono());
                pstm.setInt(6, huesped.getIdReservas());

                pstm.execute();

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        huesped.setId(rst.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void Eliminar(Integer id) {
        try (PreparedStatement stm = con.prepareStatement("DELETE FROM huespedes WHERE id = ?")) {
            stm.setInt(1, id);
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Huespedes> listarHuespedes() {
        List<Huespedes> huespedes = new ArrayList<Huespedes>();
        try {
            String sql = "SELECT id, nombre, apellido, fecha_nacimiento, nacionalidad, telefono, idReservas FROM huespedes";

            try (PreparedStatement pstm = con.prepareStatement(sql)) {
                pstm.execute();

                transformarResultSetEnHuesped(huespedes, pstm);
            }
            return huespedes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Huespedes> buscarId(String id) {
        List<Huespedes> huespedes = new ArrayList<Huespedes>();
        try {

            String sql = "SELECT id, nombre, apellido, fecha_nacimiento, nacionalidad, telefono, idReserva FROM huespedes WHERE idReserva = ?";

            try (PreparedStatement pstm = con.prepareStatement(sql)) {
                pstm.setString(1, id);
                pstm.execute();

                transformarResultSetEnHuesped(huespedes, pstm);
            }
            return huespedes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void Actualizar(String nombre, String apellido, String fechaN, String nacionalidad, String telefono, Integer idReserva, Integer id) {
        try (PreparedStatement stm = con
                .prepareStatement("UPDATE huespedes SET nombre = ?, apellido = ?, fecha_nacimiento = ?, nacionalidad = ?, telefono = ?, idReserva = ? WHERE id = ?")) {
            stm.setString(1, nombre);
            stm.setString(2, apellido);
            stm.setString(3, fechaN);
            stm.setString(4, nacionalidad);
            stm.setString(5, telefono);
            stm.setInt(6, idReserva);
            stm.setInt(7, id);
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void transformarResultSetEnHuesped(List<Huespedes> reservas, PreparedStatement pstm) throws SQLException {
        try (ResultSet rst = pstm.getResultSet()) {
            while (rst.next()) {
                Huespedes huespedes = new Huespedes(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getInt(7));
                reservas.add(huespedes);
            }
        }
    }

}
