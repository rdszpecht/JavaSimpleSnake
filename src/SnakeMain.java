public class SnakeMain {
    private static SnakeView view;
    private static SnakeController controller;
    private static SnakeModel snakeModel;
    private static Snake snake;
    private static int velocity;
    
    public static void main(String[] args) {
        snake = new Snake(10,10);
        snake.inserPoint(10, 11);
        snake.inserPoint(10, 12);
        
        view = new SnakeView(snake);
        velocity = 10;
        int[] dim = {43,70};
        snakeModel = new SnakeModel(velocity, snake, dim, view);
        controller = new SnakeController(snakeModel);
        
        view.setVisible(true);
        view.addKeyListener(controller);
    }
}
