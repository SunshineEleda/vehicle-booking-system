/**
 * A taxi.
 * Taxis have a unique ID, a location and sometimes a destination.
 * They are either free or occupied.
 * 
 * @author  Adele Kufour
 * @version 2017.01.16
 */
public class Taxi extends Vehicle
{
    // Whether it is free or not.
    private boolean free;

    /**
     * Constructor for objects of class Taxi.
     * @param base The name of the company's base.
     * @param id This taxi's unique id.
     */
    public Taxi(String base, String id)
    {
        super(id, base);
        free = true;
    }
    
    /**
     * Book this taxi to the given destination.
     * The status of the taxi will no longer be free.
     * @param destination The taxi's destination.
     */
    public void book(String destination)
    {
        if (free = true) {
            setDestination(destination);            
        } else {
            System.out.println("This taxi is booked, try again");
        }
    }

    /**
     * Indicate that this taxi has arrived at its destination.
     * As a result, it will be free.
     */
    public void arrived()
    {
        super.arrived();
        super.setDestination(null);
        System.out.println("This taxi is available to be booked");
        free = true;
    }
}
