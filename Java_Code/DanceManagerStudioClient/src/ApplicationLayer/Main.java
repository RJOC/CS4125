/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationLayer;

import ModelLayer.ApplicationModel;
import dancemanagerstudioclient.DanceManagerStudioClient;
import java.io.IOException;

public class Main {
     /**
     * @param args the command line arguments
     * Main method:
     *      
     */
    public static void main(String[] args) throws IOException {

        ApplicationLogic logic = new ApplicationLogic();
        /// will need to pass logic to view layer
        DanceManagerStudioClient myInstance = new DanceManagerStudioClient(logic);
    
    }
}
