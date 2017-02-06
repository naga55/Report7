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

    /**
     * onScannedRobot: What to do when you see another robot
     */
    public void onScannedRobot(ScannedRobotEvent e) {
        // ロボットをレーダーで感知した時の行動
        fire(3); //３で攻撃
        setTurnRightRadians(e.getBearingRadians() + Math.PI/2 - (e.getDistance()>200?Math.PI/8:-Math.PI/8));
        //砲塔を右にセットする

    }


    public void onHitWall(HitWallEvent e) {
        //ロボットが壁に当たった時の行動
        double middleX = getBattleFieldWidth()/2; //中心のx座標を取得
        double middleY = getBattleFieldHeight()/2; //中心のy座標を取得

        double px = getX(); //ロボットのx座標を取得し、pxに入れる
        double py = getY(); //ロボットのy座標を取得し、pyに入れる

        double deltaX = middleX-px; //中心から自身のロボットとのx距離を取得
        double deltaY = middleY-py; //中心から自身のロボットとのy距離を取得

        double angle = 90-Math.floor(Math.toDegrees(Math.atan(deltaY/deltaX)));
        //ラジアンから角度を取得

        px = getX(); //ロボットの現在地のx座標を取得
        py = getY(); //ロボットの現在地のy座標を取得
        deltaX = middleX-px+1;
        deltaY = middleY-py;

        if(Math.floor(Math.abs(deltaX))<=10&&Math.floor(Math.abs(deltaY))<=10){ //
            angle = 0;
            deltaX = 0;
        }

        turnRight(Math.abs(angle)-getHeading());
        ahead(deltaX);
    }

    public void onBulletMissed(BulletMissedEvent event){
        turnLeft(90);
        ahead(100);
    }
    public void onHitByBullet(BulletHitEvent event){
        turnLeft(90);
        ahead(200);
    }

    public void onHitRobot(HitRobotEvent event){
        if (event.getBearing() > -90 && event.getBearing() <= 90)
            back(100);
        else
            ahead(100);
    }
}
