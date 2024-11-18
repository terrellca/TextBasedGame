package package1;



public class VisibilityManager{

    UI ui;
    Player player;
    
    public VisibilityManager(UI userInter)
    {
        ui = userInter;
    }
    public void showTitleScreen()
    {
        ui.titleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);



        //Hide game screen
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonpanel.setVisible(false);
        ui.playerPanel.setVisible(false);
        
    }

    public void showGameScreen()
    {
        //Hide
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);



        //SHow game screen
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonpanel.setVisible(true);
        ui.playerPanel.setVisible(true);
    }

    public void showInventoryScreen()
    {
        if(ui.inventoryScrollPane.isVisible())
        {
            ui.inventoryScrollPane.setVisible(false);
        }
        else{

            ui.inventoryScrollPane.setVisible(true);
            
        }
        

    }

}