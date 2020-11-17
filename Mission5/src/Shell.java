import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Shell {
    final static File ROOT_DIR = new File("\\");
    final static File ADMIN_DIR = new File("c:\\users\\admin");
    static File currentDir = ADMIN_DIR;


    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Java Shell>");
            String input = scanner.nextLine();
            String[] command = input.split(" ");

            if(command[0].equals("ls")){
                List list = new List(command);
                list.run();
            }

            if(command[0].equals("pwd")){
                Pwd pwd = new Pwd(command);
                pwd.run();
            }

            if(command[0].equals("cd")){
                ChangeDirectory cd = new ChangeDirectory(command);
                cd.run();
            }

            if(command[0].equals("cp")){
                Copy cp = new Copy(command);
                cp.run();
            }

            if(command[0].equals("mv")){
                Move mv = new Move(command);
                mv.run();
            }



        }
    }



}
