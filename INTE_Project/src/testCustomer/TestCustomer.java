package testCustomer;

import project.Customer;
import project.Product;
import project.Receipt;

import org.junit.Before;
import org.junit.Test;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nicklas on 2015-10-14.
 * test?
 */
public class TestCustomer {
    @Test
    public void testPersonnr(){
        Customer c = new Customer("198001013310","Namn Efternamn", "Gata", "nr", true);
        assertEquals("198001013310",c.getPersonnr());
    }

    @Test
    public void testPersonnrTen(){
        Customer c = new Customer("9001013318","Namn Efternamn", "Gata", "nr", true);
        assertEquals("9001013318",c.getPersonnr());
    }

    @Test (expected = Exception.class)
    public void testPersonnrDateValidityInvalidDay(){
        new Customer("9503359995","Namn Efternamn","Gata","nr",true);
    }

    @Test (expected = Exception.class)
    public void testPersonnrDateValidityInvalidMonth(){
        new Customer("9214259997","Namn Efternamn","Gata","nr",true);
    }

    @Test
    public void testPersonnrDateValidityLeapYear(){
        new Customer("8402299997","Namn Efternamn","Gata","nr",true);
    }

    @Test (expected = Exception.class)
    public void testPersonnrDateValidityNotLeapYear(){
        new Customer("8302299998","Namn Efternamn","Gata","nr",true);
    }

    @Test
    public void testPersonnrChecksumValid(){
        Customer c = new Customer("8112189876","Namn Efternamn", "Gata", "nr", true);
        assertEquals(true,c.validChecksum(c.getPersonnr()));
    }

    @Test
    public void testPersonnrChecksumInvalid(){
        Customer c = new Customer("8112189877","Namn Efternamn", "Gata", "nr", true);
        assertEquals(false,c.validChecksum(c.getPersonnr()));
    }

}
