import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MineSweeper {
    private final int FRAME_SIZE = 500;
    private final int BLOCKS_SIZE = 9;
    private Block[][] blocks = new Block[BLOCKS_SIZE][];


    private MineSweeper() {
        JFrame frame = new JFrame("Mine Sweeper");
        frame.setSize(FRAME_SIZE, FRAME_SIZE);
        frame.setLayout(new BorderLayout());

        //NORTH에 retry버튼 추가
        JButton retry = new JButton("Retry");
        retry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Block b = (Block)e.getSource();
                if(b.getText().equals("Retry")){

                }
            }
        });
        frame.add(retry, BorderLayout.NORTH);

        //SOUTH에 buttons추가
        Container grid = new Container();
        grid.setLayout(new GridLayout(BLOCKS_SIZE, BLOCKS_SIZE));
        for (int i = 0; i < BLOCKS_SIZE; i++) {
            blocks[i] = new Block[BLOCKS_SIZE];
            for (int j = 0; j < BLOCKS_SIZE; j++) {
                blocks[i][j] = new Block(i, j, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Block b = (Block)e.getSource();
                        if (b.getText().equals("")) {
                            b.setText("1");
                        }
                        else {
                            b.setText("");
                        }
                    }
                });
                grid.add(blocks[i][j]);
            }
        }
        frame.add(grid, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }

    private class Block extends JButton{
        private final int row;
        private final int col;

        private Block(int row, int col, ActionListener actionListener) {
            this.row = row;
            this.col = col;
            addActionListener(actionListener);
            setText("");
        }
    }

    public static void main(String[] args) {
        new MineSweeper();
    }


}
