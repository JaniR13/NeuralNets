package runmodels;

import java.io.*;
import java.util.Random;

/*
 * A class to create a .csv file consisting of the inputs to the Rosenbrock function 
 * (creating vectors varying in size from 2-6), and the associated outputs. These inputs/
 * outputs are used to train the MLP and RBF function. These values are written out to a .csv
 * file.
 */

public class RosenbrockFunction extends AbstractFunction {
	// the variables to store the values used for input (domain for input is for
	// -5 to 5)
	private int x1, x2, x3, x4, x5, x6;
	// the variable for the output value
	private double o;

	/**
	 * Generates the output for a Rosenbrock function
	 * @throws IOException 
	 */
	public RosenbrockFunction(int size) {
		double intermediatecalc;
		double sum = 0;

		// open file to write inputs/outputs to
		BufferedWriter writer = null;
		BufferedWriter trainWriter = null;
		BufferedWriter testWriter = null;
		
		try {
			FileWriter fileWriter = new FileWriter("NeuralNets/src/runmodels/rosenbrock.txt");
			FileWriter testFileWriter = new FileWriter("NeuralNets/src/runmodels/rosenbrockTest.txt");
			FileWriter trainFileWriter = new FileWriter("NeuralNets/src/runmodels/rosenbrockTrain.txt");			
			
			writer = new BufferedWriter(fileWriter);
			trainWriter = new BufferedWriter(trainFileWriter);
			testWriter = new BufferedWriter(testFileWriter);			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		// calculate Rosenbrock for all vectors of size 2, with inputs from -5
		// to 5
		if (size == 2) {
			x1 = -5;
			x2 = -5;

			// increment x1 values by 1 at each iteration
			for (int k = 0; k < 11; k++) {
				// increment x2 values by 1 at each iteration
				for (int j = 0; j < 11; j++) {
					// loop through for all size 2 vectors, starting with x1 and
					// x2 at -5
					for (int i = 1; i < size; i++) {
						sum = 0;
						intermediatecalc = Math.pow(1 - x1, 2);
						intermediatecalc += 100 * Math.pow((x2 - Math.pow(x1, 2)), 2);
						sum += intermediatecalc;
					} // end for loop for size 2 vectors
					o = sum;
					try {
						writer.write(x1 + "," + x2 + "," + o);
						writer.newLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					x2 += 1;
				} // end for loop for incrementing x2
				x1 += 1;
				// set x2 back to -5
				x2 = -5;
			} // end loop for incrementing x1
		} // end if

		size++;
		
		// calculate Rosenbrock for all vectors of size 3, with inputs from -5
		// to 5
		if (size == 3) {
			x1 = -5;
			x2 = -5;
			x3 = -5;

			// increment x1 values by 1 at each iteration
			for (int l = 0; l < 11; l++) {
				// increment x2 values by 1 at each iteration
				for (int k = 0; k < 11; k++) {
					// increment x3 values by 1 at each iteration
					for (int j = 0; j < 11; j++) {
						// loop through for all size 3 vectors
						for (int i = 1; i < size; i++) {
							sum = 0;
							intermediatecalc = Math.pow(1 - x1, 2);
							intermediatecalc += 100 * Math.pow((x2 - Math.pow(x1, 2)), 2);
							sum += intermediatecalc;
							intermediatecalc = Math.pow(1 - x2, 2);
							intermediatecalc += 100 * Math.pow((x3 - Math.pow(x2, 2)), 2);
							sum += intermediatecalc;
						} // end for loop for size 3 vectors
						o = sum;
						try {
							writer.write(x1 + "," + x2 + "," + x3 + "," + o);
							writer.newLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						x3 += 1;
					} // end for loop for incrementing x3
					x2 += 1;
					// set x2 back to -5
					x3 = -5;
				} // end loop for incrementing x2
				x1 += 1;
				x2 = -5;
				x3 = -5;
			} // end loop for incrementing x1
		} // end if

		size++;
		
		// calculate Rosenbrock for all vectors of size 3, with inputs from -5
		// to 5
		if (size == 4) {
			x1 = -5;
			x2 = -5;
			x3 = -5;
			x4 = -5;

			// increment x1 values by 1 at each iteration
			for (int m = 0; m < 11; m++) {
				// increment x2 values by 1 at each iteration
				for (int l = 0; l < 11; l++) {
					// increment x3 values by 1 at each iteration
					for (int k = 0; k < 11; k++) {
						// increment x4 values by 1 at each iteration
						for (int j = 0; j < 11; j++) {
							// loop through for all size 4 vectors
							for (int i = 1; i < size; i++) {
								sum = 0;
								intermediatecalc = Math.pow(1 - x1, 2);
								intermediatecalc += 100 * Math.pow((x2 - Math.pow(x1, 2)), 2);
								sum += intermediatecalc;
								intermediatecalc = Math.pow(1 - x2, 2);
								intermediatecalc += 100 * Math.pow((x3 - Math.pow(x2, 2)), 2);
								sum += intermediatecalc;
								intermediatecalc = Math.pow(1 - x3, 2);
								intermediatecalc += 100 * Math.pow((x4 - Math.pow(x3, 2)), 2);
								sum += intermediatecalc;
							} // end for loop for size 3 vectors
							o = sum;
							try {
								writer.write(x1 + "," + x2 + "," + x3 + "," + x4 + "," + o);
								writer.newLine();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							};
							x4 += 1;
						} // end for loop for incrementing x4
						x3 += 1;
						// set x4 back to -5
						x4 = -5;
					} // end loop for incrementing x3
					x2 += 1;
					x3 = -5;
					x4 = -5;
				} // end loop for incrementing x2
				x1 += 1;
				x2 = -5;
				x3 = -5;
				x4 = -5;
				x5 = -5;
			} // end for loop for incrementing x1
		} // end if

		size++;
		
		// calculate Rosenbrock for all vectors of size 5, with inputs from -5
		// to 5
		if (size == 5) {
			x1 = -5;
			x2 = -5;
			x3 = -5;
			x4 = -5;
			x5 = -5;

			// increment x1 values by 1 at each iteration
			for (int n = 0; n < 11; n++) {
				// increment x2 values by 1 at each iteration
				for (int m = 0; m < 11; m++) {
					// increment x3 values by 1 at each iteration
					for (int l = 0; l < 11; l++) {
						// increment x4 values by 1 at each iteration
						for (int k = 0; k < 11; k++) {
							// increment x5 values by 1 at each iteration
							for (int j = 0; j < 11; j++) {
								// loop through for all size 5 vectors
								for (int i = 1; i < size; i++) {
									sum = 0;
									intermediatecalc = Math.pow(1 - x1, 2);
									intermediatecalc += 100 * Math.pow((x2 - Math.pow(x1, 2)), 2);
									sum += intermediatecalc;
									intermediatecalc = Math.pow(1 - x2, 2);
									intermediatecalc += 100 * Math.pow((x3 - Math.pow(x2, 2)), 2);
									sum += intermediatecalc;
									intermediatecalc = Math.pow(1 - x3, 2);
									intermediatecalc += 100 * Math.pow((x4 - Math.pow(x3, 2)), 2);
									sum += intermediatecalc;
									intermediatecalc = Math.pow(1 - x4, 2);
									intermediatecalc += 100 * Math.pow((x5 - Math.pow(x4, 2)), 2);
									sum += intermediatecalc;
								} // end for loop for size 5 vectors
								o = sum;
								
								try {
									writer.write(x1 + "," + x2 + "," + x3 + "," + x4 + "," + x5 + "," + o);
									writer.newLine();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								x5 += 1;
							} // end for loop for incrementing x5
							x4 += 1;
							// set x5 back to -5
							x5 = -5;
						} // end loop for incrementing x4
						x3 += 1;
						x4 = -5;
						x5 = -5;
					} // end loop for incrementing x3
					x2 += 1;
					x3 = -5;
					x4 = -5;
					x5 = -5;
				} // end for loop for incrementing x2
				x1 += 1;
				x2 = -5;
				x3 = -5;
				x4 = -5;
				x5 = -5;
			} // end loop for incrementing x1
		} // end if

		size++;
		
		// calculate Rosenbrock for all vectors of size 6, with inputs from -5
		// to 5
		if (size == 6) {
			x1 = -5;
			x2 = -5;
			x3 = -5;
			x4 = -5;
			x5 = -5;
			x5 = -5;
			x6 = -5;

			// increment x1 values by 1 at each iteration
			for (int p = 0; p < 11; p++) {
				// increment x2 values by 1 at each iteration
				for (int n = 0; n < 11; n++) {
					// increment x3 values by 1 at each iteration
					for (int m = 0; m < 11; m++) {
						// increment x4 values by 1 at each iteration
						for (int l = 0; l < 11; l++) {
							// increment x5 values by 1 at each iteration
							for (int k = 0; k < 11; k++) {
								// increment x6 values by 1 at each iteration
								for (int j = 0; j < 11; j++) {
									// loop through for all size 5 vectors
									for (int i = 1; i < size; i++) {
										sum = 0;
										intermediatecalc = Math.pow(1 - x1, 2);
										intermediatecalc += 100 * Math.pow((x2 - Math.pow(x1, 2)), 2);
										sum += intermediatecalc;
										intermediatecalc = Math.pow(1 - x2, 2);
										intermediatecalc += 100 * Math.pow((x3 - Math.pow(x2, 2)), 2);
										sum += intermediatecalc;
										intermediatecalc = Math.pow(1 - x3, 2);
										intermediatecalc += 100 * Math.pow((x4 - Math.pow(x3, 2)), 2);
										sum += intermediatecalc;
										intermediatecalc = Math.pow(1 - x4, 2);
										intermediatecalc += 100 * Math.pow((x5 - Math.pow(x4, 2)), 2);
										sum += intermediatecalc;
										intermediatecalc = Math.pow(1 - x5, 2);
										intermediatecalc += 100 * Math.pow((x6 - Math.pow(x5, 2)), 2);
										sum += intermediatecalc;
									} // end for loop for size 6 vectors
									o = sum;
									try {
										writer.write(x1 + "," + x2 + "," + x3 + "," + x4 + "," + x5 + "," + x6 + "," + o);
										writer.newLine();									
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									x6 += 1;
								} // end for loop for incrementing x6
								x5 += 1;
								// set x5 back to -5
								x6 = -5;
							} // end loop for incrementing x5
							x4 += 1;
							x5 = -5;
							x6 = -5;
						} // end loop for incrementing x4
						x3 += 1;
						x4 = -5;
						x5 = -5;
						x6 = -5;
					} // end for loop for incrementing x3
					x2 += 1;
					x3 = -5;
					x4 = -5;
					x5 = -5;
					x6 = -5;
				} // end loop for incrementing x2
				x1 += 1;
				x2 = -5;
				x3 = -5;
				x4 = -5;
				x5 = -5;
				x6 = -5;
			}
		} // end if
		
		System.out.println("Rosenbrock output generated.");

		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedReader reader = null;

		try {

			String sCurrentLine;
			int randomNumber = 0;
			
			reader = new BufferedReader(new FileReader("NeuralNets/src/runmodels/rosenbrock.txt"));

			while ((sCurrentLine = reader.readLine()) != null) {
				//generate a random number to determine whether line should be in training or test set
				randomNumber = randInt(0, 5);
				// print to test data, ~80% of data goes to test set
				if (randomNumber == 0 || randomNumber == 1 || randomNumber == 3 || randomNumber == 4 || randomNumber == 5) {
					trainWriter.write(sCurrentLine);
					trainWriter.newLine();
				} else {
				// print to training data, ~20% of data goes to training set
					testWriter.write(sCurrentLine);
					testWriter.newLine();
				}
			}
			System.out.println("Rosenbrock test and train data generated.");	
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)reader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
		
		//generate test and train sets
		try {
			trainWriter.close();
			testWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public static int randInt(int min, int max) {			
	    Random rand = new Random();

	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	// remove these?
	public double calcfx(double x) {
		return 0.00;
	}

	public double calcderivfx(double x) {
		return 0.00;
	}
	
	
	

}
