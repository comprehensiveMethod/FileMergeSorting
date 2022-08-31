import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyWriteFile {

    private String fileName;
    private final Logger WARN_LOGGER = Logger.getLogger(MyWriteFile.class.getName());
    public MyWriteFile(String fileName){
        this.fileName = fileName;
        WARN_LOGGER.setLevel(Level.WARNING);
    }

    public void writeLineInFile(String s){
        try(FileWriter fw = new FileWriter(fileName)){
            fw.write(s+"\n");
        }catch (FileNotFoundException fnfe){
            WARN_LOGGER.log(Level.WARNING,"File "+ fileName+" not found");
            return;
        }catch (IOException ioe){
            WARN_LOGGER.log(Level.WARNING, "Something went wrong "+ioe.getMessage());
            return;
        }
    }
}
