
package Negocio;


public class Paciente {
    
    private String idPaciente;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono;
    private String fechaNacimiento;
    private char genero;

    public Paciente(String idPaciente, String nombre, String primerApellido, String segundoApellido, String telefono, String fechaNacimiento, char genero) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public char getGenero() {
        return genero;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return  idPaciente+ ";" + nombre + ";" + primerApellido + ";" + segundoApellido + ";" + telefono + ";" + fechaNacimiento + ";" + genero;
    }

    
}
