
package Negocio;

public class Disponibilidad {
    
    private String idMedico;
    private String dia;
    private String hora;
    private String hora2;

    public Disponibilidad(String idMedico, String dia, String hora, String hora2) {
        this.idMedico = idMedico;
        this.dia = dia;
        this.hora = hora;
        this.hora2 = hora2;
    }

    public String getIdMedico() {
        return idMedico;
    }

    public String getDia() {
        return dia;
    }

    public String getHora() {
        return hora;
    }

    public String getHora2() {
        return hora2;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setHora2(String hora2) {
        this.hora2 = hora2;
    }

    @Override
    public String toString() {
        return idMedico + ";" + dia + ";" + hora + ";" + hora2;
    }
    
}
