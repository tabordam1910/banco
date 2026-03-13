package domain.model;

import java.util.Date;

public class CuentaBancaria {

    private String numeroCuenta;
    private String tipoCuenta;
    private String idTitular;
    private double saldoActual;
    private String moneda;
    private String estadoCuenta;
    private Date fechaApertura;

    public CuentaBancaria(String numeroCuenta, String tipoCuenta, String idTitular,
                          double saldoActual, String moneda, String estadoCuenta,
                          Date fechaApertura) {

        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.idTitular = idTitular;
        this.saldoActual = saldoActual;
        this.moneda = moneda;
        this.estadoCuenta = estadoCuenta;
        this.fechaApertura = fechaApertura;
    }

    public void depositar(double monto) {
        saldoActual += monto;
    }

    public void retirar(double monto) {
        saldoActual -= monto;
    }

    public double getSaldoActual() {
        return saldoActual;
    }
}