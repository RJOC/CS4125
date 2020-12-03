/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLayer;

import java.util.ArrayList;
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
public class DataTest {
    
    public DataTest() {
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
     * Test of getData method, of class Data.
     */
    @org.junit.Test
    public void testGetData() {
        System.out.println("getData");
        Data instance = new Data();
        ArrayList<ArrayList<String>> expResult = null;
        ArrayList<ArrayList<String>> result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setData method, of class Data.
     */
    @org.junit.Test
    public void testSetData() {
        System.out.println("setData");
        ArrayList<ArrayList<String>> data = null;
        Data instance = new Data();
        instance.setData(data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataName method, of class Data.
     */
    @org.junit.Test
    public void testGetDataName() {
        System.out.println("getDataName");
        Data instance = new Data();
        String expResult = "";
        String result = instance.getDataName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataName method, of class Data.
     */
    @org.junit.Test
    public void testSetDataName() {
        System.out.println("setDataName");
        String dataName = "";
        Data instance = new Data();
        instance.setDataName(dataName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dataType method, of class Data.
     */
    @org.junit.Test
    public void testDataType() {
        System.out.println("dataType");
        Data instance = new Data();
        String expResult = "";
        String result = instance.dataType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
