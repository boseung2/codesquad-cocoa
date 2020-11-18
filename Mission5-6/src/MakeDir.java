import java.io.File;

public class MakeDir {
    private String[] command;
    private File tempFile;

    public MakeDir(String[] command) {
        this.command = command;
    }

    public void run(){
        if(command.length <= 1 || command.length >= 4){
            return;
        }

        if(command.length == 2){
            tempFile = new File(Shell.currentDir + File.separator + command[1]);
            make(tempFile);
        }

        if(command.length == 3 && command[1].equals("-p")){
            tempFile = new File(Shell.currentDir + File.separator + command[2]);
            make(tempFile);
        }

    }

    public void make(File tempFile){
        if(tempFile.isDirectory()){
            System.out.println("directory already exists");
            return;
        }
        if(!tempFile.mkdir()){
            tempFile.mkdirs();
        }
    }
}
