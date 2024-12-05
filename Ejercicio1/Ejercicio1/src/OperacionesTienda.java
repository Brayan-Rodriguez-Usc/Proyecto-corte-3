//Brayan Rodriguez Fernandez,Angel Gabriel Villamizar Caicedo,Juan Sebastian Mosquera Murillo
public interface OperacionesTienda {
    void agregarProducto(String nombre, double precio, int cantidad);
    void venderProducto(String nombre, int cantidad);
    void mostrarInventario();
}
