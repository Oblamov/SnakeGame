import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.Key;
import java.util.Random;
import java.util.ArrayList;

public class Mechanism extends JPanel implements ActionListener, KeyListener {

    private int point = 0;
    private int boardWidth;
    private int boardHeigth;
    private int pixSize = 20;
    Timer t;
    private int velx;
    private int vely;
    public KeyEvent f;
    Random loca = new Random();

    private int pixScore;
    private int realScore;

    private int xOfApp = loca.nextInt(41) * 20; //All starts of apple's x will be change for that
    private int yOfApp = loca.nextInt(41) * 20; //All starts of apple's y will be change for that

    Pixel headOfSneak;
    ArrayList<Pixel> snakeBody;
    Pixel apple;


    private class Pixel {
        int x;
        int y;

        Pixel(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public Mechanism(int boardHeigth, int boardWidth) {

        this.boardHeigth = boardHeigth;
        this.boardWidth = boardWidth;

        pixScore = 20;


        this.setPreferredSize(new Dimension(boardWidth, boardHeigth));
        this.setBackground(Color.black);
        addKeyListener(this);
        setFocusable(true);

        velx = pixSize;
        vely = 0;

        headOfSneak = new Pixel(80, 120);
        snakeBody = new ArrayList<Pixel>();
        apple = new Pixel(xOfApp, yOfApp);


        t = new Timer(80, this);
        t.start();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        //recs
        for (int i = 0; i < boardWidth / pixSize; i++) {
            g.drawLine(0, i * pixSize, boardWidth, i * pixSize);
            g.drawLine(i * pixSize, 0, i * pixSize, boardHeigth);
        }

        //apple
        g.setColor(Color.red);
        g.fillRect(apple.x, apple.y, pixSize, pixSize);
        //snakeHead
        g.setColor(Color.CYAN);
        g.fillRect(headOfSneak.x, headOfSneak.y, pixSize, pixSize);
        //snakeBody
        for(int i = 0; i < snakeBody.size(); i++){
            Pixel snakePart = snakeBody.get(i);
            g.setColor(Color.ORANGE);
            g.fillRect(snakePart.x,snakePart.y,pixSize,pixSize);
        }

    }
    @Override
    public void keyPressed(KeyEvent e) {

        int keyP = e.getKeyCode();
        switch (keyP) {
            case KeyEvent.VK_LEFT:
                if(velx == pixSize){

                }else {

                    velx = -pixSize;
                    vely = 0;
                }
                break;

            case KeyEvent.VK_RIGHT:
                if(velx == -pixSize){

                }else {
//                    if(vely == 2) { Change shape of snake
                    velx = pixSize;
                    vely = 0;



                    // }
                }
                break;
            case KeyEvent.VK_UP:
                if(vely == pixSize){

                }else {
                    velx = 0;
                    vely = -pixSize;
                }
                break;
            case KeyEvent.VK_DOWN:
                if(vely == -pixSize){

                }else {

                    velx = 0;
                    vely = pixSize;

                }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }//Empty
    public boolean collisionOfHead(Pixel pix1,Pixel pix2){
        return pix1.x == pix2.x &&  pix1.y == pix2.y; // We can rebuild that
    }
    public boolean collisionOfSnake(Pixel pixHead,Pixel pixBody){

        return pixHead.x == pixBody.x && pixHead.y == pixBody.y;

    }

    public void move() {
        if(collisionOfHead(apple,headOfSneak)){
            snakeBody.add(new Pixel(apple.x,apple.y));
            this.point++;
            apple.x = loca.nextInt(40) * 20;
            apple.y = loca.nextInt(40) * 20;
        }
        //MoveBodyWithHead
        for(int a = snakeBody.size() - 1; a >= 0; a--){

            Pixel snake = snakeBody.get(a);
            if(a == 0){
                snake.x = headOfSneak.x;
                snake.y = headOfSneak.y;
            }else{
                Pixel prevSnakeP = snakeBody.get(a-1);
                snake.x = prevSnakeP.x;
                snake.y = prevSnakeP.y;
            }
        }
        for(int a = snakeBody.size() - 1; a >= 0; a--) {
            if(a == 0){
                continue;
            }
            if (collisionOfSnake(headOfSneak, snakeBody.get(a))) {
                t.stop();
                //Demonstrate point werth...
                JFrame frame = new JFrame("gameOver");
                JLabel jlabel = new JLabel("Your score is: " + point);
                frame.setVisible(true);
                frame.setSize(300, 100);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);

                JPanel gameend = new JPanel();
                gameend.setOpaque(true);

                gameend.setSize(300,100);
                gameend.setBackground(Color.blue);
                jlabel.setFont(new Font("Verdana",1,20));
                gameend.add(jlabel);
                gameend.setVisible(true);
                frame.add(gameend);

            }
        }
        headOfSneak.x += velx;
        headOfSneak.y += vely;

//        if (headOfSneak.x + (pixSize / 2) == apple.x + (pixSize / 2) && headOfSneak.y == apple.y || headOfSneak.x - (pixSize / 2) == apple.x - (pixSize / 2) && headOfSneak.y == apple.y || headOfSneak.x == apple.x && headOfSneak.y - (pixSize / 2) == apple.y - (pixSize / 2) || headOfSneak.x == apple.x && headOfSneak.y + (pixSize / 2) == apple.y + (pixSize / 2)) {
//
//            if(velx == pixSize) {
//                headOfSneak.x -= pixSize;
//                sizeSnakeX.set(0, sizeSnakeX.get(0) + pixSize);
//            }else if(velx == -pixSize) {
//                sizeSnakeX.set(0, sizeSnakeX.get(0) + pixSize);
//            }else if(vely == pixSize) {
//                sizeSnakeY.set(0, sizeSnakeY.get(0) + pixSize);
//            }else if(vely == -pixSize) {
//                headOfSneak.y -= pixSize;
//                sizeSnakeY.set(0, sizeSnakeY.get(0) + pixSize);
//            }
//
//            apple.x = loca.nextInt(40) * 20;
//            apple.y = loca.nextInt(40) * 20;
//        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        move();
        repaint();
    }

}
