
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeController implements KeyListener{
    private SnakeModel model;

    public SnakeController(SnakeModel model) {
        this.model = model;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getExtendedKeyCode();
        
        switch(key){
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                model.setDirection('D');
                break;
                
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                model.setDirection('L');                
                break;
                
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                model.setDirection('U');                
                break;
                
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                model.setDirection('R');                
                break;
                
            case KeyEvent.VK_PLUS:
                model.setSpeed(1);
                break;
                
            case KeyEvent.VK_MINUS:
                model.setSpeed(-1);
                break;
                
            case KeyEvent.VK_P:
                model.setPause();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
