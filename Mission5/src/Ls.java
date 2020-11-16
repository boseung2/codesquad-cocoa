import java.io.File;

public class Ls {
    String[] command;

    public Ls(String[] command) {
        this.command = command;
    }

    File[] fileList = Shell.currentDir.listFiles();


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
