/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runmodels;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author Janette
 */
public class RunModels {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        AbstractFunction rf = new RosenbrockFunction(2);
        
        // gets the os for the computer this program is run on
        String os = System.getProperty("os.name").toLowerCase();
        // gets the home location
        String home = System.getProperty("user.home");
        // starts building the file path
        String filePathTrain = home;
        String filePathTest = home;
        String filePathOutputTrain = home;
        String filePathOutputTest = home;
        String outputNameTrain;
        String outputNameTest;

        // uses file separator so is operating system agnostic
        if (os.startsWith("windows")) { // Windows
            filePathTrain += File.separator;
            filePathTest += File.separator;
            filePathOutputTrain += File.separator;
            filePathOutputTest += File.separator;
        } else if (os.startsWith("mac")) { // Mac
            filePathTrain += File.separator;
            filePathTest += File.separator;
            filePathOutputTrain += File.separator;
            filePathOutputTest += File.separator;
        } else {
            // everything else
            filePathTrain += File.separator;
            filePathTest += File.separator;
            filePathOutputTrain += File.separator;
            filePathOutputTest += File.separator;
        }

        // calls the file chooser, returns the updated file path
        System.out.println("Select Training Data Location");
        filePathTrain = callFileChooser(filePathTrain);
        System.out.println("Training Data: " + filePathTrain);
        System.out.println("Select Test Data Location");
        filePathTest = callFileChooser(filePathTest);
        System.out.println("Test Data: " + filePathTest);

        //		  Output info commented out for FFNN 	        
//        System.out.println("Enter the name of your output file for training >");
//        outputNameTrain = in.nextLine();
//        System.out.println("Enter the name of your output file for testing >");
//        outputNameTest = in.nextLine();
//        filePathOutputTrain = ("Select Desired Output Location");
//        filePathOutputTrain = callFileChooser(filePathOutputTrain);
//        filePathOutputTest = filePathOutputTrain;
//        filePathOutputTrain += File.separator + outputNameTrain + ".txt";
//        filePathOutputTest += File.separator + outputNameTest + ".txt";

        // updates filepath with trailing separator
        filePathTrain += File.separator;
        filePathTest += File.separator;
//        filePathOutputTrain += File.separator;
//        filePathOutputTest += File.separator;

        //tests the FFNN

        FeedForwardExperiment test1 = new FeedForwardExperiment(filePathTrain, filePathTest);
              
		//Tests the Kernel ANN (RBF)    
//        String outputTrain = filePathOutputTrain;
//        String outputTest = filePathOutputTest;
//        //for a network of size 2
//        String name2train = filePathTrain;
//        String name2test = filePathTest;
//        KernelANN x2 = new KernelANN();
//        int iter2 = x2.trainNetwork(name2train, 10, 10, 120, outputTrain);
//        System.out.println("iterations: " + iter2 + ", Finished! Error: " + x2.oldError);
//        x2.testNetwork(name2test, outputTest);

//	//for a network of size 3
//        KernelANN x3 = new KernelANN();
//        String name3train = filePathTrain;
//        String name3test = filePathTest;
//        int iter3 = x3.trainNetwork(name3train, 10, 10, 1330, outputTrain);
//        System.out.println("iterations: " + iter3 + ", Finished! Error: " + x3.oldError);
//        x3.testNetwork(name3test, outputTest);
        //for a network of size 4
//			KernelANN x4 = new KernelANN();
//			String name4train = filePathTrain;
//			String name4test = filePathTest;			
//			int iter4 = x4.trainNetwork(name4train, 10, 10, 14640, outputTrain);
//			System.out.println("iterations: " + iter4 + ", Finished! Error: " + x4.oldError);
        //x4.testNetwork(name4test, outputTest);
        //for a network of size 5
//			KernelANN x5 = new KernelANN();
//			String name5train = filePathTrain;
//			String name5test = filePathTest;
//			int iter5 = x5.trainNetwork(name5train, 10, 10, 161050, outputTrain);
//			System.out.println("iterations: " + iter5 + ", Finished! Error: " + x5.oldError);
        //x5.testNetwork(name5test, outputTest);
        //for a network of size 6
//			KernelANN x6 = new KernelANN();
//			String name6train = filePathTrain;
//			String name6test = filePathTest;			
//			int iter6 = x6.trainNetwork(name6train, 10, 10, 1771560, outputTrain);
//			System.out.println("iterations: " + iter6 + ", Finished! Error: " + x6.oldError);
        //x6.testNetwork(name6test, outputTest);
        //} //end for
    }

    public static String callFileChooser(String filePath) {
        // builds a JFrame
        JFrame frame = new JFrame("Folder Selection Pane");
        // string to score the path
        String thisPath = "";

        // JFrame look and feel
        frame.setPreferredSize(new Dimension(400, 200));
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Select Folder");

        // sets up the file chooser
        JFileChooser fileChooser = new JFileChooser();
        // uses file path as a starting point for file browsing
        fileChooser.setCurrentDirectory(new File(filePath));
        // choose only from directories
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int fileChosen = fileChooser.showOpenDialog(null);

        // returns either the file path, or nothing (based on user choice)
        if (fileChosen == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            thisPath = selectedFile.getAbsolutePath();
            return thisPath;
        } else {
            return null;
        }
    }
}
