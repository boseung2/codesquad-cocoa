import java.io.File;
import java.io.IOException;

public class Touch {
    private String[] command;
    private File tempFile;

    public Touch(String[] command) {
        this.command = command;
    }

    public void run() throws IOException {
        if(!(command.length == 2)){
            return;
        }

        tempFile = new File(Shell.currentDir + File.separator + command[1]);
        create(tempFile);
    }

    private void create(File tempFile) throws IOException {
        if(tempFile.exists()){
            System.out.println("file already exists");
        }
        tempFile.createNewFile();
    }
}
