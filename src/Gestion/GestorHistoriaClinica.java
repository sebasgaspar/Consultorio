
package Gestion;

import Negocio.HistoriaClinica;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GestorHistoriaClinica {
    
    private String ruta;

    public GestorHistoriaClinica() {
        this.ruta = "./Archivos/HistoriaClinica.txt";
        this.verificArchivo();
    }

    public void crearHistoriaClinica(String idPaciente, String idCita, String diagnostico, String prescripcion, String examenes) {
        HistoriaClinica hc;
        hc = new HistoriaClinica(idPaciente, idCita, diagnostico, prescripcion, examenes);
        this.guardaHistoriaClinica(hc);
    }

    public void guardaHistoriaClinica(HistoriaClinica hc) {
        try {
            File file = new File(ruta);
            FileWriter fr = new FileWriter(file, true);
            PrintWriter ps = new PrintWriter(fr);

            ps.println(hc);

            ps.close();
            JOptionPane.showMessageDialog(null, "La Operacion fue exitosa");
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Falla al guardar el archivo");
        }
    }

    public ArrayList<HistoriaClinica> getHistoriaClinica() {
        HistoriaClinica lista = null;
        ArrayList<HistoriaClinica> hcs = new ArrayList();
        FileReader file;
        BufferedReader br;
        String registro;

        try {
            file = new FileReader(ruta);
            br = new BufferedReader(file);

            while ((registro = br.readLine()) != null) {
                String[] campos = registro.split(";");
                lista = new HistoriaClinica(campos[0], campos[1], campos[2], campos[3], campos[4]);
                hcs.add(lista);
            }
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Falla buscando el archivo");
        }
        return hcs;
    }

    public HistoriaClinica buscaHistoriaClinica(String idPaciente) {
        HistoriaClinica hc = null;
        FileReader file;
        BufferedReader br;
        String registro;
        try {
            file = new FileReader(ruta);
            br = new BufferedReader(file);

            while ((registro = br.readLine()) != null) {
                String[] campos = registro.split(";");
                if ((campos[0].equals(idPaciente))) {
                    hc = new HistoriaClinica(campos[0], campos[1], campos[2], campos[3], campos[4]);

                    break;
                }
            }
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Falla buscando en el archivo");
        }
        return hc;
    }

    public void eliminarHistoriaClinica(String code) {
        ArrayList<HistoriaClinica> hcs = this.getHistoriaClinica();
        boolean existe = false;
        for (HistoriaClinica hc : hcs) {
            if (hc.getIdPaciente().equals(code)) {
                hcs.remove(hc);
                this.recargaArchivo(hcs);
                JOptionPane.showMessageDialog(null, "Operacion exitosa");
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe ese Codigo");
        }
    }

    public void modificarIdPaciente(String code, String newidPaciente) {
        ArrayList<HistoriaClinica> hcs = this.getHistoriaClinica();
        boolean existe = false;
        for (HistoriaClinica hc : hcs) {
            if (hc.getIdPaciente().equals(code)) {
                hc.setIdPaciente(newidPaciente);
                this.recargaArchivo(hcs);
                JOptionPane.showMessageDialog(null, "Operacion exitosa");
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe ese idPaciente");
        }
    }

    public void modificarIdCita(String code, String newidCita) {
        ArrayList<HistoriaClinica> hcs = this.getHistoriaClinica();
        boolean existe = false;
        for (HistoriaClinica hc : hcs) {
            if (hc.getIdPaciente().equals(code)) {
                hc.setIdCita(newidCita);
                this.recargaArchivo(hcs);
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe ese idCita");
        }
    }

    public void modificarDiagnostico(String code, String newdiagnostico) {
        ArrayList<HistoriaClinica> hcs = this.getHistoriaClinica();
        boolean existe = false;
        for (HistoriaClinica hc : hcs) {
            if (hc.getIdPaciente().equals(code)) {
                hc.setDiagnostico(newdiagnostico);
                this.recargaArchivo(hcs);
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe ese diagnostico");
        }
    }

    public void modificarPrescripcion(String code, String newprescripcion) {
        ArrayList<HistoriaClinica> hcs = this.getHistoriaClinica();
        boolean existe = false;
        for (HistoriaClinica hc : hcs) {
            if (hc.getIdPaciente().equals(code)) {
                hc.setPrescripcion(newprescripcion);
                this.recargaArchivo(hcs);
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe esa prescripcion");
        }
    }
    
    public void modificarExamenes(String code, String newexamenes) {
        ArrayList<HistoriaClinica> hcs = this.getHistoriaClinica();
        boolean existe = false;
        for (HistoriaClinica hc : hcs) {
            if (hc.getIdPaciente().equals(code)) {
                hc.setExamenes(newexamenes);
                this.recargaArchivo(hcs);
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existen esos examenes");
        }
    }

    public boolean existePaciente(String idPaciente) {
        ArrayList<HistoriaClinica> hcs = this.getHistoriaClinica();

        boolean existe = false;
        for (HistoriaClinica hc : hcs) {
            if (hc.getIdPaciente().equals(idPaciente)) {
                existe = true;
            }

        }

        return existe;
    }

    private void recargaArchivo(ArrayList<HistoriaClinica> hcs) {
        try {
            File file = new File(ruta);
            FileWriter fr = new FileWriter(file, false);
            PrintWriter ps = new PrintWriter(fr);

            ps.println(hcs.get(0));
            ps.close();
            for (int i = 1; i < hcs.size(); i++) {
                file = new File(ruta);
                fr = new FileWriter(file, true);
                ps = new PrintWriter(fr);

                ps.println(hcs.get(i));
                ps.close();
            }

        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Falla guardando el archivo");
        }

    }

    private void verificArchivo() {
        try {
            File filex = new File(ruta);
            if (!filex.exists()) {
                filex.createNewFile();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Fallo la ruta del archivo");
        }
    }
}


