package 战场;

import java.util.LinkedList;

import 战斗界面.BattlePanel;
import 角色.LiPo;
import 角色.Role;
import 辅助.Function;
import 辅助.PictureName;
import 辅助.Point;
import 障碍物与地图.Barrier;
import 障碍物与地图.Map;

/**
 * 战场类，具有角色和地图
 * @author 蔡子辉
 *
 */
public class Battle {
	/**
	 * 战场载体面板
	 */
	public static BattlePanel panel = null;
	
	/**
	 * 战场上的地图
	 */
	public Map map;
	/**
	 * 战场的一队
	 */
	public LinkedList<Role> firstRole;
	/**
	 * 战场上一队已经死亡的角色，用于复活
	 */
	public LinkedList<Role> deadFirstRole;
	/**
	 * 战场二队
	 */
	public LinkedList<Role> secondRole;
	/**
	 * 战场上二队已经死亡的角色，用于复活
	 */
	public LinkedList<Role> deadSecondRole;
	
	/**
	 * 复活死亡的角色
	 * @param deadRole 死亡的角色
	 * @throws InterruptedException 角色沉睡被提前唤醒的异常
	 */
	private void resurgence(Role deadRole) throws InterruptedException {
		Point tempPoint;
		
		//经过1000ms复活
		Thread.sleep(1000000);
		
		//复活的是一队
		if(Function.isFirstRole(deadRole.roleImg.getDescription())) {
			//离开死亡集合
			this.deadFirstRole.remove(deadRole);
			//复活
			deadRole.setMp(100);
			//寻找位置进入地图
			while(true) {
				tempPoint = new Point((int)(Math.random()*25),(int)(Math.random()*60));
				
				if(this.map.get(tempPoint).equals(PictureName.SPACE)) {
					deadRole.rolePosition = tempPoint;
					
					break;
				}
			}
			//进入地图，进入集合
			deadRole.enterMap();
			this.firstRole.add(deadRole);
		}
		
		else {
			//离开死亡集合
			this.deadSecondRole.remove(deadRole);
			//复活
			deadRole.setMp(100);
			//寻找位置进入地图
			while(true) {
				tempPoint = new Point((int)(Math.random()*25),(int)(Math.random()*60));
				
				if(this.map.get(tempPoint).equals(PictureName.SPACE)) {
					deadRole.rolePosition = tempPoint;
					
					break;
				}
			}
			//进入地图，进入集合
			deadRole.enterMap();
			this.secondRole.add(deadRole);
		}
	}
	
	/**
	 * 构造地图
	 * @param choosedMap 地图类型
	 */
	public Battle(String choosedMap) {
		Barrier barrier[];
		
		if(choosedMap.equals("复杂地图")) {
			//构造障碍物
			barrier = new Barrier[9];
			barrier[0] = new Barrier(new Point(15,35) ,4,3);
			barrier[1] = new Barrier(new Point(19,20) ,6,4);
			barrier[2] = new Barrier(new Point(7,25)  ,6,3);
			barrier[3] = new Barrier(new Point(5,46)  ,8,4);
			barrier[4] = new Barrier(new Point(8,3)   ,8,3);
			barrier[5] = new Barrier(new Point(1,13)  ,8,2);
			barrier[6] = new Barrier(new Point(14,8)  ,6,3);
			barrier[7] = new Barrier(new Point(16,46) ,10,1);
			barrier[8] = new Barrier(new Point(19,42) ,2,4);
		}
		
		else {
			barrier = new Barrier[0];
		}
		
		//构建地图
		this.map = new Map(60,25,barrier);
		
		//构建一队
		this.firstRole = new LinkedList<Role>();
		this.deadFirstRole = new LinkedList<Role>();
		this.firstRole.add(new LiPo(PictureName.ROLE_A,new Point(10,43),200,50,5));
		this.firstRole.add(new LiPo(PictureName.ROLE_B,new Point(2,36),200,50,5));
		this.firstRole.add(new Role(PictureName.ROLE_a,new Point(19,5),100,30,0));
		this.firstRole.add(new Role(PictureName.ROLE_b,new Point(21,10),100,30,0));
		
		//构建二队
		this.secondRole = new LinkedList<Role>();
		this.deadSecondRole = new LinkedList<Role>();
		this.secondRole.add(new LiPo(PictureName.ROLE_N,new Point(1,6),200,50,5));
		this.secondRole.add(new LiPo(PictureName.ROLE_O,new Point(16,43),200,50,5));
		this.secondRole.add(new Role(PictureName.ROLE_n,new Point(15,20),100,30,0));
		this.secondRole.add(new Role(PictureName.ROLE_o,new Point(12,30),100,30,0));
		
	}
	
	/**
	 * 死亡角色加入死亡集合
	 * @param deadRole 死亡的角色
	 */
	public void addDeath(Role deadRole) {
		Runnable run;
		Thread task;
		
		//一队死亡角色
		if(Function.isFirstRole(deadRole.roleImg.getDescription())) {
			this.deadFirstRole.add(deadRole);
		}
		
		else {
			this.deadSecondRole.add(deadRole);
		}
		
		//新线程复活角色
		run = new Runnable() {
			public void run() {
				try {
					resurgence(deadRole);
				} 
				catch (InterruptedException e) {
				}
			}
		};
		
		task = new Thread(run); 
		
		task.start();
	}
}
