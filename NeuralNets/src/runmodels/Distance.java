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
public class Distance {
    public Distance(){
        
    }
    public double calculateDistance(ArrayList<Double>x, ArrayList<Double> means){
        double d = 0;
        for(int i = 0; i < x.size();i++){
            d += Math.pow(means.get(i)-x.get(i), 2);
        }
        d = Math.sqrt(d);
        return d;
    }
//    public double calculateDifference(ArrayList<Double>expected, ArrayList<Double> observed){
//        double d = 0;
//        for(int i = 0; i < expected.size();i++){
//            d += Math.abs(expected.get(i)-observed.get(i));
//        }
//            return d;
//    }
}
