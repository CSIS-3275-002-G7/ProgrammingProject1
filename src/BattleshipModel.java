import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BattleshipModel {
    int boardSize = 7;
    int numShips = 3;
    int shipLength = 3;
    int shipsSunk = 0;

    public BattleshipModel() {
    }

    public boolean fire(String guess){
        return true;
    }

    public ArrayList<ArrayList> generateShipLocations() {
        ArrayList<ArrayList> allLocations = new ArrayList<ArrayList>();
        for(int i = 0; i < this.numShips; i++) {
            ArrayList<String> singleShip = this.generateShip();
            allLocations.add(singleShip);
        }
        System.out.println(allLocations.get(0));
        System.out.println(allLocations.get(1));
        System.out.println(allLocations.get(2));
        return allLocations;
    }

    public ArrayList<String> generateShip(){
        ArrayList<String> newShipLocations = new ArrayList<String>();
        Random r = new Random();
        int direction = r.nextInt(2) + 1;
        int row;
        int col;

        if (direction == 1) {
            row = r.nextInt(boardSize);
            col = r.nextInt(boardSize - shipLength) + 1;
        } else {
            row = r.nextInt(boardSize - shipLength) + 1;
            col = r.nextInt(boardSize);
        }
        for (int i = 0; i < this.shipLength; i++) {
            if (direction == 1) {
                newShipLocations.add(row + "" + (col + i));
            } else {
                newShipLocations.add((row + i) + "" + col);
            }
        }
        return newShipLocations;
    }

    public boolean checkCollision(ArrayList<String> newShipLocations) {
        return true;
    }
}
