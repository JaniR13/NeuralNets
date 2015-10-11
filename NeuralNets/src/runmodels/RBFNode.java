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
    //ArrayList<Double> inweights; //Most RBF's don't have weights from input nodes to hidden nodes
    ArrayList<Double> means; //center of the cluster as vector
    double activationOut;//Activation output
    Distance dist = new Distance();
    public RBFNode(){
        
    }
    public double calculateActivation(ArrayList<Double> x, double var){//TODO make decision about variance matrix
        double variance = 1/(2*Math.pow(var, 2));
        double error = Math.pow(dist.calculateDistance(x, means),2);
        return Math.exp(variance*error);
    }
    
}
