package jdbc.modelo;

import java.sql.Date;

public class Reservas {

    private int id;
    private String fecha_entrada;
    private String fecha_salida;
    private double valor;
    private String formaPago;

    public Reservas(String fecha_entrada, String fecha_salida, Double valor, String formaPago) {
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.valor = valor;
        this.formaPago = formaPago;
    }

    public Reservas(int id, String fechaEntrada, String fechaSalida, double valor, String formaPago) {
        this.id = id;
        this.fecha_entrada = fechaEntrada;
        this.fecha_salida = fechaSalida;
        this.valor = valor;
        this.formaPago = formaPago;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFecha_entrada() {
        return fecha_entrada;
    }
    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }
    public String getFecha_salida() {
        return fecha_salida;
    }
    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public String getFormaPago() {
        return formaPago;
    }
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

}
