import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {
    private String[] command;
    private File currentDir;

    public Copy(String[] command, File currentDir) {
        this.command = command;
        this.currentDir = currentDir;
    }

    public void run() throws IOException {
        if (command.length <= 2 || command.length >= 5) {   //command단어개수 최소 3개~4개 가능
            return;
        }

        if (command.length == 3 && !isAdress(command, 2)) {
            File originalFile = new File(currentDir.getPath() + File.separatorChar + command[1]);
            File targetFile = new File(currentDir.getPath() + File.separator + command[2]);
            copyOriginalFile(originalFile, targetFile);
        }

        if (command.length == 3 && isAdress(command, 2)) {
            command[2] = command[2].substring(1, command[2].length() - 1);
            File originalFile = new File(currentDir.getPath() + File.separatorChar + command[1]);
            File targetFile = new File(command[2] + File.separator + command[1]);
            copyOriginalFile(originalFile, targetFile);
        }

        //cp -r 명령어들 추가해야함
        if (command.length == 4 && command[2].equals("-r")) {

        }


    }

    private void copyOriginalFile(File originalFile, File targetFile) throws IOException {
        if(printErrorMessage(originalFile, targetFile)){
            return;
        }
        targetFile.createNewFile();

        FileInputStream fis = new FileInputStream(originalFile);
        FileOutputStream fos = new FileOutputStream(targetFile);

        int data = 0;
        while ((data = fis.read()) != -1) {
            fos.write(data);
        }

        fis.close();
        fos.close();
    }

    private boolean printErrorMessage(File originalFile, File targetFile){
        if (!originalFile.exists()) {
            System.out.println("can't find file");
            return true;
        }
        if (targetFile.exists()) {
            System.out.println("file already exists");
            return true;
        }
        if (!targetFile.getParentFile().exists()) {
            System.out.println("can't find directory");
            return true;
        }
        return false;
    }

    private boolean isAdress(String[] command, int i) {
        if (command[i].charAt(0) == '\"' && command[i].charAt(command[i].length() - 1) == '\"') {
            return true;
        }
        return false;
    }


}
