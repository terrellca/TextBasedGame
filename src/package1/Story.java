package package1;

import package2.WeaponFactory;

public class Story {

    Game game;
    UI ui;
    VisibilityManager vm;
    Player player;

    int knightHP = 50;

    boolean darkKnightDefeated = false;

    public Story(Game g, UI useri, VisibilityManager visib, Player player) {
        this.game = g;
        this.ui = useri;
        this.vm = visib;
        this.player = player;

    }

    public void defaultSetUp() {
        player.HP = 100;
        ui.hpNumLabel.setText("" + player.HP);

        player.addWeapon(WeaponFactory.createSword());
        player.addWeapon(WeaponFactory.createBow());
        player.equipWeapon("Sword");
        ui.showInventory(player.getInventory());
        ui.weaponNameLabel.setText(player.currentWeapon.getName());
    }

    public void selectPosition(String nextPosition) {
        switch (nextPosition) {

            case "Forest":
                Forest();
                break;

            case "townGate":
                townGate();
                break;

            case "forestWalk":
                forestWalk();
                break;

            case "relax":
                // relax();
                break;  

            case "RunAway":
                RunAway();
                break;

            case "enterTown":
                enterTown();
                break;

            case "fightDarkKnight":
                fightDarkKnight();
                break;

            case "lootDarkKnight":
                lootDarkKnight();
                break;

            case "equipExcalibur":
                equipExcalibur();
                break;

            case "equipWeaponDuringBattle":
                equipWeaponDuringBattle();
                break;

            case "equipSwordThenFight":
                player.equipWeapon("Sword");
                ui.weaponNameLabel.setText(player.currentWeapon.getName());
                ui.showInventory(player.getInventory());
                fightDarkKnight();
                break;

            case "equipBowThenFight":
                player.equipWeapon("Bow");
                ui.weaponNameLabel.setText(player.currentWeapon.getName());
                ui.showInventory(player.getInventory());
                fightDarkKnight();
                break;

            case "equipDaggerThenFight":
                player.equipWeapon("Dagger");
                ui.weaponNameLabel.setText(player.currentWeapon.getName());
                ui.showInventory(player.getInventory());
                fightDarkKnight();
                break;

            case "gameOver":
                gameOver();
                break;

            case "restart":
                game.restartGame();
                break;

            case "exit":
                System.exit(0);
                break;

            case "Filler":
                break;
        }
    }

    public void Forest() {
        ui.mainTextArea.setText(
                "You have spawned in the middle of the Dark Forest.\nAhead of you is small town.\nWhat is your next move?");
        ui.choice1.setText("Head to the town");
        ui.choice2.setText("Head deeper into the forest");
        ui.choice3.setText("Sit and relax. Take in the glorious view.");

        game.nextPosition1 = "townGate";
        game.nextPosition2 = "forestWalk";
        game.nextPosition3 = "Forest";

    }

    public void townGate() {
        if (!darkKnightDefeated) {
            ui.mainTextArea.setText(
                    "You walk towards the large gate that leads to the entrance to the town.\nAs you get closer one of the town guards waves at you. \nGuard: Hello there! I'm surprised you made it out here. Most people fall to the Dark Knight.  \nWelcome to the beginner village.");
            ui.choice1.setText("Go back to the forest");
            ui.choice2.setText("Ask about the knight.");
            ui.choice3.setText("Leave.");

            game.nextPosition1 = "Forest";
            game.nextPosition2 = "townGateTalk";
            game.nextPosition3 = "forestWalk";
        } else {
            ui.mainTextArea.setText(
                    "The Knight sees the Dark Knights redstone in your hand.\n\n" +
                            "Guard: Nice job, you actually did it... You defeated the Dark Knight!\n\n" +
                            "You are now free to enter the town as a hero!");
            ui.choice1.setText("Enter the town");
            ui.choice2.setText("Restart adventure.");
            ui.choice3.setText("");

            game.nextPosition1 = "enterTown";
            game.nextPosition2 = "restart";
            game.nextPosition3 = "";
        }
    }

    public void enterTown() {
        ui.mainTextArea.setText(
                "You step through the gate victorious, the sun shinning on your face as you are ready to take on any challenge ahead of you.");

        ui.choice1.setText("Restart Adventure");
        ui.choice2.setText("Exit Game");

        game.nextPosition1 = "restart";
        game.nextPosition2 = "exit";
    }

    public void forestWalk() {
        ui.mainTextArea.setText(
                "You move deeper into the forest. The trees are tall and block out most of the sunlight.\n" +
                        "After walking for a while you come across a clearing. In the center of the clearing\n " +
                        "stands the Dark Knight, a towering figure clad in dark armor...\n\n" +
                        "Dark Knight: 'Stares at you but you cannot tell if he is looking at you or through you' \n\n" +
                        "What will you do?");
        game.nextPosition1 = "fightDarkKnight";
        game.nextPosition2 = "RunAway";
        game.nextPosition3 = "To be added later (More choices)";

        ui.choice1.setText("Fight the Dark Knight");

    }

    // Combat and other methods

