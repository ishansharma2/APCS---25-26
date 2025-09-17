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

        double largest_pile = 0;
        double piles = 0;
        double total_piles = 0;
        double total = 0;
        double area = 1;

        roomba = new Robot(26, 149, West, 0);
        World.setDelay(0);

        boolean clear = roomba.frontIsClear();

        while (clear == true) {
            while (clear) {
                boolean scan = roomba.nextToABeeper();

                if (scan == false && clear) {
                    area++;
                    roomba.move();
                    scan = roomba.nextToABeeper();
                }

                





            }
        }
    }
}
