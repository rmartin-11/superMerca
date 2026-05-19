  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rmartin.supermerca;

import java.util.ArrayList;

/**
 *
 * @author loren
 */
public class Cajero {

    String nombre;
    int c;
    double t;
    ArrayList<Producto> ps;

    public Cajero(String n) {
        this.nombre = n;
        this.c = 0;
        this.t = 0;
        this.ps = new ArrayList<>();
    }

    public void ANADIRPRODUCTO(Producto p) {
        ps.add(p);
    }

    public void eliminarProDUCTO(Producto p) {
        ps.remove(p);
    }

    public void cobrar() {
        double subtotal = 0;
        for (Producto p : ps) {
            subtotal = subtotal + p.calcularImporte();
        }
        double iva = subtotal * 0.21;
        double total = subtotal + iva;

        System.out.println("===== TICKET =====");
        System.out.println("Cajero: " + nombre);
        for (Producto p : ps) {
            System.out.println(p.getNombre() + " x" + p.getCantidad()
                    + " = " + String.format("%.2f", p.calcularImporte()) + " EUR");
        }
        System.out.println("------------------");
        System.out.println("Subtotal: " + String.format("%.2f", subtotal) + " EUR");
        System.out.println("IVA (21%): " + String.format("%.2f", iva) + " EUR");
        System.out.println("TOTAL: " + String.format("%.2f", total) + " EUR");
        System.out.println("==================");

        c = c + 1;
        t = t + total;
        ps.clear();
    }

    public void cierreCaja() {
        double ivaRecaudado = t - (t / (1 + 0.21));

        System.out.println("===== CIERRE DE CAJA =====");
        System.out.println("Cajero: " + nombre);
        System.out.println("--------------------------");
        System.out.println("Tickets emitidos: " + c);
        System.out.println("Total facturado:  " + String.format("%.2f", t) + " EUR");
        System.out.println("IVA recaudado:    " + String.format("%.2f", ivaRecaudado) + " EUR");
        System.out.println("==========================");
    }

    public boolean ticketVacio() {
        return ps.isEmpty();
    }

    public int getTicketsEmitidos() {
        return c;
    }

    public double getTotalDia() {
        return t;
    }
}
