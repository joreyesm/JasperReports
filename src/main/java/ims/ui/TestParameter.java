/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main.java.ims.ui;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import net.sf.jasperreports.engine.*;
import java.util.*;

import jor.util.reportes.ReportDriver;

public class TestParameter extends JFrame implements ActionListener, ItemListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/*
	 * Sep 19, 2011 - Se agregó Combo Box estático.
	 * Para agregar nuevos objetivos debe modificarse este programa. TODO: Traer la lista de la base de datos.
	 */
 JasperPrint JPrint;
 JButton btnShowReport;
 JLabel lblParameter;
 //JTextField txtParameter;
 JComboBox cbbOjetivos;
// private String [] objetivos;
 String lobjetivo;


 // INITIALIZE GUI COMPONENTS
 public void initComponent(){
  btnShowReport=new JButton("Ejecutar Reporte");
  btnShowReport.setMnemonic('S');
  btnShowReport.addActionListener(this);

  lblParameter=new JLabel("Proyecto:");

  Objetivo objetivo1 = new Objetivo();
  objetivo1.setIdObjetivo("10");
  objetivo1.setDescripcion("Mantenimiento");
  
  Objetivo objetivo2 = new Objetivo();
  objetivo2.setIdObjetivo("278");
  objetivo2.setDescripcion("FIVA");
  
  Objetivo objetivo3 = new Objetivo();
  objetivo3.setIdObjetivo("291");
  objetivo3.setDescripcion("Mantenimiento FINDUR");

  Objetivo objetivo4 = new Objetivo();
  objetivo4.setIdObjetivo("304");
  objetivo4.setDescripcion("SIMP");
  
  Objetivo array[]=new Objetivo[4];
  array[0] = objetivo1;
  array[1] = objetivo4;
  array[2] = objetivo3;
  array[3] = objetivo2;
  cbbOjetivos = new JComboBox(array);
  cbbOjetivos.addItemListener (this);
 }

 // DESIGN THE FORM
 public void design(){
  setTitle("Indicadores de Seguimiento 20120525");
  getContentPane().setLayout(new FlowLayout());
  getContentPane().add(lblParameter);
  //getContentPane().add(txtParameter);
  getContentPane().add(cbbOjetivos);
  getContentPane().add(btnShowReport);
  
  setSize(300, 200);
  setLocation(400,200);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setVisible(true);
 }

 // SHOW THE REPORT
 public void showReport(){
     String databaseName = "bcr" ;
     String userName = "mgrctr";
     String password = "snorkels";
     String reportFile = "D:\\Ejercicios Eclipse\\Util9999\\src\\Util9999\\JasperReports\\SeguimientoProyectos.jrxml";
     /* Pasar los parámetros al reporte */
     Map<String, Object> parameters = new HashMap<String, Object>();
     parameters.put("proyecto", getProyecto(lobjetivo));
     parameters.put("FECHA", new java.util.Date());
     parameters.put("year", "2012");
     ReportDriver.runReport(databaseName, userName, password, reportFile, parameters);
 } // showReport()
 public Long getProyecto(String dato)
 {
   Long proyecto;
   try {
        proyecto = Long.parseLong(dato);
   } catch (NumberFormatException e){
    	proyecto = null;
   }
   return proyecto;
 } //getProyecto()

 // CONTRUCTOR
 TestParameter(){
  initComponent();
  design();
 }

 public static void main(String[] args){
  new TestParameter();
 }

 // EVENT LISTENER
 public void actionPerformed(ActionEvent ae){
  // IF SHOW BUTTON CLICKED, SHOW THE REPORT
  if(ae.getSource()==btnShowReport)
   showReport();
 }
 public void itemStateChanged(ItemEvent e) {
	 Objetivo objetivo=(Objetivo)cbbOjetivos.getSelectedItem();
	     lobjetivo = objetivo.getIdObjetivo();
	     lblParameter.setText(lobjetivo);
 } 
}
