public class Producto {
    private String nombre;
    private String descripcion;
    private String categoria;
    private double precio;
    private int stock;

    public Producto(String nombre, String descripcion, String categoria, double precio, int stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getStock() {
        return this.stock;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setStock(int i) {
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Descripción: " + this.descripcion);
        System.out.println("Precio: $" + this.precio);
        System.out.println("Stock: " + this.stock);
        System.out.println("Categoría: " + this.categoria);
        System.out.println();
    }
}