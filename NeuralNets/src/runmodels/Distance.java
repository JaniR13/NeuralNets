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
    public double calculateDistance(ArrayList<Double>x, ArrayList<Double> means, int dim){
        //System.out.println("distance");
        double d = 0;
        for(int i = 0; i < dim;i++){
            //System.out.println(means.get(i) + " : " + x.get(i));
            double g = Double.parseDouble(""+means.get(i));
            double h = Double.parseDouble(""+x.get(i));
            d += Math.pow(g-h, 2);
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
