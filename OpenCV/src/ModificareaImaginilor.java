import java.awt.List;
import java.util.ArrayList;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ModificareaImaginilor {

	Imgcodecs imageCodecs = new Imgcodecs();
	
	String file ="D:/imaginePrimavara.jpg";
	public void LoadImage() {
		Mat matrix = imageCodecs.imread(file);
		System.out.println("Imagine incarcata.............");
		
	}

	public void SaveImage() {
		System.out.println("Imagine incarcata.............");
		String file2 ="D:/imaginePrimavara_resalvata.jpg"; 
		Mat matrix = imageCodecs.imread(file);
		imageCodecs.imwrite(file2,matrix);
		System.out.println("Imagine salvata.............");
		
	}

	public void GrayScale() {
		System.out.println("Imagine incarcata.............");
		String file2 ="D:/imaginePrimavara_greyScale.jpg";
		Mat matrix = imageCodecs.imread(file);
		Mat matrix2 = imageCodecs.imread(file2);
		Imgproc.cvtColor(matrix, matrix2, Imgproc.COLOR_RGB2GRAY);
		imageCodecs.imwrite(file2, matrix2);
		System.out.println("Imagine salvata.............");
		
	}

	public void Negativ() {
		System.out.println("Imagine incarcata.............");
		String file2 ="D:/imaginePrimavara_negativa.jpg"; 
		Mat matrix = imageCodecs.imread(file);
		Mat matrix2 = imageCodecs.imread(file2);
		Mat invertcolormatrix =  new Mat(matrix.rows(),matrix.cols(),matrix.type(),new Scalar(255,255,255));
     	Core.subtract(invertcolormatrix, matrix, matrix2);
     	imageCodecs.imwrite(file2,matrix2);
     	System.out.println("Imagine salvata.............");
	}

	public void RGBToHSV() {
		System.out.println("Imagine incarcata.............");
		String file2 ="D:/imaginePrimavara_RGBToHSV.jpg"; 
		Mat matrix = imageCodecs.imread(file);
		Mat matrix2 = imageCodecs.imread(file2);
		Imgproc.cvtColor(matrix, matrix2, Imgproc.COLOR_RGB2HSV);
		imageCodecs.imwrite(file2, matrix2);
		System.out.println("Imagine salvata.............");
	}

	public void GrayScaleToBinary() {
		System.out.println("Imagine incarcata.............");
		String file2 ="D:/imaginePrimavara_greyScale.jpg"; 
		String file3 ="D:/imaginePrimavara_GrayScaleToBinary.jpg"; 
		Mat matrix = imageCodecs.imread(file2);
		Mat matrix2 = imageCodecs.imread(file3);
		Imgproc.threshold(matrix, matrix2, 200, 500, Imgproc.THRESH_BINARY);
		imageCodecs.imwrite(file3, matrix2);
		System.out.println("Imagine salvata.............");
	}

	public void histogram() {
		
	      String file ="D:/imaginePrimavara.jpg";
	      Mat img = Imgcodecs.imread(file);
	      Mat equ = new Mat();
	      img.copyTo(equ);
	      Imgproc.blur(equ, equ, new Size(3, 3));
	      Imgproc.cvtColor(equ, equ, Imgproc.COLOR_BGR2YCrCb);
	      ArrayList<Mat> channels = new ArrayList<Mat>();
	      Core.split(equ, channels);
	      Imgproc.equalizeHist(channels.get(0), channels.get(0));
	      Core.merge(channels, equ);
	      Imgproc.cvtColor(equ, equ, Imgproc.COLOR_YCrCb2BGR);
	      Mat gray = new Mat();
	      Imgproc.cvtColor(equ, gray, Imgproc.COLOR_BGR2GRAY);
	      Mat grayOrig = new Mat();
	      Imgproc.cvtColor(img, grayOrig, Imgproc.COLOR_BGR2GRAY);
	      Imgcodecs.imwrite("D:/imaginePrimavara_histograma.jpg", equ);
	      System.out.println("Image Procesata");
	   }
		
	}
	
	

	


