
package Vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GestionAtencionAlPaciente extends javax.swing.JFrame {
    
    public static void main(String[] args) {
        
        GestionAtencionAlPaciente atencion = new GestionAtencionAlPaciente();
        atencion.setVisible(true);
    }
    
    public JPanel panel;
    
    public GestionAtencionAlPaciente(){
     
        setSize(530, 330);
        setTitle("ATENCIÓN AL PACIENTE");
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        iniciarComponentes();
        
        }
    
    private void iniciarComponentes(){
        
        crearPanel();
        crearEtiquetas();
        crearBotones();
        crearAreaDeTexto();
        crearCajaDeTexto();
        crearCitasDespegables();
     
    }
    
    private void crearPanel(){
        
        panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(null);
        this.getContentPane().add(panel);
        
    }
    
    private void crearEtiquetas(){
        
        JLabel etiqueta = new JLabel();
        etiqueta.setText("Fecha:");
        etiqueta.setBounds(10, 5, 100, 25);
        etiqueta.setFont(new Font("Times New Roman", 0, 15));
        panel.add(etiqueta);
        
        JLabel etiqueta1 = new JLabel();
        etiqueta1.setText("Doctor:");
        etiqueta1.setBounds(250, 5, 130, 30);
        etiqueta1.setFont(new Font("Times New Roman", 0, 15));
        panel.add(etiqueta1);
        
        JLabel etiqueta2 = new JLabel();
        etiqueta2.setText("Diagnostico");
        etiqueta2.setBounds(5, 10, 130, 100);
        etiqueta2.setFont(new Font("Times New Roman", 0, 15));
        panel.add(etiqueta2);
        
        JLabel etiqueta3 = new JLabel();
        etiqueta3.setText("Prescripción");
        etiqueta3.setBounds(5, 30, 130, 30);
        etiqueta3.setFont(new Font("Times New Roman", 0, 15));
        panel.add(etiqueta3);
        
        JLabel etiqueta4 = new JLabel();
        etiqueta4.setText("Exámenes");
        etiqueta4.setBounds(5, 30, 130, 30);
        etiqueta4.setFont(new Font("Times New Roman", 0, 15));
        panel.add(etiqueta4);
        
        /*
        Etiqueta tipo imagen
        
        JLabel etiqueta2 = new JLabel(new ImageIcon(imagen));
        etiqueta2.setIcon(new ImageIcon("balonMundial.jpg"));
        etiqueta2.setBounds(10, 10, 200, 100);
        panel.add(etiqueta2);
        */
    }
    
    private void crearBotones(){
        
        JButton boton1 = new JButton("Regresar");
        boton1.setBounds(180, 50, 100, 20);
        boton1.setForeground(Color.blue);
        panel.add(boton1);
        
    }
    
    private void crearAreaDeTexto(){
        
        JTextArea areaTexto = new JTextArea();
        areaTexto.setBounds(20, 80, 300, 200);
        panel.add(areaTexto);
        
       
        JTextArea areaTexto1 = new JTextArea();
        areaTexto1.setBounds(100, 20, 300, 200);
        panel.add(areaTexto1);
        
        JTextArea areaTexto2 = new JTextArea();
        areaTexto2.setBounds(20, 20, 300, 200);
        panel.add(areaTexto2);
                
               
    }
    
    private void crearCajaDeTexto(){
        
        JTextField cajaTexto1 = new JTextField();
        cajaTexto1.setBounds(300, 10, 200, 20);
        panel.add(cajaTexto1);
    }
    
    private void crearCitasDespegables(){
        
        JComboBox listaDespegable1 = new JComboBox();
        listaDespegable1.setBounds(50, 10, 180, 20);
        panel.add(listaDespegable1);
                
    }
    
}
            
    
    
    
