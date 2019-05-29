
package Gestion;

import Negocio.Disponibilidad;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GestorDisponibilidad {
    
    private String ruta;

    public GestorDisponibilidad() {
        this.ruta = "./Archivos/Disponibilidad.txt";
        this.verificArchivo();
    }

    public void crearDisponibilidad(String idMedico, String dia, String hora, String hora2) {
        Disponibilidad disponibilidad;
        disponibilidad = new Disponibilidad(idMedico, dia, hora, hora2);
        this.guardaDisponibilidad(disponibilidad);
    }

    public void guardaDisponibilidad(Disponibilidad disponibilidad) {
        try {
            File file = new File(ruta);
            FileWriter fr = new FileWriter(file, true);
            PrintWriter ps = new PrintWriter(fr);

            ps.println(disponibilidad);

            ps.close();
            JOptionPane.showMessageDialog(null, "La Operacion fue exitosa");
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Falla al guardar el archivo");
        }
    }

    public ArrayList<Disponibilidad> getDisponibilidad() {
        Disponibilidad lista = null;
        ArrayList<Disponibilidad> disponibilidades = new ArrayList();
        FileReader file;
        BufferedReader br;
        String registro;

        try {
            file = new FileReader(ruta);
            br = new BufferedReader(file);

            while ((registro = br.readLine()) != null) {
                String[] campos = registro.split(";");
                lista = new Disponibilidad(campos[0], campos[1], campos[2], campos[3]);
                disponibilidades.add(lista);
            }
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Falla buscando el archivo");
        }
        return disponibilidades;
    }

    public Disponibilidad buscaDisponibilidad(String idMedico) {
        Disponibilidad disponibilidad = null;
        FileReader file;
        BufferedReader br;
        String registro;
        try {
            file = new FileReader(ruta);
            br = new BufferedReader(file);

            while ((registro = br.readLine()) != null) {
                String[] campos = registro.split(";");
                if ((campos[0].equals(idMedico))) {
                    disponibilidad = new Disponibilidad(campos[0], campos[1], campos[2], campos[3]);

                    break;
                }
            }
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Falla buscando en el archivo");
        }
        return disponibilidad;
    }

    public void eliminarDisponibilidad(String code) {
        ArrayList<Disponibilidad> disponibilidades = this.getDisponibilidad();
        boolean existe = false;
        for (Disponibilidad disponibilidad : disponibilidades) {
            if (disponibilidad.getIdMedico().equals(code)) {
                disponibilidades.remove(disponibilidad);
                this.recargaArchivo(disponibilidades);
                JOptionPane.showMessageDialog(null, "Operacion exitosa");
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe ese Codigo");
        }
    }

    public void modificarIdMedico(String code, String newidMedico) {
        ArrayList<Disponibilidad> disponibilidades = this.getDisponibilidad();
        boolean existe = false;
        for (Disponibilidad disponibilidad : disponibilidades) {
            if (disponibilidad.getIdMedico().equals(code)) {
                disponibilidad.setIdMedico(newidMedico);
                this.recargaArchivo(disponibilidades);
                JOptionPane.showMessageDialog(null, "Operacion exitosa");
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe ese idMedico");
        }
    }

    public void modificarDia(String code, String newdia) {
        ArrayList<Disponibilidad> disponibilidades = this.getDisponibilidad();
        boolean existe = false;
        for (Disponibilidad disponibilidad : disponibilidades) {
            if (disponibilidad.getIdMedico().equals(code)) {
                disponibilidad.setDia(newdia);
                this.recargaArchivo(disponibilidades);
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe ese dia");
        }
    }

    public void modificarHora(String code, String newhora) {
        ArrayList<Disponibilidad> disponibilidades = this.getDisponibilidad();
        boolean existe = false;
        for (Disponibilidad disponibilidad : disponibilidades) {
            if (disponibilidad.getIdMedico().equals(code)) {
                disponibilidad.setHora(newhora);
                this.recargaArchivo(disponibilidades);
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe esa hora");
        }
    }

    public void modificarHora2(String code, String newhora2) {
        ArrayList<Disponibilidad> disponibilidades = this.getDisponibilidad();
        boolean existe = false;
        for (Disponibilidad disponibilidad : disponibilidades) {
            if (disponibilidad.getIdMedico().equals(code)) {
                disponibilidad.setHora2(newhora2);
                this.recargaArchivo(disponibilidades);
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe esa hora");
        }
    }

    public boolean existeMedico(String idMedico) {
        ArrayList<Disponibilidad> disponibilidades = this.getDisponibilidad();

        boolean existe = false;
        for (Disponibilidad disponibilidad : disponibilidades) {
            if (disponibilidad.getIdMedico().equals(idMedico)) {
                existe = true;
            }

        }

        return existe;
    }

    private void recargaArchivo(ArrayList<Disponibilidad> disponibilidades) {
        try {
            File file = new File(ruta);
            FileWriter fr = new FileWriter(file, false);
            PrintWriter ps = new PrintWriter(fr);

            ps.println(disponibilidades.get(0));
            ps.close();
            for (int i = 1; i < disponibilidades.size(); i++) {
                file = new File(ruta);
                fr = new FileWriter(file, true);
                ps = new PrintWriter(fr);

                ps.println(disponibilidades.get(i));
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


