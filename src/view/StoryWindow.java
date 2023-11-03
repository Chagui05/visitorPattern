package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.LikeVisitor;
import model.Story;

public class StoryWindow extends JFrame {
	private Story story;

	public StoryWindow(Story pStory) {
		story = pStory;
		setTitle("Historia");
		setSize(400, 550);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocation(200, 200);
		
		JLabel storyTitle = new JLabel("Story");
		storyTitle.setFont(new Font("Monospaced", Font.BOLD, 38)); 
		storyTitle.setForeground(Color.BLACK); 
		storyTitle.setBounds(110, 0, 250, 40);
		
		ImageIcon imageIcon = new ImageIcon(story.getImageDirection());
		Image image = imageIcon.getImage().getScaledInstance(200, 380, Image.SCALE_DEFAULT);
		ImageIcon resizedIcon = new ImageIcon(image);
		JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setBounds(80, 50, 220, 300);
        
        JButton button = new JButton("Dar Like");
        button.setBounds(110, 360, 150, 50);
        
        JLabel likeAmount = new JLabel("Likes :\n0");
        likeAmount.setFont(new Font("Monospaced", Font.BOLD, 18));
        likeAmount.setBounds(60, 410, 300, 80);
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	LikeVisitor visitor = new LikeVisitor();
            	int amount = story.accept(visitor);
            	String StrAmount = String.valueOf(amount);
            	likeAmount.setText("Likes: "+StrAmount);
            }
        });
        
		getContentPane().setLayout(null);
		getContentPane().add(storyTitle);
		getContentPane().add(imageLabel);
		getContentPane().add(button);
		getContentPane().add(likeAmount);
	}

}
