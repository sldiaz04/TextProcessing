package textprocessing;

import java.util.HashMap;
import java.util.Map;

public class FileProcessor extends Thread{
    private final FileContents fc;
    private final WordFrequencies wf;
    private final Map<String,Integer> claveValor = new HashMap<>();
    
    public FileProcessor(FileContents fc, WordFrequencies wf) {
        this.fc = fc;
        this.wf = wf;
    }
    
    @Override
    public void run(){
        while(true){
            String texto = fc.getContents();
            if(texto == null){
                break;
            }
            String [] procesoTexto = texto.split("[^a-zA-Z0-9áÁéÉíÍóÓúÚüÜ]+");
            
            // añado los elementos una Lista
            for(int i= 0; i < procesoTexto.length; i++){
                if(claveValor.containsKey(procesoTexto[i])){
                    claveValor.put(procesoTexto[i], claveValor.get(procesoTexto[i])+1);
                }else{
                    claveValor.put(procesoTexto[i], 1);
                }
            }
            wf.addFrequencies(claveValor);//añado el resultado al objeto frecuencia
            claveValor.clear();
        }
    }
}
