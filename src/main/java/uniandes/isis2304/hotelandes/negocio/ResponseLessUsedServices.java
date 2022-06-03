package uniandes.isis2304.hotelandes.negocio;

import java.math.BigDecimal;

public class ResponseLessUsedServices {
    public BigDecimal idServicio;
    public String nombreServicio;
    public String tipoServicio;
    
    public ResponseLessUsedServices(BigDecimal idServicio, String nombreServicio, String tipoServicio) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.tipoServicio = tipoServicio;
    }

    @Override
    public String toString() {
        return "ResponseLessUsedServices{" +
                "idServicio=" + idServicio +
                ", nombreServicio='" + nombreServicio + '\'' +
                ", tipoServicio='" + tipoServicio + '\'' +
                '}';
    }
}
