/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphplottingsystem1;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Imesh
 */
public class Lineplot extends JPanel {
    private int padding = 25;
    private int labelPadding = 25;
    private Color lineColor = new Color(44, 102, 230, 180);
    private Color pointColor = new Color(100, 100, 100, 180);
    private Color gridColor = new Color(200, 200, 200, 200);
    private static final Stroke GRAPH_STROKE = new BasicStroke(2f);
    
    //String dummy = "10, 15, 23, 30, 38,52,60,78,83,92,100";
    //String[] dummy1 = dummy.split(",");
    //int[] Ydatapoints =  Arrays.stream(dummy1).mapToInt(Integer::parseInt).toArray();
   // String s = "10, 15, 23, 30, 38,52,60,78,83,92,100";
   // String[] split = s.split(",");
    int a,b, c, d, e,f,g,h,i,j,k;
    
    //public int[] Ydatapoints = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
    public int[] Ydatapoints = {10, 15, 23, 30, 38,52,60,78,83,92,100};
    
    //public int[] Ydatapoints = {a, b, c, d, e,f,g,h,i,j,k}; 
    public int[] Xdatapoints = {3, 10, 15, 20, 28,30,35,40,47,53,60};
    String Ylabel ="hello";
    private int pointWidth = 5;
    String s1="1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17";  
    String[] mumbers=s1.split(",");    //splits the string based on comma

 
    int Ygravity = 0;
    int Xgravity = 0;
    private List<Double> scores;

