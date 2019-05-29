
package Gestion;

import Negocio.Medico;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GestorMedico {
    
    private String ruta;

    public GestorMedico() {
        this.ruta = "./Archivos/Medico.txt";
        this.verificArchivo();
    }

    public void crearMedico(String idMedico, String idEspecialidad, String nombre, String primerapellido, String segundoapellido, String telefono, String foto, String contraseña) {
        Medico med;
        med = new Medico(idMedico, idEspecialidad, nombre, primerapellido, segundoapellido, telefono, foto, contraseña);
        this.guardaMedico(med);
    }

    public void guardaMedico(Medico med) {
        try {
            File file = new File(ruta);
            FileWriter fr = new FileWriter(file, true);
            PrintWriter ps = new PrintWriter(fr);

            ps.println(med);

            ps.close();
            JOptionPane.showMessageDialog(null, "La Operacion fue exitosa");
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Falla al guardar el archivo");
        }
    }

    public ArrayList<Medico> getMedico() {
        Medico lista = null;
        ArrayList<Medico> meds = new ArrayList();
        FileReader file;
        BufferedReader br;
        String registro;

        try {
            file = new FileReader(ruta);
            br = new BufferedReader(file);

            while ((registro = br.readLine()) != null) {
                String[] campos = registro.split(";");
                lista = new Medico(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], campos[7]);
                meds.add(lista);
            }
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Falla buscando el archivo");
        }
        return meds;
    }

    public Medico buscaMedico(String idMedico) {
        Medico med = null;
        FileReader file;
        BufferedReader br;
        String registro;
        try {
            file = new FileReader(ruta);
            br = new BufferedReader(file);

            while ((registro = br.readLine()) != null) {
                String[] campos = registro.split(";");
                if ((campos[0].equals(idMedico))) {
                    med = new Medico(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], campos[7]);

                    break;
                }
            }
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Falla buscando en el archivo");
        }
        return med;
    }

    public void eliminarMedico(String code) {
        ArrayList<Medico> meds = this.getMedico();
        boolean existe = false;
        for (Medico med : meds) {
            if (med.getIdMedico().equals(code)) {
                meds.remove(med);
                this.recargaArchivo(meds);
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
        ArrayList<Medico> meds = this.getMedico();
        boolean existe = false;
        for (Medico med : meds) {
            if (med.getIdMedico().equals(code)) {
                med.setIdMedico(newidMedico);
                this.recargaArchivo(meds);
                JOptionPane.showMessageDialog(null, "Operacion exitosa");
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe ese idMedico");
        }
    }

    public void modificarIdEspecialidad(String code, String newespecialidad) {
        ArrayList<Medico> meds = this.getMedico();
        boolean existe = false;
        for (Medico med : meds) {
            if (med.getIdMedico().equals(code)) {
                med.setIdEspecialidad(newespecialidad);
                this.recargaArchivo(meds);
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe esa especialidad");
        }
    }

    public void modificarNombre(String code, String newnombre) {
        ArrayList<Medico> meds = this.getMedico();
        boolean existe = false;
        for (Medico med : meds) {
            if (med.getIdMedico().equals(code)) {
                med.setNombre(newnombre);
                this.recargaArchivo(meds);
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe ese nombre");
        }
    }

    public void modificarPrimerApellido(String code, String newPrimerapellido) {
        ArrayList<Medico> meds = this.getMedico();
        boolean existe = false;
        for (Medico med : meds) {
            if (med.getIdMedico().equals(code)) {
                med.setPrimerApellido(newPrimerapellido);
                this.recargaArchivo(meds);
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe ese apellido");
        }
    }
    
    public void modificarSegundoApellido(String code, String newSegundoapellido) {
        ArrayList<Medico> meds = this.getMedico();
        boolean existe = false;
        for (Medico med : meds) {
            if (med.getIdMedico().equals(code)) {
                med.setSegundoApellido(newSegundoapellido);
                this.recargaArchivo(meds);
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe esa apellido");
        }
    }
    
     public void modificarTelefono(String code, String newtelefono) {
        ArrayList<Medico> meds = this.getMedico();
        boolean existe = false;
        for (Medico med : meds) {
            if (med.getIdMedico().equals(code)) {
                med.setTelefono(newtelefono);
                this.recargaArchivo(meds);
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe ese telefono");
        }
    }
     
    public void modificarFoto(String code, String newfoto) {
        ArrayList<Medico> meds = this.getMedico();
        boolean existe = false;
        for (Medico med : meds) {
            if (med.getIdMedico().equals(code)) {
                med.setFoto(newfoto);
                this.recargaArchivo(meds);
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe esa foto");
        }
    }
    
     public void modificarContraseña(String code, String newcontraseña) {
        ArrayList<Medico> meds = this.getMedico();
        boolean existe = false;
        for (Medico med : meds) {
            if (med.getIdMedico().equals(code)) {
                med.setContraseña(newcontraseña);
                this.recargaArchivo(meds);
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe esa contraseña");
        }
    }

    public boolean existeMedico(String idMedico) {
        ArrayList<Medico> meds = this.getMedico();

        boolean existe = false;
        for (Medico med : meds) {
            if (med.getIdMedico().equals(idMedico)) {
                existe = true;
            }

        }

        return existe;
    }

    private void recargaArchivo(ArrayList<Medico> meds) {
        try {
            File file = new File(ruta);
            FileWriter fr = new FileWriter(file, false);
            PrintWriter ps = new PrintWriter(fr);

            ps.println(meds.get(0));
            ps.close();
            for (int i = 1; i < meds.size(); i++) {
                file = new File(ruta);
                fr = new FileWriter(file, true);
                ps = new PrintWriter(fr);

                ps.println(meds.get(i));
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


