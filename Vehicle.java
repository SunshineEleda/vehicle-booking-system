import java.util.Iterator;
/**
 * This class stores information about all the vehicles in the fleet
 * 
 * @author Adele Kufour
 * @version 1/1/2017
 */
public class Vehicle
{
    // the unique ID of the vehice
    private String id;
     // The next destination of the vehicle.
    private String destination;
    // The location of the vehicle.
    private String location;

    /**
     * Constructor for objects of class Vehicle
     * @param id The vehicle's unique id.
     */
    public Vehicle(String id, String base)
    {
        // initialise instance variables
        this.id = id;
        destination = null;
        location = base;
    }

      /**
     * Return the location of the vehicle.
     * @return The location of the vehicle.
     */
    public String getLocation()
    {
        return location;
    }
    
    /**
     * A method whch returns he ID of the vehicle
     * @return The id of the vehicle.
     */
    public String getID()
    {
        return id;
    }
    
    /**
     * Return the destination of the vehicle.
     * @return The destination of the vehicle.
     */
    public String getDestination()
    {
        return destination;
    }
    
     /**
     * Set the intented destination of the vehicle.
     * @param destination The intended destination.
     */
    public void setDestination(String destination)
    {
        this.destination = destination;
    }
    
     /**
     * Return the status of the vehicle.
     * @return The status.
     */
    public String getStatus()
    {
        return id + " at " + location + " headed for " + destination;
    }
    
    /**
     * Indicate that this vehicle has arrived at its destination.
     * As a result, if it is a taxi it will be free.
     * If it is a shuttle it will go to the next location
     */
    public void arrived()
    {
        location = destination;
    }
}
