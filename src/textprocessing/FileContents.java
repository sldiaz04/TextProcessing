package textprocessing;
import java.util.LinkedList;
import java.util.Queue;
public class FileContents {
    private final Queue<String> queue = new LinkedList<>();
    private int registerCount = 0;
    private boolean closed = false;
    
    private final int maxFiles;
    private final int maxChars;
    
    public FileContents(int maxFiles, int maxChars) {
        this.maxFiles = maxFiles;
        this.maxChars = maxChars;
    }
    public synchronized void registerWriter() {
        registerCount++;
    }
    public synchronized void unregisterWriter() {
        
        if(registerCount == 1){
            registerCount--;
            closed = true;// cerramos los FileContents
            notifyAll();
        }else{
            registerCount--;
        }
    }
    public synchronized void addContents(String contents) {
        
        String ristra = "";
        
        for (String queue1 : queue) {
            ristra += queue1;
        }
        String caraTotales = ristra + contents;
        
        while(queue.size() == maxFiles || (queue.isEmpty() == false && caraTotales.length() > maxChars)){// si ha llegado al maximo elementos permitidos
            try {
                wait();
            } catch (InterruptedException ex) {}
        }
        queue.add(contents);    
        notifyAll();
    }
    public synchronized String getContents() {
        while(queue.isEmpty() && !closed){
            try {
                wait();
            } catch (InterruptedException ex) {}
        }
        if(queue.isEmpty()){
            return null;
        }
        notifyAll();
        return queue.remove();
    }
}
