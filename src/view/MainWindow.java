package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import model.*;

public class MainWindow extends JFrame {
	private PostWindow postWindow;
	private StoryWindow historyWindow;

	public MainWindow(Post pPost, Story pStory) {
		setTitle("Instagram");
		setSize(400, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(400, 200);
		
		JLabel instaTitle = new JLabel("Instagram");
		instaTitle.setFont(new Font("Monospaced", Font.BOLD, 38)); 
		instaTitle.setForeground(Color.BLACK); 
		instaTitle.setBounds(75, 0, 250, 40);
		
		JButton buttonIngresar = new JButton("Enter");
		buttonIngresar.setBounds(80, 360, 220, 60);
		buttonIngresar.addActionListener(e -> abrirVentanas());
		
		ImageIcon imageIcon = new ImageIcon("C:\\Users\\santi\\OneDrive\\Desktop\\TEC-UCR\\TEC\\II-Semestre\\POO\\visitorPattern\\instaLogo.jpeg");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(80, 10, 220, 400);
		
        
        historyWindow = new StoryWindow(pStory);
        postWindow = new PostWindow(pPost);
        
		getContentPane().setLayout(null);
        getContentPane().add(instaTitle);
        getContentPane().add(buttonIngresar);
        getContentPane().add(imageLabel);

	}
	
	private void abrirVentanas() {
		postWindow.setVisible(true);
		historyWindow.setVisible(true);
		this.setState(ICONIFIED);
	}
	public static void main(String args[]) 
	{
		Post post = new Post("C:\\Users\\santi\\OneDrive\\Desktop\\TEC-UCR\\TEC\\II-Semestre\\POO\\visitorPattern\\post.jpg");
		Story story = new Story("C:\\Users\\santi\\OneDrive\\Desktop\\TEC-UCR\\TEC\\II-Semestre\\POO\\visitorPattern\\story.jpg");
      	MainWindow frame = new MainWindow(post, story);
      	
        SwingUtilities.invokeLater(() -> {
			
	        frame.setVisible(true);
	        
	    }); 
	}
}
