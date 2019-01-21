import java.io.Serializable;

public class Productos implements Serializable {

    private String codVenta;
    private String producto;
    private String fechaVenta;
    private int unidadesVendidas;
    private Double precioUnitario;
    private Double precioVenta;

    public Productos(String codVenta, String producto, String fechaVenta, int unidadesVendidas, Double precioUnitario, Double precioVenta){
        this.codVenta=codVenta;
        this.producto=producto;
        this.fechaVenta=fechaVenta;
        this.unidadesVendidas=unidadesVendidas;
        this.precioUnitario=precioUnitario;
        this.precioVenta=precioVenta;
    }

    public String getCodVenta() {
        return codVenta;
    }

    public void setCodVenta(String codVenta) {
        this.codVenta = codVenta;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getUnidadesVendidas() {
        return unidadesVendidas;
    }

    public void setUnidadesVendidas(int unidadesVendidas) {
        this.unidadesVendidas = unidadesVendidas;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }





}
