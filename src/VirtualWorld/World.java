package VirtualWorld;

import VirtualWorld.Animals.*;
import VirtualWorld.Plants.Belladonna;
import VirtualWorld.Plants.Grass;
import VirtualWorld.Plants.Guarana;
import VirtualWorld.Plants.SowThistle;

import java.util.*;

public class World {

    private int mapHeight = 2;
    private int mapWidth = 2;
    private List<Organism> organismList;
    private Organism[][] worldMap;


    public World() {
    }


    private void executeRound() {

    }


    public void drawWorld() {
        populateWorld();
        int i = 0;
        for (i = 0; i < mapWidth; i++) {
            System.out.print("-");
        }
        for (i = 0; i < mapHeight; i++) {
            System.out.println();
            for (int j = 0; j < mapWidth; j++) {
                if (worldMap[i][j] == null) {
                    System.out.print('*');
                } else {
                    System.out.print(worldMap[i][j].getSymbol());
                }
            }
        }
        System.out.println();
        for (i = 0; i < mapWidth; i++) {
            System.out.print("-");
        }
    }

    public void defineWorldSize() {
        System.out.println("Welcome to the Virtual World");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Define map width: ");
        this.mapWidth = scanner.nextInt();
        System.out.println("Define map height: ");
        this.mapHeight = scanner.nextInt();
    }

    public void populateWorld() {
        worldMap = new Organism[mapWidth][mapHeight];
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


        System.out.println(organismList);
        System.out.println();

        Collections.sort(organismList);

        System.out.println(organismList);
    }

    public int[] checkIfPositionIsAvailable() {
        boolean condition = false;
        int[] newCoordinates = new int[2];
        while (!condition) {
            int posX = new SplittableRandom().nextInt(1, mapHeight);
            int posY = new SplittableRandom().nextInt(1, mapWidth);
            if (worldMap[posX][posY] == null) {
                condition = true;
                newCoordinates = new int[]{posX, posY};
            }
        }
        return newCoordinates;
    }


}


