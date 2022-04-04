package uniandes.isis2304.hotelandes.negocio;

public class DineroPorHabitacion {
    long numHabitacion;
    long dinero;

    public DineroPorHabitacion( long numHabitacion, long dinero) {
        this.numHabitacion = numHabitacion;
        this.dinero = dinero;
    }



    public long getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(long numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public long getDinero() {
        return dinero;
    }

    public void setDinero(long dinero) {
        this.dinero = dinero;
    }
    @Override
    public String toString()
    {
        return "DineroHab [Servicio=" + numHabitacion + ", numHabitacion=" + numHabitacion + ", dinero "+ dinero +"]";
    }
}
