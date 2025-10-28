package package1;

import javax.swing.JOptionPane;

import package2.WeaponFactory;

public class Story {

    Game game;
    UI ui;
    VisibilityManager vm;
    Player player;

    int knightHP = 150;

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

            case "townGateTalk":
                townGateTalk();
                break;

            case "forestWalk":
                forestWalk();
                break;

            case "sneakPast":
                sneakPast();
                break;

            case "relax":
                relaxInForest();
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
        game.nextPosition3 = "relax";

    }

    private void relaxInForest() {

        player.HP += 10; // permenent health boost
        if (player.HP > 110) {
            player.HP = 110; // HP cannot exceed 110.

            JOptionPane.showMessageDialog(null,
                    "You are already at full health!\nYour HP will not increase further.",
                    "Health Maxed",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "You feel rested and gain +10 HP!",
                    "Rest Successful",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        ui.hpNumLabel.setText("" + player.HP);

        ui.mainTextArea.setText("You take a moment to sit down and relax in the serene environment of the forest.\n"
                + "The calming nature of the forest with sun lightly shining down upon you through the leaves of the towering trees.\n"
                + "As you close your eyes and take a deep breath, you feel a sense of calm wash over you.\n\n"
                + "After a while, you feel rejuvenated and ready to continue your adventure."
                + "Your HP has increased by +10!");

        ui.choice1.setText("Head to the town");
        ui.choice2.setText("Explore deeper into the forest");
        ui.choice3.setText("Relax some more (Will not increase HP Further!)");

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
                    "The Guard sees the Dark Knights ember stone in your hand.\n\n" +
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

    public void townGateTalk() {
        ui.mainTextArea.setText(
                "Guard: The Dark Knight appeared a few weeks ago... No one who enters the forest returns.\n" +
                        "If you plan to face him, make sure you're prepared.");
        ui.choice1.setText("Return to the gate");
        ui.choice2.setText("Head back to the forest");
        ui.choice3.setText("");

        game.nextPosition1 = "townGate";
        game.nextPosition2 = "forestWalk";
        game.nextPosition3 = "";
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
        game.nextPosition3 = "sneakPast";

        ui.choice1.setText("Fight the Dark Knight");
        ui.choice2.setText("Retreat back to the forest entrance");
        ui.choice3.setText("Try to sneak past him");

    }

    public void sneakPast() {
        ui.mainTextArea.setText(
                "You try to sneak around the Dark Knight... but he senses your presence.\n" +
                        "You have no choice but to fight!");

        ui.choice1.setText("Fight!");
        ui.choice2.setText("Run Away!");
        ui.choice3.setText("");

        game.nextPosition1 = "fightDarkKnight";
        game.nextPosition2 = "RunAway";
        game.nextPosition3 = "";
    }

    // Combat and other methods

    public void fightDarkKnight() {
        int baseDmg = player.currentWeapon.damage;
        String weaponName = player.currentWeapon.getName();

        // Weak but is better for ranged.
        if (weaponName.equalsIgnoreCase("Bow")) {
            baseDmg -= 14;
        } else if (weaponName.equalsIgnoreCase("Sword")) {

        } else if (weaponName.equalsIgnoreCase("Dagger")) {
            baseDmg += 10;
        } else if (weaponName.equalsIgnoreCase("Excalibur")) {
            baseDmg += 25;
        }

        boolean hit = Math.random() < 0.20;

        boolean crit = Math.random() < 0.15;

        int damageDealt = 0;

        // knightHP -= damageDealt;
        StringBuilder fightText = new StringBuilder();

        fightText.append("You attack the Dark Knight with your ").append(weaponName).append("!\n");

        if (hit) {
            damageDealt = baseDmg;

            if (crit) {
                damageDealt *= 2;
                fightText.append("Critical hit! You find a weak point!\n");
            }

            // apply damage
            knightHP -= damageDealt;

            fightText.append("You deal ").append(damageDealt).append(" damage!\n");

            // specific weapon dmg response
            if (weaponName.equalsIgnoreCase("Bow")) {
                fightText.append("Your arrow pierces through the Dark Knight’s armor!\n");

            } else if (weaponName.equalsIgnoreCase("Sword")) {
                fightText.append("You swing and hit your mark dealing a good amount of damage!\n");

            } else if (weaponName.equalsIgnoreCase("Dagger")) {
                fightText.append("You move swiftly and use your dagger.\n");

            } else if (weaponName.equalsIgnoreCase("Excalibur")) {

                fightText.append("Excalibur radiates with dark energy, burning through the armor!\n");
            }

        } else {
            fightText.append("You have missed! The Dark Knight is not affected by your attack.\n");
        }

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

            if (player.HP <= 20) {
                fightText.append("\n\nYour health is critically low. You may need to retreat or change your weapon.");
            }

            ui.mainTextArea.setText(fightText.toString());
            ui.hpNumLabel.setText("" + player.HP);

            // defeat
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
            game.nextPosition2 = "equipWeaponDuringBattle";
            game.nextPosition3 = "RunAway";

        } else {
            // victory
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
        knightHP = 150;
        game.restartGame();

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