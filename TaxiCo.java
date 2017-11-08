import java.util.*;

/**
 * A Taxi Company manages a fleet of taxis and shuttles.
 * Taxis move between single destinations.
 * Shuttles move around circular routes.
 * 
 * @author  Adele Kufour
 * @version 2017.01.16
 */
public class TaxiCo
{
    // The name of this company.
    private String companyName;
    // The name of the company's base.
    private final String base;    
    // A value for allocating taxi ids.
    private int nextID;
    // A list of available destinations for shuttles.
    private ArrayList<String> destinations;
    //the fleet of all vehicles
    private ArrayList<Vehicle> vehicles;

    /**
     * Constructor for objects of class TaxiCo.
     * @param name The name of this company.
     */
    public TaxiCo(String name)
    {
        companyName = name;
        base = "base";
        vehicles = new ArrayList<Vehicle>();
        nextID = 1;
        destinations = new ArrayList<String>();
        fillDestinations();
    }
    
    /**
     * Record that we have a new vehicle
     * A unique ID will be allocated.
     * @param add a type of vehicle already on the work bench.
     */
    public void addVehicle(Vehicle vehicle)
    {
        vehicles.add(vehicle);
    }
    
    /**
     * Record that we have a new vehicle
     * A unique ID will be allocated.
     * @param the type of vehicle one wants to be added to vehicle.
     */
    public void addVehicle(String vehicle)
    {
        if (vehicle.equals("shuttle") ) {
           // Sanity warning:
           // The following is a thoroughly contrived way to create a route!
        
           // Create a random list of destinations for its route.
           Collections.shuffle(destinations);
           ArrayList<String> route = new ArrayList<String>();
           // The starting point is always the base.
           route.add(base);
           // Decide on an (arbitrary) length for all routes.
           final int ROUTE_LENGTH = 7;
           for(int i = 0; i < ROUTE_LENGTH; i++) {
               route.add(destinations.get(i));
           }
        
           Shuttle shuttle = new Shuttle("Shuttle #" + nextID, "HQ", route);
           vehicles.add(shuttle);
           // Increment the ID for the next one.
           nextID++;
       } else if (vehicle.equals("taxi")) {
           Taxi taxi = new Taxi("HQ", "Car #" + nextID);
           vehicles.add(taxi);
           // Increment the ID for the next one.
           nextID++;
       }
    }
    
    /**
     * Return the vehicle with the given id.
     * @param id The id of the vehicle to be returned.
     * @return The matching vehicle, or null if no match is found.
     */
    public Vehicle lookup(String id)
    {
        boolean found = false;
        Vehicle vehicle = null;
        Iterator<Vehicle> it = vehicles.iterator();
        while(!found && it.hasNext()) {
            vehicle = it.next();
            if(id.equals(vehicle.getID())) {
                found = true;
            }
        }
        if(found) {
            return vehicle;
        }
        else {
            return null;
        }
    }
    
    /**
     * Book a vehicle to the customer's required destination.
     * Shuttles will be checked first because they are priority
     * If the next destination of the shuttle matches that of customer, shuttle will be booked
     * If no shuttle is found then a taxi will be booked.
     * @param name of the destination the customer wnts to go to
     * @return preferably a shuttle, if not then a taxi
     */
    public Vehicle book(String destination)
    {
        boolean found = false;
        boolean booked = false;
        Vehicle vehicle = null;
        Iterator<Vehicle> it = vehicles.iterator();
        while(!found && it.hasNext()) {
           vehicle = it.next();
            for (Vehicle vehic: vehicles) {
            if(vehic instanceof Shuttle) {
                Shuttle shuttle = (Shuttle) vehic;
                if (destination.equals(shuttle.getDestination())) {
                    found = true;
                }
            }
           }
            
           if (vehicle instanceof Taxi){
                 Taxi taxi = (Taxi) vehicle;
                 if (!(vehicle.getDestination() == null)) {
                        found = false;
                    } else if (vehicle.getDestination() == null){
                        taxi.book(destination);
                        found = true;
                        booked = true;
                   }
           }
        }
        if(found) {
            return vehicle;
        }
        else {
            return null;
        }
    }
    
    /**
     * Show the status of the fleet of taxis and shuttles. 
     */
    public void showStatus()
    {
        System.out.println("Current status of the " + companyName + " fleet");
        for(Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getStatus());
        }
    }
    
    /**
     * Put all the possible shuttle destinations in a list.
     */
    private void fillDestinations()
    {
        destinations.add("Canterbury West");
        destinations.add("Canterbury East");
        destinations.add("The University");
        destinations.add("Whitstable");
        destinations.add("Herne Bay");
        destinations.add("Sainsbury's");
        destinations.add("Darwin");
    }
}