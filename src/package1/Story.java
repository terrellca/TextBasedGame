package package1;

import package2.WeaponFactory;

public class Story
{

Game game;
UI ui;
VisibilityManager vm;
Player player;

    public Story(Game g, UI useri, VisibilityManager visib, Player player)
    {   
        this.game = g;
        this.ui = useri;
        this.vm = visib;
        this.player = player;

    }

    public void defaultSetUp()
    {
        player.HP = 100;
        ui.hpNumLabel.setText("" + player.HP);

        player.addWeapon(WeaponFactory.createSword());
        player.addWeapon(WeaponFactory.createBow());
        player.equipWeapon("Sword");
        ui.weaponNameLabel.setText(player.currentWeapon.getName());
    }


    public void selectPosition(String nextPosition)
    {
        switch(nextPosition){

            case "Forest":
            Forest();
            break;

            case "townGate":
            townGate();
            break;

            case "forestWalk":
            forestWalk();
            break;


            case "Filler":
            break;
        }
    }

    public void Forest()
    {
        ui.mainTextArea.setText("You have spawned in the middle of the Dark Forest.\nAhead of you is small town.\nWhat is your next move?");
        ui.choice1.setText("Head to the town");
        ui.choice2.setText("Head deeper into the forest");
        ui.choice3.setText("Filler");

        game.nextPosition1 = "townGate";
        game.nextPosition2 = "forestWalk";
        game.nextPosition3 = "";

    }

    public void townGate()
    {
        ui.mainTextArea.setText("You walk towards the large gate that leads to the entrance to the town.\nAs you get closer one of the town guards waves at you. \nGuard: Hello there! \nWelcome to the beginner village.");
        ui.choice1.setText(">");
        ui.choice2.setText("Testing");
        ui.choice3.setText("");

        game.nextPosition1 = "Forest";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
    }

    public void forestWalk()
    {
        
    }

    /*
    * Edit when needed.
    *public void Filler()
    {    }
     */


}