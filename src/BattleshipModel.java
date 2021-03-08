import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BattleshipModel {
    int boardSize = 7;
    int numShips = 3;
    int shipLength = 3;
    int shipsSunk = 0;
    BattleshipView view;
    ArrayList<ArrayList> ships = new ArrayList<>();

    public int getShipsSunk() {
        return shipsSunk;
    }

    public int getNumShips() {
        return numShips;
    }

    public BattleshipModel(BattleshipView view) {
        this.populateShipsArray();
        this.generateShipLocations();
        this.view = view;
    }

    public void populateShipsArray() {
        for (int i = 0; i < this.numShips; i++) {
            ArrayList<String> shipLocations = new ArrayList<>(Arrays.asList("", "", ""));
            ArrayList<String> shipHits = new ArrayList<>(Arrays.asList("", "", ""));
            ArrayList<ArrayList<String> > ship = new ArrayList<>(Arrays.asList(shipLocations, shipHits));
            ships.add(ship);
        }
    }

    public boolean fire(String guess){
        for (int i = 0; i < this.numShips; i++) {
            ArrayList<ArrayList> ship = this.ships.get(i);
            int index = ship.get(0).indexOf(guess);

            if (index >= 0) if (ship.get(1).get(index) == "hit") {
                this.view.displayMessage("Oops, you already hit that location!");
                return true;
            } else {
                ship.get(1).set(index, "hit");
                this.view.displayShip(guess);
                this.view.displayMessage("HIT!");

                if (this.isSunk(ship)) {
                    this.view.displayMessage("You sank my battleship!");
                    this.shipsSunk++;
                }
                return true;
            }
        }
        this.view.displayMiss(guess);
        this.view.displayMessage("You missed");
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
        ArrayList<String> newShipLocations = new ArrayList<>();
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
            for (String shipLocation : shipLocations) {
                if (ship.get(0).contains(shipLocation)) {
                    return true;
                }
            }
        }
        return false;
    }
}
