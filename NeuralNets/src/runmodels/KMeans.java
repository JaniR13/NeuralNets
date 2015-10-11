/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runmodels;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Janette
 */
public class KMeans {

    private Distance d = new Distance();

    public KMeans() {

    }

    public ArrayList<ArrayList> createClusters(int k, ArrayList<ArrayList> in) {
        Random rand = new Random();
        int dim = in.get(0).size(); //figure out dimensionality of input
        ArrayList<ArrayList> clusters = new ArrayList(); //initalize cluster array
        for (int i = 0; i < k; i++) {//Generate k examples of dimensionality same as input
            clusters.add(new ArrayList());
            for (int j = 0; j < dim; j++) {
                clusters.get(i).add(rand.nextInt(10) - 5);
            }
        }
        clusters = trainClusters(in, clusters, dim, 10);
        return clusters;
    }

    public ArrayList<ArrayList> trainClusters(ArrayList<ArrayList> in, ArrayList<ArrayList> clusters, int iter, int dim) {
        for (int i = 0; i < in.size(); i++) {
            in.get(i).add(dim, 0);
        }
        for (int i = 0; i < iter; i++) {//number of iterations
            for (int j = 0; j < in.size(); j++) {//each datapoint
                double curD = Double.MAX_VALUE;
                int smallestCluster = 0;
                for (int k = 0; k < clusters.size(); k++) {
                    double tempD = d.calculateDistance(in.get(j), in.get(k));//find closest cluster
                    if (tempD < curD) {
                        smallestCluster = k;
                    }
                }
                in.get(j).set(dim, smallestCluster);
            }
            for (int k = 0; k < clusters.size(); k++) {//for each cluster
                //double avg = 0;
                for (int l = 0; l < dim; l++) {//each dimension
                    double dimAvg = 0;
                    for (int j = 0; j < in.size(); j++) {//each input
                        if (in.get(j).get(dim).equals(k)) {
                            dimAvg += (double) in.get(j).get(l);
                        }
                    }
                    clusters.get(k).set(l, dimAvg/in.size());
                }
            }
        }
        return clusters;
    }
}
