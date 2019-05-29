
package Negocio;

public class Cita {
    
    private String idCita;
    private String idMedico;
    private String idPaciente;
    private String fecha;
    private String dia;
    private String hora;
    private boolean revisado;

    public Cita(String idCita, String idMedico, String idPaciente, String fecha, String dia, String hora, boolean revisado) {
        this.idCita = idCita;
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
        this.fecha = fecha;
        this.dia = dia;
        this.hora = hora;
        this.revisado = revisado;
    }

    public String getIdCita() {
        return idCita;
    }

    public String getIdMedico() {
        return idMedico;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDia() {
        return dia;
    }

    public String getHora() {
        return hora;
    }

    public boolean isRevisado() {
        return revisado;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setRevisado(boolean revisado) {
        this.revisado = revisado;
    }

    @Override
    public String toString() {
        return idCita + ";" + idMedico + ";" + idPaciente + ";" + fecha + ";" + dia + ";" + hora + ";" + revisado;
    }
    
}
