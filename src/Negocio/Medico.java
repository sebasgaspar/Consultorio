
package Negocio;

public class Medico {
    
    private String idMedico;
    private String idEspecialidad;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono;
    private String foto;
    private String contraseña;

    public Medico(String idMedico, String idEspecialidad, String nombre, String primerApellido, String segundoApellido, String telefono, String foto, String contraseña) {
        this.idMedico = idMedico;
        this.idEspecialidad = idEspecialidad;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.foto = foto;
        this.contraseña = contraseña;
    }

    public String getIdMedico() {
        return idMedico;
    }

    public String getIdEspecialidad() {
        return idEspecialidad;
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

    public String getFoto() {
        return foto;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }

    public void setIdEspecialidad(String idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
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

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Medico{" + "idMedico=" + idMedico + ", idEspecialidad=" + idEspecialidad + ", nombre=" + nombre + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", telefono=" + telefono + ", foto=" + foto + ", contrase\u00f1a=" + contraseña + '}';
    }

    
}
