/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runmodels;

import java.util.ArrayList;

/**
 *
 * @author Janette
 */
public class RBFNode {
    ArrayList<Double> outweights; //weights to each output node from this RBF
    ArrayList<Double> inweights; //weights from each input to this RBF
    double var;//variance (do we need variance matrix or will single parameter do?)
    ArrayList<Double> means; //center of the cluster as vector
    double activationOut;//Activation output
    public RBFNode(){
        
    }
    public double calculateActivation(ArrayList<Double> x){//TODO make decision about variance matrix
        double error = 0;
        double variance = 1/(2*Math.pow(var, 2));
        for(int i = 0; i < x.size();i++){
            error += Math.pow(means.get(i)-x.get(i), 2);
        }
        error = Math.sqrt(error);
        double phi = Math.exp(var*error);
        return phi;
    }
}
