package uniandes.isis2304.hotelandes.negocio;

import java.math.BigDecimal;

public class Servicio implements VOServicio{
    public long id;
    public String nombre;
    public long tipoServicio;
    public long descuentoTC;

    public Servicio(long id, String nombre, long tipoServicio, long descuentoTC) {
        this.id = id;
        this.nombre = nombre;
        this.tipoServicio = tipoServicio;
        this.descuentoTC = descuentoTC;
    }

    public Servicio(BigDecimal id, String nombre, BigDecimal tipoServicio, BigDecimal descuentoTC) {
        this.id = id.longValue();
        this.nombre = nombre;
        this.tipoServicio = tipoServicio.longValue();
        this.descuentoTC = descuentoTC.longValue();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(long tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public long getDescuentoTC() {
        return descuentoTC;
    }

    public void setDescuentoTC(long descuentoTC) {
        this.descuentoTC = descuentoTC;
    }
    @Override
    public String toString()
    {
        return "SERVICIO [nombre=" + nombre + ", tipoServicio=" + tipoServicio + "]";
    }
}


