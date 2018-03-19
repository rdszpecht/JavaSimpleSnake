
import java.awt.Color;
import java.util.List;

public class SnakeModel {
    private int velocity;
    private Snake snake;
    private int[] dim;
    private int[] direction;
    private SnakeSecThread secThread;
    private SnakeView view;
    
    public SnakeModel(int velocity, Snake snake, int[] dim, SnakeView view) {
        this.velocity = velocity;
        this.snake = snake;
        this.dim = dim;
        this.view = view;
        
        this.direction = new int[2];
        this.direction[0] = 1;
        this.direction[1] = 0;
        
        this.secThread = new SnakeSecThread(velocity,this,dim);
        secThread.start();
    }
    
    public void actSnake(){
        view.showSnake(Color.WHITE);
        
        List<int[]> points = snake.getPoints();
        int len = points.size();
        
        for (int i = len - 1; i > 0; i--) {
            points.set(i, points.get(i - 1));
        } 
        
        int[] head = points.get(0);
        int[] newHead = new int[2];
        newHead[0] = head[0] + this.direction[0];
        newHead[1] = head[1] + this.direction[1];
        
        if((newHead[0] < 0) || (newHead[1] < 0) || (newHead[0] > dim[0] - 1) || (newHead[1] > dim[1] - 1)){
            secThread.setAlive(false);
            view.endGame();
        }else{        
            points.set(0, newHead);
            view.setSnake(snake);      
        }
    }
    
    public void setDirection(int[] dir){
        this.direction = dir;
    }
    
    public void setDirection(char c){
        int[] dir = {0,0};
        switch(c){
            case 'l':
            case 'L':
                dir[1] = -1;
                break;
                
            case 'u':
            case 'U':
                dir[0] = -1;
                break;
                
            case 'r':
            case 'R':
                dir[1] = 1;
                break;
                
            case 'd':
            case 'D':
                dir[0] = 1;
                break;
        }
        
        this.direction = dir;
    }
    
    public void setPause(){
        if(secThread.getPause()){
            secThread.setPause(false);
            view.setPause(false);
        }else{
            secThread.setPause(true);
            view.setPause(true);
        }
    }
    
    public void setSpeed(int speed){
        if (this.velocity > 0 && this.velocity < 100){
            this.velocity = this.velocity + speed;
            secThread.setVelocity(velocity);
        }
    }
}
