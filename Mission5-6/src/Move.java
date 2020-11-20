import java.io.File;
import java.io.IOException;

public class Move {
    private String[] command;
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
            moveFileToDir(command, currentDir);
        }
        if (isFile(command, 1) && isFile(command, 2)) {         // mv 원본파일명 바꾸고싶은파일명  -> 원본파일이름변경
            renameFile(command, currentDir);
        }
        // 1. mv 원본디렉토리 옮기고싶은디렉토리 추가예정
        // 2. mv 원본디렉토리 바꾸고싶은디렉토리 추가예정
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

    private void renameFile(String[] command, File currentDir) {
        File file = new File(currentDir.getPath() + File.separatorChar + command[1]);
        File fileNew = new File(currentDir.getPath() + File.separatorChar + command[2]);
        if (file.exists()) {
            file.renameTo(fileNew);
        }
    }

    private void moveFileToDir(String[] command, File currentDir) throws IOException {
        String[] tempCommand = new String[]{"cp ", command[1], command[2]};
        Copy cp = new Copy(tempCommand, currentDir);
        cp.run();
        tempCommand = new String[]{"rm ", command[1]};
        Remove rm = new Remove(tempCommand, currentDir);
        rm.run();
    }


}
