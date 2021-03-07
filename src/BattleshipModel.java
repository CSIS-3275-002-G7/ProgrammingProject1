import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BattleshipModel {
    int boardSize = 7;
    int numShips = 3;
    int shipLength = 3;
    int shipsSunk = 0;
    ArrayList<String> ship1locations = new ArrayList<String>(Arrays.asList("", "", ""));
    ArrayList<String> ship2locations = new ArrayList<String>(Arrays.asList("", "", ""));
    ArrayList<String> ship3locations = new ArrayList<String>(Arrays.asList("", "", ""));
    ArrayList<String> ship1hits = new ArrayList<String>(Arrays.asList("", "", ""));
    ArrayList<String> ship2hits = new ArrayList<String>(Arrays.asList("", "", ""));
    ArrayList<String> ship3hits= new ArrayList<String>(Arrays.asList("", "", ""));
    ArrayList<ArrayList> ship1 = new ArrayList<>(Arrays.asList(ship1locations, ship1hits));
    ArrayList<ArrayList> ship2 = new ArrayList<>(Arrays.asList(ship2locations, ship2hits));
    ArrayList<ArrayList> ship3 = new ArrayList<>(Arrays.asList(ship3locations, ship3hits));
    ArrayList<ArrayList> ships = new ArrayList<>(Arrays.asList(ship1, ship2, ship3));

    public BattleshipModel() {
        this.generateShipLocations();
        System.out.println(ships.get(0).get(0));
    }

    public boolean fire(String guess){
        for (int i = 0; i < this.numShips; i++) {
            ArrayList<ArrayList> ship = this.ships.get(i);
            int index = ship.get(0).indexOf(guess);

            if (index >= 0) if (ship.get(1).get(index) == "hit") {
                System.out.println("Oops, you already hit that location!");
                return true;
            } else {
                ship.get(1).set(index, "hit");
                System.out.println(guess);
                System.out.println("HIT!");

                if (this.isSunk(ship)) {
                    System.out.println("You sank my battleship!");
                    this.shipsSunk++;
                }
                return true;
            }
        }
        System.out.println(guess);
        System.out.println("You missed.");
        return false;
    }

    public boolean isSunk(ArrayList<ArrayList> ship) {
        for (int i = 0; i < this.shipLength; i++) {
            if (ship.get(1).get(i) != "hit") {
                return false;
            }
        }
        return true;
    }

    public void generateShipLocations() {
        ArrayList<String> locations;
        for(int i = 0; i < this.numShips; i++) {
            do {
                locations = this.generateShip();
            } while (this.checkCollision(locations));
            this.ships.get(i).set(0, locations);
        }
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

    public boolean checkCollision(ArrayList<String> shipLocations) {
        for (int i = 0; i < this.numShips; i++) {
            ArrayList<ArrayList> ship = this.ships.get(i);
            for (int j = 0; j < shipLocations.size(); j++) {
                if (ship.get(0).indexOf(shipLocations.get(j)) >= 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
