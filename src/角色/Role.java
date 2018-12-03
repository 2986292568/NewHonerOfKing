package 角色;

import javax.swing.ImageIcon;

import 战斗界面.BattlePanel;
import 辅助.PictureName;
import 辅助.Point;
import 辅助.SimpleShell;

/**
 * 普通角色
 * @author 蔡子辉
 *
 */
public class Role implements ForRole {
	//静态数据区：
	/**
	 * 角色的载体，面板
	 */
	static public BattlePanel panel = null;
	
	//非静态数据区：
	/**
	 * 生命值，初始值为100
	 */
	public int Mp;
	/**
	 * 魔法值，初始值为30
	 */
	public int Hp;
	/**
	 * 经验值，初始值为0
	 */
	public int Exp;
	/**
	 * 角色模样 ，区别于其他角色的标志
	 */
    public ImageIcon roleImg;
    /**
     * 角色位置，构造角色时也必须指定。虽指定了位置，但英雄未进入地图
     */
    public Point rolePosition;
    
	
    
    //私有方法区：
    /**
     * 往上简单攻击
     * @throws InterruptedException 线程被提前唤醒的异常
     */
    private void simpleAttackUp() throws InterruptedException {
    	SimpleShell shell = new SimpleShell(this.rolePosition,PictureName.UP_SHELL,25,this);
    	String result;
    	
    	while(true) {
    		result = shell.up();
    		
    		if(result.equals("成功前行")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
    	}
    }
    
    /**
     * 往下简单攻击
     * @throws InterruptedException 线程被提前唤醒的异常
     */
    private void simpleAttackDown() throws InterruptedException {
    	SimpleShell shell = new SimpleShell(this.rolePosition,PictureName.DOWN_SHELL,25,this);
    	String result;
    	
    	while(true) {
    		result = shell.down();
    		
    		if(result.equals("成功前行")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
    	}
    }
    
    /**
     * 往左简单攻击
     * @throws InterruptedException 线程被提前唤醒的异常
     */
    private void simpleAttackLeft() throws InterruptedException {
    	SimpleShell shell = new SimpleShell(this.rolePosition,PictureName.LEFT_SHELL,25,this);
    	String result;
    	
    	while(true) {
    		result = shell.left();
    		
    		if(result.equals("成功前行")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
    	}
    }
    
    /**
     * 往右简单攻击
     * @throws InterruptedException 线程被提前唤醒的异常
     */
    private void simpleAttackRight() throws InterruptedException {
    	SimpleShell shell = new SimpleShell(this.rolePosition,PictureName.RIGHT_SHELL,25,this);
    	String result;
    	
    	while(true) {
    		result = shell.right();
    		
    		if(result.equals("成功前行")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
    	}
    }
    
    /**
     * 判断是否可以往左走n步
     * @param n 指定的步数
     * @return boolean
     */
    private boolean canGoLeft(int n) {
    	int i;
    	
    	for(i=1 ; i<=n ; i++) {
    		//有墙不能走
    		if(panel.battle.map.get(this.rolePosition.setY(this.rolePosition.getY()-i)).equals(PictureName.WALL)) {
    			return false;
    		}
    	}
    	
    	return true;	
    }
    
    /**
     * 判断是否可以往右走n步
     * @param n 指定的步数
     * @return boolean
     */
    private boolean canGoRight(int n) {
    	int i;
    	
    	for(i=1 ; i<=n ; i++) {
    		//有墙不能走
    		if(panel.battle.map.get(this.rolePosition.setY(this.rolePosition.getY()+i)).equals(PictureName.WALL)) {
    			return false;
    		}
    	}
    	
    	return true;	
    }
    
    /**
     * 往上走n步
     * @param n 指定的步数
     * @return boolean 是否成功走了n步
     * @throws InterruptedException 线程被提前唤醒的异常
     */
    private boolean goUp(int n) throws InterruptedException {
    	int i;
    	
    	for(i=1 ; i<=n ; i++) {
    		//有可能碰到人物
    		if(this.goForward("上") == false) {
    			return false;
    		}
    		
    		Thread.sleep(100);
    	}
    	
    	return true;
    }
    
    /**
     * 往下走n步
     * @param n 指定的步数
     * @return boolean 是否成功走了n步
     * @throws InterruptedException 线程被提前唤醒的异常
     */
    private boolean goDown(int n) throws InterruptedException {
    	int i;
    	
    	for(i=1 ; i<=n ; i++) {
    		//有可能碰到人物
    		if(this.goForward("下") == false) {
    			return false;
    		}
    		
    		Thread.sleep(100);
    	}
    	
    	return true;
    }
    
    /**
     * 往左走n步
     * @param n 指定的步数
     * @return boolean 是否成功走了n步
     * @throws InterruptedException 线程被提前唤醒的异常
     */
    private boolean goLeft(int n) throws InterruptedException {
    	int i;
    	
    	for(i=1 ; i<=n ; i++) {
    		//有可能碰到人物
    		if(this.goForward("左") == false) {
    			return false;
    		}
    		
    		Thread.sleep(100);
    	}
    	
    	return true;
    }
    
    /**
     * 往右走n步
     * @param n 指定的步数
     * @return boolean 是否成功走了n步
     * @throws InterruptedException 线程被提前唤醒的异常
     */
    private boolean goRight(int n) throws InterruptedException {
    	int i;
    	
    	for(i=1 ; i<=n ; i++) {
    		//有可能碰到人物
    		if(this.goForward("右") == false) {
    			return false;
    		}
    		
    		Thread.sleep(100);
    	}
    	
    	return true;
    }
    
    /**
     * 往左上方向走
     * @param anotherPoint 目标点
     * @throws InterruptedException 线程被提前唤醒的异常
     */
    private synchronized void goLeftUp(Point anotherPoint) throws InterruptedException {
    	int leftN,upN;
    	
    	//左走和上走的步数
    	leftN = this.rolePosition.getY()-anotherPoint.getY();
    	upN = this.rolePosition.getX()-anotherPoint.getX();
    	
    	
    	//先左后上
		//左能走，直接走
		if(this.canGoLeft(leftN)) {
			//左走成功，再向上走
			if(this.goLeft(leftN)) {
				this.goUp(upN);
			}
		}
		
		//不管能不能走，直接先上后左
		else {
			if(this.goUp(upN)) {
				this.goLeft(leftN);
			}
		}
    }
    
    /**
     * 往左下方向走
     * @param anotherPoint 目标点
     * @throws InterruptedException 线程被提前唤醒的异常
     */
    private synchronized void goLeftDown(Point anotherPoint) throws InterruptedException {
    	int leftN,downN;
    	
    	leftN = this.rolePosition.getY() - anotherPoint.getY();
    	downN = anotherPoint.getX() - this.rolePosition.getX();
    	
    	//先左后下
    	if(this.canGoLeft(leftN)) {
    		if(this.goLeft(leftN)) {
    			this.goDown(downN);
    		}
    	}
    	
    	//不管能不能走，直接先下后左
    	else {
    		if(this.goDown(downN)) {
    			this.goLeft(leftN);
    		}
    	}
    }
    
    /**
     * 往右上方向走
     * @param anotherPoint 目标点
     * @throws InterruptedException 线程被提前唤醒的异常
     */
    private synchronized void goRightUp(Point anotherPoint) throws InterruptedException {
    	int rightN,upN;
    	
    	rightN = anotherPoint.getY() - this.rolePosition.getY();
    	upN = this.rolePosition.getX() - anotherPoint.getX();
    	
    	//先右后上
    	if(this.canGoRight(rightN)) {
    		if(this.goRight(rightN)) {
    			this.goUp(upN);
    		}
    	}
    	
    	//直接先上后右
    	else {
    		if(this.goUp(upN)) {
    			this.goRight(rightN);
    		}
    	}
    }
    
    /**
     * 往右下方向走
     * @param anotherPoint 目标点
     * @throws InterruptedException 线程被提前唤醒的异常
     */
    private synchronized void goRightDown(Point anotherPoint) throws InterruptedException {
    	int rightN,downN;
    	
    	rightN = anotherPoint.getY() - this.rolePosition.getY();
    	downN = anotherPoint.getX() - this.rolePosition.getX();
    	
    	//先右后下
    	if(this.canGoRight(rightN)) {
    		if(this.goRight(rightN)) {
    			this.goDown(downN);
    		}
    	}
    	
    	//直接先下后右
    	else {
    		if(this.goDown(downN)) {
    			this.goRight(rightN);
    		}
    	}
    }
    
       
    //公有方法区：
    /**
     * 构造角色
     * @param Mp 生命值
     * @param Hp 魔法值
     * @param Exp 经验值 
     * @param roleImgName 英雄图片名称
     * @param rolePosition 角色位置 
     */
    public Role(String roleImgName,Point rolePosition,int Mp,int Hp,int Exp) {
    	this.roleImg = new ImageIcon(roleImgName);
    	this.rolePosition = rolePosition;
    	this.Mp = Mp;
    	this.Hp = Hp;
    	this.Exp = Exp;
    }
	
    public void enterMap() {
		panel.battle.map.replace(this.rolePosition, roleImg.getDescription());
	}

    public void exitMap() {
		panel.battle.map.sharpReplace(this.rolePosition, PictureName.SPACE);
	}
	
    public void setMp(int Mp) {
    	this.Mp = Mp;
    }
	
    public boolean goForward(String direction) {
		if(direction.equals("上")) {
			if(panel.battle.map.get(this.rolePosition.setX(this.rolePosition.getX()-1)).equals(PictureName.SPACE)) { //如果可以往上走
				panel.battle.map.sharpReplace(this.rolePosition, PictureName.SPACE);
    			this.rolePosition = this.rolePosition.setX(this.rolePosition.getX()-1);
    			panel.battle.map.replace(this.rolePosition, this.roleImg.getDescription());
    			
    			return true;
    		}
		}
    				
    	else if(direction.equals("下")) {
    		if(panel.battle.map.get(this.rolePosition.setX(this.rolePosition.getX()+1)).equals(PictureName.SPACE)) { //如果可以往上走
				panel.battle.map.sharpReplace(this.rolePosition, PictureName.SPACE);
    			this.rolePosition = this.rolePosition.setX(this.rolePosition.getX()+1);
    			panel.battle.map.replace(this.rolePosition, this.roleImg.getDescription());
    			
    			return true;
    		}
    	}
    			
    	else if(direction.equals("左")) {
    		if(panel.battle.map.get(this.rolePosition.setY(this.rolePosition.getY()-1)).equals(PictureName.SPACE)) { //如果可以往左走
    			panel.battle.map.sharpReplace(this.rolePosition, PictureName.SPACE);
    			this.rolePosition = this.rolePosition.setY(this.rolePosition.getY()-1);
    			panel.battle.map.replace(rolePosition, this.roleImg.getDescription());
    			
    			return true;
    		}
    	}
    				
    	else if(direction.equals("右")) {
    		if(panel.battle.map.get(this.rolePosition.setY(this.rolePosition.getY()+1)).equals(PictureName.SPACE)) { //如果可以往左走
    			panel.battle.map.sharpReplace(this.rolePosition, PictureName.SPACE);
    			this.rolePosition = this.rolePosition.setY(this.rolePosition.getY()+1);
    			panel.battle.map.replace(rolePosition, this.roleImg.getDescription());
    			
    			return true;
    		}
    	}	
    	
    	return false;
    }

	public void simpleAttack(String direction) {
		Runnable run = null;
		Thread task;
		
		if(direction.equals("上")) {
			run = new Runnable() {
				public void run() {
					try {
						simpleAttackUp();
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
						simpleAttackDown();
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
						simpleAttackLeft();
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
						simpleAttackRight();
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

	public boolean isDead() {
		if(this.Mp <= 0) {
			return true;
		}
		
		return false;
	}
	
	public void goTo(Point anotherPoint) {
		String relation;
		Runnable run;
		Thread task;
		
		relation = this.rolePosition.getRelationWith(anotherPoint);
		run = null;
		
		if(relation.equals("左上")) {
			run = new Runnable() {
				public void run() {
					try {
						goLeftUp(anotherPoint);
					} 
					catch (InterruptedException e) {
					}
				}
			};
		}
		
		else if(relation.equals("左下")) {
			run = new Runnable() {
				public void run() {
					try {
						goLeftDown(anotherPoint);
					} 
					catch (InterruptedException e) {
					}
				}
			};
		}
		
		else if(relation.equals("右上")) {
			run = new Runnable() {
				public void run() {
					try {
						goRightUp(anotherPoint);
					} 
					catch (InterruptedException e) {
					}
				}
			};
		}
		
		else if(relation.equals("右下")) {
			run = new Runnable() {
				public void run() {
					try {
						goRightDown(anotherPoint);
					} 
					catch (InterruptedException e) {
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