package uniandes.isis2304.hotelandes.negocio;

import java.sql.Timestamp;

public interface VOReserva {
    public long getId();

    public void setId(long id);

    public Timestamp getHoraInicio();

    public void setHoraInicio(Timestamp horaInicio);

    public Timestamp getHoraFinal();

    public void setHoraFinal(Timestamp horaFinal);

    public long getIdUsuario();

    public void setIdUsuario(long idUsuario);

    public long getActivo();

    public void setActivo(long activo);
    @Override
    public String toString();
}
