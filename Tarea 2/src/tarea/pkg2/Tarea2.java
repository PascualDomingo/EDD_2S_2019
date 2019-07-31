
package tarea.pkg2;

public class Tarea2 {

    public static void main(String[] args) {
        Bolsa bl = new Bolsa();
        bl.insertar(5, 10);
        bl.insertar(6, 12);
        bl.insertar(7, 14);
        bl.insertar(8, 16);
        bl.insertar(9, 18);
        bl.insertar(10, 20);
        bl.insertar(11, 22);
        bl.imprimir();
        System.out.println("\n**************\n");
        if(bl.vacia()){
            System.out.println("La bolsa esta vacia");
        }else{
            System.out.println("La bolsa no esta vacia");
        }
        bl.contar(9, 18); /*contar elemento desde la pos x,y */
        
    }
    
}
