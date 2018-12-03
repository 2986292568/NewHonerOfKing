package ��ɫ;

import ����.ComplexShell;
import ����.PictureName;
import ����.Point;

/**
 * ����࣬���и��ӹ�������
 * @author ���ӻ�
 *
 */
public class LiPo extends Role{
	//˽�з�����
	/**
	 * �����ӹ���
	 * @throws InterruptedException �̱߳���ǰ���ѵ��쳣
	 */
	private void complexAttackLeft() throws InterruptedException {
		ComplexShell shell = new ComplexShell(this.rolePosition,PictureName.COMPLEX_SHELL,50,this);
		String result;
		
		while(true) {
			
			result = shell.leftUp();
			if(result.equals("�ɹ�ǰ��")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
			
			result = shell.leftDown();
			if(result.equals("�ɹ�ǰ��")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
			
			result = shell.leftDown();
			if(result.equals("�ɹ�ǰ��")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
			
			result = shell.leftUp();
			if(result.equals("�ɹ�ǰ��")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
		}
	}
	
	/**
	 * ���Ҹ��ӹ���
	 * @throws InterruptedException �̱߳���ǰ���ѵ��쳣
	 */
	private void complexAttackRight() throws InterruptedException {
		ComplexShell shell = new ComplexShell(this.rolePosition,PictureName.COMPLEX_SHELL,50,this);
		String result;
		
		while(true) {
			
			result = shell.rightUp();
			if(result.equals("�ɹ�ǰ��")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
			
			result = shell.rightDown();
			if(result.equals("�ɹ�ǰ��")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
			
			result = shell.rightDown();
			if(result.equals("�ɹ�ǰ��")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
			
			result = shell.rightUp();
			if(result.equals("�ɹ�ǰ��")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
		}
	}
	
	/**
	 * ���ϸ��ӹ���
	 * @throws InterruptedException �̱߳���ǰ���ѵ��쳣
	 */
	private void complexAttackUp() throws InterruptedException {
		ComplexShell shell = new ComplexShell(this.rolePosition,PictureName.COMPLEX_SHELL,50,this);
		String result;
		
		while(true) {
			
			result = shell.rightUp();
			if(result.equals("�ɹ�ǰ��")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
			
			result = shell.leftUp();
			if(result.equals("�ɹ�ǰ��")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
			
			result = shell.leftUp();
			if(result.equals("�ɹ�ǰ��")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
			
			result = shell.rightUp();
			if(result.equals("�ɹ�ǰ��")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
		}
	}
	
	/**
	 * ���¸��ӹ���
	 * @throws InterruptedException �̱߳���ǰ���ѵ��쳣
	 */
	private void complexAttackDown() throws InterruptedException {
		ComplexShell shell = new ComplexShell(this.rolePosition,PictureName.COMPLEX_SHELL,50,this);
		String result;
		
		while(true) {
			
			result = shell.rightDown();
			if(result.equals("�ɹ�ǰ��")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
			
			result = shell.leftDown();
			if(result.equals("�ɹ�ǰ��")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
			
			result = shell.leftDown();
			if(result.equals("�ɹ�ǰ��")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
			
			result = shell.rightDown();
			if(result.equals("�ɹ�ǰ��")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
		}
	}
	
	//���з�������
	/**
	 * ������׽�ɫ
	 * @param roleImgName ��ɫָ����ͼƬ
	 * @param rolePosition ��ɫָ����λ��
	 * @param Mp ����ֵ
	 * @param Hp ħ��ֵ
	 * @param Exp ����ֵ
	 */
	public LiPo(String roleImgName, Point rolePosition, int Mp, int Hp, int Exp) {
		super(roleImgName, rolePosition, Mp, Hp, Exp);
	}

	/**
	 * ���ӹ���
	 * @param direction ��������
	 */
	public void complexAttack(String direction) {
		Runnable run = null;
		Thread task;
		
		if(direction.equals("��")) {
			run = new Runnable() {
				public void run() {
					try {
						complexAttackUp();
						
					} 
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		}
		
		else if(direction.equals("��")) {
			run = new Runnable() {
				public void run() {
					try {
						complexAttackDown();
						
					} 
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		}
		
		else if(direction.equals("��")) {
			run = new Runnable() {
				public void run() {
					try {
						complexAttackLeft();
						
					} 
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		}
		
		else if(direction.equals("��")) {
			run = new Runnable() {
				public void run() {
					try {
						complexAttackRight();
						
					} 
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		}
		
		if(run != null) {
			task = new Thread(run);
			
			task.start();
		}
	}
	
}
