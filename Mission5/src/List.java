import java.io.File;

public class List {
    private String[] command;
    private File[] fileList = Shell.currentDir.listFiles();

    public List(String[] command) {
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
