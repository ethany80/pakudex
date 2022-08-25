/*
Pakuri class creates pakuri objects;
each object is a pakuri, and can hold
the diffrent information on the creature
 */
public class Pakuri
{
    /*
    private members created for name
    of species, and fighting statistics
     */
    private String species;
    private int attack, defense, speed;
    /*
    constructor sets stats based on
    pakuri name length; 'this' keyword
    used to ensure variable refers to
    the current object, rather than the
    method parameter
     */
    public Pakuri(String species)
    {
        this.species = species;
        attack = (species.length() * 7) + 9;
        defense = (species.length() * 5) + 17;
        speed = (species.length() * 6) + 13;
    }
    /*
    following four methods are
    getters used to retrieve species
    name and stats
     */
    public String getSpecies()
    {
        return species;
    }

    public int getAttack()
    {
        return attack;
    }

    public int getDefense()
    {
        return defense;
    }

    public int getSpeed()
    {
        return speed;
    }
    /*
    setter method allows user to
    set new attack stat for pakuri
     */
    public void setAttack(int newAttack)
    {
        attack = newAttack;
    }
    /*
    method allows user to "evolve"
     */
    public void evolve()
    {
        attack *= 2;
        defense *= 4;
        speed *= 3;
    }
    /*
    compareTo method compares this
    object to target object based on
    the species name strings. comparison
    uses same lexicographical ordering
     */
    public int compareTo(Pakuri target)
    {
        return this.species.compareTo(target.getSpecies());
    }
}
