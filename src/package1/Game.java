package package1;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import package2.Weapon;

public class Game {

    ChoiceHandler cHandler = new ChoiceHandler();

    UI ui = new UI();
    Player player = new Player();
    VisibilityManager vm = new VisibilityManager(ui, player);
    Story story = new Story(this, ui, vm, player);

    String nextPosition1, nextPosition2, nextPosition3;

    public Game() {
        ui.createUI(cHandler); // Calls method to create UI
        story.defaultSetUp();
        vm.showTitleScreen(); // Displays Title.
    }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();

            switch (yourChoice) {
                case "start":
                    vm.showGameScreen();
                    story.Forest();
                    break;

                case "c1":
                    story.selectPosition(nextPosition1);
                    break;

                case "c2":
                    story.selectPosition(nextPosition2);
                    break;

                case "c3":
                    story.selectPosition(nextPosition3);
                    break;

                case "inventory":
                    if (ui.inventoryScrollPane.isVisible()) {
                        ui.inventoryScrollPane.setVisible(false);
                    } else {
                        ui.showInventory(player.getInventory()); // inventory check
                        ui.inventoryScrollPane.setVisible(true);
                    }
                    // vm.showInventoryScreen();
                    break;

                case "equipWeapon":
                    story.equipWeaponDuringBattle();
                    break;

                case "equipSword":
                    ui.showInventory(player.getInventory());
                    if (player.currentWeapon != null) {
                        ui.weaponNameLabel.setText(player.currentWeapon.getName());
                    }
                    story.fightDarkKnight();
                    break;

                default:
                    break;

            }
        }
    }

    public void restartGame() {
        player = new Player();
        story = new Story(this, ui, vm, player);
        story.defaultSetUp();
        vm.showTitleScreen();

        ui.showInventory(player.getInventory());
        if (player.currentWeapon != null) {
            ui.weaponNameLabel.setText(player.currentWeapon.getName());
        } else {
            ui.weaponNameLabel.setText("None");
        }
    }

    public static void main(String[] args) {
        new Game();
    }

}