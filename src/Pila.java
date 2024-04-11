import java.util.Stack;

public class Pila {
    private Stack<Integer> numeros;

    public Pila(){
        numeros = new Stack<Integer>();
    }

    public boolean estaVacia(){
        return numeros.empty();
    }
    public void apilar(Integer elemento){
        numeros.push(elemento);
    }

    public Integer desapilar() throws Exception{
        if(estaVacia())
            throw new Exception("No hay elements en la pila");
        return numeros.pop();
    }

    public Integer cima() throws Exception{
        if(estaVacia())
            throw new Exception("La pila está vacia");
        return numeros.peek();

    }

    public int buscarElemento(int i) throws Exception{
        if(estaVacia())
            throw new Exception("No hay elements en la pila");
        return numeros.search(i);
    }


    @Override
    public String toString(){
        String mensaje="";
        for(int i=numeros.size()-1; i>=0; i--){
            mensaje += numeros.get(i)+"\n";
        }
        return mensaje;
    }

    public String convertirBinario
    (int numero){
        Stack<Integer> pila = new Stack<Integer>();
        String binario = "";
        while(numero>0){
            pila.push(numero%2);
            numero = numero/2;
        }
        while(!pila.empty()){
            binario += pila.pop();
        }
        return binario;
    }
}

