package com.bookstore.customer.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;


import javax.imageio.ImageIO;




/* ��һ���Ѿ���ɣ���������SecurityCode���ṩ����֤�룬��Ӧ�ÿ�����ô��ͼƬ��д�ַ����ˡ�
 * ��Java�в���ͼƬ����Ҫʹ��BufferedImage�࣬�������ڴ��е�ͼƬ��
 * д�ַ���������Ҫ��ͼƬBufferedImage�ϵõ���ͼͼ��Graphics��Ȼ����ͼ����drawString��


     Ϊ��ʹ��֤����һ���ĸ����ԣ�Ҳ������һЩ��㡣����Graphics���drawRect����1*1��С�ķ���Ϳ����ˡ�


     �ر�˵��һ�£����ں���Ҫ��Strtus2���ʹ�ã�
     ����Struts2����ǰ̨����ͼƬ����ʹ�õ�������������ʽ�������ṩ�˴�ͼƬ������ת������
     */
public class SecurityImage {
/**
 * ������֤��ͼƬ
 * @param securityCode   ��֤���ַ�
 * @return  BufferedImage  ͼƬ
 */
	public static BufferedImage createImage(String securityCode){
		//��֤�볤��
		int codeLength=securityCode.length();
		//�����С
		int fSize = 20;
		int fWidth = fSize + 1;
		//ͼƬ���
		int width = codeLength * fWidth + 6 ;
		//ͼƬ�߶�
	    int height = fSize * 2  -5;
	         
	    //ͼƬ
	    BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	    Graphics g=image.createGraphics();
	         
	    //���ñ���ɫ
	    g.setColor(Color.WHITE);
	    //��䱳��,�ð�ɫ���
	    g.fillRect(0, 0, width, height);
	         
	    //���ñ߿���ɫ
	    g.setColor(Color.LIGHT_GRAY);
	    //�߿�������ʽ
	    g.setFont(new Font("Arial", Font.BOLD, height-2));
	    //���Ʊ߿�
	    g.drawRect(0, 0, width - 1, height -1);
	         
	         
	    //�������
	    Random rand = new Random();
	    //���������ɫ
	    //g.setColor(Color.LIGHT_GRAY);
	    for(int i = 0;i < codeLength * 7;i++){
	         int x = rand.nextInt(width);
	         int y = rand.nextInt(height);
	         g.setColor(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
	        //����1*1��С�ľ���
	         g.drawRect(x, y, 1, 1);
	         //g.setColor(Color.LIGHT_GRAY);
	    }
	         
	    //������֤��
	     int codeY = height - 10;  
	     //����������ɫ����ʽ
	     //g.setColor(new Color(19,148,246));
	     g.setFont(new Font("Georgia", Font.BOLD, fSize+2));
	     for(int i = 0; i < codeLength;i++){
		     g.setColor(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
		     g.drawString(String.valueOf(securityCode.charAt(i)),i * 16 + 5, codeY);
	     }
	     //�ر���Դ
	     g.dispose();
	     return image;
	}
	     
	/**
	 * ������֤��ͼƬ������ʽ
	 * @param securityCode  ��֤��
	 * @return ByteArrayInputStream ͼƬ��
	 */
	public static ByteArrayInputStream getImageAsInputStream(String securityCode){
	     BufferedImage image = createImage(securityCode);
	     return convertImageToStream(image);
	}
	/**
	 * ��BufferedImageת����ByteArrayInputStream
	 * @param image  ͼƬ
	 * @return ByteArrayInputStream ��
	 */
	private static ByteArrayInputStream convertImageToStream(BufferedImage image){
		ByteArrayInputStream inputStream = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte [] bimage=null;
		try {
			ImageIO.write(image, "jpeg", bos);
			bimage=bos.toByteArray();
			inputStream = new ByteArrayInputStream(bimage);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inputStream;
	}
}
