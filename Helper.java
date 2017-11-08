import java.util.*;

/**
 * The test class Helper.
 * Provides the beginning of a set of tests for program development.
 *
 * @author  Adele Kufour
 * @version 2017.01.16
 */
public class Helper extends junit.framework.TestCase
{
	private TaxiCo taxiCo1;

    /**
     * Default constructor for test class Helper
     */
    public Helper()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp()
    {
        taxiCo1 = new TaxiCo("djb's cars");
		taxiCo1.addVehicle("shuttle");
		taxiCo1.addVehicle("taxi");
		taxiCo1.addVehicle("taxi");
	}

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown()
    {
    }
    
    /**
     * Test the if the id and location fields moved to Vehicle work
     */
    public void testFields()
    {
        Shuttle shuttle1 = (Shuttle) taxiCo1.lookup("Shuttle #1"); //id
        assertNotNull(shuttle1);
        assertEquals("HQ", shuttle1.getLocation()); //location
    }

    /**
     * Test whether we can make a booking
     */
	public void testBook()
	{
	    Taxi taxi1 = (Taxi) taxiCo1.lookup("Car #2");
		assertNotNull(taxi1);
		taxiCo1.book("ASDA");
		assertEquals("ASDA", taxi1.getDestination());
	}
	
	/**
	 * Test that the polymorphism used to create the vehicle list works
	 */
	public void testAddVehicle()
	{
	    Shuttle shuttle1 = (Shuttle) taxiCo1.lookup("Shuttle #1");
	    taxiCo1.addVehicle(shuttle1);
	}
	   
	/**
	 * Test the status of a taxi after it has arrived.
	 */
	public void testArrived()
	{
		Taxi taxi1 = (Taxi) taxiCo1.lookup("Car #2");
		assertNotNull(taxi1);
		taxiCo1.book("ASDA");
		taxi1.arrived();
		assertNull(taxi1.getDestination());
		assertEquals("ASDA", taxi1.getLocation());
		//check if it can be booked again, to check the boolean free.
		taxi1.book("Tesco");
		assertEquals("Tesco", taxi1.getDestination());
	}
}