import java.io.File;
import java.io.IOException;

public class Move {
    private String[] command;
    private String[] tempCommand;
    private File currentDir;

    public Move(String[] command, File currentDir) {
        this.command = command;
        this.currentDir = currentDir;
    }


    void run() throws IOException {
        if (!(command.length == 3)) {
            return;
        }
        if (isFile(command, 1) && isAdress(command, 2)) {       // mv 원본파일명 옮기고싶은디렉토리명 ->해당디렉토리로 파일이동
            tempCommand = new String[]{"cp ", command[1], command[2]};
            Copy cp = new Copy(tempCommand, currentDir);
            cp.run();
            tempCommand = new String[]{"rm ", command[1]};
            Remove rm = new Remove(tempCommand, currentDir);
            rm.run();
        }
        if (isFile(command, 1) && isFile(command, 2)) {         // mv 원본파일명 바꾸고싶은파일명  -> 원본파일이름변경
            String originalFile = currentDir.getPath() + File.separatorChar + command[1];
            String targetFile = currentDir.getPath() + File.separatorChar + command[2];
            renameFile(originalFile, targetFile);
        }
        // 1. mv 원본디렉토리 옮기고싶은디렉토리
        // 2. mv 원본디렉토리 바꾸고싶은디렉토리
        if (isAdress(command, 2) && isAdress(command, 2)) {

        }


    }


    private boolean isAdress(String[] command, int i) {
        if (command[i].charAt(0) == '\"' && command[i].charAt(command[i].length() - 1) == '\"') {
            return true;
        }
        return false;
    }

    private boolean isFile(String[] command, int i) {
        File tempFile = new File(currentDir + File.separator + command[1]);
        if (tempFile.isFile()) {
            return true;
        }
        return false;
    }

    public void renameFile(String filename, String newFilename) {
        File file = new File(filename);
        File fileNew = new File(newFilename);
        if (file.exists()) {
            file.renameTo(fileNew);
        }
    }


}
