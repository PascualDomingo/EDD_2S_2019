package tarea.pkg2;

public class Bolsa {

    class celda {

        int x;
        int y;
        celda siguiente;
    }

    celda inicio = null;
    celda ultimo = null;

    void insertar(int x, int y) {
        celda nuevo = new celda();
        nuevo.x = x;
        nuevo.y = y;
        if (inicio == null) {
            nuevo.siguiente = inicio;
            inicio = nuevo;
            ultimo = nuevo;
            ultimo.siguiente = inicio;
        } else {
            nuevo.siguiente = inicio;
            inicio = nuevo;
            ultimo.siguiente = inicio;
        }

    }

    void contar(int x, int y){
        celda aux = inicio;
        do{
            if(aux.x == x && aux.y == y){
                contador(aux);
                break;
            }
            aux = aux.siguiente;
        }while(aux != inicio);
    }
    
    void contador(celda nodo){
        celda aux = nodo;
        int con = 0;
        do{
            con++;
            aux = aux.siguiente;
        }while(aux != nodo);
        
        System.out.println("");
        System.out.println("existen: "+con+" elemntos en la bolsa \n");
    }
    boolean vacia() {
        boolean retornar = false;
        if (inicio == null) {
            retornar = true;
        }
        return retornar;
    }
    

    void imprimir() {
        celda aux = inicio;
        do{
            System.out.println("pos X: " + aux.x + "  pos Y: " + aux.y);
            aux = aux.siguiente;
        }while (aux != inicio);
    }
}
