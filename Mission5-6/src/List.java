import java.io.File;

public class List {
    private String[] command;
    public List(String[] command) {
        this.command = command;
    }


    public void run() {
        if(command.length != 1){
            return;
        }

        File[] fileList = Shell.currentDir.listFiles();
        print(fileList);
    }


    private void print(File[] fileList){
        for (int i = 0; i < fileList.length; i++) {
            String fileName = fileList[i].getName();
            if (fileList[i].isFile()) {
                System.out.println(fileName);
            }
            if (fileList[i].isDirectory()) {
                System.out.println(fileName + File.separatorChar);
            }
        }
    }

}
