package Jframe;

import java.util.List;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1292, 782);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Open map in browser");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Desktop d = Desktop.getDesktop();
				try {
					d.browse(new URI("https://meteo.ua/ua/sputnik"));
				} catch (IOException | URISyntaxException e) {
					
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(92, 25, 221, 45);
		contentPane.add(btnNewButton);
		
		JLabel Jlabel1 = new JLabel("showMap");
		Jlabel1.setBounds(12, 103, 842, 533);
		contentPane.add(Jlabel1);
		
		JLabel LabelCloud = new JLabel("Average Cloud");
		LabelCloud.setBounds(886, 417, 355, 307);
		contentPane.add(LabelCloud);
		
		JButton btnDownloadMapWith = new JButton("download map with website");
		btnDownloadMapWith.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				//	Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
				//	BufferedImage capture = new Robot().createScreenCapture(screenRect);
				//	ImageIcon icon = new ImageIcon(capture);	
				//	
				//	Jlabel1.setIcon(icon);
				//	
				//	
				//	ImageIO.write(capture, "png", new File("D:\\sts"));
					
					EventQueue.invokeLater(new Runnable() {
						
						@Override
						public void run() {
							try {
								UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
							  } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
				                }
							
							try {
								
								Document doc;
								doc = Jsoup.connect("https://meteo.ua/ua/sputnik").get();

								
								Elements row = doc.select("#slide_afta");
								

									Elements images = row.select("img[src~=(?i)\\.(png|jpe?g|gif|jpg)]");
									
									
									for(Element image: images) {
										String l = image.attr("src");
									if(l.length()>0) {
										if(l.length()<4)
											l = doc.baseUri()+l.substring(1);
										else if(!l.substring(0, 4).equals("http"))
											l = doc.baseUri()+l.substring(1);
									}
										System.out.println(l);
									}
									
									
								//https://meteo.ua/var/zip/Sputn-01.jpg?u=654931
										String path = "https://meteo.ua/var/zip/Sputn-01.jpg?u=654931";
			                    System.out.println("Get Image from " + path);
			                    URL url = new URL(path);
			                    BufferedImage imageio = ImageIO.read(url);
			                    System.out.println("Load image into frame...");
			                    Jlabel1.setIcon(new ImageIcon(imageio));
									
								
							} catch (Exception exp) {
			                    exp.printStackTrace();
			                }
						}
					});
				
						
				}catch(Exception ex){
					
				}
			}
				
		});
		btnDownloadMapWith.setBounds(838, 37, 221, 45);
		contentPane.add(btnDownloadMapWith);
		
		JButton btnNewButton_1 = new JButton("ParsePixel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Icon image = Jlabel1.getIcon();
				// 6 shades of gray
				  
				
                 List<String> rgb = new ArrayList<>();
                   
				 BufferedImage imageio = null;
					try {
						String path = "https://meteo.ua/var/zip/Sputn-01.jpg?u=654931";
	                    System.out.println("Get Image from " + path);
	                    URL url = new URL(path);
	                     imageio = ImageIO.read(url);
	        
/*	                     int rgbRed =   RGB.RedColor(imageio);
	                     int rgbGreen =   RGB.GreenColor(imageio);
	                     int rgbBlue =   RGB.BlueColor(imageio);
	                     
	                     System.out.println(rgbRed + "." + rgbGreen + "." + rgbBlue + " " );
				
	                     int rgbAll=   RGB.AllColor(imageio);
	                     System.out.println("rgbAll" + rgbAll);*/
	                     
	                 //   BufferedImage grayplace = new BufferedImage(imageio.getWidth(),imageio.getHeight(), BufferedImage.TYPE_INT_ARGB);
                    
	                   for(int i = 0; i < imageio.getHeight(); i++) {
	                    	for(int j = 0; j < imageio.getWidth(); j++) {
	                    		//Get RBG Color all pixel
	                    		Color c = new Color(imageio.getRGB(j, i));
	                    		int r = c.getRed();
	                    		int g = c.getGreen();
	                    		int b = c.getBlue();
	                    	
	                    
	                    		//rgb.add(r + "." + g + "." + b);
	                   System.out.println(r + "." + g + "." + b + " " ); 
	                 //  Jlabel1.setText(r + "." + g + "." + b + " " );
	                    	
//	                   int foo = 0;
//	                   
//	                   Iterator<String> iterator = rgb.iterator();
//	                   while(iterator.hasNext()) {
//	                	   String next = iterator.next();
//	                	   System.out.println(next);
//	                	   foo = Integer.parseInt(next);
//	                   }
	                   
	                   
	                   
	                 
	                	   
	                   
	                  /* System.out.println("countDimGray = " + countDimGray);
	                   System.out.println("countGray = " + countGray);
	                   System.out.println("countDarkGrey = " + countDarkGrey);
	                   System.out.println("countSilverGray = " + countSilverGray);
	                   System.out.println("countLightGray = " + countLightGray);
	                   System.out.println("countGainsboroGray = " + countGainsboroGray);*/
	              
	                  
	                    
	                    		
	                   
	                    }
	                    	System.out.println();
	                   }
	                   
	                
					//ImageIO.write(grayplace, "png", new File("D:\\grayplace.png"));
					}catch(IOException ex){
						
					}
					
			}
		});
		btnNewButton_1.setBounds(960, 103, 221, 52);
		contentPane.add(btnNewButton_1);
		
		JButton btnCount = new JButton("Count Average Cloudiness");
		btnCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 int countDimGray = 0;
                 int countGray = 0;
                 int countDarkGrey = 0;
                 int countSilverGray = 0;
                 int countLightGray = 0;
                 int countGainsboroGray = 0;
                 
				String path = "https://meteo.ua/var/zip/Sputn-01.jpg?u=654931";
                System.out.println("Get Image from " + path);
                URL url;
				try {
					url = new URL(path);
					  BufferedImage imageio = ImageIO.read(url);
			
               
                 
		
               
               for(int i = 0; i < imageio.getHeight(); i++) {
               	for(int j = 0; j < imageio.getWidth(); j++) {
               		//Get RBG Color all pixel
               		Color c = new Color(imageio.getRGB(j, i));
               		int r = c.getRed();
               		int g = c.getGreen();
               		int b = c.getBlue();

               if(r == 105 && g == 105 && b == 105)
            	   countDimGray++;
               if(r == 128 && g == 128 && b == 128)
                    countGray ++;
               if(r == 169 && g == 169 && b == 169)
                    countDarkGrey ++;
               if(r == 192 && g == 192 && b == 192)
                    countSilverGray ++;
               if(r == 211 && g == 211 && b == 211)
                    countLightGray ++;
               if(r == 220 && g == 220 && b == 220)
                    countGainsboroGray ++;
               	}}
        	   int height = imageio.getWidth();
               int width = imageio.getHeight();
               int allPixel = height * width;
               int allCloudiness = countDimGray + countGray + countDarkGrey + countSilverGray + countLightGray + countGainsboroGray;
               
               
               if(countDimGray + countGray + countDarkGrey <= countSilverGray + countLightGray + countGainsboroGray)
            	   System.out.println("Грози");
               else
            	   System.out.println("Хмарно");
               
               
               float averagePercentagesCloudiness = allCloudiness / allPixel * 100  ; //?
               double averagePercentagesCloudiness1 = allCloudiness / allPixel * 100 ; //?
               LabelCloud.setText("Середня хмарність" + averagePercentagesCloudiness1);
               
               System.out.println("Всі пікселі = " + allPixel);
               System.out.println("Вся хмарність = " + allCloudiness);
               System.out.println("Середня хмарність = " +averagePercentagesCloudiness);
               System.out.println("Середня хмарність double = " +averagePercentagesCloudiness1);
               
				} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
		});
		btnCount.setBounds(960, 200, 221, 52);
		contentPane.add(btnCount);
		
		
	
	
	}
}
