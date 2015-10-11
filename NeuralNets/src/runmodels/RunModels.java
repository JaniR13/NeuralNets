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
        KernelANN x = new KernelANN();
        String name = "C://Users//Janette//Documents//GradSchoolStuff//MachineLearning//Project2//rosenbrock_size2.txt";
        x.trainNetwork(name, 0.5, 11, 0.00001);
        System.out.println("Finished! Error: " + x.totalError );
    }
    
}
