package uniandes.isis2304.hotelandes.negocio;

import oracle.sql.TIMESTAMP;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Habitacion implements VOHabitacion{
    public long id;
    public long tipo;
    public long hotel;
    public long numeroHabitacion;
    public long valorAPagar;
    public long enuso;

    public Habitacion(){
        this.id=0;
        this.tipo=0;
        this.hotel=0;
        this.numeroHabitacion=0;
        this.valorAPagar=0;
    }
    public Habitacion(long id, long tipo, long hotel, long numberoHabitacion, long valorAPagar, long enuso){
        this.id=id;
        this.tipo=tipo;
        this.hotel=hotel;
        this.enuso=enuso;
        this.numeroHabitacion=numberoHabitacion;
        this.valorAPagar=valorAPagar;
    }
    public Habitacion(BigDecimal id, BigDecimal tipo,BigDecimal hotel,BigDecimal numberoHabitacion,BigDecimal valorAPagar, BigDecimal enuso) throws SQLException {
        this.id=id.longValue();
        this.tipo=tipo.longValue();
        this.hotel=hotel.longValue();
        this.enuso=enuso.longValue();
        this.numeroHabitacion=numberoHabitacion.longValue();
        this.valorAPagar=valorAPagar.longValue();
    }

    public long getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(long numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public long getEnuso() {
        return enuso;
    }

    public void setEnuso(long ensuo) {
        this.enuso = ensuo;
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public long getTipo() {
        return tipo;
    }


    public void setTipo(long tipo) {
        this.tipo = tipo;
    }


    public long getHotel() {
        return hotel;
    }



    public void setHotel(long hotel) {
        this.hotel = hotel;
    }



    public long getNumberoHabitacion() {
        return numeroHabitacion;
    }



    public void setNumberoHabitacion(long numberoHabitacion) {
        this.numeroHabitacion = numberoHabitacion;
    }



    public long getValorAPagar() {
        return valorAPagar;
    }



    public void setValorAPagar(long valorAPagar) {
        this.valorAPagar = valorAPagar;
    }



    @Override
    public String toString()
    {
        return "TipoHabitacion [tipo=" + tipo + ", NumeroHabitacion=" + numeroHabitacion + "]";
    }
}
