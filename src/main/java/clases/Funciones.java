package clases;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;

import javax.swing.*;
import java.awt.*;
import java.awt.Desktop;
import java.net.URI;

public class Funciones {
    public static void abrirSegundaPantalla() {
        JFrame segundaVentana = new JFrame("Lista de Capítulos");
        segundaVentana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        segundaVentana.setSize(600, 400);
        segundaVentana.setLocationRelativeTo(null);

        Capitulo[] capitulos = {
        	    new Capitulo("Capítulo 1", "Luffy comienza su aventura tras el sombrero de paja.", "img/1.jpg"),
        	    new Capitulo("Capítulo 2", "Luffy y Zoro, el cazador de piratas, forman equipo.", "img/2.jpg"),
        	    new Capitulo("Capítulo 3", "Luffy y Zoro rescatan a Nami de los piratas de Buggy.", "img/3.jpg"),
        	    new Capitulo("Capítulo 4", "Luffy y su equipo enfrentan al temible capitán Kuro.", "img/4.jpg"),
        	    new Capitulo("Capítulo 5", "El equipo de Luffy se dirige a Baratie, el restaurante marino.", "img/5.jpg"),
        	    new Capitulo("Capítulo 6", "Sanji se une al equipo de Luffy en Baratie.", "img/6.jpg"),
        	    new Capitulo("Capítulo 7", "Nami revela su oscuro pasado y su relación con Arlong.", "img/7.jpg"),
        	    new Capitulo("Capítulo 8", "Luffy y su equipo derrotan a Arlong y liberan a Nami.", "img/8.jpg"),
        	    new Capitulo("Capítulo 9", "Luffy y su equipo llegan a Loguetown, la ciudad del inicio y fin.", "img/9.jpg"),
        	    new Capitulo("Capítulo 10", "Smoker aparece y persigue a Luffy y su equipo en Loguetown.", "img/10.jpg")
        	};

        final JList<Capitulo> listaCapitulos = new JList<>(capitulos);
        listaCapitulos.setCellRenderer(new ListCellRenderer<Capitulo>() {
            @Override
            public Component getListCellRendererComponent(JList<? extends Capitulo> list, Capitulo value, int index, boolean isSelected, boolean cellHasFocus) {
                JPanel panel = new JPanel(new BorderLayout());
                JLabel labelTitulo = new JLabel(value.getTitulo());
                JLabel labelImagen = new JLabel();
                Image imagenRedimensionada = value.getImagen().getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                labelImagen.setIcon(new ImageIcon(imagenRedimensionada));
                panel.add(labelTitulo, BorderLayout.CENTER);
                panel.add(labelImagen, BorderLayout.EAST);
                if (isSelected) {
                    panel.setBackground(list.getSelectionBackground());
                    panel.setForeground(list.getSelectionForeground());
                } else {
                    panel.setBackground(list.getBackground());
                    panel.setForeground(list.getForeground());
                }
                return panel;
            }
        });

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        JPanel panelLista = new JPanel(new BorderLayout());
        panelLista.add(new JScrollPane(listaCapitulos), BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        JButton verDetalleButton = new JButton("Ver en detalle");
        verDetalleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Capitulo capituloSeleccionado = listaCapitulos.getSelectedValue();
                if (capituloSeleccionado != null) {
                    mostrarVentanaEmergente(capituloSeleccionado.getTitulo(),
                            capituloSeleccionado.getDescripcion(), capituloSeleccionado.getImagen());
                }
            }
        });
        panelBotones.add(verDetalleButton);
        panelPrincipal.add(panelLista, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
        segundaVentana.add(panelPrincipal);
        segundaVentana.setVisible(true);
    }
    private static void mostrarVentanaEmergente(String titulo, String descripcion, ImageIcon imagen) {
        JDialog ventanaEmergente = new JDialog();
        ventanaEmergente.setTitle("Detalles del Capítulo");
        ventanaEmergente.setSize(400, 300);
        ventanaEmergente.setLocationRelativeTo(null);

        JLabel tituloLabel = new JLabel(titulo);
        JLabel descripcionLabel = new JLabel(descripcion);
        JLabel imagenLabel = new JLabel();

        // Convertir la imagen a escala de grises
        BufferedImage bufferedImage = new BufferedImage(
            imagen.getIconWidth(),
            imagen.getIconHeight(),
            BufferedImage.TYPE_INT_ARGB);
        Graphics g = bufferedImage.createGraphics();
        imagen.paintIcon(null, g, 0,0);
        g.dispose();

        BufferedImage imagenEscalaGrises = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        ColorConvertOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
        op.filter(bufferedImage, imagenEscalaGrises);

        ImageIcon imagenGris = new ImageIcon(imagenEscalaGrises.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        imagenLabel.setIcon(imagenGris);

        // Crear el botón para abrir la URL
        JButton botonURL = new JButton("Ver serie completa");
        botonURL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www3.animeflv.net/anime/one-piece-tv"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(tituloLabel, BorderLayout.NORTH);
        panelPrincipal.add(descripcionLabel, BorderLayout.CENTER);
        panelPrincipal.add(imagenLabel, BorderLayout.WEST);
        panelPrincipal.add(botonURL, BorderLayout.SOUTH);  // Agregar el botón al panel

        ventanaEmergente.add(panelPrincipal);
        ventanaEmergente.setVisible(true);
    }
}