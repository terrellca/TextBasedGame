package package1;

import package2.Sword;

public class Story
{

Game game;
UI ui;
VisibilityManager vm;
Player player = new Player();

    public Story(Game g, UI useri, VisibilityManager visib)
    {   
        this.game = g;
        this.ui = useri;
        this.vm = visib;

    }

    public void defaultSetUp()
    {
        player.HP = 10;
        ui.hpNumLabel.setText("" + player.HP);

        player.currentWeapon = new Sword();
        ui.weaponNameLabel.setText(player.currentWeapon.name);
    }


}