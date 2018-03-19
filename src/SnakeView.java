
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JPanel;

public class SnakeView extends javax.swing.JFrame {

    public SnakeView(Snake snake) {
        initComponents();
        jLabelPause.setVisible(false);
        initMyStuff();
        mySetLocation();
        this.snake = snake;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelPause = new javax.swing.JLabel();
        jPanelGameScreen = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RDS MP 2018 P2");
        setMaximumSize(new java.awt.Dimension(720, 450));
        setMinimumSize(new java.awt.Dimension(720, 450));
        setResizable(false);

        jPanel1.setBackground(java.awt.Color.darkGray);
        jPanel1.setLayout(null);

        jLabelPause.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabelPause.setForeground(java.awt.Color.red);
        jLabelPause.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPause.setText("PAUSE");
        jLabelPause.setFocusable(false);
        jPanel1.add(jLabelPause);
        jLabelPause.setBounds(283, 185, 220, 79);

        jPanelGameScreen.setBackground(java.awt.Color.darkGray);

        javax.swing.GroupLayout jPanelGameScreenLayout = new javax.swing.GroupLayout(jPanelGameScreen);
        jPanelGameScreen.setLayout(jPanelGameScreenLayout);
        jPanelGameScreenLayout.setHorizontalGroup(
            jPanelGameScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jPanelGameScreenLayout.setVerticalGroup(
            jPanelGameScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelGameScreen);
        jPanelGameScreen.setBounds(10, 30, 700, 400);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelPause;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelGameScreen;
    // End of variables declaration//GEN-END:variables
    
    private final int ROWS = 43;
    private final int COLS = 70;
    private JPanel[][] gameScreen;
    private Snake snake;
    
    public void setSnake(Snake snake){
        this.snake = snake;
        showSnake(Color.BLUE);
    }
    
    public void setPause(boolean bool){
        // Otherwise it means the game is over
        if(jLabelPause.getText().equals("PAUSE")){
            if (bool){
                jLabelPause.setVisible(true);            
            }else{
                jLabelPause.setVisible(false);            
            }
        }
    }
    
    public void endGame(){
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                gameScreen[i][j].setBackground(Color.LIGHT_GRAY);
            }
        }
        
        showSnake(Color.GREEN);
        
        jLabelPause.setVisible(true);   
        jLabelPause.setText("GAME OVER");        
    }
    
    public void showSnake(Color color){
        List<int[]> points = this.snake.getPoints();
        
        for(int[] point: points){
            gameScreen[point[0]][point[1]].setBackground(color);
        }
    }
    
    private void initMyStuff(){
        gameScreen = new JPanel[ROWS][COLS];
        initGameScreen();
    }
    
    private void initGameScreen(){
        GridLayout layout = new GridLayout(ROWS,COLS);
        jPanelGameScreen.setLayout(layout);
        
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                JPanel pixel = new JPanel();
                jPanelGameScreen.add(pixel);
                gameScreen[i][j] = pixel;
                gameScreen[i][j].setBackground(Color.WHITE);
            }
        }
    }
    
    private void mySetLocation(){
        // This method pretends to center the view window on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double screenWidth = screenSize.getWidth();
        double screenHeight = screenSize.getHeight();
        
        this.setLocation((int) ((screenWidth/2)-(this.getWidth()/2)), (int) ((screenHeight/2)-(this.getHeight()/2))); 
    }
    
}
