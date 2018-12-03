package 障碍物与地图;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import 战斗界面.BattlePanel;
import 辅助.PictureName;
import 辅助.Point;
import 辅助.Function;

/**
 * 地图类
 * @author 蔡子辉
 *
 */
public class Map {
	/**
	 * 地图的面板载体
	 */
	public static BattlePanel panel = null;
	/**
	 * 地图的图片
	 */
	public ImageIcon mapImg[][];
	/**
	 * 地图的图片的载体--标签
	 */
	public JLabel mapLabel[][];
	
	/**
	 * 为地图增加单个障碍物
	 * @param barrier 障碍物
	 */
	private void addBarrier(Barrier barrier) {
		int i,j;
		int beginX,beginY;
		
		beginX = barrier.position.getX();
		beginY = barrier.position.getY();
		
		for(i=0 ; i<barrier.height && beginX+i<mapImg.length ; i++) {
			for(j=0 ; j<barrier.width && beginY+j<mapImg[i].length ; j++) {
				mapImg[beginX+i][beginY+j] = new ImageIcon(PictureName.WALL);
				
				mapLabel[beginX+i][beginY+j].setIcon(mapImg[beginX+i][beginY+j]);
			}
		}
	}
	
	/**
	 * 构造地图
	 * @param width 地图宽
	 * @param height 地图高
	 * @param barrier 地图上所有的障碍物
	 */
	public Map(int width,int height,Barrier barrier[]) {
		int i,j;
		
		mapImg = new ImageIcon[height][width];
		mapLabel = new JLabel[height][width];
		
		for(i=0 ; i<mapImg.length ; i++) {
			//第一行与最后一行特殊，全是墙
			if(i==0 || i==mapImg.length-1) {
				for(j=0 ; j<mapImg[i].length ; j++) {
					mapImg[i][j] = new ImageIcon(PictureName.WALL);
					mapLabel[i][j] = new JLabel(mapImg[i][j]);
					
					panel.add(mapLabel[i][j]);
					mapLabel[i][j].setBounds(j*30, i*30, 30, 30);
				}
			}
			
			else {
				for(j=0 ; j<mapImg[i].length ; j++) {
					if(j==0 || j==mapImg[i].length-1) {
						mapImg[i][j] = new ImageIcon(PictureName.WALL);
						mapLabel[i][j] = new JLabel(mapImg[i][j]);
					}
					
					else {
						mapImg[i][j] = new ImageIcon(PictureName.SPACE);
						mapLabel[i][j] = new JLabel(mapImg[i][j]);
					}
					
					panel.add(mapLabel[i][j]);
					mapLabel[i][j].setBounds(j*30, i*30, 30, 30);
				}
			}
		}
		
		//处理障碍物
		for(i=0 ; i<barrier.length ; i++) {
			this.addBarrier(barrier[i]);
		}
	}
	
	/**
	 * 判断一个点是否在地图上
	 * @param position 点的位置
	 * @return boolean
	 */
	public boolean contains(Point position) {
		if(position.getX() >= 0 && position.getX() < mapImg.length 
		&& position.getY() >= 0 && position.getY() < mapImg[0].length) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * 获取指定点的图片描述
	 * @param position 指定点
	 * @return String 该点的图片描述
	 */
	public String get(Point position) {
		if(contains(position)) {
			return mapImg[position.getX()][position.getY()].getDescription();
		}
		
		return null;
	}
	
	/**
	 * 更改地图上指定点的图片，只能更改空白格
	 * @param position 指定点
	 * @param description 图片描述
	 * @return boolean 更改是否成功的信息
	 */
	public boolean replace(Point position,String description) {
		String tempDescription;
		
		if(contains(position)) {
			tempDescription = get(position);
			
			//不是墙、英雄
			if(tempDescription.equals(PictureName.WALL)==false && Function.isRole(tempDescription)==false) {
				
				mapImg[position.getX()][position.getY()] = new ImageIcon(description);
				mapLabel[position.getX()][position.getY()].setIcon(mapImg[position.getX()][position.getY()]);
				
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 更改地图上指定点的图片，除了墙，其他的都能更改
	 * @param position 指定点
	 * @param description 图片描述
	 * @return boolean 更改是否成功的信息
	 */
	public boolean sharpReplace(Point position,String description) {
		String tempDescription;
		
		if(contains(position)) {
			tempDescription = get(position);
			
			//不是墙
			if(tempDescription.equals(PictureName.WALL)==false) {
				mapImg[position.getX()][position.getY()] = new ImageIcon(description);
				mapLabel[position.getX()][position.getY()].setIcon(mapImg[position.getX()][position.getY()]);
				
				return true;
			}
		}
		
		return false;
	}
}
