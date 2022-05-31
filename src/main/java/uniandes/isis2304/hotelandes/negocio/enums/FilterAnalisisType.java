package uniandes.isis2304.hotelandes.negocio.enums;

public enum FilterAnalisisType {
    TIPOHABITACION("Tipo de Habitacion"),
    SERVICIO("Servicio");
    
    private final String text;
    
    FilterAnalisisType(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
