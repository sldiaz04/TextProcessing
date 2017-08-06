package textprocessing;
import java.util.LinkedList;
import java.util.Queue;
public class FileNames {
    private final Queue<String> queue = new LinkedList<>();// funciona como un LIFO
    private boolean noMoreNames = false;
    
    public synchronized void addName(String fileName) {
        queue.add(fileName);
        notify();// para despertar a los hilos
    }
    public synchronized String getName() {
        while(queue.isEmpty() && !noMoreNames){
            try {
                wait();
            } catch (InterruptedException ex) {}
        }
        if(queue.isEmpty()){
            return null;
        }
        notify();// notificamos a los hilos en espera*/
        return queue.remove();// extrae el objeto ,devuelve su valor o lanza una exepcion
    }
    public synchronized void noMoreNames() {
        noMoreNames = true;// para que no admita más elementos
        notifyAll();
    }
}