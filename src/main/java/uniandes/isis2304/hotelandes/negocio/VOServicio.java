package uniandes.isis2304.hotelandes.negocio;

public interface VOServicio {
    public long getId();

    public void setId(long id);

    public String getNombre();

    public void setNombre(String nombre);

    public long getTipoServicio();

    public void setTipoServicio(long tipoServicio);

    public long getDescuentoTC();

    public void setDescuentoTC(long descuentoTC);
    @Override
    public String toString();
}
