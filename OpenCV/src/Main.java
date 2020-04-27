import org.opencv.core.Core;

public class Main {
	
	public static void main(String args[]) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		ModificareaImaginilor img = new ModificareaImaginilor();
		img.LoadImage();
		img.SaveImage();
		img.GrayScale();
		img.Negativ();
		img.GrayScaleToBinary();
		img.RGBToHSV();
		img.histogram();
		
		
	}

}
