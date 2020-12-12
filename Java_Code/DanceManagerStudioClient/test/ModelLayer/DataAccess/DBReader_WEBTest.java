/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLayer.DataAccess;

import ModelLayer.Data;
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
        String keyWords = "student1";
        DBReader_WEB instance = new DBReader_WEB();
        Data expResult = new Data();
        expResult.setDataName("Student");
        Data result = instance.readFromDB(instruction, keyWords);
        assertEquals(expResult.getDataName(), result.getDataName());
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    
}
