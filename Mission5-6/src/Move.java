import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//고쳐야함
public class Move {
    String[] command;
    File currentDir;
    String pathOfOriginalFile;
    String pathOfTargetFile;
    File tempFile;

    public Move(String[] command) {
        this.command = command;
        this.currentDir = currentDir;
    }

    void run() throws IOException {
        if(command.length == 3){
            pathOfOriginalFile = currentDir.getPath() + "\\" + command[1];
            pathOfTargetFile = currentDir.getPath() + "\\" + command[2];
            File originalFile = new File(pathOfOriginalFile);
            File targetFile = new File(pathOfTargetFile);

            if(originalFile.isFile() && originalFile.exists()){

                if(targetFile.isDirectory()){
                    targetFile = new File(pathOfTargetFile + "\\" + command[1]);
                    targetFile.createNewFile();

                    FileInputStream fis = new FileInputStream(originalFile);
                    FileOutputStream fos = new FileOutputStream(targetFile);

                    int data = 0;
                    while ((data = fis.read()) != -1) {
                        fos.write(data);
                    }

                    fis.close();
                    fos.close();
                    originalFile.delete();
                }

                if(targetFile.isFile()){

                    tempFile = new File(pathOfOriginalFile + "command[2]");
                    boolean success = tempFile.renameTo(new File(pathOfOriginalFile + command[2]));
                    if (!success) {
                        System.out.println("Failed to rename to " + pathOfOriginalFile + command[2]);
                    }

                }

            }
        }
    }
}
