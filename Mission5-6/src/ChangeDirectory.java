import java.io.File;

public class ChangeDirectory {
    private String[] command;

    public ChangeDirectory(String[] command) {
        this.command = command;
    }

    public void run() {
        if (command.length >= 3) { // command 단어 개수 3개 이상 제외
            return;
        }

        if (command.length == 1) { //command 단어개수 1개일때 (cd)
            Shell.currentDir = Shell.ADMIN_DIR;
            return;
        }

        if (command[1].equals("/")) { //command 단어개수 2개일때
            Shell.currentDir = Shell.ROOT_DIR;
            return;
        }
        if (command[1].equals("..")){
            File tempFile = checkGetParentFile(Shell.currentDir);
            Shell.currentDir = tempFile;
            return;
        }
        if(command[1].charAt(0) == '\"' && command[1].charAt(command[1].length()-1) == '\"'){
            command[1] = command[1].substring(1,command[1].length()-1);
            File tempFile = new File(command[1]);
            Shell.currentDir = checkGetFile(tempFile);

        }else if(!command[1].contains("\\")){
            File tempFile = new File(Shell.currentDir.getPath() + File.separatorChar + command[1]);
            Shell.currentDir = checkGetFile(tempFile);
        }
    }

    public File checkGetParentFile(File file){
        if(file.getParentFile() == null){
            System.out.println("directory not found");
            return file;
        }
        return file.getParentFile();
    }

    public File checkGetFile(File file){
        if(!file.exists() || !file.isDirectory()){
            System.out.println("directory not found");
            return Shell.currentDir;
        }
        return file;
    }



}


