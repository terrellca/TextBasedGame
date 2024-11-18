package package1;

import package2.Weapon;
import java.util.List;
import java.util.ArrayList;

public class Player
{
    //Weapon and HP
    public int HP;
    public Weapon currentWeapon;
    public List<Weapon> inventory;
    

    public Player()
    {
        this.HP = 100;
        this.inventory = new ArrayList<>();
    }

    public void addWeapon(Weapon weapon)
    {
        inventory.add(weapon);
        System.out.println(weapon.getName() + " added to inventory");
    }


    public void equipWeapon(String weaponName)
    {
        for (Weapon weapon : inventory)
        {
            if(weapon.getName().equals(weaponName))
            {
                currentWeapon = weapon;
                System.out.println(weaponName + " is now equiped");
                break;
            }
            else
            {
                System.out.println("Weapon is not in inventory");
            }
        }
       
    }


    public void displayInventory()
    {
        System.out.println("Player inventory");
        for (Weapon weapon : inventory)
        {
            System.out.println(weapon.getName() + "Damage: " + weapon.getDmg());
        }
    }
}