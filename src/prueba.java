
import java.util.LinkedList;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sergio
 */
public class prueba {
    public static void main(String [] args){
        Queue<String> queue = new LinkedList<>();
        queue.add("Esto");queue.add("Esto");queue.add("Esto");queue.add("Esto");
        
        System.out.println("El tamaño de la cola es: " + queue.size());
        String ristra = "";
        for (String queue1 : queue) {
            ristra += queue1;
        }
        String prueba = "Sergio Sergio";
        String r = ristra+prueba;
        System.out.println("El contenido de la cola es: \n" + ristra + 
                " y el tamaño es: " + r.length());
    }
}
