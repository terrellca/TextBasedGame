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


    public void Forest()
    {
        ui.mainTextArea.setText("You have spawned in the middle of the Dark Forest.\nAhead of you is small town.\n What is your next move?");

    }
}