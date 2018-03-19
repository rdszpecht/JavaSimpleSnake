public class SnakeSecThread extends Thread{
    
    private boolean alive;
    private int velocity;
    private SnakeModel snakeModel;
    private int[] dim;
    private boolean pause;
    
    public SnakeSecThread(int velocity, SnakeModel snakeModel, int[] dim){
        this.alive = true;
        this.velocity = velocity;
        this.snakeModel = snakeModel;
        this.dim = dim;
        this.pause = false;
    }
    
    public boolean getPause(){
        return pause;
    }
    
    public void setVelocity(int velocity){
        this.velocity = velocity;
    }
    
    public int getVelocity(){
        return velocity;
    }
    
    public void setPause(boolean pause){
        this.pause = pause;
    }
    
    public void setAlive(boolean alive){
        this.alive = alive;
    }
    
    private boolean myIsAlive(){
        return alive;
    }
    
    private void move(){
        if (!pause){
            snakeModel.actSnake();
        }
    }
    
    @Override
    public void run(){
        while(myIsAlive()){
            try{
                Thread.sleep(100/velocity * 50);
            }catch (InterruptedException ex){
                System.err.println("ERROR. Something gone wrong with actGame class object");
            }
            move();  
        }      
    }       
}
