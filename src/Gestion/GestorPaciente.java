
package Gestion;

import Negocio.Paciente;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GestorPaciente {
    
    private String ruta;

    public GestorPaciente() {
        this.ruta = "./Archivos/Paciente.txt";
        this.verificArchivo();
    }

    public void crearPaciente(String idPaciente, String nombre, String primerapellido, String segundoapellido, String telefono, String fechaNacimiento, char genero) {
        Paciente paciente;
        paciente = new Paciente(idPaciente, nombre, primerapellido, segundoapellido, telefono, fechaNacimiento, genero);
        this.guardaPaciente(paciente);
    }

    public void guardaPaciente(Paciente paciente) {
        try {
            File file = new File(ruta);
            FileWriter fr = new FileWriter(file, true);
            PrintWriter ps = new PrintWriter(fr);

            ps.println(paciente);

            ps.close();
            JOptionPane.showMessageDialog(null, "La Operacion fue exitosa");
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Falla al guardar el archivo");
        }
    }

    public ArrayList<Paciente> getPaciente() {
        Paciente lista = null;
        ArrayList<Paciente> pacientes = new ArrayList();
        FileReader file;
        BufferedReader br;
        String registro;

        try {
            file = new FileReader(ruta);
            br = new BufferedReader(file);

            while ((registro = br.readLine()) != null) {
                String[] campos = registro.split(";");
                lista = new Paciente(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], charAt(campos[6]));
                pacientes.add(lista);
            }
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Falla buscando el archivo");
        }
        return pacientes;
    }

    public Paciente buscaPaciente(String idPaciente) {
        Paciente paciente = null;
        FileReader file;
        BufferedReader br;
        String registro;
        try {
            file = new FileReader(ruta);
            br = new BufferedReader(file);

            while ((registro = br.readLine()) != null) {
                String[] campos = registro.split(";");
                if ((campos[0].equals(idPaciente))) {
                    paciente = new Paciente(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], charAt(campos[6]));

                    break;
                }
            }
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Falla buscando en el archivo");
        }
        return paciente;
    }

    public void eliminarPaciente(String code) {
        ArrayList<Paciente> pacientes = this.getPaciente();
        boolean existe = false;
        for (Paciente paciente : pacientes) {
            if (paciente.getIdPaciente().equals(code)) {
                pacientes.remove(paciente);
                this.recargaArchivo(pacientes);
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
        ArrayList<Paciente> pacientes = this.getPaciente();
        boolean existe = false;
        for (Paciente paciente : pacientes) {
            if (paciente.getIdPaciente().equals(code)) {
                paciente.setIdPaciente(newidPaciente);
                this.recargaArchivo(pacientes);
                JOptionPane.showMessageDialog(null, "Operacion exitosa");
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe ese idPaciente");
        }
    }

    public void modificarNombre(String code, String newnombre) {
        ArrayList<Paciente> pacientes = this.getPaciente();
        boolean existe = false;
        for (Paciente paciente : pacientes) {
            if (paciente.getIdPaciente().equals(code)) {
                paciente.setNombre(newnombre);
                this.recargaArchivo(pacientes);
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe ese nombre");
        }
    }

    public void modificarPrimerApellido(String code, String newPrimerapellido) {
        ArrayList<Paciente> pacientes = this.getPaciente();
        boolean existe = false;
        for (Paciente paciente : pacientes) {
            if (paciente.getIdPaciente().equals(code)) {
                paciente.setPrimerApellido(newPrimerapellido);
                this.recargaArchivo(pacientes);
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe ese apellido");
        }
    }
    
    public void modificarSegundoApellido(String code, String newSegundoapellido) {
        ArrayList<Paciente> pacientes = this.getPaciente();
        boolean existe = false;
        for (Paciente paciente : pacientes) {
            if (paciente.getIdPaciente().equals(code)) {
                paciente.setSegundoApellido(newSegundoapellido);
                this.recargaArchivo(pacientes);
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe ese apellido");
        }
    }
    
     public void modificarTelefono(String code, String newtelefono) {
        ArrayList<Paciente> pacientes = this.getPaciente();
        boolean existe = false;
        for (Paciente paciente : pacientes) {
            if (paciente.getIdPaciente().equals(code)) {
                paciente.setTelefono(newtelefono);
                this.recargaArchivo(pacientes);
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe ese telefono");
        }
    }
     
    public void modificarFechaNacimiento(String code, String newFechanacimiento) {
        ArrayList<Paciente> pacientes = this.getPaciente();
        boolean existe = false;
        for (Paciente paciente : pacientes) {
            if (paciente.getIdPaciente().equals(code)) {
                paciente.setFechaNacimiento(newFechanacimiento);
                this.recargaArchivo(pacientes);
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe esa fecha");
        }
    }
    
     public void modificarGenero(String code, char newgenero) {
        ArrayList<Paciente> pacientes = this.getPaciente();
        
        boolean existe = false;
        for (Paciente paciente : pacientes) {
            if (paciente.getIdPaciente().equals(code)) {
                paciente.setGenero(newgenero);
                this.recargaArchivo(pacientes);
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(null, "No existe esa fecha");
        }
    
    }

    public boolean existePaciente(String idPaciente) {
        ArrayList<Paciente> pacientes = this.getPaciente();

        boolean existe = false;
        for (Paciente paciente : pacientes) {
            if (paciente.getIdPaciente().equals(idPaciente)) {
                existe = true;
            }

        }

        return existe;
    }

    private void recargaArchivo(ArrayList<Paciente> pacientes) {
        try {
            File file = new File(ruta);
            FileWriter fr = new FileWriter(file, false);
            PrintWriter ps = new PrintWriter(fr);

            ps.println(pacientes.get(0));
            ps.close();
            for (int i = 1; i < pacientes.size(); i++) {
                file = new File(ruta);
                fr = new FileWriter(file, true);
                ps = new PrintWriter(fr);

                ps.println(pacientes.get(i));
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

    private char charAt(String campo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
    