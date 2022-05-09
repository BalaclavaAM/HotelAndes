package uniandes.isis2304.hotelandes.negocio;

import java.math.BigDecimal;

public class Hotel {

    public long id;
    public String nombre;
    public int estrellas;
    public int cadenaHotelera;

    public Hotel(long id, String nombre, int estrellas, int cadenaHotelera) {
        this.id = id;
        this.nombre = nombre;
        this.estrellas = estrellas;
        this.cadenaHotelera = cadenaHotelera;
    }

    public Hotel(BigDecimal id, String nombre, BigDecimal estrellas, BigDecimal cadenaHotelera) {
        this.id = id.longValue();
        this.nombre = nombre;
        this.estrellas = estrellas.intValue();
        this.cadenaHotelera = cadenaHotelera.intValue();
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

    @Override
    public String toString() {
        return "Hotel [id=" + id + ", nombre=" + nombre + ", estrellas=" + estrellas + ", cadenaHotelera=" + cadenaHotelera + "]";
    }
}
