//Brayan Rodriguez Fernandez,Angel Gabriel Villamizar Caicedo,Juan Sebastian Mosquera Murillo
public class ProductoEspecifico extends Producto {

    public ProductoEspecifico(String nombre, double precio, int cantidad) {
        super(nombre, precio, cantidad);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Producto: " + nombre + ", Precio: $" + precio + ", Cantidad: " + cantidad);
    }
}
