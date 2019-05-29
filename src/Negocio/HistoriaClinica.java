
package Negocio;

public class HistoriaClinica {
    
    private String idPaciente;
    private String idCita;
    private String diagnostico;
    private String prescripcion;
    private String examenes;

    public HistoriaClinica(String idPaciente, String idCita, String diagnostico, String prescripcion, String examenes) {
        this.idPaciente = idPaciente;
        this.idCita = idCita;
        this.diagnostico = diagnostico;
        this.prescripcion = prescripcion;
        this.examenes = examenes;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public String getIdCita() {
        return idCita;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getPrescripcion() {
        return prescripcion;
    }

    public String getExamenes() {
        return examenes;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void setPrescripcion(String prescripcion) {
        this.prescripcion = prescripcion;
    }

    public void setExamenes(String examenes) {
        this.examenes = examenes;
    }

    @Override
    public String toString() {
        return idPaciente + ";" + idCita + ";" + diagnostico + ";" + prescripcion + ";" + examenes;
    }
    
    
    
}
