public class Pwd {
    String[] command;

    public Pwd(String[] command) {
        this.command = command;
    }

    void run(){
        if(!(command.length == 1)) {
            return;
        }
        System.out.println(Shell.currentDir.getPath());
    }

}
