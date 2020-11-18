import java.io.File;

public class List {
    private String[] command;
    private File currentDir;
    public List(String[] command, File currentDir) {
        this.command = command;
        this.currentDir = currentDir;
    }

    public void print() {
        if(command.length != 1){
            return;
        }
        File[] files = currentDir.listFiles();
        printList(files);
    }


    private void printList(File[] files){
        for (int i = 0; i < files.length; i++) {
            String fileName = files[i].getName();
            if (files[i].isFile()) {
                System.out.println(fileName);
            }
            if (files[i].isDirectory()) {
                System.out.println(fileName + File.separatorChar);
            }
        }
    }

}
