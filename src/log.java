import java.io.*;
import java.util.Date;

public class log {
    private BufferedWriter file;

    public log() {
        String fileName = new Date().getTime() + ".log";
        try
        {
            file = new BufferedWriter (new OutputStreamWriter (new FileOutputStream (fileName, false)));
        }
        catch (IOException e){
            System.out.println("file not found");
        }
        catch (Exception e){
            System.out.println("something went wrong : error msg : "+e);
        }
    }
    public void write(String s){
        try
        {
            file.write(s+"\n");
        }
        catch (Exception e ){
            System.out.println("something went wrong : error msg : "+e);
        }
    }
    public void close(){
        try
        {
            file.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
