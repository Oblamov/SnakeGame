import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;


public class Main {

    public static void main(String[] args) throws Exception {


            int boardWidth = 800;
            int boardHeight = 800;

            JFrame frame = new JFrame("Snake");
            frame.setVisible(true);
            frame.setSize(boardWidth, boardHeight);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


              Mechanism snakeGame = new Mechanism(boardWidth, boardHeight);
              frame.add(snakeGame);
              frame.pack();     //It setting up the title bar pixel size
              snakeGame.requestFocus();

    }





        //        JLayeredPane jpane = new JLayeredPane();
//
//        JFrame frame = new JFrame("SnakeGame");
//
//        frame.setSize(600,400);
//
//
//        frame.setLayout(new BorderLayout());
//        frame.add(jpane,BorderLayout.CENTER);
//        jpane.setBounds(0,0,600,400);
//
//        JComponent snak1 = new Box(BoxLayout.X_AXIS);
//        snak1.setOpaque(true);
//        snak1.setVisible(true);
//        snak1.setSize(50,50);
//        snak1.setBackground(Color.cyan);
//        int x = 100;
//        int y = 100;
//        int turn = 100;
//        while(turn != 0){
//        turn--;
//        x++;
//        y++;
//        }
//
//        JPanel snake = new JPanel();
//        snake.setBounds(100, 100, 50, 10);
//        snake.setOpaque(true);
//        snake.setBackground(Color.CYAN);
//
//        JPanel panel = new JPanel();
//        panel.setBounds(0,0,600,600);
//        panel.setOpaque(true);
//        panel.setBackground(Color.BLACK);
//
//        jpane.add(snake, 1,0);
//        jpane.add(panel,0,0);
//
//        frame.setVisible(true);
//        frame.setLayout(new BorderLayout());
//        frame.add(lpane,BorderLayout.CENTER);
//        lpane.setBounds(0, 0, 600,600);
//        lpane.add(snake, 0);
//        lpane.add(panel,0);
//        frame.setLocation(500,200);
//
//
//       frame.add(snake);
//
//
//
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

