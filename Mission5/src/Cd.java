import java.io.File;

public class Cd {

    String[] command;
    //File tempDir = new File(command[1]);

    public Cd(String[] command) {
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
                    File tempDir = new File(command[1]);
                    if (tempDir.exists()) {
                        Shell.currentDir = tempDir;
                    } else {
                        System.out.println("file not found");
                    }
                }
            }
        }catch(NullPointerException e){}

    }



}


