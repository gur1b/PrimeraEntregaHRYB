package edu.coderhouse.proyecto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private  int id;

  @Column(name="descripcion")
  private String descripcion;

  @Column(name= "codigo")
  private String codigo;

  @Column(name = "stock")
  private int stock;

  @Column(name = "precio")
  private double precio;

  public Producto(String descripcion, String codigo, int stock, double precio) {
    this.descripcion = descripcion;
    this.codigo = codigo;
    this.stock = stock;
    this.precio = precio;
  }

  public Producto() {}

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  @Override
  public String toString() {
    return "Producto{id=" + id + ", codigo='" + codigo + "', descripcion='" + descripcion + "', precio=" + precio + ", stock=" + stock + "}";
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
}