    public Lineplot(List<Double> scores) {
        this.scores = scores;

    }
    public Lineplot() {
        //int a=10;int b=15;int c=23;int d=30;int e=38;int f=52;int g=60;int h=78;int i=83;int j=92;int k=100;
        
       // LinedataIn chart=new LinedataIn();
       // List<String> xvalues = chart.Xval;
      //  String[] myArray = new String[xvalues.size()];
      //  xvalues.toArray(myArray);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;
        Graphics2D g3 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g3.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        for (int i = 0; i < Ydatapoints.length; i++) {
            Ygravity = Ygravity + Ydatapoints[i];
            Xgravity = Xgravity + Xdatapoints[i];
            int gravityY =Ygravity;
            int gravityX =Xgravity;
            
            if((gravityY/Ydatapoints.length)>getYMaxScore()){
            	break;
            	}
          }
        int gravityY =Ygravity/Ydatapoints.length;
        int gravityX =Xgravity/Xdatapoints.length;

       // double xScale = ((double) getWidth() - (2 * padding) - labelPadding) / (getXMaxScore());
        double xScale1 = ( (getXMaxScore()/((double) getWidth() - (2 * padding) - labelPadding)));

       // double yScale = ((double) getHeight() - (2 * padding) - labelPadding) / (getYMaxScore());
        double yScale1 = (getYMaxScore()/((double) getHeight() - (2 * padding) - labelPadding));
        
        int y11 = (int) ((getYMaxScore() - (gravityY*1.8))/ yScale1 + padding);
        int x11 = (int) ((gravityX*1.8) / xScale1 )+ padding + labelPadding;

        List<Point> graphPoints = new ArrayList<>();
        
      //  for (int i = 0; i < scores.size(); i++) {
        for (int i = 0; i < Ydatapoints.length; i++) {
            int x1 = (int) ((Xdatapoints[i] / xScale1 )+ padding + labelPadding);
            int y1 = (int) ((getYMaxScore() - Ydatapoints[i])/ yScale1 + padding);
            graphPoints.add(new Point(x1, y1));
        }
        
        
        // draw white background
        g2.setColor(Color.WHITE);
        g2.fillRect(padding + labelPadding, padding, getWidth() - (2 * padding) - labelPadding,
                getHeight() - 2 * padding - labelPadding);
        g2.setColor(Color.BLACK);
        g3.setColor(Color.RED);
        
        // create hatch marks and grid lines for y axis.
        for (int i = 0; i < Ydatapoints.length+1; i++) {
            int x0 = padding + labelPadding;
            int x1 = pointWidth + padding + labelPadding;
            int y0 = getHeight()
                    - ((i * (getHeight() - padding * 2 - labelPadding)) / Ydatapoints.length + padding + labelPadding);
            int y1 = y0;
            if (Ydatapoints.length > 0) {
                g2.setColor(gridColor);
                g2.drawLine(padding + labelPadding + 1 + pointWidth, y0, getWidth() - padding, y1);
                g2.setColor(Color.BLACK);
                String yLabel = ((int) ((getYMinScore()
                        + (getYMaxScore() - getYMinScore()) * ((i * 1.0) / Ydatapoints.length)) ))  + "";
               // String yLabel = ((int) (Ydatapoints[i]/yScale1))  + "";
                FontMetrics metrics = g2.getFontMetrics();
                int labelWidth = metrics.stringWidth(yLabel);
                g2.drawString(yLabel, x0 - labelWidth - 5, y0 + (metrics.getHeight() / 2) - 3);
            }
            g2.drawLine(x0, y0, x1, y1);
        }

        // and for x axis
        for (int i = 0; i < Xdatapoints.length+1; i++) {
            if (Xdatapoints.length > 1) {
                int x0 = (i) * (getWidth() - padding * 2 - labelPadding) / (Xdatapoints.length ) + padding + labelPadding;
                int x1 = x0;
                int y0 = getHeight() - padding - labelPadding;
                int y1 = y0 - pointWidth;
               // if ((i % ((int) ((Xdatapoints.length / 20.0))+1)) == 0) {
                if (Xdatapoints.length > 0) {
                    g2.setColor(gridColor);
                    g2.drawLine(x0, getHeight() - padding - labelPadding  - pointWidth, x1, padding);
                    g2.setColor(Color.BLACK);
                    //String xLabel = (int)((i)xScale(getXMaxScore()/(Xdatapoints.length))) + "";
                    String xLabel =((int) ((getXMinScore()
                            + (getXMaxScore() - getXMinScore()) * ((i * 1.0) / Xdatapoints.length)) ))  + "";
                //    String xLabel =(Xdatapoints[i]/xScale1) + "";
              //      String xLabel =((int) ((getXMinScore()
                //            + (getXMaxScore() - getXMinScore()) * ((i * 1.0) / Xdatapoints.length)) ))  + "";
                    FontMetrics metrics = g2.getFontMetrics();
                    int labelWidth = metrics.stringWidth(xLabel);
                    g2.drawString(xLabel, x0 - labelWidth / 2, y0 + metrics.getHeight() + 3);
                }
                g2.drawLine(x0, y0, x1, y1);
            }
        }

        // create x and y axes
        g2.drawLine(padding + labelPadding, getHeight() - padding - labelPadding, padding + labelPadding, padding);
        g2.drawLine(padding + labelPadding, getHeight() - padding - labelPadding, getWidth() - padding,
                getHeight() - padding - labelPadding);

        Stroke oldStroke = g2.getStroke();
        g2.setColor(lineColor);
        g2.setStroke(GRAPH_STROKE);
        
        
        g3.drawLine(padding + labelPadding,getHeight()-padding - labelPadding,x11,y11);
        System.out.println("xgravity  "+gravityX+"  "+xScale1);
        System.out.println("ygravity  "+gravityY);
        System.out.println("Gradient "+gravityY/gravityX);
        
        
        
        
        for (int i = 0; i < graphPoints.size() - 1; i++) {
            int x1 = graphPoints.get(i).x;
            int y1 = graphPoints.get(i).y;
            int x2 = graphPoints.get(i + 1).x;
            int y2 = graphPoints.get(i + 1).y;
            g2.drawLine(x1, y1, x2, y2);
           // g3.drawLine(10, 10, gravityX, gravityY);
        }
        

        g2.setStroke(oldStroke);
        g2.setColor(pointColor);
        for (int i = 0; i < graphPoints.size(); i++) {
            int x = graphPoints.get(i).x - pointWidth / 2;
            int y = graphPoints.get(i).y - pointWidth / 2;
            int ovalW = pointWidth;
            int ovalH = pointWidth;
            g2.fillOval(x, y, ovalW, ovalH);
        }
    }
   

    private double getXMaxScore() {
    	int maxX = -Integer.MAX_VALUE;  
        for(int i=0; i<Xdatapoints.length; i++){  
            if(Xdatapoints[i]>maxX)  
                maxX = Xdatapoints[i];  
             
        }  
        return maxX; 
    }

