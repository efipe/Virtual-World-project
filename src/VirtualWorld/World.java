package VirtualWorld;

import VirtualWorld.Animals.*;
import VirtualWorld.Plants.Belladonna;
import VirtualWorld.Plants.Grass;
import VirtualWorld.Plants.Guarana;
import VirtualWorld.Plants.SowThistle;

import java.util.*;

public class World {

    private int columns = 20;
    private int rows = 6;
    private List<Organism> organismList;
    private Organism[][] worldMap;


    public World() {
        organismList = new ArrayList<>();
        worldMap = new Organism[columns][rows];
    }


    private void executeRound() {

    }


    public void drawWorld() {

        //todo size modification & cleanup

        System.out.println(organismList);

        for (int i = 0; i < columns + 15; i++) {
            System.out.print("-");
        }

        for (int row = 0; row < rows; row++) {
            System.out.println();
            for (int col = 0; col < columns; col++) {
                if (worldMap[col][row] == null) {
                    System.out.print('*');
                } else {
                    System.out.print(worldMap[col][row].getSymbol());
                }
            }
        }

        System.out.println();
        for (int i = 0; i < columns + 15; i++) {
            System.out.print("-");
        }
    }

//    public void defineWorldSize() {
//        System.out.println("Welcome to the Virtual World");
//        System.out.println();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Define map width: ");
//        this. = scanner.nextInt();
//        System.out.println("Define map height: ");
//        this. = scanner.nextInt();
//    }

    public void populateWorld() {

        organismList = Arrays.asList(
                new Turtle(checkIfPositionIsAvailable(), this),
                new Fox(checkIfPositionIsAvailable(), this),
                new Antelope(checkIfPositionIsAvailable(), this),
                new Wolf(checkIfPositionIsAvailable(), this),
                new Sheep(checkIfPositionIsAvailable(), this),
                new Belladonna(checkIfPositionIsAvailable(), this),
                new Grass(checkIfPositionIsAvailable(), this),
                new Guarana(checkIfPositionIsAvailable(), this),
                new SowThistle(checkIfPositionIsAvailable(), this)
        );
        for (Organism organism : organismList) {
            int[] positionToSave = organism.getPositionXY();
            worldMap[positionToSave[0]][positionToSave[1]] = organism;

        }
        Collections.sort(organismList);
    }

    public int[] checkIfPositionIsAvailable() {
        boolean condition = false;
        int[] newCoordinates = new int[2];
        while (!condition) {
            int posX = new SplittableRandom().nextInt(0, columns - 1);
            int posY = new SplittableRandom().nextInt(0, rows - 1);
            if (worldMap[posX][posY] == null) {
                condition = true;
                newCoordinates = new int[]{posX, posY};
            }
        }
        return newCoordinates;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public List<Organism> getOrganismList() {
        return organismList;
    }

    public Organism[][] getWorldMap() {
        return worldMap;
    }
}


