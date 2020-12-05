/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLayer.DataAccess;

import ModelLayer.CustomDataType;


/**
 *
 * @author Jono
 */
public interface DBWriteBroker {
    public void writeToDB(String instruction, CustomDataType data);
}
