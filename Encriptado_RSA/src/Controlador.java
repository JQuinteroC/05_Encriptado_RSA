
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

/**
 *
 * * @author <a href="https://github.com/JQuinteroC">JQuinteroC</a>
 */
public class Controlador implements ActionListener, KeyListener {

    Vista d;
    RSA t;

    public Controlador(Vista d, RSA t) {
        this.d = d;
        this.t = t;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(d.btnEncriptar)) {

            if (d.txtP.getText().isEmpty() || Integer.parseInt(d.txtP.getText()) < 23 || Integer.parseInt(d.txtP.getText()) > 500) {
                JOptionPane.showMessageDialog(null, "Ingrese un numero primo en P, mayor que 23 y menor a 500");
                d.txtP.requestFocus();
            } else if (d.txtQ.getText().isEmpty() || Integer.parseInt(d.txtQ.getText()) < 23 || Integer.parseInt(d.txtQ.getText()) > 500) {
                JOptionPane.showMessageDialog(null, "Ingrese un numero primo en Q, mayor que 23 y menor a 500");
                d.txtQ.requestFocus();
            } else if (d.txtN.getText().isEmpty() || Integer.parseInt(d.txtN.getText()) < 23 || Integer.parseInt(d.txtN.getText()) > 500) {
                JOptionPane.showMessageDialog(null, "Ingrese un numero primo en N, mayor que 23 y menor a 500");
                d.txtN.requestFocus();
            } else if (d.txtP.getText().equals(d.txtQ.getText())) {
                JOptionPane.showMessageDialog(null, "P y Q deben ser números primos diferentes");
                d.txtP.requestFocus();
            } else if (!t.isPimo(Integer.parseInt(d.txtP.getText())) || !t.isPimo(Integer.parseInt(d.txtQ.getText())) || !t.isPimo(Integer.parseInt(d.txtN.getText()))) {
                JOptionPane.showMessageDialog(null, "P, Q y N deben ser números primos");
                reDiseño();
            } else {
                // Definir valores
                t.p = Integer.parseInt(d.txtP.getText());
                t.q = Integer.parseInt(d.txtQ.getText());
                t.n = Integer.parseInt(d.txtN.getText());

                // Encriptar
                t.FI(t.p, t.q);
                t.Z(t.p, t.q);
                t.S(t.n);

                // Cifrado
                String e1 = "";
                // Valor numerico del caracter
                String e2 = "";

                // Cifrar
                String texto = d.txtPalabra.getText();
                String textoE = "<html><body><i>Encriptar con el método RSA</i><br>(Rivest, Shamir y Adleman)<br> s = " + t.s
                        + " (clave privada)   z = " + t.z + "<br> ";
                for (int i = 0; i < texto.length(); i++) {
                    e1 += (char) t.encriptar(texto.codePointAt(i));
                    e2 += (char) texto.codePointAt(i) + " = " + t.encriptar(texto.codePointAt(i)) + "<br> ";

                }

                textoE += e2;
                textoE += "<b>Texto cifrado:</b> " + e1 + "<br>";

                // Desencriptado
                String encriptado = e1;
                e1 = "";
                e2 = "";
                for (int i = 0; i < encriptado.length(); i++) {
                    e1 += (char) t.desencriptar(encriptado.codePointAt(i));
                    e2 += (char) encriptado.codePointAt(i) + " = " + t.desencriptar(encriptado.codePointAt(i)) + "<br> ";

                }

                textoE += "<br><i> Desencriptado</i><br>z = " + t.z + "<br>";
                textoE += e2;
                textoE += "<b>Texto original:</b> " + e1 + "<br>";
                textoE += "</body></html>";

                // Poner tiempo
                d.setSize(new Dimension(d.getWidth(), 370));
                d.jsRes.setSize(d.jsRes.getWidth(), 110);
                d.txtResultado.setText(textoE);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e
    ) {
        if (!e.getSource().equals(d.txtPalabra)) {
            if (!Character.isDigit(e.getKeyChar())) {
                e.consume();
            }
        } else {
            if (Character.isDigit(e.getKeyChar()) || Character.isUpperCase(e.getKeyChar())) {
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e
    ) {
    }

    @Override
    public void keyReleased(KeyEvent e
    ) {
    }

    public void reDiseño() {
        d.setSize(new Dimension(d.getWidth(), 290));
        d.jsRes.setSize(d.jsRes.getWidth(), 30);
        d.txtResultado.setText(null);
    }
}
