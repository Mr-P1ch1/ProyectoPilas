import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BinarioVentana {
    private JPanel binario;
    private JButton convertirButton;
    private JTextArea textArea1;
    private JTextField numeroingresado;
    private Pila pila=new Pila();

    public BinarioVentana() {
        convertirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"El numero decimal dado, en binario es "+ (pila.convertirBinario(Integer.parseInt(numeroingresado.getText())))+ textArea1.getText());
                textArea1.setText(pila.convertirBinario(Integer.parseInt(numeroingresado.getText())));
                numeroingresado.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BinarioVentana");
        frame.setContentPane(new BinarioVentana().binario);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

