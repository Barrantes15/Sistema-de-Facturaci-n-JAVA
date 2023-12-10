package modelo;

import java.sql.Date;
import java.sql.Time;

public class Citas {

    private int idCita;
    private String asusnto;
    private Date fecha;
    private Time hora;
    private Date fechaCreacion;
    private Mascota mascota;
    private Veterinarios veterianario;
    private Usuario usuario;

    public Citas() {
    }

    public Citas(int idCita, String asusnto, Date fecha, Time hora, Date fechaCreacion, Mascota mascota, Veterinarios veterianario, Usuario usuario) {
        this.idCita = idCita;
        this.asusnto = asusnto;
        this.fecha = fecha;
        this.hora = hora;
        this.fechaCreacion = fechaCreacion;
        this.mascota = mascota;
        this.veterianario = veterianario;
        this.usuario = usuario;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getAsusnto() {
        return asusnto;
    }

    public void setAsusnto(String asusnto) {
        this.asusnto = asusnto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Mascota getIdMascota() {
        return mascota;
    }

    public void setIdMascota(Mascota idMascota) {
        this.mascota = idMascota;
    }

    public Veterinarios getIdVeterianario() {
        return veterianario;
    }

    public void setIdVeterianario(Veterinarios idVeterianario) {
        this.veterianario = idVeterianario;
    }

    public Usuario getIdUsuario() {
        return usuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.usuario = idUsuario;
    }

}
