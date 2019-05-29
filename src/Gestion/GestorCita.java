package Gestion;

import Negocio.Cita;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GestorCita {

    private String ruta;

    public GestorCita() {
        this.ruta = "./Archivos/Cita.txt";
        this.verificArchivo();
    }

    public void crearCita(String idCita, String idMedico, String idPaciente, String fecha, String dia, String hora, boolean revisado) {
        Cita cita;
        cita = new Cita(idCita, idMedico, idPaciente, fecha, dia, hora, revisado);
        this.guardaCita(cita);
    }

    public void guardaCita(Cita cita) {
        try {
            File file = new File(ruta);
            FileWriter fr = new FileWriter(file, true);
            PrintWriter ps = new PrintWriter(fr);

            ps.println(cita);

            ps.close();
            JOptionPane.showMessageDialog(null, "La Operacion fue exitosa");
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Falla al guardar el archivo");
        }
    }

    public ArrayList<Cita> getCita() {
        Cita lista = null;
        ArrayList<Cita> citas = new ArrayList();
        FileReader file;
        BufferedReader br;
        String registro;

        try {
            file = new FileReader(ruta);
            br = new BufferedReader(file);

            while ((registro = br.readLine()) != null) {
                String[] campos = registro.split(";");
                lista = new Cita(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], Boolean.valueOf(campos[6]));
                citas.add(lista);
            }
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Falla buscando el archivo");
        }
        return citas;
    }

    public Cita buscaCita(String idPaciente) {
        Cita cita = null;
        FileReader file;
        BufferedReader br;
        String registro;
        try {
            file = new FileReader(ruta);
            br = new BufferedReader(file);

            while ((registro = br.readLine()) != null) {
                String[] campos = registro.split(";");
                if ((campos[3].equals(idPaciente))) {
                    cita = new Cita(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5],Boolean.valueOf( campos[6]));

                    break;
                }
            }
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Falla buscando en el archivo");
        }
        return cita;
    }

    public void eliminarCita(String code) {
        ArrayList<Cita> citas = this.getCita();
        boolean existe = false;
        for (Cita cita : citas) {
            if (cita.getIdCita().equals(code)) {
                citas.remove(cita);
                this.recargaArchivo(citas);
                JOptionPane.showMessageDialog(null, "Operacion exitosa");
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe ese idCita");
        }
    }

    public void modificarIdCita(String code, String newidCita) {
        ArrayList<Cita> citas = this.getCita();
        boolean existe = false;
        for (Cita cita : citas) {
            if (cita.getIdCita().equals(code)) {
                cita.setIdCita(newidCita);
                this.recargaArchivo(citas);
                JOptionPane.showMessageDialog(null, "Operacion exitosa");
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe ese idCita");
        }
    }

    public void modificaridMedico(String code, String newidMedico) {
        ArrayList<Cita> citas = this.getCita();
        boolean existe = false;
        for (Cita cita : citas) {
            if (cita.getIdCita().equals(code)) {
                cita.setIdMedico(newidMedico);
                this.recargaArchivo(citas);
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe ese idMedico");
        }
    }

    public void idPaciente(String code, String newidPaciente) {
        ArrayList<Cita> citas = this.getCita();
        boolean existe = false;
        for (Cita cita : citas) {
            if (cita.getIdCita().equals(code)) {
                cita.setIdPaciente(newidPaciente);
                System.out.print("1" + newidPaciente);
                this.recargaArchivo(citas);
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe ese idPaciente");
        }
    }

    public void modificarFecha(String code, String newfecha) {
        ArrayList<Cita> citas = this.getCita();
        boolean existe = false;
        for (Cita cita : citas) {
            if (cita.getIdCita().equals(code)) {
                cita.setFecha(newfecha);
                this.recargaArchivo(citas);
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe esa fecha");
        }
    }

    public void modificarDia(String code, String newdia) {
        ArrayList<Cita> citas = this.getCita();
        boolean existe = false;
        for (Cita cita : citas) {
            if (cita.getIdCita().equals(code)) {
                cita.setDia(newdia);
                this.recargaArchivo(citas);
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe ese dia");
        }
    }

    public void modificarHora(String code, String newhora) {
        ArrayList<Cita> citas = this.getCita();
        boolean existe = false;
        for (Cita cita : citas) {
            if (cita.getIdCita().equals(code)) {
                cita.setHora(newhora);
                this.recargaArchivo(citas);
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe esa hora");
        }
    }
    
    public void modificarRevisado(String code, boolean newrevisado){
        
        ArrayList<Cita> citas = this.getCita();
        
               boolean existe = false;
        for (Cita cita : citas) {
            if (cita.getIdCita().equals(code)) {
                cita.setRevisado(newrevisado);
                this.recargaArchivo(citas);
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe esa hora");
        }
    }
      

    public boolean existePaciente(String idPaciente) {
        ArrayList<Cita> citas = this.getCita();

        boolean existe = false;
        for (Cita cita : citas) {
            if (cita.getIdPaciente().equals(idPaciente)) {
                existe = true;
            }

        }

        return existe;
    }

    private void recargaArchivo(ArrayList<Cita> citas) {
        try {
            File file = new File(ruta);
            FileWriter fr = new FileWriter(file, false);
            PrintWriter ps = new PrintWriter(fr);

            ps.println(citas.get(0));
            ps.close();
            for (int i = 1; i < citas.size(); i++) {
                file = new File(ruta);
                fr = new FileWriter(file, true);
                ps = new PrintWriter(fr);

                ps.println(citas.get(i));
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

