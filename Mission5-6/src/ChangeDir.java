import java.io.File;

public class ChangeDir {
    private String[] command;
    private File currentDir;

    public ChangeDir(String[] command, File currentDir) {
        this.command = command;
        this.currentDir = currentDir;
    }

    public File getCurrentDir() {
        if (command.length >= 3) { // command 단어 개수 3개 이상 제외
            return currentDir;
        }

        if (command.length == 1) { //command 단어개수 1개일때 (cd)
            return Shell.ADMIN_DIR;
        }

        if (command[1].equals("/")) { //command 단어개수 2개일때부터
            return Shell.ROOT_DIR;
        }

        if (command[1].equals("..")){
            return checkGetParentFile(currentDir);
        }

        if(isAdress(command, 1)){
            command[1] = command[1].substring(1,command[1].length()-1);
            return checkGetFile(new File(command[1]));
        }

        else if(!command[1].contains("\\")){
            return checkGetFile(new File(currentDir.getPath() + File.separatorChar + command[1]));
        }

        return currentDir;
    }

    private File checkGetParentFile(File tempFile){
        if(tempFile.getParentFile() == null){
            System.out.println("directory not found");
            return tempFile;
        }
        return tempFile.getParentFile();
    }

    private File checkGetFile(File tempFile){
        if(!tempFile.exists() || !tempFile.isDirectory()){
            System.out.println("directory not found");
            return currentDir;
        }
        return tempFile;
    }

    private boolean isAdress(String[] command, int i){
        if(command[i].charAt(0) == '\"' && command[i].charAt(command[i].length()-1) == '\"'){
            return true;
        }
        return false;
    }



}


