package edu.coderhouse.proyecto.model;

import edu.coderhouse.proyecto.model.Cliente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "Factura")
public class Factura {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne
  @JoinColumn(name="id_cliente", nullable = false)
  private Cliente cliente;

  @Column(name = "fecha_creacion")
  private LocalDateTime fechaCreacion;

  @Column(name = "total")
  private double total;
  public Factura(Cliente cliente, double total) {
    this.cliente = cliente;
    this.total = total;
    this.fechaCreacion = LocalDateTime.now();
  }

  public Factura(){}

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public LocalDateTime getFechaCreacion() {
    return fechaCreacion;
  }

  public void setFechaCreacion(LocalDateTime fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }


  @Override
  public String toString() {
    return "Factura: {id=" + id +
        ", cliente=" + (cliente != null ? cliente.toString() : "N/A") +
        ", fechaCreacion=" + fechaCreacion +
        ", total=" + total + "}";
  }
}