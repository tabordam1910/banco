package domain.model;

import java.util.Date;

public class Usuario {

    private int idUsuario;
    private String idRelacionado;
    private String nombreCompleto;
    private String identificacion;
    private String correo;
    private String telefono;
    private Date fechaNacimiento;
    private String direccion;
    private String rolSistema;
    private String estadoUsuario;

    public Usuario(int idUsuario, String idRelacionado, String nombreCompleto, String identificacion,
                   String correo, String telefono, Date fechaNacimiento,
                   String direccion, String rolSistema, String estadoUsuario) {

        this.idUsuario = idUsuario;
        this.idRelacionado = idRelacionado;
        this.nombreCompleto = nombreCompleto;
        this.identificacion = identificacion;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.rolSistema = rolSistema;
        this.estadoUsuario = estadoUsuario;
    }

    public int getIdUsuario() { return idUsuario; }
    public String getNombreCompleto() { return nombreCompleto; }
    public String getRolSistema() { return rolSistema; }
    public String getEstadoUsuario() { return estadoUsuario; }

}