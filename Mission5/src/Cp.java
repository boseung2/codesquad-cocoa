import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Cp {
    String[] command;
    String pathOfOriginalFile;
    String pathOfTargetFile;



    public Cp(String[] command) {
        this.command = command;
    }

    void run() throws IOException {

        if(command.length == 3){
            pathOfOriginalFile = Shell.currentDir.getPath() + "\\" + command[1];
            pathOfTargetFile = Shell.currentDir.getPath() + "\\" + command[2];
            File originalFile = new File(pathOfOriginalFile);
            File targetFile = new File(pathOfTargetFile);

            if(originalFile.exists()) {
                targetFile.createNewFile();

                FileInputStream fis = new FileInputStream(originalFile);
                FileOutputStream fos = new FileOutputStream(targetFile);

                int data = 0;
                while ((data = fis.read()) != -1) {
                    fos.write(data);
                }

                fis.close();
                fos.close();
            }

        }

    }
}
