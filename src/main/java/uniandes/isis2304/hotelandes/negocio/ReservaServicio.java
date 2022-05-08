package uniandes.isis2304.hotelandes.negocio;

import oracle.sql.TIMESTAMP;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ReservaServicio {
    public long id;
    public Timestamp horaInicio;
    public Timestamp horaFin;
    public long idUsuario;
    public long activo;
    public long idServicio;
    public ReservaServicio(){
        this.id=0;
        this.horaInicio=null;
        this.horaFin=null;
        this.idUsuario=0;
        this.activo=0;
    }
    public ReservaServicio(long id,Timestamp horaInicio, Timestamp horaFinal,long idUsuario, long activo, long idServicio) {
        this.id=id;
        this.horaInicio=horaInicio;
        this.horaFin=horaFinal;
        this.idUsuario=idUsuario;
        this.activo=activo;
        this.idServicio=idServicio;

    }
    public ReservaServicio(BigDecimal id, TIMESTAMP horaInicio, TIMESTAMP horaFinal, BigDecimal idUsuario, BigDecimal activo, BigDecimal idServicio) throws SQLException {
        Date dateEntrada=horaInicio.dateValue();
        Timestamp dateEntradat = new Timestamp(dateEntrada.getTime());
        Date dateSalida=horaFinal.dateValue();
        Timestamp dateSalidat = new Timestamp(dateSalida.getTime());
        this.id=id.longValue();
        this.horaInicio=dateEntradat;
        this.horaFin=dateSalidat;
        this.idUsuario=idUsuario.longValue();
        this.activo=activo.longValue();
        this.idServicio=idServicio.longValue();
    }

    public long getidServicio() {
        return idServicio;
    }

    public void setNumeroHabitacion(long idServicio) {
        this.idServicio = idServicio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Timestamp horaInicio) {
        this.horaInicio = horaInicio;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getActivo() {
        return activo;
    }

    public void setActivo(long activo) {
        this.activo = activo;
    }

    public Timestamp getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Timestamp horaFin) {
        this.horaFin = horaFin;
    }

    @Override
    public String toString()
    {
        return "Usuario [Fecha inicio=" + horaInicio + ", HoraFinal=" + horaFin + "]";
    }
}