    private double getYMinScore() {
    	double maxX = Double.MIN_VALUE;  
        for(int i=0; i<Ydatapoints.length; i++){  
            if(Ydatapoints[i]<maxX)  
                maxX = Ydatapoints[i];  
             
        }  
        return maxX; 
    }
    private double getXMinScore() {
    	double maxX = Double.MIN_VALUE;  
        for(int i=0; i<Xdatapoints.length; i++){  
            if(Xdatapoints[i]<maxX)  
                maxX = Xdatapoints[i];  
             
        }  
        return maxX; 
    }

    private double getYMaxScore() {
    	int maxY = -Integer.MAX_VALUE;  
        for(int i=0; i<Ydatapoints.length; i++){  
            if(Ydatapoints[i]>maxY)  
                maxY = Ydatapoints[i];  
             
        }  
        return maxY; 
    }

    public void setScores(List<Double> scores) {
        this.scores = scores;
        invalidate();
        this.repaint();
    }
    
    public List<Double> getScores() {
        return scores;
    }
    

    public static void createAndShowGui() {
    	//int[] Ydatapoints = {0, 10, 23, 30, 38,52,60,78,83,92,98}; 
    	//int[] Xdatapoints = {0, 10, 15, 20, 25,30,35,40,45,53,60}; 
       List<Double> scores = new ArrayList<>();
      // List<Double> Xscores = new ArrayList<>();

        MainPanel mainPanel = new MainPanel(scores);
        mainPanel.setPreferredSize(new Dimension(800, 600));
        JFrame frame = new JFrame();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        System.out.println();
       	createAndShowGui();
    	
       /* SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
        
    	MainPanel mainPanel = new MainPanel(scores);
        mainPanel.setPreferredSize(new Dimension(800, 600));
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);*/
    }
    //Main changes underneath


    public static class MainPanel extends JPanel {
        JLabel title = new JLabel("Graph tittle");
        String string ="YLabel (Units)" ;
        String string1 = "X Label (Unit)";
        public MainPanel(List<Double> scores) {

            setLayout(new BorderLayout());

            
            title.setFont(new Font("Arial", Font.BOLD, 25));
            title.setHorizontalAlignment(JLabel.CENTER);

            JPanel graphPanel = new Lineplot(scores);

            VerticalPanel vertPanel = new VerticalPanel();

            HorizontalPanel horiPanel = new HorizontalPanel();

            add(title, BorderLayout.NORTH);
            add(horiPanel, BorderLayout.SOUTH);
            add(vertPanel, BorderLayout.WEST);
            add(graphPanel, BorderLayout.CENTER);

        }

       public class VerticalPanel extends JPanel {
           
            public VerticalPanel() {
                setPreferredSize(new Dimension(25, 0));
            }

            @Override
            public void paintComponent(Graphics g) {
                
                super.paintComponent(g);

                Graphics2D gg = (Graphics2D) g;
                gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                Font font = new Font("Arial", Font.PLAIN, 15);

                

                FontMetrics metrics = g.getFontMetrics(font);
                int width = metrics.stringWidth(string);
                int height = metrics.getHeight();

                gg.setFont(font);

                drawRotate(gg, getWidth(), (getHeight() + width) / 2, 270, string);
            }

            public void drawRotate(Graphics2D gg, double x, double y, int angle, String text) {
                gg.translate((float) x, (float) y);
                gg.rotate(Math.toRadians(angle));
                gg.drawString(text, 0, 0);
                gg.rotate(-Math.toRadians(angle));
                gg.translate(-(float) x, -(float) y);
            }

        }

        public class HorizontalPanel extends JPanel {
            
            public HorizontalPanel() {
                setPreferredSize(new Dimension(0, 25));
            }

            @Override
            public void paintComponent(Graphics g) {

                super.paintComponent(g);

                Graphics2D gg = (Graphics2D) g;
                gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                Font font = new Font("Arial", Font.PLAIN, 15);
               
                FontMetrics metrics = g.getFontMetrics(font);
                int width = metrics.stringWidth(string1);
                int height = metrics.getHeight();

                gg.setFont(font);

                gg.drawString(string1, (getWidth() - width) / 2, 11);
            }
        }
    }
    
}
