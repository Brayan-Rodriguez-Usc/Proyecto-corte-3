//Brayan Rodriguez Fernandez,Angel Gabriel Villamizar Caicedo,Juan Sebastian Mosquera Murillo
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TiendaGUI extends JFrame implements OperacionesTienda {
    private ArrayList<Producto> inventario = new ArrayList<>();
    private JTextArea areaInventario;

    public TiendaGUI() {
        setTitle("Tienda");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        areaInventario = new JTextArea(10, 30);
        areaInventario.setEditable(false);
        add(new JScrollPane(areaInventario));

        JButton agregarButton = new JButton("Agregar Producto");
        agregarButton.addActionListener(e -> agregarProductoGUI());
        add(agregarButton);

        JButton venderButton = new JButton("Vender Producto");
        venderButton.addActionListener(e -> venderProductoGUI());
        add(venderButton);
    }

    private void agregarProductoGUI() {
        String nombre = JOptionPane.showInputDialog(this, "Nombre del producto:");
        double precio = Double.parseDouble(JOptionPane.showInputDialog(this, "Precio del producto:"));
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(this, "Cantidad del producto:"));

        agregarProducto(nombre, precio, cantidad);
    }

    private void venderProductoGUI() {
        String nombre = JOptionPane.showInputDialog(this, "Nombre del producto a vender:");
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(this, "Cantidad a vender:"));
        venderProducto(nombre, cantidad);
    }

    @Override
    public void agregarProducto(String nombre, double precio, int cantidad) {
        Producto nuevoProducto = new ProductoEspecifico(nombre, precio, cantidad);
        inventario.add(nuevoProducto);
        mostrarInventario();
    }

    @Override
    public void venderProducto(String nombre, int cantidad) {
        for (Producto p : inventario) {
            if (p.getNombre().equals(nombre) && p.getCantidad() >= cantidad) {
                p.setCantidad(p.getCantidad() - cantidad);
                mostrarInventario();
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Producto no encontrado o cantidad insuficiente.");
    }

    @Override
    public void mostrarInventario() {
        areaInventario.setText("");
        for (Producto p : inventario) {
            areaInventario.append(p.getNombre() + " - " + p.getCantidad() + " unidades - $" + p.getPrecio() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TiendaGUI().setVisible(true));
    }
}
