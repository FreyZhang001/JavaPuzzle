package com.fly.zcf;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.fly.zcf.Game;

public class GameFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Game game;
	JPanel jp;

	public GameFrame(){
		this.setTitle("拼图");
		this.setBounds(200, 0, 666, 798);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //this.setLayout(null);
		this.setVisible(true);
	
	
	    jp = new JPanel() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 2L;

				@Override
				public void paintComponent(Graphics g) {
				super.paintComponent(g);
					
				ImageIcon   img=new   ImageIcon(Thread.currentThread().getContextClassLoader().getResource("").getPath()+"imgs/10.png");
				g.drawImage(img.getImage(), 0, 0, null);
				}
		};
		
		this.add(jp);
		jp.setLayout(null);
		
		JButton jb1 = new JButton("开始游戏");
		jp.add(jb1);
		jb1.setBounds(270, 300, 100, 30);
		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startGame();
				requestFocus();
			}
		});
		
		JButton jb2 = new JButton("操作说明");
		jp.add(jb2);
		jb2.setBounds(270, 350, 100, 30);
        jb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "\t               点击"
						+ "\t\n            完成拼图", "操作说明",
						JOptionPane.INFORMATION_MESSAGE);
				requestFocus();
			}
		});
		
        JButton jb3 = new JButton("退出游戏");
		jp.add(jb3);
		jb3.setBounds(270, 400, 100, 30);
		jb3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				setVisible(false);
				requestFocus();
			}
		});
		
		this.requestFocus();
		
		
	}
	
	public void startGame(){
		game=new Game();
		repaint();
		this.remove(jp);
		this.setLayout(null);
		this.add(game);
		this.getContentPane().addMouseListener(new mouseProcassor());
	}
	
	class mouseProcassor extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e){
			game.mouseClicked(e);
		}
	}

	
	
	public static void main(String[] args) {
		new GameFrame();	
	}

}
