package 角色;

import 辅助.ComplexShell;
import 辅助.PictureName;
import 辅助.Point;

/**
 * 李白类，具有复杂攻击技能
 * @author 蔡子辉
 *
 */
public class LiPo extends Role{
	//私有方法区
	/**
	 * 往左复杂攻击
	 * @throws InterruptedException 线程被提前唤醒的异常
	 */
	private void complexAttackLeft() throws InterruptedException {
		ComplexShell shell = new ComplexShell(this.rolePosition,PictureName.COMPLEX_SHELL,50,this);
		String result;
		
		while(true) {
			
			result = shell.leftUp();
			if(result.equals("成功前行")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
			
			result = shell.leftDown();
			if(result.equals("成功前行")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
			
			result = shell.leftDown();
			if(result.equals("成功前行")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
			
			result = shell.leftUp();
			if(result.equals("成功前行")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
		}
	}
	
	/**
	 * 往右复杂攻击
	 * @throws InterruptedException 线程被提前唤醒的异常
	 */
	private void complexAttackRight() throws InterruptedException {
		ComplexShell shell = new ComplexShell(this.rolePosition,PictureName.COMPLEX_SHELL,50,this);
		String result;
		
		while(true) {
			
			result = shell.rightUp();
			if(result.equals("成功前行")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
			
			result = shell.rightDown();
			if(result.equals("成功前行")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
			
			result = shell.rightDown();
			if(result.equals("成功前行")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
			
			result = shell.rightUp();
			if(result.equals("成功前行")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
		}
	}
	
	/**
	 * 往上复杂攻击
	 * @throws InterruptedException 线程被提前唤醒的异常
	 */
	private void complexAttackUp() throws InterruptedException {
		ComplexShell shell = new ComplexShell(this.rolePosition,PictureName.COMPLEX_SHELL,50,this);
		String result;
		
		while(true) {
			
			result = shell.rightUp();
			if(result.equals("成功前行")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
			
			result = shell.leftUp();
			if(result.equals("成功前行")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
			
			result = shell.leftUp();
			if(result.equals("成功前行")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
			
			result = shell.rightUp();
			if(result.equals("成功前行")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
		}
	}
	
	/**
	 * 往下复杂攻击
	 * @throws InterruptedException 线程被提前唤醒的异常
	 */
	private void complexAttackDown() throws InterruptedException {
		ComplexShell shell = new ComplexShell(this.rolePosition,PictureName.COMPLEX_SHELL,50,this);
		String result;
		
		while(true) {
			
			result = shell.rightDown();
			if(result.equals("成功前行")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
			
			result = shell.leftDown();
			if(result.equals("成功前行")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
			
			result = shell.leftDown();
			if(result.equals("成功前行")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
			
			result = shell.rightDown();
			if(result.equals("成功前行")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
		}
	}
	
	//公有方法区：
	/**
	 * 构造李白角色
	 * @param roleImgName 角色指定的图片
	 * @param rolePosition 角色指定的位置
	 * @param Mp 生命值
	 * @param Hp 魔法值
	 * @param Exp 经验值
	 */
	public LiPo(String roleImgName, Point rolePosition, int Mp, int Hp, int Exp) {
		super(roleImgName, rolePosition, Mp, Hp, Exp);
	}

	/**
	 * 复杂攻击
	 * @param direction 攻击方向
	 */
	public void complexAttack(String direction) {
		Runnable run = null;
		Thread task;
		
		if(direction.equals("上")) {
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
		
		else if(direction.equals("下")) {
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
		
		else if(direction.equals("左")) {
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
		
		else if(direction.equals("右")) {
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
