package uniandes.isis2304.hotelandes.negocio;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class Convencion {
    private List asistentes;
    private int dias;
    private Timestamp fechaInicio;
    private Timestamp fechaFin;

    public Convencion(List asistentes, Timestamp fechaInicio, Timestamp fechaFin) {
        this.asistentes = asistentes;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        //Dias de la convencion = fechaFin - fechaInicio
        this.dias = (int) ((fechaFin.getTime() - fechaInicio.getTime()) / (1000 * 60 * 60 * 24));
    }

    @Override
    public String toString() {
        return "Convencion [asistentes=" + asistentes + ", dias=" + dias + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
    }

    public Timestamp getHoraInicio() {
        return fechaInicio;
    }

    public Timestamp getHoraFin() {
        return fechaFin;
    }
}
