package uniandes.isis2304.hotelandes.negocio;

import oracle.sql.TIMESTAMP;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

public class PersonasHabitacion implements VOPersonasHabitacion{
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
    public PersonasHabitacion(BigDecimal idHabitacion, TIMESTAMP fechaEntrada, TIMESTAMP fechaSalida, BigDecimal idUso, BigDecimal Uso) throws SQLException {
        Date dateEntrada=fechaEntrada.dateValue();
        Timestamp dateEntradat = new Timestamp(dateEntrada.getTime());
        Date dateSalida=fechaSalida.dateValue();
        Timestamp dateSalidat = new Timestamp(dateSalida.getTime());
        this.idHabitacion=idHabitacion.longValue();
        this.fechaEntrada=dateEntradat;
        this.fechaSalida=dateSalidat;
        this.idUso=idUso.longValue();
        this.Uso=Uso.longValue();
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
