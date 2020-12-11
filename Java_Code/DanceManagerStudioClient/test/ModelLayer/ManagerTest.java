/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLayer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jono
 */
public class ManagerTest {
    
    public ManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFirstName method, of class Manager.
     */
    @org.junit.Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        Manager instance = new Manager();
        String expResult = "Unknown";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastName method, of class Manager.
     */
    @org.junit.Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Manager instance = new Manager();
        String expResult = "Unknown";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }
}
