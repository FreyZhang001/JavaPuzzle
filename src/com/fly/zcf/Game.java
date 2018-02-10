package com.fly.zcf;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Game extends JPanel{

	/**
	 * test
	 */
	private static final long serialVersionUID = 3L;
	private static final int LEN = 222;
	private static final int WIDTH = 266;
	private long sysDate=System.currentTimeMillis();
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	private static Image[] imgs = null;
	private static int pic[][]={{0,1,2},{3,4,5},{6,7,8}};
	JButton jb=new JButton("重新开始");
	JButton jbt=new JButton("退出游戏");
	static {
		imgs = new Image[] {
				tk.getImage(GameFrame.class.getClassLoader().getResource(
						"imgs/0.png")),
				tk.getImage(GameFrame.class.getClassLoader().getResource(
						"imgs/1.png")),
				tk.getImage(GameFrame.class.getClassLoader().getResource(
						"imgs/2.png")),
				tk.getImage(GameFrame.class.getClassLoader().getResource(
						"imgs/3.png")),
				tk.getImage(GameFrame.class.getClassLoader().getResource(
						"imgs/4.png")),
				tk.getImage(GameFrame.class.getClassLoader().getResource(
						"imgs/5.png")),
				tk.getImage(GameFrame.class.getClassLoader().getResource(
						"imgs/6.png")),
				tk.getImage(GameFrame.class.getClassLoader().getResource(
						"imgs/7.png")),
				tk.getImage(GameFrame.class.getClassLoader().getResource(
						"imgs/8.png")),
				tk.getImage(GameFrame.class.getClassLoader().getResource(
						"imgs/9.png")) };
		}

	private boolean isPass() {
		boolean pass=true;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(pic[i][j]!=3*i+j){
					pass=false;
					break;
				}
			}
		}
		return pass;
	}
	
    @Override
	public void paint(Graphics g) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				g.drawImage(imgs[pic[i][j]], j * LEN, i * WIDTH, this);
			}
		}
		g.setColor(Color.BLUE);
	}
	
	public Game(){
		this.setBounds(0,0,666,798);
		this.setVisible(true);
		for(int i=0;i<200;i++){
			mv((int)(0+Math.random()*(2-0+1)), (int)(0+Math.random()*(2-0+1)));
		}
	}

	public void mouseClicked(MouseEvent e) {
		int x,y;
		x=e.getX()/LEN;
		y=e.getY()/WIDTH;
		if(!isPass()){
			mv(x,y);
			if(isPass()){
				sysDate=System.currentTimeMillis()-sysDate;
				pic[2][2]=9;
				repaint();
				
				JOptionPane.showMessageDialog(null,"你使用"+sysDate/1000+"秒", "提示",
						JOptionPane.INFORMATION_MESSAGE);
				
				
				this.add(jbt);
				jbt.setBounds(270, 350, 100, 30);
				jbt.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							System.exit(0);
							setVisible(false);
							requestFocus();
						}
					});
				
				this.add(jb);
				jb.setBounds(270, 300, 100, 30);
				jb.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						restart();
					}
				});			
			
			}
		}
	}

	private void restart() {
		// TODO Auto-generated method stub
		sysDate=System.currentTimeMillis();
		this.remove(jb);
		this.remove(jbt);
		pic[2][2]=8;
		for(int i=0;i<200;i++){
			mv((int)(0+Math.random()*(2-0+1)), (int)(0+Math.random()*(2-0+1)));
		}
		repaint();
		
	}

	private void mv(int y, int x) {
		// TODO Auto-generated method stub
		int i,j=0;
		int p=0;
		for(i=0;i<3;i++){
			for(j=0;j<3;j++){
				if(pic[i][j]==8)
					{p=pic[i][j];break;}
			}
			if(p==8)
				break;
		}
		if(Math.abs(i-x)<=1&&j==y||Math.abs(j-y)<=1&&i==x){
				pic[i][j]=pic[x][y];
				pic[x][y]=8;
				repaint();
		}
		
	}
	
}
