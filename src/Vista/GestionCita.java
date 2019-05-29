
package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class GestionCita extends javax.swing.JFrame implements ActionListener{
    
    public JPanel panel;
    
    public static void main(String[] args) {
        
        GestionCita cita = new GestionCita();
        cita.setVisible(true);
    }
    
    public GestionCita(){
        
        setSize(530, 330);
        setTitle("GESTIÓN DE CITAS");
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.yellow);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        iniciarComponentes();
        
        }
    
    private void iniciarComponentes(){
        
        crearPanel();
        crearEtiquetas();
        crearBotones();
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
        etiqueta.setText("IdPaciente");
        etiqueta.setBounds(5, 5, 100, 25);
        etiqueta.setFont(new Font("Times New Roman", 0, 15));
        panel.add(etiqueta);
        
        JLabel etiqueta1 = new JLabel();
        etiqueta1.setText("Programación de cita");
        etiqueta1.setBounds(5, 30, 130, 30);
        etiqueta1.setFont(new Font("Times New Roman", 0, 15));
        panel.add(etiqueta1);
        
    }
    
    private void crearBotones(){
        
        JButton boton1 = new JButton("Buscar");
        boton1.setBounds(180, 10, 100, 20);
        boton1.setForeground(Color.blue);
        panel.add(boton1);
        
        JButton boton2 = new JButton("Guardar");
        boton2.setBounds(70, 90, 400, 20);
        boton2.setForeground(Color.red);
        panel.add(boton2);
        
        JButton boton3 = new JButton("Modificar Cita");
        boton3.setBounds(5, 250, 180, 20);
        boton3.setForeground(Color.blue);
        panel.add(boton3);
        
        JButton boton4 = new JButton("Eliminar");
        boton4.setBounds(190, 250, 155, 20);
        boton4.setForeground(Color.red);
        panel.add(boton4);
        
        JButton boton5 = new JButton("Regresar");
        boton5.setBounds(350, 250, 160, 20);
        boton5.setForeground(Color.blue);
        panel.add(boton5);
        
    }
    
    private void crearCajaDeTexto(){
        
        JTextField cajaTexto1 = new JTextField();
        cajaTexto1.setBounds(70, 10, 100, 20);
        panel.add(cajaTexto1);
        
        JTextField cajaTexto2 = new JTextField();
        cajaTexto2.setBounds(290, 10, 100, 20);
        panel.add(cajaTexto2);
        
        JTextField cajaTexto3 = new JTextField();
        cajaTexto3.setBounds(400, 10, 100, 20);
        panel.add(cajaTexto3);
        
        JTextField cajaTexto4 = new JTextField("idCita");
        cajaTexto4.setBounds(5, 120, 70, 20);
        panel.add(cajaTexto4);
        
        JTextField cajaTexto5 = new JTextField("Fecha");
        cajaTexto5.setBounds(75, 120, 80, 20);
        panel.add(cajaTexto5);
        
        JTextField cajaTexto6 = new JTextField("Dia");
        cajaTexto6.setBounds(155, 120, 70, 20);
        panel.add(cajaTexto6);
        
        JTextField cajaTexto7 = new JTextField("Hora");
        cajaTexto7.setBounds(225, 120, 80, 20);
        panel.add(cajaTexto7);
        
        JTextField cajaTexto8 = new JTextField("Paciente");
        cajaTexto8.setBounds(305, 120, 200, 20);
        panel.add(cajaTexto8);
        
        JTextField cajaTexto9 = new JTextField();
        cajaTexto9.setBounds(5, 140, 70, 100);
        panel.add(cajaTexto9);
              
        JTextField cajaTexto10 = new JTextField();
        cajaTexto10.setBounds(75, 140, 80, 100);
        panel.add(cajaTexto10);
                
        JTextField cajaTexto11 = new JTextField();
        cajaTexto11.setBounds(155, 140, 70, 100);
        panel.add(cajaTexto11);
                
        JTextField cajaTexto12 = new JTextField();
        cajaTexto12.setBounds(225, 140, 80, 100);
        panel.add(cajaTexto12);
        
        JTextField cajaTexto13 = new JTextField();
        cajaTexto13.setBounds(305, 140, 200, 100);
        panel.add(cajaTexto13);                
        
    }
    
    private void crearCitasDespegables(){
        
        JComboBox listaDespegable1 = new JComboBox();
        listaDespegable1.setBounds(5, 60, 150, 20);
        panel.add(listaDespegable1);
        
        JComboBox listaDespegable2 = new JComboBox();
        listaDespegable2.setBounds(160, 60, 80, 20);
        panel.add(listaDespegable2);
        
        JComboBox listaDespegable3 = new JComboBox();
        listaDespegable3.setBounds(245, 60, 90, 20);
        panel.add(listaDespegable3);
        
        JComboBox listaDespegable4 = new JComboBox();
        listaDespegable4.setBounds(340, 60, 60, 20);
        panel.add(listaDespegable4);
        
        JComboBox listaDespegable5 = new JComboBox();
        listaDespegable5.setBounds(405, 60, 50, 20);
        panel.add(listaDespegable5);
        
        JComboBox listaDespegable6 = new JComboBox();
        listaDespegable6.setBounds(460, 60, 50, 20);
        panel.add(listaDespegable6);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
