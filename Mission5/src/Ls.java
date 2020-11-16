import java.io.File;

public class Ls {
    String[] command;
    File[] fileList = Shell.currentDir.listFiles();

    public Ls(String[] command) {
        this.command = command;
    }

    void run() {
        for (int i = 0; i < fileList.length; i++) {
            String fileName = fileList[i].getName();
            if (fileList[i].isFile()) {
                System.out.println(fileName);
            }
            if (fileList[i].isDirectory()) {
                System.out.println(fileName + "/");
            }
        }
    }



}
