package jdbc.modelo;

public class Huespedes {

    private int id;
    private String nombre;
    private String apellido;
    private String fecha_nacimiento;
    private String nacionalidad;
    private String telefono;
    private int idReservas;

    public Huespedes(int id, String nombre, String apellido, String fechaNacimiento, String nacionalidad, String telefono, int idReserva) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.idReservas = idReserva;
    }

    public Huespedes(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Huespedes(String nombre, String apellido, String fecha_nacimiento, String nacionalidad, String telefono, int idReservas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.idReservas = idReservas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getIdReservas() {
        return idReservas;
    }

    public void setIdReservas(int idReservas) {
        this.idReservas = idReservas;
    }
}
