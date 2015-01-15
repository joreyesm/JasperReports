/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main.java.ims.ui;

public class Objetivo {
	private String idObjetivo;
    private String descripcion;

	public String getIdObjetivo() {
		return idObjetivo;
	}
	public void setIdObjetivo(String idObjetivo) {
		this.idObjetivo = idObjetivo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String toString()
	  {
	  return this.descripcion;
	  }
}
