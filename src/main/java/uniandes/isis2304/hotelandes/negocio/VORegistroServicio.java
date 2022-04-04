package uniandes.isis2304.hotelandes.negocio;

import java.sql.Timestamp;

public interface VORegistroServicio {
    public long getId();

    public void setId(long id);

    public long getIdHabitacion();

    public void setIdHabitacion(long idHabitacion);

    public String getLugarConsumo();

    public void setLugarConsumo(String lugarConsumo);

    public String getNombreCliente();

    public void setNombreCliente(String nombreCliente);

    public long getCostoTotal();

    public void setCostoTotal(long costoTotal);

    public long getServicio();

    public void setServicio(long servicio);

    public Timestamp getFecha();

    public void setFecha(Timestamp fecha);
    @Override
    public String toString();
}
