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

    String n;
    int c;
    double t;
    ArrayList<Producto> ps;
    
    
    /**
     * Constructor de la clase Cajero.
     * Inicializa un nuevo cajero con un nombre específico, pone a cero el contador 
     * de caja y el total acumulado, e inicializa la lista de productos vacía.
     *
     * @param n El nombre o identificador que se asignará al cajero.
     */
    public Cajero(String n) {
        this.n = n;
        this.c = 0;
        this.t = 0;
        this.ps = new ArrayList<>();
    }
    
    /**
     * Elimina un producto del ticket de compra actual.
     * 
     * @param p El objeto {@link Producto} que se desea retirar.
     */
    public void ANADIRPRODUCTO(Producto p) {
        ps.add(p);
    }
    /**
     * Elimina un producto del ticket de compra actual.
     * 
     * @param p El objeto {@link Producto} que se desea retirar.
     */
    public void eliminarProDUCTO(Producto p) {
        ps.remove(p);
    }
    
    /**
     * Procesa el cobro del ticket actual.
     * 
     * Calcula el subtotal, el IVA (21%) y el total de la compra. Muestra por 
     * consola el desglose del ticket, actualiza el histórico diario de la caja 
     * (incrementa el número de tickets y suma el total facturado) y, finalmente, 
     * vacía el ticket para el siguiente cliente.
     * 
     */
    public void cobrar() {
        double subt = 0;
        for (Producto p : ps) {
            subt = subt + p.calcularImporte();
        }
        double iva = subt * 0.21;
        double tot = subt + iva;

        System.out.println("===== TICKET =====");
        System.out.println("Cajero: " + n);
        for (Producto p : ps) {
            System.out.println(p.getNombre() + " x" + p.getCantidad()
                    + " = " + String.format("%.2f", p.calcularImporte()) + " EUR");
        }
        System.out.println("------------------");
        System.out.println("Subtotal: " + String.format("%.2f", subt) + " EUR");
        System.out.println("IVA (21%): " + String.format("%.2f", iva) + " EUR");
        System.out.println("TOTAL: " + String.format("%.2f", tot) + " EUR");
        System.out.println("==================");

        c = c + 1;
        t = t + tot;
        ps.clear();
    }
    
    /**
     * Realiza el cierre de caja del día.
     *
     * Calcula de forma desglosada el IVA total recaudado a partir del dinero 
     * acumulado en caja y muestra por consola un resumen con el nombre del cajero, 
     * el número total de tickets emitidos y la facturación total del día.
     * 
     */
    public void cierreCaja() {
        double ivaRec = t - (t / (1 + 0.21));

        System.out.println("===== CIERRE DE CAJA =====");
        System.out.println("Cajero: " + n);
        System.out.println("--------------------------");
        System.out.println("Tickets emitidos: " + c);
        System.out.println("Total facturado:  " + String.format("%.2f", t) + " EUR");
        System.out.println("IVA recaudado:    " + String.format("%.2f", ivaRec) + " EUR");
        System.out.println("==========================");
    }
    
    /**
     * Comprueba si el ticket de compra actual está vacío.
     * 
     * @return {@code true} si no hay productos en el ticket actual; 
     *         {@code false} en caso contrario.
     */
    public boolean ticketVacio() {
        return ps.isEmpty();
    }
    
    /**
     * Obtiene la cantidad total de tickets emitidos durante el día.
     * 
     * @return El número de tickets cobrados hasta el momento.
     */
    public int getTicketsEmitidos() {
        return c;
    }
    
    /**
     * Obtiene el importe total facturado acumulado en el día.
     * 
     * @return El total de dinero recaudado (con IVA incluido).
     */
    public double getTotalDia() {
        return t;
    }
}
