package AI;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import dataModels.Color;
import dataModels.RGBColor;
import humanTrainingInterface.TrainingWindow;
import pictureSerialization.Picture;

public class Main {
	
	static Perceptron p = new Perceptron();
	
	// Training data
	static Picture red = new Picture("src/Training Data/RED.jpg");
	static Picture notRed = new Picture("src/Training Data/NOTRED.jpg");
	
	// analyzing data
	static Picture picture = new Picture("src/Source img Data/ironman.jpeg");
	
	// Output data | Array same size as Picture in px
	static boolean[][] picInBool = new boolean[picture.getDimensions()[0] + 1][picture.getDimensions()[1] + 1];
	
	// Setting
	static boolean verbose = false;
	
	public static void main(String[] args) {
		TrainingWindow w = new TrainingWindow(new Color(0,0,0));
		//doThisPictureChangingStuff(new Network());

	}
	
	/**
	 * function for line from 0,0 corner to max,max corner
	 * @param x
	 * @return
	 */
	private static double f(int x, Picture p) {
		
		/**
		 * m = y2 - y1 / x2 -x1
		 * m = dimensions[1] - 0 / dimensions [0] - 0
		 * m =
		 */
		
		int[] dimensions = p.getDimensions();
		
		double raw = ((double) dimensions[1]) / ((double) dimensions[0]);
		return raw * x;
		
	}
	
	public static void printOutputArray() {
		// Picture dimensions
		int dimensions[] = picture.getDimensions();
		
		System.out.print("\n");
		System.out.print("\n");
		System.out.print("\n");
		
		for(int i = 0; i <= dimensions[1]; i++) {
			
			for(int j = 0; j <= dimensions[0]; j++) {
				System.out.print(picInBool[j][i] ? "1" : "0");
			}
			System.out.print("\n");
		}
	}
	
	public static void printOutputArrayToFile() {
		try {
			File myObj = new File("output.txt");
			
			if(myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
			
			FileWriter myWriter = new FileWriter("output.txt");
			
			int dimensions[] = picture.getDimensions();
			
			for(int i = 0; i <= dimensions[1]; i++) {
				
				for(int j = 0; j <= dimensions[0]; j++) {
					myWriter.write(picInBool[j][i] ? "1" : "0");
				}
				myWriter.write("--\n");
			}
			
			myWriter.write(":\n");
			
			myWriter.write("End");
			
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
			
		} catch(IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	public static void doThisPictureChangingStuff(Network n) {
		RGBColor c;
		
		int[] dimensions = picture.getDimensions();
		
		Picture newPic = new Picture(dimensions[0], dimensions[1]);
		
		System.out.println("Printing new image ...");
		
		for(int y = 0; y < dimensions[1]; y++) {
			
			for(int x = 0; x < dimensions[0]; x++) {
				
				Color col = new Color(picture.getRGBOf(x, y));
				c = n.evaluateHard(col)[0];
				
				/**
				 * m = y2 - y1 / x2 -x1
				 * m = - dimensions[1] / - dimensions [0]	
				 */
				// f(y,newPic) < x // queer line
				if(true) {
					newPic.setPixel(x, y, c);
					if(verbose) {
						System.out.println(" change ");
					}
					continue;
				} else {
					newPic.setPixel(x, y, col.r, col.g, col.b);
					if(verbose) {
						System.out.println(" keep ----- ");
					}
					
				}
				
			}
			
		}
		newPic.saveImage();
		
		// simple
	}

}
