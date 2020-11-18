import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Shell {
    Scanner scanner = new Scanner(System.in);
    final public static File ROOT_DIR = new File("c:\\");
    final public static File ADMIN_DIR = new File("c:\\users\\admin");
    public static File currentDir = ADMIN_DIR;

    public void start() throws IOException {

        while (true) {
            String[] command = inputCommandOneLine();
            String mainCommand = command[0];

            if(mainCommand.equals("cd")){
                ChangeDir cd = new ChangeDir(command);
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

            if(mainCommand.equals("rm")){
                Remove rm = new Remove(command);
                rm.run();
            }

            if(mainCommand.equals("mkdir")){
                MakeDir mkdir = new MakeDir(command);
                mkdir.run();
            }

            if(mainCommand.equals("touch")){
                Touch touch = new Touch(command);
                touch.run();
            }

//            if(mainCommand.equals("cp")){
//                Copy cp = new Copy(command);
//                cp.run();
//            }

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

    private void clear() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }






}
