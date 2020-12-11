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
        
        instance.setData(expResult);
        ArrayList<ArrayList<String>> result = instance.getData();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getDataName method, of class Data.
     */
    @org.junit.Test
    public void testGetDataName() {
        System.out.println("getDataName");
        Data instance = new Data();
        String expResult = "EmptyDataObject";
        String result = instance.getDataName();
        assertEquals(expResult, result);
    }

    /**
     * Test of dataType method, of class Data.
     */
    @org.junit.Test
    public void testDataType() {
        System.out.println("dataType");
        Data instance = new Data();
        String expResult = "Data";
        String result = instance.dataType();
        assertEquals(expResult, result);
    }
    
}
