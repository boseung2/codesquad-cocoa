import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Paths;

public class Remove {
    private String[] command;
    public File[] fileList;
    public File tempFile;

    public Remove(String[] command) {
        this.command = command;
    }

    public void run() {
        if (command.length <= 1 || command.length >= 4) {
            return;
        }

        if (command.length == 2 && command[1].equals("*")) {
            fileList = Shell.currentDir.listFiles();
            delete(fileList);
        }
        if (command.length == 2 && command[1].contains("*.")) {
            String extension = command[1].substring(1);
            fileList = Shell.currentDir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(extension);
                }
            });
            delete(fileList);
        }
        if (command.length == 2) {
            tempFile = new File(Shell.currentDir.getPath() + File.separator + command[1]);
            delete(tempFile);
        }

        // rm -r 이후 명령어 구현해야함
        if (command.length == 3 && command[1].equals("-r")) {

        }
        if (command.length == 3 && command[1].equals("-rf")) {

        }

    }

    private void delete(File[] fileList) {
        for (int i = 0; i < fileList.length; i++) {
            fileList[i].delete();
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
