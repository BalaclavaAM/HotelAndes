package uniandes.isis2304.hotelandes.negocio;

import java.math.BigDecimal;

public class ResponseRegistroServicioStatistics {
    public int quantity;
    public String tiempo;
    public String filter;

    public ResponseRegistroServicioStatistics(BigDecimal quantity, String tiempo, String filter) {
        this.quantity = quantity.intValue();
        this.tiempo = tiempo;
        this.filter = filter;
    }	

    @Override
    public String toString() {
        return "ResponseRegistroServicioStatistics{" +
                "quantity=" + quantity +
                ", tiempo='" + tiempo + '\'' +
                ", filter='" + filter + '\'' +
                '}';
    }
}
