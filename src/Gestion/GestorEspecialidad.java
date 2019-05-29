
package Gestion;

import Negocio.Especialidad;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class GestorEspecialidad {
    
    private String ruta;

    public GestorEspecialidad() {
        this.ruta = "./Archivos/Especialidad.txt";
        this.verificArchivo();
    }

    public void crearEspecialidad(String idEspecialidad, String especialidad) {
        Especialidad espec;
        espec = new Especialidad(idEspecialidad, especialidad);
        this.guardaEspecialidad(espec);
    }

    public void guardaEspecialidad(Especialidad espec) {
        try {
            File file = new File(ruta);
            FileWriter fr = new FileWriter(file, true);
            PrintWriter ps = new PrintWriter(fr);

            ps.println(espec);

            ps.close();
            JOptionPane.showMessageDialog(null, "La Operacion fue exitosa");
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Falla al guardar el archivo");
        }
    }

    public ArrayList<Especialidad> getEspecialidad() {
        Especialidad lista = null;
        ArrayList<Especialidad> espec = new ArrayList();
        FileReader file;
        BufferedReader br;
        String registro;

        try {
            file = new FileReader(ruta);
            br = new BufferedReader(file);

            while ((registro = br.readLine()) != null) {
                String[] campos = registro.split(";");
                lista = new Especialidad(campos[0], campos[1]);
                espec.add(lista);
            }
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Falla buscando el archivo");
        }
        return espec;
    }

    public Especialidad buscaEspecialidad(String idEspecialidad) {
        Especialidad espec = null;
        FileReader file;
        BufferedReader br;
        String registro;
        try {
            file = new FileReader(ruta);
            br = new BufferedReader(file);

            while ((registro = br.readLine()) != null) {
                String[] campos = registro.split(";");
                if ((campos[0].equals(idEspecialidad))) {
                    espec = new Especialidad(campos[0], campos[1]);

                    break;
                }
            }
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Falla buscando en el archivo");
        }
        return espec;
    }

    public void eliminarEspecialidad(String code) {
        ArrayList<Especialidad> especialidades = this.getEspecialidad();
        boolean existe = false;
        for (Especialidad espec : especialidades) {
            if (espec.getIdEspecialidad().equals(code)) {
                especialidades.remove(espec);
                this.recargaArchivo(especialidades);
                JOptionPane.showMessageDialog(null, "Operacion exitosa");
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe ese Codigo");
        }
    }

    public void modificarIdEspecialidad(String code, String newidEspecialidad) {
        ArrayList<Especialidad> especialidades = this.getEspecialidad();
        boolean existe = false;
        for (Especialidad espec : especialidades) {
            if (espec.getIdEspecialidad().equals(code)) {
                espec.setIdEspecialidad(newidEspecialidad);
                this.recargaArchivo(especialidades);
                JOptionPane.showMessageDialog(null, "Operacion exitosa");
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe ese idEspecialidad");
        }
    }

    public void modificarEspecialidad(String code, String newEspecialidad) {
        ArrayList<Especialidad> especialidades = this.getEspecialidad();
        boolean existe = false;
        for (Especialidad espec : especialidades) {
            if (espec.getEspecialidad().equals(code)) {
                espec.setEspecialidad(newEspecialidad);
                this.recargaArchivo(especialidades);
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe esa especialidad");
        }
    }

    public boolean existeEspecialidad(String idEspecialidad) {
        ArrayList<Especialidad> especialidades = this.getEspecialidad();

        boolean existe = false;
        for (Especialidad espec : especialidades) {
            if (espec.getIdEspecialidad().equals(idEspecialidad)) {
                existe = true;
            }

        }

        return existe;
    }

    private void recargaArchivo(ArrayList<Especialidad> especialidades) {
        try {
            File file = new File(ruta);
            FileWriter fr = new FileWriter(file, false);
            PrintWriter ps = new PrintWriter(fr);

            ps.println(especialidades.get(0));
            ps.close();
            for (int i = 1; i < especialidades.size(); i++) {
                file = new File(ruta);
                fr = new FileWriter(file, true);
                ps = new PrintWriter(fr);

                ps.println(especialidades.get(i));
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

