package VirtualWorld.Animals;

import VirtualWorld.Organism;
import VirtualWorld.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Human extends Animal {
    int firstSkillCooldown;
    int secondSkillCooldown;
    int thirdSkillCooldown;


    public Human(int[] positionXY, World world) {
        this.strength = 5;
        this.initiative = 4;
        this.positionXY = positionXY;
        this.symbol = "H";
        this.age = 0;
        this.isAlive = true;
        this.world = world;
        this.firstSkillCooldown = 0;
        this.secondSkillCooldown = 0;
        this.thirdSkillCooldown = 0;

    }

    @Override
    public void action() {
        Scanner input = new Scanner(System.in);
        System.out.println();
        printAvailableActionOptions();
        int decision = input.nextInt();
        if (decision >= 6) {
            setPositionXY(makeAMove(decision));
        } else {
            useOneFromSkillSet(decision);
        }
        if (strength > 5) {
            strength = strength - 1;
        }
        reduceCooldowns();
    }

    private void useOneFromSkillSet(int skill) {

        switch (skill) {
            case 1:
                immortality(makeAMove(askAndSetMovementDirection()), askAndSetMovementDirection());
                break;
            case 2:
                magicElixir(askAndSetMovementDirection());
                break;
            case 3:
                annihilation(askAndSetMovementDirection());
                break;
        }
    }

    private int askAndSetMovementDirection() {
        Scanner moveDirection = new Scanner(System.in);
        System.out.println("Define movement direction");
        return moveDirection.nextInt();
    }

    private void printAvailableActionOptions() {
        System.out.println();
        System.out.print("Choose available action, 1-5 for skillset and 6-9 for movement" + "\n" +
                "1) Immortality" + "\n" +
                "2) Magic Elixir" + "\n" +
                "3) Annihilation" + "\n" +
                "4 - left, 5 - right, 6 - up, 7 - down ");
        System.out.println();
    }

    private int[] makeAMove(int input) {
        int[] newPosition = getPositionXY();
        switch (input) {
            case 4:
                if (newPosition[0] != 0) {
                    newPosition[0] = newPosition[0] - 1;
                }
                break;
            case 5:
                if (newPosition[0] != world.getWorldMap()[0].length) {
                    newPosition[0] = newPosition[0] + 1;
                }
                break;
            case 6:
                if (newPosition[1] != 0) {
                    newPosition[1] = newPosition[1] - 1;
                }
            case 7:
                if (newPosition[1] != world.getWorldMap()[1].length) {
                    newPosition[1] = newPosition[1] + 1;
                }
                break;
        }
        if (world.getWorldMap()[newPosition[0]][newPosition[1]] != null) {
            colission(newPosition);
        } else {
            return newPosition;
        }
        return newPosition;
    }


    public void immortality(int[] occupiedPosition, int movement) {
        if (firstSkillCooldown == 0) {
            int opponentStrenght = world.getWorldMap()[occupiedPosition[0]][occupiedPosition[1]].getStrength();
            if (opponentStrenght > strength) {
                setPositionXY(calculateNewCoordinates());
            }
        } else setPositionXY(makeAMove(movement));
        setFirstSkillCooldown(5);
    }


    public void magicElixir(int movement) {
        setStrength(strength + 10);
        setPositionXY(makeAMove(movement));
        setSecondSkillCooldown(5);
    }


    public void annihilation(int movement) {
        int playerPosX = getPositionXY()[0];
        int playerPosY = getPositionXY()[1];
        int organismPosX;
        int organismPosY;
        List<Organism> organismsNearby = new ArrayList<>();


        for (Organism organism : world.getOrganismList()) {
            organismPosX = organism.getPositionXY()[0];
            organismPosY = organism.getPositionXY()[1];
            if (playerPosX == (organismPosX + 1) || playerPosX == (organismPosX - 1)) {
                if (playerPosY == (organismPosY + 1) || playerPosY == (organismPosX - 1)) {
                    organismsNearby.add(organism);
                }
            }
        }
        for (Organism organism : organismsNearby) {
            organism.setAlive(false);
        }
    }

    public void reduceCooldowns() {
        if (firstSkillCooldown > 0) {
            setFirstSkillCooldown(firstSkillCooldown - 1);
        }
        if (secondSkillCooldown > 0) {
            setSecondSkillCooldown(secondSkillCooldown - 1);
        }
        if (thirdSkillCooldown > 0) {
            setThirdSkillCooldown(thirdSkillCooldown - 1);
        }
    }

    public void setFirstSkillCooldown(int firstSkillCooldown) {
        this.firstSkillCooldown = firstSkillCooldown;
    }

    public void setSecondSkillCooldown(int secondSkillCooldown) {
        this.secondSkillCooldown = secondSkillCooldown;
    }

    public void setThirdSkillCooldown(int thirdSkillCooldown) {
        this.thirdSkillCooldown = thirdSkillCooldown;
    }


}

