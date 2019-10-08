package com.test.algorithms;

import java.io.IOException;

public class RectangleOverlapping {

	static class Point {
		private int x;
		
		private int y;

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
	}

	static class Rectangle {
		private Point lowerLeftPoint;
		
		private Point rightUpperPoint;
		
		public Rectangle() {
			// TODO Auto-generated constructor stub
		}

		public Rectangle(int x, int y, int width, int height) {
			lowerLeftPoint = new Point();
			rightUpperPoint = new Point();
			
			lowerLeftPoint.x = x;
			lowerLeftPoint.y = y;

			rightUpperPoint.x = lowerLeftPoint.x + width;
			rightUpperPoint.y = lowerLeftPoint.y + height;
		}

		public Point getLowerLeftPoint() {
			return lowerLeftPoint;
		}

		public Point getRightUpperPoint() {
			return rightUpperPoint;
		}
	}
	
	public static void main(String[] args) throws IOException {
		String input = "300 300 200 240 120 80 80 120";
		/*
		 * InputStreamReader reader = new InputStreamReader(System.in,
		 * StandardCharsets.UTF_8); BufferedReader in = new BufferedReader(reader);
		 * String line; while ((line = in.readLine()) != null) {
		 * System.out.println(line); }
		 */

		
		String[] r = input.split(" ");

		Rectangle first = new Rectangle(Integer.parseInt(r[0]), Integer.parseInt(r[1]), Integer.parseInt(r[2]),
				Integer.parseInt(r[3]));
		
		Rectangle second = new Rectangle(Integer.parseInt(r[4]), Integer.parseInt(r[5]), Integer.parseInt(r[6]),
				Integer.parseInt(r[7]));
		
		if (isOverlapping(first, second)) {
			System.out.println("Overlapping"); 
		} else {
			System.out.println("Not overrlapping"); 
		}
	}
	
	public static boolean isOverlapping(Rectangle first, Rectangle second) {
		if (first.getRightUpperPoint().getY() < second.getLowerLeftPoint().getY() 
				|| first.getLowerLeftPoint().getY() > second.getRightUpperPoint().getY()) {
			return false;
		}
		
		if (first.getRightUpperPoint().getX() < second.getLowerLeftPoint().getX() 
			 || first.getLowerLeftPoint().getX() > second.getRightUpperPoint().getX()) {
				return false;
		}
		return true;
	}
}
