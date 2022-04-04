package uniandes.isis2304.hotelandes.negocio;

import java.sql.Timestamp;

public class Reserva implements VOReserva{
    public long id;
    public Timestamp horaInicio;
    public Timestamp horaFinal;
    public long idUsuario;
    public long activo;
    public Reserva(){
        this.id=0;
        this.horaInicio=null;
        this.horaFinal=null;
        this.idUsuario=0;
        this.activo=0;
    }
    public Reserva(long id,Timestamp horaInicio, Timestamp horaFinal,long idUsuario, long activo){
        this.id=id;
        this.horaInicio=horaInicio;
        this.horaFinal=horaFinal;
        this.idUsuario=idUsuario;
        this.activo=activo;
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

    public Timestamp getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Timestamp horaFinal) {
        this.horaFinal = horaFinal;
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

    @Override
    public String toString()
    {
        return "Usuario [Fecha inicio=" + horaInicio + ", HoraFinal=" + horaFinal + "]";
    }
}
