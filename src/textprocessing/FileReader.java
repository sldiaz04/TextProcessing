package textprocessing;
public class FileReader extends Thread{
    private final FileNames fn;
    private final FileContents fc;

    public FileReader(FileNames fn, FileContents fc) {
        this.fn = fn;
        this.fc = fc;
    }
    
    @Override
    public void run(){
        fc.registerWriter();//registro el hilo
        String fileName;
        while(true){
            fileName = fn.getName();
            if(fileName == null){
                break;
            }else{
                 fc.addContents(Tools.getContents(fileName));// añadimos el contenido del fichero
            }
            //System.out.println(Thread.currentThread().getName());// para depurar
        }
        fc.unregisterWriter();// elimino el registro
    }
}
