package 辅助;

import 战斗界面.BattlePanel;

/**
 * 点类
 * @author 蔡子辉
 *
 */
public class Point {
	public static BattlePanel panel = null;
	
	private int x = 0;
	private int y = 0;
	
	public Point(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point() {}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}

	public Point setXY(int x,int y) {
		return new Point(x,y);
	}
	
	public Point setX(int x) {
		return new Point(x,this.y);
	}
	
	public Point setY(int y) {
		return new Point(this.x,y);
	}
	
	
	public String getRelationWith(Point anotherPoint) {
		String result = "";
		
		if(anotherPoint.y < this.y) {
			result += "左";
		}
		
		else {
			result += "右";
		}
		
		if(anotherPoint.x < this.x) {
			result += "上";
		}
		
		else {
			result += "下";
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
}
