package uniandes.isis2304.hotelandes.negocio;

import oracle.sql.TIMESTAMP;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

public class RegistroServicio implements VORegistroServicio{
    public long id;
    public long idHabitacion;
    public String lugarConsumo;
    public String nombreCliente;
    public long costoTotal;
    public long servicio;
    public Timestamp fecha;

    public RegistroServicio(long id, long idHabitacion, String lugarConsumo, String nombreCliente, long costoTotal, long servicio, Timestamp fecha) {
        this.id = id;
        this.idHabitacion = idHabitacion;
        this.lugarConsumo = lugarConsumo;
        this.nombreCliente = nombreCliente;
        this.costoTotal = costoTotal;
        this.servicio = servicio;
        this.fecha = fecha;
    }

    public RegistroServicio(BigDecimal id, BigDecimal idHabitacion, String lugarConsumo, String nombreCliente, BigDecimal costoTotal, BigDecimal servicio, TIMESTAMP fecha) throws SQLException {
        Date dateEntrada=fecha.dateValue();
        Timestamp date = new Timestamp(dateEntrada.getTime());
        this.id = id.longValue();
        this.idHabitacion = idHabitacion.longValue();
        this.lugarConsumo = lugarConsumo;
        this.nombreCliente = nombreCliente;
        this.costoTotal = costoTotal.longValue();
        this.servicio = servicio.longValue();
        this.fecha = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(long idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getLugarConsumo() {
        return lugarConsumo;
    }

    public void setLugarConsumo(String lugarConsumo) {
        this.lugarConsumo = lugarConsumo;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public long getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(long costoTotal) {
        this.costoTotal = costoTotal;
    }


    public long getServicio() {
        return servicio;
    }

    public void setServicio(long servicio) {
        this.servicio = servicio;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
    @Override
    public String toString()
    {
        return "Servicio [habitacion=" + idHabitacion + ", costototal=" + costoTotal + "]";
    }
}