    public void fightDarkKnight() {
        int damageDealt = player.currentWeapon.damage;
        String weaponName = player.currentWeapon.getName();

        // Weak but is better for ranged.
        if (weaponName.equalsIgnoreCase("Bow")) {
            damageDealt -= 5;
        } else if (weaponName.equalsIgnoreCase("Sword")) {
            // Balanced
        } else if (weaponName.equalsIgnoreCase("Axe")) {
            damageDealt += 5; // More powerful
        }

        knightHP -= damageDealt;
        StringBuilder fightText = new StringBuilder();

        fightText.append("You attack the Dark Knight with your ")
                .append(weaponName)
                .append("!\nYou deal ")
                .append(damageDealt)
                .append(" damage.\n\n");

        // ui.mainTextArea.setText(
        // "You charge towards the towering figure!\n" +
        // "You swin your " + player.currentWeapon.getName() + " at the Dark Knight.\n"
        // +
        // "You deal " + damageDealt + " damage to the Dark Knight.\n" +
        // "The Dark Knight has " + (knightHP - damageDealt) + " HP left.");

        if (knightHP > 0) {
            // Enemy counter
            int enemyDamage = (int) (Math.random() * 15 + 10);
            player.HP -= enemyDamage;

            fightText.append("The Dark Knight growls in rage and slashes back!\n")
                    .append("You take ")
                    .append(enemyDamage)
                    .append(" damage!\n\n")
                    .append("Your HP: ")
                    .append(player.HP)
                    .append("\nEnemy HP: ")
                    .append(knightHP);

            ui.mainTextArea.setText(fightText.toString());
            ui.hpNumLabel.setText("" + player.HP);

            if (player.HP <= 0) {
                game.nextPosition1 = "gameOver";
                selectPosition("gameOver");
                return;
            }

            // Fight still going
            ui.choice1.setText("Attack Again");
            ui.choice2.setText("Change Weapon");
            ui.choice3.setText("Retreat");

            game.nextPosition1 = "fightDarkKnight";
            game.nextPosition2 = "equipWeapon";
            game.nextPosition3 = "RunAway";

        } else {

            ui.mainTextArea.setText(
                    "With a final blow, you successfully bring down the Dark Knight!\n" +
                            "He falls to the ground, defeated and reduces to cinder.\n\n" +
                            "You have defeated the Dark Knight!");
            darkKnightDefeated = true;

            ui.choice1.setText("Search the ashen remains");
            ui.choice2.setText("Turn back towards the town gate");
            ui.choice3.setText("");

            game.nextPosition1 = "lootDarkKnight";
            game.nextPosition2 = "townGate";
        }
    }

    public void lootDarkKnight() {
        ui.mainTextArea.setText(
                "As you search the ashes... you notice \n\n" +
                        "a gleaming sword covered in dust. \n\n" + "**The Famed Excalibur**\n\n" +
                        "You hear a ringing noise in your ears as you pick up the sword.\n\n" +
                        "You feel a surge of power coursing through your veins.\n\n" +
                        "Upon picking up the blade, it reverts into a mere gemstone. \n\n");

        ui.choice1.setText("Channel the Excaliburs power");
        ui.choice2.setText("Drop it on the forest floor to remain untainted.");
        ui.choice3.setText("");

        game.nextPosition1 = "equipExcalibur";
        game.nextPosition2 = "townGate";

    }

    public void equipExcalibur() {
        player.addWeapon(WeaponFactory.createExcalibur());
        player.equipWeapon("Excalibur");
        ui.weaponNameLabel.setText(player.currentWeapon.getName());

        ui.mainTextArea.setText(
                "You have earned the Excalibur after defeating the Dark Knight!\n " +
                        "As you grasp the Excalibur, you take a moment to feel how light it feels withing your hands.\n\n"
                        +
                        "This legendary sword is said to possess immense power and is fit for a true hero. \n\n");

        ui.choice1.setText("Head to the town");
        ui.choice2.setText("");
        ui.choice3.setText("");

        game.nextPosition1 = "townGate";
    }

    private void RunAway() {
        ui.mainTextArea.setText(
                "You decide to turn tail and run away from the impending doom.\n" +
                        "As you sprint back towards the safety of the forest edge, \n" +
                        "you note that you cannot hear the Dark Knights foot steps behind you.\n\n" +
                        "Perhaps he is not inclined to chase a fleeing opponent. \n\n" +
                        "You manage to escape back to the forest entrance, your heart racing.\n");

        ui.choice1.setText("Head to the town");
        ui.choice2.setText("Rest for a while");

        game.nextPosition1 = "townGate";
        game.nextPosition2 = "Forest";
    }

    public void gameOver() {
        ui.mainTextArea.setText("You have fallen in battle...\n\nGAME OVER");
        ui.choice1.setText("Restart");
        ui.choice2.setText("Exit");

        game.nextPosition1 = "restart";
        game.nextPosition2 = "exit";
    }

    public void restart() {
        darkKnightDefeated = false;
        knightHP = 50;
        game.restartGame();
        defaultSetUp();

    }

    public void equipWeaponDuringBattle() {
        ui.mainTextArea.setText(
                "You look through your bag...\n" +
                        "Which weapon would you like to equip?");

        ui.choice1.setText("Sword");
        ui.choice2.setText("Bow");
        ui.choice3.setText("Dagger");

        game.nextPosition1 = "equipSwordThenFight";
        game.nextPosition2 = "equipBowThenFight";
        game.nextPosition3 = "equipDaggerThenFight";
    }
}