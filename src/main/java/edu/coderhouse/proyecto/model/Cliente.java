package edu.coderhouse.proyecto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "nombre")
  private String nombre;
  @Column(name = "apellido")
  private String apellido;
  @Column(name = "numeroDNI")
  private String numeroDocumento;
  public Cliente() {super();}

  public Cliente(String nombre, String apellido, String numeroDocumento) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.numeroDocumento = numeroDocumento;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getNumeroDocumento() {
    return numeroDocumento;
  }

  public void setNumeroDocumento(String numeroDocumento) {
    this.numeroDocumento = numeroDocumento;
  }

  @Override
  public String toString() {
    return "Cliente{id=" + id + ", apellido='" + apellido + "', nombre='" + nombre + "', numerodni='" + numeroDocumento + "'}";
  }
}
