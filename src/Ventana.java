import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel ventana;
    private JTextField textNumero;
    private JButton apilarButton;
    private JButton desapilarButton;
    private JButton cimaButton;
    private JButton buscarButton;
    private JTextArea textArea1;
    private Pila pila = new Pila();

    public Ventana(){

        apilarButton.addActionListener(new ActionListener() { // Sirve para agregar un evento al boton apilar
            @Override
            public void actionPerformed(ActionEvent e) { // Metodo que se ejecuta al dar click en el boton
                pila.apilar(Integer.parseInt(textNumero.getText())); // Se agrega el numero ingresado a la pila
                textArea1.setText(pila.toString()); // Se muestra la pila en el textArea
                textNumero.setText(""); // Se limpia el campo de texto
            }
        });
        desapilarButton.addActionListener(new ActionListener() { // Sirve para agregar un evento al boton desapilar
            @Override
            public void actionPerformed(ActionEvent e) { // Metodo que se ejecuta al dar click en el boton
                try{
                    JOptionPane.showMessageDialog(null,"El dato sacado es "+pila.desapilar()); // Se muestra el dato que se saco
                    textArea1.setText(pila.toString()); // Se muestra la pila en el textArea
                }catch(Exception ex){ // Si la pila esta vacia se muestra un mensaje
                    JOptionPane.showMessageDialog(null, ex.getMessage()); // Se muestra el mensaje
                }
            }
        });
        cimaButton.addActionListener(new ActionListener() { // Sirve para agregar un evento al boton cima
            @Override
            public void actionPerformed(ActionEvent e) { // Metodo que se ejecuta al dar click en el boton
                try{
                    JOptionPane.showMessageDialog(null,"El dato de la cima es "+pila.cima()); // Se muestra el dato de la cima
                }catch(Exception ex){ // Si la pila esta vacia se muestra un mensaje
                    JOptionPane.showMessageDialog(null, ex.getMessage()); // Se muestra el mensaje
                }
            }
        });
        buscarButton.addActionListener(new ActionListener() { // Sirve para agregar un evento al boton buscar
            @Override
            public void actionPerformed(ActionEvent e) { // Metodo que se ejecuta al dar click en el boton
                try{
                    int indice = pila.buscarElemento(Integer.parseInt(textNumero.getText())); // Se busca el elemento en la pila
                    if(indice == -1){ // Si el elemento no se encuentra se muestra un mensaje
                        JOptionPane.showMessageDialog(null, "Elemento no encontrado"); // Se muestra el mensaje
                    }else
                        JOptionPane.showMessageDialog(null, "El elemento "+textNumero.getText()+ " se encuentra en la posicion "+indice); // Se muestra la posicion del elemento
                }catch(Exception exc){ // Si el elemento no es un numero se muestra un mensaje
                    JOptionPane.showMessageDialog(null, exc.getMessage()); // Se muestra el mensaje
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}