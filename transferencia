package domain.model;

import java.util.Date;

public class Transferencia {

    private int idTransferencia;
    private String cuentaOrigen;
    private String cuentaDestino;
    private double monto;
    private Date fechaCreacion;
    private Date fechaAprobacion;
    private String estadoTransferencia;
    private int idUsuarioCreador;
    private int idUsuarioAprobador;

    public Transferencia(int idTransferencia, String cuentaOrigen,
                         String cuentaDestino, double monto,
                         int idUsuarioCreador) {

        this.idTransferencia = idTransferencia;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.monto = monto;
        this.idUsuarioCreador = idUsuarioCreador;
        this.estadoTransferencia = "Creada";
        this.fechaCreacion = new Date();
    }

    public void aprobar(int idAprobador) {
        this.estadoTransferencia = "Ejecutada";
        this.idUsuarioAprobador = idAprobador;
        this.fechaAprobacion = new Date();
    }
}