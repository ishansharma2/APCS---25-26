package robot;

import kareltherobot.*;

public class Driver implements Directions {

    private static Robot roomba;
    private static int st = 0;
    private static int av = 0;

    public static void turnRight() {
        roomba.turnLeft();
        roomba.turnLeft();
        roomba.turnLeft();
    }

    public static void main(String[] args) {
        String wrldName = "robot/finalTestWorld2024.wld";

        World.readWorld(wrldName);
        World.setVisible(true);
        

       
    }
}
