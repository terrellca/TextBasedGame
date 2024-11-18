package package2;



public class WeaponFactory
{
    public static Weapon createSword()
    {
        return new Weapon("Sword", 16, 12.5);
    }

    public static Weapon createBow()
    {
        return new Weapon("Bow", 14,10);
    }


    public static Weapon createExcalibur()
    {
        return new Weapon("Excalibur", 50, 15.5);
    }
}