package clases;

import javax.swing.ImageIcon;

public class Capitulo {
    private String titulo;
    private String descripcion;
    private ImageIcon imagen;

    public Capitulo(String titulo, String descripcion, String rutaImagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = new ImageIcon(rutaImagen);
    }

    // getters, setters...

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public ImageIcon getImagen() {
        return imagen;
    }
}