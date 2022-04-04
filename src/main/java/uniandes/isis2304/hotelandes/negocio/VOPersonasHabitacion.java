package uniandes.isis2304.hotelandes.negocio;

import java.sql.Timestamp;

public interface VOPersonasHabitacion {
    public long getIdHabitacion();

    public void setIdHabitacion(long idHabitacion);

    public Timestamp getFechaEntrada() ;

    public void setFechaEntrada(Timestamp fechaEntrada);

    public Timestamp getFechaSalida();

    public void setFechaSalida(Timestamp fechaSalida);

    public long getIdUso();

    public void setIdUso(long idUso);

    public long getUso();

    public void setUso(long uso);

    public long getValorAPagar();

    public void setValorAPagar(long valorAPagar);
    @Override
    public String toString();
}
