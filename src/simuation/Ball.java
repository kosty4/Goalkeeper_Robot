package simuation;

import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Ball {

    public Circle ball;
    public Rectangle goal;

    double alphaInterpolant = 1;

    public Ball(){

        goal = new Rectangle(40,20,420,30);
        //so the line of the goal is at y = 50...

        ball = new Circle();
        ball.setFill(Color.BLUE);
        ball.setCenterX(230.0);
        ball.setCenterY(400.0);
        ball.setRadius(30);
    }

    public void simulate() {
        BallAnimationControl ballAnimationControl = new BallAnimationControl();
        ballAnimationControl.start();
    }

    public class BallAnimationControl extends AnimationTimer {

        @Override
        public void handle(long now) {
//            ball.setCenterY(ball.getCenterY() -  10 * calculateInterpolation(400, ball.getCenterY(), 100));

            if(alphaInterpolant - 0.005 > 0 ){
                alphaInterpolant = alphaInterpolant - 0.005;

                System.out.println("Running! " + alphaInterpolant);
            }

            if(ball.getCenterY() > 50){

                ball.setCenterY(ball.getCenterY() -  5 * alphaInterpolant);
            }

            System.out.println("Ball position "+  ball.getCenterY());
        }
    }

    private double calculateInterpolation(double initialY, double currentY, int destinationY){
        double distance = Math.abs(initialY - destinationY);

        double a = Math.abs(currentY-destinationY) / distance;
        System.out.println("alpha : " + a + "  Current Y : " + currentY );


        return a;
    }


}