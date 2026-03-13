package domain.model;

import java.util.Date;

public class Prestamo {

    private int idPrestamo;
    private String tipoPrestamo;
    private String idCliente;
    private double montoSolicitado;
    private double montoAprobado;
    private double tasaInteres;
    private int plazoMeses;
    private String estadoPrestamo;
    private Date fechaAprobacion;
    private Date fechaDesembolso;
    private String cuentaDestino;

    public Prestamo(int idPrestamo, String tipoPrestamo, String idCliente,
                    double montoSolicitado, double montoAprobado,
                    double tasaInteres, int plazoMeses, String estadoPrestamo) {

        this.idPrestamo = idPrestamo;
        this.tipoPrestamo = tipoPrestamo;
        this.idCliente = idCliente;
        this.montoSolicitado = montoSolicitado;
        this.montoAprobado = montoAprobado;
        this.tasaInteres = tasaInteres;
        this.plazoMeses = plazoMeses;
        this.estadoPrestamo = estadoPrestamo;
    }

    public void aprobarPrestamo(double montoAprobado) {
        this.montoAprobado = montoAprobado;
        this.estadoPrestamo = "Aprobado";
    }

}