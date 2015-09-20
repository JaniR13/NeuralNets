/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runmodels;

/**
 *
 * @author Janette
 */
public abstract class AbstractModel {
    public AbstractModel(){
        
    }
    public void importData(){
     //Get data from wherever   
    }
    public void exportResults(){
     //put comma separated values in a CSV file
    }
    
    abstract void compileResults();//assemble results in desired comma separated value format
    abstract void execute();//run the model
    
}
