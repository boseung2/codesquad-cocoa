import java.io.File;
import java.io.IOException;

public class Touch {
    private String[] command;
    private File currentDir;

    public Touch(String[] command, File currentDir) {
        this.command = command;
        this.currentDir = currentDir;
    }

    public void run() throws IOException {
        if(!(command.length == 2)){
            return;
        }
        create(new File(currentDir + File.separator + command[1]));
    }

    private void create(File tempFile) throws IOException {
        if(tempFile.exists()){
            System.out.println("file already exists");
        }
        tempFile.createNewFile();
    }
}
