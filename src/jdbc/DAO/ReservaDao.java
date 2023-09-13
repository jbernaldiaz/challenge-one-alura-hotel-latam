package jdbc.DAO;

import jdbc.modelo.Reservas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDao {

    private static Connection con;

    public ReservaDao(Connection connection) {
        this.con = connection;
    }

    public void guardar(Reservas reserva) {

        try {
            String sql = "INSERT INTO reservas (fecha_entrada, fecha_salida, valor, forma_pago) VALUES (?, ?, ?, ?)";

            try (PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                System.out.println(sql);
                pstm.setString(1, reserva.getFecha_entrada());
                pstm.setString(2, reserva.getFecha_salida());
                pstm.setDouble(3, reserva.getValor());
                pstm.setString(4, reserva.getFormaPago());

               pstm.executeUpdate();

                try (ResultSet rst = pstm.getGeneratedKeys()) {

                    while (rst.next()) {
                        reserva.setId(rst.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Reservas> listar() {
        List<Reservas> resultado = new ArrayList<>();

        try {
            final PreparedStatement statement = con
                    .prepareStatement("SELECT id, fecha_entrada, fecha_salida, valor, forma_pago FROM huespedes");

            try (statement) {
                statement.execute();

                final ResultSet resultSet = statement.getResultSet();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Reservas(
                                resultSet.getInt("id"),
                                resultSet.getString("fecha_entrada"),
                                resultSet.getString("fecha_salida"),
                                resultSet.getDouble("valor"),
                                resultSet.getString("forma_pago")
                                ));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    public List<Reservas> buscar() {
        List<Reservas> reservas = new ArrayList<Reservas>();
        try {
            String sql = "SELECT id, fecha_entrada, fecha_salida, valor, forma_pago FROM reservas";

            try (PreparedStatement pstm = con.prepareStatement(sql)) {
                pstm.execute();

                transformarResultSetEnReserva(reservas, pstm);
            }
            return reservas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void Eliminar(Integer id) {
        try (PreparedStatement stm = con.prepareStatement("DELETE FROM reservas WHERE id = ?")) {
            stm.setInt(1, id);
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Reservas> buscarId(String id) {
        List<Reservas> reservas = new ArrayList<Reservas>();
        try {

            String sql = "SELECT id, fecha_entrada, fecha_salida, valor, forma_pago FROM reservas WHERE id = ?";

            try (PreparedStatement pstm = con.prepareStatement(sql)) {
                pstm.setString(1, id);
                pstm.execute();

                transformarResultSetEnReserva(reservas, pstm);
            }
            return reservas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void Actualizar(String fechaE, String fechaS, Double valor, String formaPago, Integer id) {
        try (PreparedStatement stm = con
                .prepareStatement("UPDATE reservas SET fecha_entrada = ?, fecha_salida = ?, valor = ?, forma_pago = ? WHERE id = ?")) {
            stm.setString(1, fechaE);
            stm.setString(2, fechaS);
            stm.setDouble(3, valor);
            stm.setString(4, formaPago);
            stm.setInt(5, id);
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private void transformarResultSetEnReserva(List<Reservas> reservas, PreparedStatement pstm) throws SQLException {
        try (ResultSet rst = pstm.getResultSet()) {
            while (rst.next()) {
                Reservas produto = new Reservas(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDouble(4), rst.getString(5));

                reservas.add(produto);
            }
        }
    }
}
