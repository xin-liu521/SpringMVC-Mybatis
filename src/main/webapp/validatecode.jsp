<!-- 验证码生成工具页面 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="java.util.Random"%>
<%@ page import="java.io.OutputStream"%>
<%@ page import="java.awt.Color"%>
<%@ page import="java.awt.Font"%>
<%@ page import="java.awt.Graphics"%>
<%@ page import="java.awt.image.BufferedImage"%>
<%@ page import="javax.imageio.ImageIO"%>
<%
	int width = 80;
	int height = 32;
	//create the image
	BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	Graphics g = image.getGraphics();
	// set the background color
	g.setColor(new Color(0xDCDCDC));
	g.fillRect(0, 0, width, height);
	// draw the border
	g.setColor(Color.black);
	g.drawRect(0, 0, width - 1, height - 1);
	// create a random instance to generate the codes
	Random rdm = new Random();
	// 定义验证码的位数
	int size = 4;
	//String hash1 = String.valueOf(rdm.nextInt());

	// 定义变量保存生成的验证码
	String vCode = "";
	char c;
	// 产生验证码
	for (int i = 0; i < size; i++) {
		// 产生一个26以内的随机整数
		int number = rdm.nextInt(26);
		// 如果生成的是偶数，则随机生成一个数字
		if (number % 2 == 0) {
			c = (char) ('0' + (char) ((int) (Math.random() * 10)));
			// 如果生成的是偶数，则随机生成一个数字
		} else {
			c = (char) ('0' + (char) ((int) (Math.random() * 10)));
		}
		vCode = vCode + c;
	}

	// make some confusion
	for (int i = 0; i < 50; i++) {
		int x = rdm.nextInt(width);
		int y = rdm.nextInt(height);
		g.drawOval(x, y, 0, 0);
	}
//	// 产生随机的验证码
//	String capstr = hash1.substring(0, 4);
	//把验证码保存到session
	session.setAttribute("key", vCode);
	g.setColor(new Color(0, 100, 0));
	g.setFont(new Font("Candara", Font.BOLD, 24));
	g.drawString(vCode, 8, 24);
	g.dispose();
	response.setContentType("image/jpeg");
	out.clear();
	out = pageContext.pushBody();
	OutputStream strm = response.getOutputStream();
	ImageIO.write(image, "jpeg", strm);
	strm.close();
%>