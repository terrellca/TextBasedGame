package package2;

public class Weapon //If I am going to change this to items, I can use the same arraylist and just list off the other items.
{
    public String name;
    public int damage;    
    public double weight;

    public Weapon(String name, int damage, double weight)
    {
        this.name = name;
        this.damage = damage;
        this.weight = weight;
    }



    public String getName()
    {
        return name;
    }

    public int getDmg()
    {
        return damage;
    }

    public double getWeight()
    {
        return weight;
    }

    /*
     * public String toString()
    {
        return name + 
    }
     * 
     */
    

}