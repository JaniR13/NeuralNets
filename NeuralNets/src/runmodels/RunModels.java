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
public class RunModels {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        for (int i = 0; i < 1; i++) {
            KernelANN x2 = new KernelANN();
            String name2 = "C:\\Users\\Janette\\Documents\\GradSchoolStuff\\MachineLearning\\Project2\\RosenbrockTrainData\\RosenbrockTrainData\\rosenbrockTrain2.txt";
            int iter2 = x2.trainNetwork(name2, 11, 11, 120);
            System.out.println("i: " + i + ", iterations: " + iter2 + ", Finished! Error: " + x2.oldError);
            
//            KernelANN x3 = new KernelANN();
//            String name3 = "C:\\Users\\Janette\\Documents\\GradSchoolStuff\\MachineLearning\\Project2\\RosenbrockTrainData\\RosenbrockTrainData\\rosenbrockTrain3.txt";
//            int iter3 = x3.trainNetwork(name3, 11, 11, 0.00001);
//            System.out.println("i: " + i + ", iterations: " + iter3 + ", Finished! Error: " + x3.totalError);
        }
    }

}
