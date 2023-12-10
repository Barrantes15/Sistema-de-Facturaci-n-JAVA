package modelo;


public class Mascota {
    
    private int idMascota;
    private String nombre;
    private String genero;
    private String tipo;
    private String raza;
    private int activo;
    private Dueño dueños;

    public Mascota() {
    }

    public Mascota(int idMascota, String nombre, String genero, String tipo, String raza, int activo, Dueño dueños) {
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.genero = genero;
        this.tipo = tipo;
        this.raza = raza;
        this.activo = activo;
        this.dueños = dueños;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public Dueño getDueños() {
        return dueños;
    }

    public void setDueños(Dueño dueños) {
        this.dueños = dueños;
    }
    
    
    
}
