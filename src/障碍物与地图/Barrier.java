package 障碍物与地图;

import 辅助.Point;

/**
 * 障碍物类
 * @author 蔡子辉
 *
 */
public class Barrier {
	/**
	 * 障碍物位置
	 */
	public Point position;
	/**
	 * 障碍物宽与高
	 */
	public int width,height;
	
	/**
	 * 构建障碍物 
	 * @param position 障碍物坐标
	 * @param width 障碍物宽
	 * @param height 障碍物高
	 */
	public Barrier(Point position,int width,int height) {
		this.position = position;
		this.width = width;
		this.height = height;
	}
}
