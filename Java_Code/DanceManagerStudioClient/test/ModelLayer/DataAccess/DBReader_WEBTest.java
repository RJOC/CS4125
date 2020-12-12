/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLayer.DataAccess;

import ModelLayer.Data;
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
public class DBReader_WEBTest {
    
    public DBReader_WEBTest() {
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
     * Test of readFromDB method, of class DBReader_WEB.
     */
    @org.junit.Test
    public void testReadFromDB() {
        System.out.println("readFromDB");
        String instruction = "GetUser";
        String keyWords = "jono123";
        DBReader_WEB instance = new DBReader_WEB();
        Data expResult = new Data();
        expResult.setDataName("Manager");
        
        Data result = instance.readFromDB(instruction, keyWords);
        assertEquals(expResult.getDataName(), result.getDataName());
        
        expResult.getData().add(new ArrayList<>());
        
        /// int uID, String uName, String firstName, String lastName
        expResult.getData().get(0).add("");
        expResult.getData().get(0).add("jono123");
        expResult.getData().get(0).add("Jono");
        expResult.getData().get(0).add("pp");
        
        assertEquals(expResult.getData().get(0).get(1), result.getData().get(0).get(1));
        

        
        
        
        
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    
}
