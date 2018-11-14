package Jframe;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class RGB {
	
	public BufferedImage imageio;
	
	
	
	
	
	
	
	
	
	 public RGB(BufferedImage imageio) {
		super();
		this.imageio = imageio;
	}

		
	 
	 public BufferedImage getImageio() {
		return imageio;
	}

	public void setImageio(BufferedImage imageio) {
		this.imageio = imageio;
	}
	
	



	


 static int  RedColor(BufferedImage imageio) {
	int r = 0;     
         for(int i = 0; i < imageio.getHeight(); i++) {
         	for(int j = 0; j < imageio.getWidth(); j++) {
         		//Get RBG Color all pixel
         		Color c = new Color(imageio.getRGB(j, i));
         		 r = c.getRed();
         	}         	}
      
		return r;
}
 
 static int  GreenColor(BufferedImage imageio) {
	 int g =0;
	         for(int i = 0; i < imageio.getHeight(); i++) {
	         	for(int j = 0; j < imageio.getWidth(); j++) {
	         		//Get RBG Color all pixel
	         		Color c = new Color(imageio.getRGB(j, i));
	         		
	         		 g = c.getGreen();
	      
	         	}      	}
	      
			return g;
	}
 
 static int  BlueColor(BufferedImage imageio) {
	 int b =0;
	         for(int i = 0; i < imageio.getHeight(); i++) {
	         	for(int j = 0; j < imageio.getWidth(); j++) {
	         		//Get RBG Color all pixel
	         		Color c = new Color(imageio.getRGB(j, i));
	         		 b = c.getBlue();
	        }         	}
	      return b;
	}
 
 
 static   void AllColor(BufferedImage imageio) {

     for(int i = 0; i < imageio.getHeight(); i++) {
     	for(int j = 0; j < imageio.getWidth(); j++) {
     		//Get RBG Color all pixel
     		Color c = new Color(imageio.getRGB(j, i));
     		int r = c.getRed();
     		int g = c.getGreen();
     		int b = c.getBlue();
     		int a = c.getAlpha();
	
	}}}

}

		