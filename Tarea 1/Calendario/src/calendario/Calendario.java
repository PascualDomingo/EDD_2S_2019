package calendario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Calendario {

    public static void main(String[] args) throws ParseException {
        dia_de_semana();
        criba_eratostenes();
    }

    private static void dia_de_semana() throws ParseException {
        System.out.println("+++++++++++++++++++++++++++++++++++");
        System.out.println("+    DIA DE LA FECHA INGRESADA    +");
        System.out.println("+++++++++++++++++++++++++++++++++++");

        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese el anio mayor o igual a 1700");
        int anio = sc.nextInt();
        if (anio < 1700) {
            System.out.println("el anio no debe ser menor que 1700");
            System.exit(0);
        }
        System.out.println("ingrese el mes ");
        int month = sc.nextInt();
        if (month > 12) {
            System.out.println("los meses no deben se mayor a 12");
            System.exit(0);
        }
        System.out.println("ingrese el dia");
        int dia = sc.nextInt();
        if (dia > 31) {
            System.out.println("los dias no deben ser mayores a 31");
            System.exit(0);
        }
        String fecha = "" + anio + "-" + month + "-" + dia;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar miCalendario = Calendar.getInstance();
        //Date hoy=new Date();
        Date mifehca = sdf.parse(fecha);
        miCalendario.setTime(mifehca);
        //miCalendario.set(anio, month, dia);
        int numeroDia = miCalendario.get(miCalendario.DAY_OF_WEEK);
        String[] dias = new String[]{"domingo", "lunes", "martes", "miercoles", "jueves", "viernes", "sabado"};

        System.out.println("dia: " + dias[numeroDia - 1] + " " + dia);
        System.out.println("");
        System.out.println("");
        
    }

    private static void criba_eratostenes() {
        System.out.println("+++++++++++++++++++++++++++++++++++");
        System.out.println("+    LISTA DE NUMEROS PRIMOS      +");
        System.out.println("+++++++++++++++++++++++++++++++++++");

        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese un numero");
        int numero = sc.nextInt();
        int raiz = (int) Math.round(Math.sqrt(numero)) + 1;
        System.out.println("");
        int[][] matrix = new int[raiz][raiz];
        int[][] numPrimos = new int[raiz][raiz];
        /*llena la matriz*/
        int contador = 0;
        for (int i = 0; i < raiz; i++) {
            for (int j = 0; j < raiz; j++) {
                contador++;
                matrix[i][j] = contador;
                numPrimos[i][j] = contador;
            }
        }

        /*el numero 1 se considera como no primo*/
        numPrimos[0][0] = 0;
        /*todas las casillas que se llenan con 0 son no primos*/

 /*sustituir los multiplos de 2+i en 0*/
        int mul2 = 2;
        int con = 1;
        while (mul2 < raiz) {
            for (int i = 0; i < raiz; i++) {
                for (int j = 0; j < raiz; j++) {
                    if (mul2 * con == matrix[i][j]) {
                        numPrimos[i][j] = 0;
                        if (mul2 * con == 2) {
                            numPrimos[i][j] = 2;
                        } else if (mul2 * con == 3) {
                            numPrimos[i][j] = 3;
                        }
                        con++;
                    }
                }
            }
            mul2++;
            con = 2;
        }

        /*imprime los valor de la matriz*/
        for (int i = 0; i < raiz; i++) {
            for (int j = 0; j < raiz; j++) {
                if (numPrimos[i][j] != 0 && numPrimos[i][j] <= numero) {
                    System.out.println(numPrimos[i][j]);
                }
            }
        }
        
        System.out.println("");
        System.out.println("");
    }

}
