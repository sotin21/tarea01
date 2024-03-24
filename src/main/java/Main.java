import java.util.Scanner;

public class Main {
    private static Tienda tienda = new Tienda();
    private static Scanner scanner;

    public Main() {
    }

    private static void mostrarMenu() {
        System.out.println("----- Menú -----");
        System.out.println("1. Mostrar todos los productos");
        System.out.println("2. Buscar producto");
        System.out.println("3. Agregar nuevo producto");
        System.out.println("4. Modificar producto");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Realizar compra");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void main(String[] args) {
        agregarProductos();

        int opcion;
        do {
            mostrarMenu();
            opcion = obtenerOpcion();
            ejecutarOpcion(opcion);
        } while(opcion != 7);

        scanner.close();
    }

    private static void agregarProductos() {
        tienda.agregarProducto(new Producto("GTX 1650S", "da imagen", "GPU", 200.0, 8));
        tienda.agregarProducto(new Producto("i3 10100", "el cerebro de tu PC", "CPU", 150.0, 10));
        tienda.agregarProducto(new Producto("MouseLG", "para jugar mejor LOL", "ratones", 30.0, 6));
    }

    private static int obtenerOpcion() {
        return scanner.nextInt();
    }

    private static void ejecutarOpcion(int opcion) {
        scanner.nextLine();
        switch (opcion) {
            case 1:
                tienda.mostrarProductos();
                break;
            case 2:
                buscarProducto();
                break;
            case 3:
                agregarProducto();
                break;
            case 4:
                modificarProducto();
                break;
            case 5:
                eliminarProducto();
                break;
            case 6:
                realizarCompra();
                break;
            case 7:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida.Seleccione otra opción.");
        }

    }

    private static void buscarProducto() {
        System.out.print("Ingrese el nombre o categoría del producto a buscar: ");
        String textoBusqueda = scanner.nextLine();
        tienda.buscarProducto(textoBusqueda);
    }

    private static void agregarProducto() {
        tienda.agregarProducto(crearProducto());
    }

    private static Producto crearProducto() {
        System.out.print("Ingrese el nombre del nuevo producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la descripción del nuevo producto: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese el precio del nuevo producto: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese el stock inicial del nuevo producto: ");
        int stock = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese la categoría del nuevo producto: ");
        String categoria = scanner.nextLine();
        return new Producto(nombre, descripcion, categoria, precio, stock);
    }

    private static void modificarProducto() {
        System.out.print("Ingrese el nombre del producto a modificar: ");
        String nombreModificar = scanner.nextLine();
        tienda.modificarProducto(nombreModificar, crearProducto());
    }

    private static void eliminarProducto() {
        System.out.print("Ingrese el nombre del producto a eliminar: ");
        String nombreEliminar = scanner.nextLine();
        tienda.eliminarProducto(nombreEliminar);
    }

    private static void realizarCompra() {
        System.out.print("Ingrese el nombre del producto a comprar: ");
        String nombreCompra = scanner.nextLine();
        System.out.print("Ingrese la cantidad a comprar: ");
        int cantidadCompra = scanner.nextInt();
        tienda.realizarCompra(nombreCompra, cantidadCompra);
    }

    static {
        scanner = new Scanner(System.in);
    }
}