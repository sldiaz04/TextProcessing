package textprocessing;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class WordFrequencies {
    private final Map<String,Integer> frecuencia = new HashMap<>();
    
    public synchronized void addFrequencies(Map<String,Integer> f){
        Iterator iterador = f.keySet().iterator();
        while(iterador.hasNext()){
            String clave = (String)iterador.next();
            
            if(frecuencia.containsKey(clave)){
                frecuencia.put(clave, f.get(clave)+frecuencia.get(clave));//añado el par clave valor acumulando la frecuencia si ya existe la clave
            }else{
                frecuencia.put(clave, f.get(clave));//añado el par clave valor 
            }
        }
    }
    public Map<String,Integer> getFrequencies(){
        return frecuencia;
    }
}
