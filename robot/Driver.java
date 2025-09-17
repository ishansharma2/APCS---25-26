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

                int beepers = 0;
                piles = 0;

                while (scan) {
                    roomba.pickBeeper();
                    total++;
                    scan = roomba.nextToABeeper();
                    beepers++;
                    piles++;

                    if (piles == 1) {
                        total_piles += 1; // count this pile once
                    }
                    if (beepers > largest_pile) {
                        largest_pile = beepers;
                        st = roomba.street();
                        av = roomba.avenue();
                    }
                }

                clear = roomba.frontIsClear();
            }

            clear = roomba.frontIsClear();
            boolean faceEast = roomba.facingEast();
            boolean faceWest = roomba.facingWest();

            if (clear == false) {
                if (faceEast == true) {
                    roomba.turnLeft();
                    clear = roomba.frontIsClear();
                    if (clear) {
                        area++;
                        roomba.move();
                        roomba.turnLeft();
                        clear = roomba.frontIsClear();
                    } else {
                        area++;
                       roomba.turnOff();
                       System.out.println("Area of Room: " + area);
                       System.out.println("Total Amount of Piles: " + total_piles + " piles");
                       System.out.println("Total Beepers: " + total + " beepers");
                       System.out.println("The largest pile's size: " + largest_pile + " beepers");
                       System.out.println("Location of Largest Pile: (" + st + ", " + av + ")");
                       System.out.println("Average pile size: " + (total / total_piles) + " beepers");
                       System.out.println("Percent room dirty: " + ((total_piles * 100) / area) + "%");
                   }
               } else if (faceWest) {
                   turnRight();
                   clear = roomba.frontIsClear();
                   if (clear) {
                       area++;
                       roomba.move();
                       turnRight();
                      
                        if (clear) {
                       area++;
                       roomba.move();
                       turnRight();
                       clear = roomba.frontIsClear();
                   } else {
                       area++;
                       roomba.turnOff();
                       System.out.println("Area of Room: " + area);
                       System.out.println("Total Amount of Piles: " + total_piles + " piles");
                       System.out.println("Total Beepers: " + total + " beepers");
                       System.out.println("The largest pile's size: " + largest_pile + " beepers");
                       System.out.println("Location of Largest Pile: (" + st + ", " + av + ")");
                       System.out.println("Average pile size: " + (total / total_piles) + " beepers");
                       System.out.println("Percent room dirty: " + ((total_piles * 100) / area) + "%");

                   } 
                    

                    }
                }

            }
        }
    }
}
