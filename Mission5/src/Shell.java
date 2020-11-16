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
                Ls ls = new Ls(command);
                ls.run();
            }

            if(command[0].equals("pwd")){
                Pwd pwd = new Pwd(command);
                pwd.run();
            }

            if(command[0].equals("cd")){
                Cd cd = new Cd(command);
                cd.run();
            }

            if(command[0].equals("cp")){
                Cp cp = new Cp(command);
                cp.run();
            }

            if(command[0].equals("mv")){
                Mv mv = new Mv(command);
                mv.run();
            }



        }
    }



}
