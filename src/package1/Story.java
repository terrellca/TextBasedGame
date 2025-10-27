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

            case "fightGoblin":
                fightDarkKnight();
                break;

            case "lootGoblin":
                lootDarkKnight();
                break;

            case "equipExcalibur":
                equipExcalibur();
                break;

            case "gameOver":
                gameOver();
                break;

            case "restart":
                restart();
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

        if (weaponName.equalsIgnoreCase("Bow")) {
            damageDealt -= 5; // Less damage
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
        //         "You charge towards the towering figure!\n" +
        //                 "You swin your " + player.currentWeapon.getName() + " at the Dark Knight.\n" +
        //                 "You deal " + damageDealt + " damage to the Dark Knight.\n" +
        //                 "The Dark Knight has " + (knightHP - damageDealt) + " HP left.");

         if (knightHP > 0) {
        // Enemy counterattacks
        int enemyDamage = (int)(Math.random() * 15 + 10); // 10–25 dmg
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

            // Fight still going
            ui.choice1.setText("Swing Again");
            ui.choice2.setText("Change Weapon");
            ui.choice3.setText("Retreat");

            game.nextPosition1 = "fightDarkKnight";
            game.nextPosition2 = "equipWeapon";
            game.nextPosition3 = "forestWalk";

        } else {
           
            ui.mainTextArea.setText(
                    "With a final blow, you successfully bring down the Dark Knight!\n" +
                            "He falls to the ground, defeated and becomes ash.\n\n" +
                            "You have defeated the Dark Knight!");
                            darkKnightDefeated = true;
            
            ui.choice1.setText("Search the ashen remains");
            ui.choice2.setText("Turn back towards the town gate");
            ui.choice3.setText("");

        }

    }

    public void lootDarkKnight() {
    }

    public void equipExcalibur() {
    }

    public void gameOver() {
    }

    public void restart() {
    }

    public void equipWeaponDuringBattle() {
        ui.mainTextArea.setText(
                "You quickly rummage through your bag...\n" +
                        "Which weapon do you want to equip?");

        ui.choice1.setText("Sword");
        ui.choice2.setText("Bow");
        ui.choice3.setText("Axe");

        game.nextPosition1 = "equipSwordThenFight";
        game.nextPosition2 = "equipBowThenFight";
        game.nextPosition3 = "equipAxeThenFight";
    }
}