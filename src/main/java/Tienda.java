import java.util.ArrayList;
import java.util.Iterator;

public class Tienda {
    private ArrayList<Producto> productos = new ArrayList();

    public Tienda() {
    }

    public void mostrarProductos() {
        System.out.println("Lista de productos disponibles:");
        Iterator var1 = this.productos.iterator();

        while(var1.hasNext()) {
            Producto producto = (Producto)var1.next();
            producto.mostrarInformacion();
        }

    }

    public void buscarProducto(String texto) {
        System.out.println("Resultados de la búsqueda:");
        Iterator var2 = this.productos.iterator();

        while(true) {
            Producto producto;
            do {
                if (!var2.hasNext()) {
                    return;
                }

                producto = (Producto)var2.next();
            } while(!producto.getNombre().toLowerCase().contains(texto.toLowerCase()) && (producto.getCategoria() == null || !producto.getCategoria().toLowerCase().contains(texto.toLowerCase())));

            producto.mostrarInformacion();
        }
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
        System.out.println("Producto agregado exitosamente.");
    }

    public void modificarProducto(String nombre, Producto nuevoProducto) {
        for(int i = 0; i < this.productos.size(); ++i) {
            if (((Producto)this.productos.get(i)).getNombre().equalsIgnoreCase(nombre)) {
                this.productos.set(i, nuevoProducto);
                System.out.println("Producto modificado exitosamente.");
                return;
            }
        }

        System.out.println("No se encontró ningún producto.");
    }

    public void eliminarProducto(String nombre) {
        for(int i = 0; i < this.productos.size(); ++i) {
            if (((Producto)this.productos.get(i)).getNombre().equalsIgnoreCase(nombre)) {
                this.productos.remove(i);
                System.out.println("Producto eliminado exitosamente.");
                return;
            }
        }

        System.out.println("No se encontró ningún producto.");
    }

    public void realizarCompra(String nombre, int cantidad) {
        Iterator var3 = this.productos.iterator();

        Producto producto;
        do {
            if (!var3.hasNext()) {
                System.out.println("No se encontró ningún producto.");
                return;
            }

            producto = (Producto)var3.next();
        } while(!producto.getNombre().equalsIgnoreCase(nombre));

        if (producto.getStock() >= cantidad) {
            producto.setStock(producto.getStock() - cantidad);
            System.out.println("Compra realizada :) .");
        } else {
            System.out.println("No hay stock.");
        }
    }
}