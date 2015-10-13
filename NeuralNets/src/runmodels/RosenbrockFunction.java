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

		
		//for FFNN, leave size uncommented so grows at each iteration
		//for RBF, make files of each size
		
		//file to write the full spectrum of inputs/outputs to
		BufferedWriter writer = null;
		//file to write a subset of the inputs/outputs to
		BufferedWriter trainWriter = null;
		//file to write a smaller subset of the inputs/outputs to
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
	if(size==3)

	{
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
	if(size==4)

	{
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
						}
						;
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
	if(size==5)

	{
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
	if(size==6)

	{
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

	try

	{
		// closes the writer for the file consisting of all inputs/outputs
		writer.close();
	} catch(

	IOException e)

	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	// a reader to read the file of all inputs/outputs
	BufferedReader reader = null;

	try	
	{
		// the current line in the full file
		String sCurrentLine;
		int lineNo = 0;
		
		//a random number to decide which line goes to the appropriate file
		int randomNumber = 0;

		// a reader used to read the full file of Rosenbrock outputs
		reader = new BufferedReader(new FileReader("NeuralNets/src/runmodels/rosenbrock.txt"));

		//while we are in the size 2 segment of the file
		while (lineNo < 122) {
			randomNumber = randInt(0, 10);
			sCurrentLine = reader.readLine();
			lineNo++;
			if (randomNumber == 1 || randomNumber == 2 || randomNumber == 8) {
				trainWriter.write(sCurrentLine);
				trainWriter.newLine();
			} else if (randomNumber == 7) {
				testWriter.write(sCurrentLine);
				testWriter.newLine();
			}
		} //ends size 2 part of data
		
		//while we are in the size 3 segment of the file
		while (lineNo < 1453) {
			randomNumber = randInt(0, 20);
			sCurrentLine = reader.readLine();
			lineNo++;
			if (randomNumber == 1 || randomNumber == 2 || randomNumber == 9 ) {
				trainWriter.write(sCurrentLine);
				trainWriter.newLine();
			} else if (randomNumber == 7) {
				testWriter.write(sCurrentLine);
				testWriter.newLine();
			}
		} //ends size 3 part of data
		
		//while we are in the size 4 segment of the file
		while (lineNo < 16094) {
			randomNumber = randInt(0, 30);
			sCurrentLine = reader.readLine();
			lineNo++;
			if (randomNumber == 1 || randomNumber == 8 || randomNumber == 9 ) {
				trainWriter.write(sCurrentLine);
				trainWriter.newLine();
			} else if (randomNumber == 7) {
				testWriter.write(sCurrentLine);
				testWriter.newLine();
			}
		} //ends size 4 part of data
		
		//while we are in the size 5 segment of the file
		while (lineNo < 177145) {
			randomNumber = randInt(0, 70);
			sCurrentLine = reader.readLine();
			lineNo++;
			if (randomNumber == 2 || randomNumber == 8 || randomNumber == 9 ) {
				trainWriter.write(sCurrentLine);
				trainWriter.newLine();
			} else if (randomNumber == 7) {
				testWriter.write(sCurrentLine);
				testWriter.newLine();
			}
		} //ends size 5 part of data
		
		// while there is still data left to be read		
		while ((sCurrentLine = reader.readLine()) != null) {
			randomNumber = randInt(0, 100);
			sCurrentLine = reader.readLine();
			lineNo++;
			if (randomNumber == 1 || randomNumber == 8 || randomNumber == 9 ) {
				trainWriter.write(sCurrentLine);
				trainWriter.newLine();
			} else if (randomNumber == 7) {
				testWriter.write(sCurrentLine);
				testWriter.newLine();
			}
		}
		System.out.println("Rosenbrock test and train data generated.");

	} catch(

	IOException e)

	{
		e.printStackTrace();
	} finally

	{
		try {
			if (reader != null)
				reader.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// close the writers for the train and test datasets
	try

	{
		trainWriter.close();
		testWriter.close();
	} catch(

	IOException e)

	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

	// generates a random number, used to determine if line should go in test or
	// train set
	public static int randInt(int min, int max) {
		Random rand = new Random();
		// generates a random number between two inclusive values
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

	// TODO: if time allows, move calculation of Rosenbrock function down here
	// and call
	public double calcfx(double x) {
		return 0.00;
	}

	// the derivative calculation is not necessary for this function
	public double calcderivfx(double x) {
		return 0.00;
	}

}
