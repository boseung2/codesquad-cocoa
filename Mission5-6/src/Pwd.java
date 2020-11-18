import java.io.File;

public class Pwd {
    private String[] command;
    private File currentDir;

    public Pwd(String[] command, File currentDir) {
        this.command = command;
        this.currentDir = currentDir;
    }

    public void print(){
        if(!(command.length == 1)) {
            return;
        } //   pwd   ->  현재 위치 프린트
        System.out.println(currentDir.getPath());
    }

}
