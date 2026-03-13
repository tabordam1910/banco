package domain.model;

import java.util.Date;
import java.util.Map;

public class BitacoraOperacion {

    private String idBitacora;
    private String tipoOperacion;
    private Date fechaHoraOperacion;
    private int idUsuario;
    private String rolUsuario;
    private String idProductoAfectado;
    private Map<String, Object> datosDetalle;

    public BitacoraOperacion(String idBitacora, String tipoOperacion,
                             int idUsuario, String rolUsuario,
                             String idProductoAfectado,
                             Map<String, Object> datosDetalle) {

        this.idBitacora = idBitacora;
        this.tipoOperacion = tipoOperacion;
        this.fechaHoraOperacion = new Date();
        this.idUsuario = idUsuario;
        this.rolUsuario = rolUsuario;
        this.idProductoAfectado = idProductoAfectado;
        this.datosDetalle = datosDetalle;
    }

}