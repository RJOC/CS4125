/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelLayer.DataAccess;

import ModelLayer.Data;

/**
 *
 * @author Jono
 */
public interface DBReadBroker {
    public Data readFromDB(String instruction, String keyWords);
}
