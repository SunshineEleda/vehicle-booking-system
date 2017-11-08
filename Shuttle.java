import java.util.*;

/**
 * A shuttle.
 * Shuttles have a unique ID, a location and a list of destinations.
 * They operate a circular route.
 * 
 * @author  Adele Kufour
 * @version 2017.01.16
 */
public class Shuttle extends Vehicle
{
    // The circular route of this shuttle.
    private ArrayList<String> route;
    // The destination number in route that the shuttle is
    // currently headed for.
    private int destinationNumber;

    /**
     * Constructor for objects of class Shuttle
     * @param id This shuttle's unique id.
     * @param route The route taken by this shuttle.
     *              The first entry is the starting location.
     */
    public Shuttle(String id, String base, ArrayList<String> route)
    {
        super(id, base);
        setRoute(route);
    }

    /**
     * Indicate that this shuttle has arrived at its next destination.
     */
    public void arrived()
    {
        super.arrived();
        setNextDestination();
    }
    
    /**
     * Set the next destination of the shuttle.
     */
    private void setNextDestination()
    {
        destinationNumber++;
        if(destinationNumber >= route.size()) {
            // End of the circular route.
            // Start from the beginning again.
            destinationNumber = 0;
        }
        super.setDestination(route.get(destinationNumber));
    }
    
    public String nextDestination()
    {
        Iterator<String> it = route.iterator();
        String nextDestination = null;
        boolean found = false;
        while(!found && it.hasNext()) {
            nextDestination = it.next();
            found = true;
            return nextDestination;
        }
        return nextDestination;
    }
    
    /**
     * Set the route for this shuttle.
     * @param route The circular list of destinations.
     */
    private void setRoute(ArrayList<String> route)
    {
        // Make a copy of the list parameter.
        
        String location = getLocation();
        String destination = getDestination();
        
        this.route = new ArrayList<String>();
        this.route.addAll(route);
        destinationNumber = 0;
        location = route.get(destinationNumber);
        setNextDestination();
    }
}
