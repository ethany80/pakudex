/*
Pakudex class creates pakudex objects
used to hold, count, sort, and retrieve
stats on a list of stored pakuris
 */
public class Pakudex
{
    /*
    private members created for the
    capacity and current size of
    the pakudex
    Pakuri array made to hold the
    list of pakuri objects; size of
    array is set to default capacity,
    or that entered by user
     */
    private int capacity, size = 0;
    Pakuri[] pakuriArr;
    /*
    default constructor sets capacity
    to 20 and creates pakuri array
     */
    public Pakudex()
    {
        this.capacity = 20;
        pakuriArr = new Pakuri[capacity];
    }
    /*
    custom constructor allows user to
    set capacity when creating pakudex
    and creates pakuri array
     */
    public Pakudex(int capacity)
    {
        this.capacity = capacity;
        pakuriArr = new Pakuri[capacity];
    }
    /*
    following two getter methods alow
    size and capacity to be retrieved
     */
    public int getSize()
    {
        return size;
    }

    public int getCapacity()
    {
        return capacity;
    }
    /*
    method creates an array of Strings
    for the species names in the pakudex
    and returns this array
     */
    public String[] getSpeciesArray()
    {
        /*
        returns null if no pakuri is
        in pakudex yet
         */
        if (size == 0)
        {
            return null;
        }
        /*
        sets each element of string array
        equal to the name of the pakuri at
        the same index in the pakuri object
        array
         */
        else
        {
            String[] speciesArr = new String[size];

            for (int i = 0; i < size; ++i)
            {
                speciesArr[i] = pakuriArr[i].getSpecies();
            }

            return speciesArr;
        }
    }
    /*
    method creates an integer array
    to store and return the stats for
    a user-picked pakuri in the pakudex
     */
    public int[] getStats(String species)
    {
        /*
        for loop first searches for the
        user chosen pakuri in the pakuri
        array, then fills the stats array
        once found
         */
        for (int i = 0; i < size; ++i)
        {
            if (pakuriArr[i].getSpecies().equals(species))
            {
                int[] stats = new int[3];
                stats[0] = pakuriArr[i].getAttack();
                stats[1] = pakuriArr[i].getDefense();
                stats[2] = pakuriArr[i].getSpeed();
                return stats;
            }
        }

        return null;
    }
    /*
    method sorts the pakuri array in
    lexicographical order with use
    of the compareTo function from the
    pakuri class
     */
    public void sortPakuri()
    {
        /*
        nested for loop used to check
        each index of the pakuri array
        against all others beyond it
         */
        for (int i = 0; i < size - 1; ++i)
        {
            int minIndex = i;

            for (int j = i + 1; j < size; ++j)
            {
                if (pakuriArr[j].compareTo(pakuriArr[minIndex]) < 0)
                {
                    minIndex = j;
                }
            }
            /*
            if one pakuri is found to be less
            than that of the current outter for
            loop iteration/index (using compareTo
            from pakuri class), the two pakuris
            swap places in the pakuri array
             */
            Pakuri temp = pakuriArr[i];
            pakuriArr[i] = pakuriArr[minIndex];
            pakuriArr[minIndex] = temp;
        }
    }
    /*
    if possible, this method stores
    a new pakuri in the pakudex and
    updates the size
     */
    public boolean addPakuri(String species)
    {
        /*
        if pakuri already exists in the
        pakudex, based on name, method
        returns false
         */
        for (int i = 0; i < size; ++i)
        {
            if (species.equals(pakuriArr[i].getSpecies()))
            {
                return false;
            }
        }
        /*
        method returns true and pakuri
        is created and stored in pakuriArr
        if pakuri does not already exist
        in pakudex
         */
        pakuriArr[size] = new Pakuri(species);
        ++size;

        return true;
    }
    /*
    if the user entered pakuri exists
    in the pakudex, based on species
    name, that pakuri is evolved
     */
    public boolean evolveSpecies(String species)
    {
        for (int i = 0; i < size; ++i)
        {
            if (species.equals(pakuriArr[i].getSpecies()))
            {
                pakuriArr[i].evolve();
                return true;
            }
        }

        return false;
    }

}
