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
import model.Post;

public class PostWindow extends JFrame{
	private Post post;

	public PostWindow(Post pPost) {
		post = pPost;
		setTitle("Post");
		setSize(400, 550);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocation(600, 200);
		
		JLabel postTitle = new JLabel("Post");
		postTitle.setFont(new Font("Monospaced", Font.BOLD, 38)); 
		postTitle.setForeground(Color.BLACK); 
		postTitle.setBounds(130, 0, 250, 40);
		
		ImageIcon imageIcon = new ImageIcon(post.getImageDirection());
		Image image = imageIcon.getImage().getScaledInstance(200, 380, Image.SCALE_DEFAULT);
		ImageIcon resizedIcon = new ImageIcon(image);
		JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setBounds(80, 50, 220, 300);
        
        JButton button = new JButton("Dar LyC");
        button.setBounds(110, 360, 150, 50);
        
        JLabel lyCAmount = new JLabel("Likes & Comments :\n0");
        lyCAmount.setFont(new Font("Monospaced", Font.BOLD, 18));
        lyCAmount.setBounds(60, 410, 300, 80);
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	LikeVisitor visitor = new LikeVisitor();
            	int amount = post.accept(visitor);
            	String StrAmount = String.valueOf(amount);
            	lyCAmount.setText("Likes & Comments : "+StrAmount);
            }
        });
        
		getContentPane().setLayout(null);
		getContentPane().add(postTitle);
		getContentPane().add(imageLabel);
		getContentPane().add(button);
		getContentPane().add(lyCAmount);
	}
}
