import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Paths;

public class Remove {
    private String[] command;
    private File currentDir;
    public File[] files;

    public Remove(String[] command, File currentDir) {
        this.command = command;
        this.currentDir = currentDir;
    }

    public void run() {
        if (command.length <= 1 || command.length >= 4) {
            return;
        }

        if (command.length == 2 && command[1].equals("*")) {    // rm *   -> 해당디렉토리 전체파일 삭제
            delete(currentDir.listFiles());
        }
        if (command.length == 2 && command[1].contains("*.")) {     // rm *.txt   ->  .txt로 끝나는 모든 파일 삭제
            String extension = command[1].substring(1);
            files = currentDir.listFiles((dir, name) -> name.endsWith(extension));
            delete(files);
        }
        if (command.length == 2) {      // rm 파일명   -> 해당파일삭제
            delete(new File(currentDir.getPath() + File.separator + command[1]));
        }

        // rm -r 이후 명령어 구현해야함
        if (command.length == 3 && command[1].equals("-r")) {

        }
        if (command.length == 3 && command[1].equals("-rf")) {

        }

    }


    private void delete(File[] files) {
        for (int i = 0; i < files.length; i++) {
            files[i].delete();
        }
    }

    private void delete(File tempFile){
        if (tempFile.isFile()) {
            tempFile.delete();
        }
        else if(tempFile.isDirectory()){
            System.out.println("can't remove directory (use rm -r)");
        }
        else{
            System.out.println("file not found");
        }
    }
}
