package clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField nombreTextField;
    private JRadioButton hombreRadioButton;
    private JRadioButton mujerRadioButton;
    private JRadioButton otroRadioButton;

    public VentanaPrincipal() {
        // Configuración de la ventana principal
        setTitle("One Piece");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(336, 443);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Creación de los componentes de la pantalla inicial
        JLabel tituloLabel = new JLabel("One peace");
        JLabel imagenLabel = new JLabel(new ImageIcon("One_piece.png"));
        nombreTextField = new JTextField(20);
        hombreRadioButton = new JRadioButton("Hombre");
        mujerRadioButton = new JRadioButton("Mujer");
        otroRadioButton = new JRadioButton("Otro");
        JButton entrarButton = new JButton("Entrar");

        // Agrupar los RadioButtons para que solo se pueda seleccionar uno
        ButtonGroup grupoRadioButtons = new ButtonGroup();
        grupoRadioButtons.add(hombreRadioButton);
        grupoRadioButtons.add(mujerRadioButton);
        grupoRadioButtons.add(otroRadioButton);

        // Panel para el formulario de nombre y género
        JPanel formularioPanel = new JPanel();
        formularioPanel.setLayout(new GridLayout(3, 2));
        formularioPanel.add(new JLabel("Nombre:"));
        formularioPanel.add(nombreTextField);
        formularioPanel.add(new JLabel("Género:"));
        formularioPanel.add(hombreRadioButton);
        formularioPanel.add(new JLabel(""));
        formularioPanel.add(mujerRadioButton);
        formularioPanel.add(new JLabel(""));
        formularioPanel.add(otroRadioButton);

        // Panel para la imagen y el botón de entrar
        JPanel imagenPanel = new JPanel();
        imagenPanel.setLayout(new BorderLayout());
        imagenPanel.add(imagenLabel, BorderLayout.WEST);
        imagenPanel.add(entrarButton, BorderLayout.SOUTH);

        // Panel principal de la ventana
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(tituloLabel, BorderLayout.NORTH);
        panelPrincipal.add(imagenPanel, BorderLayout.CENTER);
        panelPrincipal.add(formularioPanel, BorderLayout.SOUTH);

        // Acción del botón "Entrar"
        entrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Funciones.abrirSegundaPantalla();
            }
        });

        // Agregar el panel principal a la ventana
        add(panelPrincipal);

        // Mostrar la ventana principal
        setVisible(true);
    }
}