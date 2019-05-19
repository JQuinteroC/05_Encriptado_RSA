
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author <a href="https://github.com/JQuinteroC">JQuinteroC</a>
 */
public class Vista extends JFrame {

    JLabel lblTitulo = new JLabel("Cifrado RSA");
    JLabel lblP = new JLabel("Ingrese P");
    JLabel lblQ = new JLabel("Ingrese Q");
    JLabel lblN = new JLabel("Ingrese N");
    JLabel lblPalabra = new JLabel("Palabra a encriptar");

    JTextField txtP = new JTextField();
    JTextField txtQ = new JTextField();
    JTextField txtN = new JTextField();
    JTextField txtPalabra = new JTextField();

    JButton btnEncriptar = new JButton("Encriptar");

    JLabel txtResultado = new JLabel();

    JScrollPane jsRes = new JScrollPane();

    Font fuente = new Font("verdana", Font.PLAIN, 13);

    void mostrar() {
        lblTitulo.setFont(new java.awt.Font("Verdana", 1, 25));
        lblTitulo.setBounds(110, 5, 220, 45);

        lblP.setFont(fuente);
        lblP.setBounds(8, 50, 70, 25);

        lblQ.setFont(fuente);
        lblQ.setBounds(8, 80, 70, 25);

        lblN.setFont(fuente);
        lblN.setBounds(8, 110, 70, 25);

        lblPalabra.setFont(fuente);
        lblPalabra.setBounds(8, 140, 130, 25);

        txtP.setFont(fuente);
        txtP.setBounds(170, 50, 200, 25);

        txtQ.setFont(fuente);
        txtQ.setBounds(170, 80, 200, 25);

        txtN.setFont(fuente);
        txtN.setBounds(170, 110, 200, 25);

        txtPalabra.setFont(fuente);
        txtPalabra.setBounds(170, 140, 200, 25);

        btnEncriptar.setFont(new java.awt.Font("Verdana", 1, 14));
        btnEncriptar.setBounds(8, 170, 361, 30);

        txtResultado.setFont(fuente);
        txtResultado.setBorder(null);
        txtResultado.setOpaque(true);
        txtResultado.setBackground(Color.white);

        jsRes.setViewportView(txtResultado);
        jsRes.setBounds(8, 210, 361, 30);

        setSize(393, 290);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Cifrado RSA");
    }

    public Vista() throws HeadlessException {
        java.awt.Container c;
        c = getContentPane();

        c.setLayout(null);
        c.add(lblTitulo);
        c.add(lblP);
        c.add(lblQ);
        c.add(lblN);
        c.add(lblPalabra);
        c.add(txtP);
        c.add(txtQ);
        c.add(txtN);
        c.add(txtPalabra);
        c.add(btnEncriptar);
        c.add(jsRes);
    }

    void asignaOyentes(Controlador c) {
        btnEncriptar.addActionListener(c);
        txtN.addKeyListener(c);
        txtP.addKeyListener(c);
        txtQ.addKeyListener(c);
        txtPalabra.addKeyListener(c);
    }

    void setText(String txt) {

    }
}
