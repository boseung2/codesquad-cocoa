import java.io.File;
import java.util.Scanner;

public class Shell {
    Scanner scanner = new Scanner(System.in);
    final public static File ROOT_DIR = new File(File.pathSeparator);
    final public static File ADMIN_DIR = new File("c:\\users\\admin");
    public static File currentDir = ADMIN_DIR;

    public File getCurrentDir() {
        return currentDir;
    }

    public void setCurrentDir(File currentDir) {
        this.currentDir = currentDir;
    }

    public void start(){

        while (true) {
            String[] command = inputCommandOneLine();
            String mainCommand = command[0];

            if(mainCommand.equals("cd")){
                ChangeDirectory cd = new ChangeDirectory(command);
                cd.run();
            }

            if(mainCommand.equals("pwd")){
                Pwd pwd = new Pwd(command);
                pwd.run();
            }

            if(mainCommand.equals("ls")){
                List list = new List(command);
                list.run();
            }


//            if(mainCommand.equals("cp")){
//                Copy cp = new Copy(command);
//                cp.run();
//            }
//
//            if(mainCommand.equals("mv")){
//                Move mv = new Move(command);
//                mv.run();
//            }

        }
    }

    private String[] inputCommandOneLine(){
        System.out.print("Java Shell>");
        String input = scanner.nextLine();
        return input.split(" ");
    }






}
