import java.io.File;

public class MakeDir {
    private String[] command;
    private File currentDir;

    public MakeDir(String[] command, File currentDir) {
        this.command = command;
        this.currentDir = currentDir;
    }

    public void run(){
        if(command.length <= 1 || command.length >= 4){
            return;
        }

        if(command.length == 2){
            make(new File(currentDir + File.separator + command[1]));
        }

        if(command.length == 3 && command[1].equals("-p")){
            make(new File(currentDir + File.separator + command[2]));
        }

    }

    private void make(File tempFile){
        if(tempFile.isDirectory()){
            System.out.println("directory already exists");
            return;
        }
        if(!tempFile.mkdir()){
            tempFile.mkdirs();
        }
    }
}
