package ս��;

import java.util.LinkedList;

import ս������.BattlePanel;
import ��ɫ.LiPo;
import ��ɫ.Role;
import ����.Function;
import ����.PictureName;
import ����.Point;
import �ϰ������ͼ.Barrier;
import �ϰ������ͼ.Map;

/**
 * ս���࣬���н�ɫ�͵�ͼ
 * @author ���ӻ�
 *
 */
public class Battle {
	/**
	 * ս���������
	 */
	public static BattlePanel panel = null;
	
	/**
	 * ս���ϵĵ�ͼ
	 */
	public Map map;
	/**
	 * ս����һ��
	 */
	public LinkedList<Role> firstRole;
	/**
	 * ս����һ���Ѿ������Ľ�ɫ�����ڸ���
	 */
	public LinkedList<Role> deadFirstRole;
	/**
	 * ս������
	 */
	public LinkedList<Role> secondRole;
	/**
	 * ս���϶����Ѿ������Ľ�ɫ�����ڸ���
	 */
	public LinkedList<Role> deadSecondRole;
	
	/**
	 * ���������Ľ�ɫ
	 * @param deadRole �����Ľ�ɫ
	 * @throws InterruptedException ��ɫ��˯����ǰ���ѵ��쳣
	 */
	private void resurgence(Role deadRole) throws InterruptedException {
		Point tempPoint;
		
		//����1000ms����
		Thread.sleep(1000000);
		
		//�������һ��
		if(Function.isFirstRole(deadRole.roleImg.getDescription())) {
			//�뿪��������
			this.deadFirstRole.remove(deadRole);
			//����
			deadRole.setMp(100);
			//Ѱ��λ�ý����ͼ
			while(true) {
				tempPoint = new Point((int)(Math.random()*25),(int)(Math.random()*60));
				
				if(this.map.get(tempPoint).equals(PictureName.SPACE)) {
					deadRole.rolePosition = tempPoint;
					
					break;
				}
			}
			//�����ͼ�����뼯��
			deadRole.enterMap();
			this.firstRole.add(deadRole);
		}
		
		else {
			//�뿪��������
			this.deadSecondRole.remove(deadRole);
			//����
			deadRole.setMp(100);
			//Ѱ��λ�ý����ͼ
			while(true) {
				tempPoint = new Point((int)(Math.random()*25),(int)(Math.random()*60));
				
				if(this.map.get(tempPoint).equals(PictureName.SPACE)) {
					deadRole.rolePosition = tempPoint;
					
					break;
				}
			}
			//�����ͼ�����뼯��
			deadRole.enterMap();
			this.secondRole.add(deadRole);
		}
	}
	
	/**
	 * �����ͼ
	 * @param choosedMap ��ͼ����
	 */
	public Battle(String choosedMap) {
		Barrier barrier[];
		
		if(choosedMap.equals("���ӵ�ͼ")) {
			//�����ϰ���
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
		
		//������ͼ
		this.map = new Map(60,25,barrier);
		
		//����һ��
		this.firstRole = new LinkedList<Role>();
		this.deadFirstRole = new LinkedList<Role>();
		this.firstRole.add(new LiPo(PictureName.ROLE_A,new Point(10,43),200,50,5));
		this.firstRole.add(new LiPo(PictureName.ROLE_B,new Point(2,36),200,50,5));
		this.firstRole.add(new Role(PictureName.ROLE_a,new Point(19,5),100,30,0));
		this.firstRole.add(new Role(PictureName.ROLE_b,new Point(21,10),100,30,0));
		
		//��������
		this.secondRole = new LinkedList<Role>();
		this.deadSecondRole = new LinkedList<Role>();
		this.secondRole.add(new LiPo(PictureName.ROLE_N,new Point(1,6),200,50,5));
		this.secondRole.add(new LiPo(PictureName.ROLE_O,new Point(16,43),200,50,5));
		this.secondRole.add(new Role(PictureName.ROLE_n,new Point(15,20),100,30,0));
		this.secondRole.add(new Role(PictureName.ROLE_o,new Point(12,30),100,30,0));
		
	}
	
	/**
	 * ������ɫ������������
	 * @param deadRole �����Ľ�ɫ
	 */
	public void addDeath(Role deadRole) {
		Runnable run;
		Thread task;
		
		//һ��������ɫ
		if(Function.isFirstRole(deadRole.roleImg.getDescription())) {
			this.deadFirstRole.add(deadRole);
		}
		
		else {
			this.deadSecondRole.add(deadRole);
		}
		
		//���̸߳����ɫ
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
