import java.io.File;

public class ChangeDirectory {

    private String[] command;

    public ChangeDirectory(String[] command) {
        this.command = command;
    }

    void run() {

        try {
            if (command.length == 1) {
                Shell.currentDir = Shell.ADMIN_DIR;
            }

            if (command.length == 2) {
                if (command[1].equals("/")) {
                    Shell.currentDir = Shell.ROOT_DIR;
                }
                else if (command[1].equals("..") && Shell.currentDir.getParentFile().exists()) {
                    Shell.currentDir = Shell.currentDir.getParentFile();
                }
                else {
                    File tempDir1 = new File(command[1]);
                    File tempDir2 = new File(Shell.currentDir.getPath() + "\\" + command[1]);

                    if (tempDir1.exists()) {
                        Shell.currentDir = tempDir1;
                    }else if (tempDir2.exists()){
                        Shell.currentDir = tempDir2;
                    }
                    else {
                        System.out.println("file not found");
                    }
                }
            }
        }catch(NullPointerException e){

        }

    }

}


