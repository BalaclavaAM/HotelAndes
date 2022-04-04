package uniandes.isis2304.hotelandes.negocio;

import java.sql.Timestamp;

public class PersonasHabitacion {
    public long idHabitacion;
    public Timestamp fechaEntrada;
    public Timestamp fechaSalida;
    public long idUso;
    public long Uso;
    public PersonasHabitacion(){
        idHabitacion=0;
        fechaEntrada=null;
        fechaSalida=null;
        idUso=0;
        Uso=0;
    }
    public PersonasHabitacion(long idHabitacion, Timestamp fechaEntrada, Timestamp fechaSalida, long idUso, long Uso){
        this.idHabitacion=idHabitacion;
        this.fechaEntrada=fechaEntrada;
        this.fechaSalida=fechaSalida;
        this.idUso=idUso;
        this.Uso=Uso;
    }

    public long getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(long idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Timestamp getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Timestamp fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Timestamp getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Timestamp fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public long getIdUso() {
        return idUso;
    }

    public void setIdUso(long idUso) {
        this.idUso = idUso;
    }

    public long getUso() {
        return Uso;
    }

    public void setUso(long uso) {
        Uso = uso;
    }
    @Override
    public String toString()
    {
        return "PersonasHabitacion [Uso=" + Uso + ", fecha entrada=" + fechaEntrada + "]";
    }
}
