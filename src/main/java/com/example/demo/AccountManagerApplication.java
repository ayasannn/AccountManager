package com.example.demo;

import java.awt.Component;
import java.awt.Window;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountManagerApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AccountManagerApplication.class);
		app.setBannerMode(Mode.OFF);
		app.setHeadless(false);
		app.run(args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		var frame = new JFrame("Spring AccountManager Booster");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(200, 200, 200, 90);
		var jp = new JPanel();
		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
		
		var jl = new JLabel("↓押すとSpringを閉じるよ！↓");
		jl.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		var jb = new JButton("Bootを止める");
		jb.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		jb.addActionListener( e ->  {
				Component c = (Component) e.getSource();
				Window w = SwingUtilities.getWindowAncestor(c);
				w.dispose();
				System.exit(0);
			});
		jp.add(jl);
		jp.add(jb);
		frame.add(jp);
		frame.setVisible(true);
	}
}