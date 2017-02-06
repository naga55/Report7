package e16;
import robocode.*;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * MYrobot - a robot by (your name here)
 */
public class MYrobot extends AdvancedRobot
{
    /**
     * run: MYrobot's default behavior
     */
    public void run() {

        while(true) {
            // Replace the next 4 lines with any behavior you would like
            turnRadarRightRadians(Double.POSITIVE_INFINITY);
            //setTurnGunRight(45);//砲塔を45度右に回す
            setTurnRight(10000);
            setMaxVelocity(5);//最高速度を８に制限
            ahead(10000);
            //setAhead(50);//前に５０進む
            //setMaxVelocity(8);//最高速度を８に制限

        }
    }

