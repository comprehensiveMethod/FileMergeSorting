import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyReadFile {
    private final Logger WARN_LOGGER = Logger.getLogger(MyReadFile.class.getName());
    private final Logger INFO_LOGGER = Logger.getLogger(MyReadFile.class.getName());
    private String fileName;

    public MyReadFile(String fileName){
        this.fileName = fileName;
        WARN_LOGGER.setLevel(Level.WARNING);
        INFO_LOGGER.setLevel(Level.INFO);
    }

    public String readLineFromFile(){
        try(FileReader fr = new FileReader(fileName); Scanner scan = new Scanner(fr)){
            if(scan.hasNextLine()) return scan.nextLine();
            else{
                INFO_LOGGER.log(Level.INFO, "file "+ fileName+ " ended");
                return null;
            }
        }catch (FileNotFoundException fnfe){
            WARN_LOGGER.log(Level.WARNING,"File "+ fileName+" not found");
            return null;
        }catch (IOException ioe){
            WARN_LOGGER.log(Level.WARNING, "Something went wrong "+ioe.getMessage());
            return null;
        }
    }




}
