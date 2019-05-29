
package Negocio;

public class Especialidad {
    
    private String idEspecialidad;
    private String especialidad;

    public Especialidad(String idEspecialidad, String especialidad) {
        this.idEspecialidad = idEspecialidad;
        this.especialidad = especialidad;
    }

    public String getIdEspecialidad() {
        return idEspecialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setIdEspecialidad(String idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return idEspecialidad + ";" + especialidad;
    }   
    
}
