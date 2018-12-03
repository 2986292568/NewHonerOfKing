package ��ɫ;

import javax.swing.ImageIcon;

import ս������.BattlePanel;
import ����.PictureName;
import ����.Point;
import ����.SimpleShell;

/**
 * ��ͨ��ɫ
 * @author ���ӻ�
 *
 */
public class Role implements ForRole {
	//��̬��������
	/**
	 * ��ɫ�����壬���
	 */
	static public BattlePanel panel = null;
	
	//�Ǿ�̬��������
	/**
	 * ����ֵ����ʼֵΪ100
	 */
	public int Mp;
	/**
	 * ħ��ֵ����ʼֵΪ30
	 */
	public int Hp;
	/**
	 * ����ֵ����ʼֵΪ0
	 */
	public int Exp;
	/**
	 * ��ɫģ�� ��������������ɫ�ı�־
	 */
    public ImageIcon roleImg;
    /**
     * ��ɫλ�ã������ɫʱҲ����ָ������ָ����λ�ã���Ӣ��δ�����ͼ
     */
    public Point rolePosition;
    
	
    
    //˽�з�������
    /**
     * ���ϼ򵥹���
     * @throws InterruptedException �̱߳���ǰ���ѵ��쳣
     */
    private void simpleAttackUp() throws InterruptedException {
    	SimpleShell shell = new SimpleShell(this.rolePosition,PictureName.UP_SHELL,25,this);
    	String result;
    	
    	while(true) {
    		result = shell.up();
    		
    		if(result.equals("�ɹ�ǰ��")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
    	}
    }
    
    /**
     * ���¼򵥹���
     * @throws InterruptedException �̱߳���ǰ���ѵ��쳣
     */
    private void simpleAttackDown() throws InterruptedException {
    	SimpleShell shell = new SimpleShell(this.rolePosition,PictureName.DOWN_SHELL,25,this);
    	String result;
    	
    	while(true) {
    		result = shell.down();
    		
    		if(result.equals("�ɹ�ǰ��")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
    	}
    }
    
    /**
     * ����򵥹���
     * @throws InterruptedException �̱߳���ǰ���ѵ��쳣
     */
    private void simpleAttackLeft() throws InterruptedException {
    	SimpleShell shell = new SimpleShell(this.rolePosition,PictureName.LEFT_SHELL,25,this);
    	String result;
    	
    	while(true) {
    		result = shell.left();
    		
    		if(result.equals("�ɹ�ǰ��")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
    	}
    }
    
    /**
     * ���Ҽ򵥹���
     * @throws InterruptedException �̱߳���ǰ���ѵ��쳣
     */
    private void simpleAttackRight() throws InterruptedException {
    	SimpleShell shell = new SimpleShell(this.rolePosition,PictureName.RIGHT_SHELL,25,this);
    	String result;
    	
    	while(true) {
    		result = shell.right();
    		
    		if(result.equals("�ɹ�ǰ��")) {
				Thread.sleep(100);
			}
			else {
				break;
			}
    	}
    }
    
    /**
     * �ж��Ƿ����������n��
     * @param n ָ���Ĳ���
     * @return boolean
     */
    private boolean canGoLeft(int n) {
    	int i;
    	
    	for(i=1 ; i<=n ; i++) {
    		//��ǽ������
    		if(panel.battle.map.get(this.rolePosition.setY(this.rolePosition.getY()-i)).equals(PictureName.WALL)) {
    			return false;
    		}
    	}
    	
    	return true;	
    }
    
    /**
     * �ж��Ƿ����������n��
     * @param n ָ���Ĳ���
     * @return boolean
     */
    private boolean canGoRight(int n) {
    	int i;
    	
    	for(i=1 ; i<=n ; i++) {
    		//��ǽ������
    		if(panel.battle.map.get(this.rolePosition.setY(this.rolePosition.getY()+i)).equals(PictureName.WALL)) {
    			return false;
    		}
    	}
    	
    	return true;	
    }
    
    /**
     * ������n��
     * @param n ָ���Ĳ���
     * @return boolean �Ƿ�ɹ�����n��
     * @throws InterruptedException �̱߳���ǰ���ѵ��쳣
     */
    private boolean goUp(int n) throws InterruptedException {
    	int i;
    	
    	for(i=1 ; i<=n ; i++) {
    		//�п�����������
    		if(this.goForward("��") == false) {
    			return false;
    		}
    		
    		Thread.sleep(100);
    	}
    	
    	return true;
    }
    
    /**
     * ������n��
     * @param n ָ���Ĳ���
     * @return boolean �Ƿ�ɹ�����n��
     * @throws InterruptedException �̱߳���ǰ���ѵ��쳣
     */
    private boolean goDown(int n) throws InterruptedException {
    	int i;
    	
    	for(i=1 ; i<=n ; i++) {
    		//�п�����������
    		if(this.goForward("��") == false) {
    			return false;
    		}
    		
    		Thread.sleep(100);
    	}
    	
    	return true;
    }
    
    /**
     * ������n��
     * @param n ָ���Ĳ���
     * @return boolean �Ƿ�ɹ�����n��
     * @throws InterruptedException �̱߳���ǰ���ѵ��쳣
     */
    private boolean goLeft(int n) throws InterruptedException {
    	int i;
    	
    	for(i=1 ; i<=n ; i++) {
    		//�п�����������
    		if(this.goForward("��") == false) {
    			return false;
    		}
    		
    		Thread.sleep(100);
    	}
    	
    	return true;
    }
    
    /**
     * ������n��
     * @param n ָ���Ĳ���
     * @return boolean �Ƿ�ɹ�����n��
     * @throws InterruptedException �̱߳���ǰ���ѵ��쳣
     */
    private boolean goRight(int n) throws InterruptedException {
    	int i;
    	
    	for(i=1 ; i<=n ; i++) {
    		//�п�����������
    		if(this.goForward("��") == false) {
    			return false;
    		}
    		
    		Thread.sleep(100);
    	}
    	
    	return true;
    }
    
    /**
     * �����Ϸ�����
     * @param anotherPoint Ŀ���
     * @throws InterruptedException �̱߳���ǰ���ѵ��쳣
     */
    private synchronized void goLeftUp(Point anotherPoint) throws InterruptedException {
    	int leftN,upN;
    	
    	//���ߺ����ߵĲ���
    	leftN = this.rolePosition.getY()-anotherPoint.getY();
    	upN = this.rolePosition.getX()-anotherPoint.getX();
    	
    	
    	//�������
		//�����ߣ�ֱ����
		if(this.canGoLeft(leftN)) {
			//���߳ɹ�����������
			if(this.goLeft(leftN)) {
				this.goUp(upN);
			}
		}
		
		//�����ܲ����ߣ�ֱ�����Ϻ���
		else {
			if(this.goUp(upN)) {
				this.goLeft(leftN);
			}
		}
    }
    
    /**
     * �����·�����
     * @param anotherPoint Ŀ���
     * @throws InterruptedException �̱߳���ǰ���ѵ��쳣
     */
    private synchronized void goLeftDown(Point anotherPoint) throws InterruptedException {
    	int leftN,downN;
    	
    	leftN = this.rolePosition.getY() - anotherPoint.getY();
    	downN = anotherPoint.getX() - this.rolePosition.getX();
    	
    	//�������
    	if(this.canGoLeft(leftN)) {
    		if(this.goLeft(leftN)) {
    			this.goDown(downN);
    		}
    	}
    	
    	//�����ܲ����ߣ�ֱ�����º���
    	else {
    		if(this.goDown(downN)) {
    			this.goLeft(leftN);
    		}
    	}
    }
    
    /**
     * �����Ϸ�����
     * @param anotherPoint Ŀ���
     * @throws InterruptedException �̱߳���ǰ���ѵ��쳣
     */
    private synchronized void goRightUp(Point anotherPoint) throws InterruptedException {
    	int rightN,upN;
    	
    	rightN = anotherPoint.getY() - this.rolePosition.getY();
    	upN = this.rolePosition.getX() - anotherPoint.getX();
    	
    	//���Һ���
    	if(this.canGoRight(rightN)) {
    		if(this.goRight(rightN)) {
    			this.goUp(upN);
    		}
    	}
    	
    	//ֱ�����Ϻ���
    	else {
    		if(this.goUp(upN)) {
    			this.goRight(rightN);
    		}
    	}
    }
    
    /**
     * �����·�����
     * @param anotherPoint Ŀ���
     * @throws InterruptedException �̱߳���ǰ���ѵ��쳣
     */
    private synchronized void goRightDown(Point anotherPoint) throws InterruptedException {
    	int rightN,downN;
    	
    	rightN = anotherPoint.getY() - this.rolePosition.getY();
    	downN = anotherPoint.getX() - this.rolePosition.getX();
    	
    	//���Һ���
    	if(this.canGoRight(rightN)) {
    		if(this.goRight(rightN)) {
    			this.goDown(downN);
    		}
    	}
    	
    	//ֱ�����º���
    	else {
    		if(this.goDown(downN)) {
    			this.goRight(rightN);
    		}
    	}
    }
    
       
    //���з�������
    /**
     * �����ɫ
     * @param Mp ����ֵ
     * @param Hp ħ��ֵ
     * @param Exp ����ֵ 
     * @param roleImgName Ӣ��ͼƬ����
     * @param rolePosition ��ɫλ�� 
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
		if(direction.equals("��")) {
			if(panel.battle.map.get(this.rolePosition.setX(this.rolePosition.getX()-1)).equals(PictureName.SPACE)) { //�������������
				panel.battle.map.sharpReplace(this.rolePosition, PictureName.SPACE);
    			this.rolePosition = this.rolePosition.setX(this.rolePosition.getX()-1);
    			panel.battle.map.replace(this.rolePosition, this.roleImg.getDescription());
    			
    			return true;
    		}
		}
    				
    	else if(direction.equals("��")) {
    		if(panel.battle.map.get(this.rolePosition.setX(this.rolePosition.getX()+1)).equals(PictureName.SPACE)) { //�������������
				panel.battle.map.sharpReplace(this.rolePosition, PictureName.SPACE);
    			this.rolePosition = this.rolePosition.setX(this.rolePosition.getX()+1);
    			panel.battle.map.replace(this.rolePosition, this.roleImg.getDescription());
    			
    			return true;
    		}
    	}
    			
    	else if(direction.equals("��")) {
    		if(panel.battle.map.get(this.rolePosition.setY(this.rolePosition.getY()-1)).equals(PictureName.SPACE)) { //�������������
    			panel.battle.map.sharpReplace(this.rolePosition, PictureName.SPACE);
    			this.rolePosition = this.rolePosition.setY(this.rolePosition.getY()-1);
    			panel.battle.map.replace(rolePosition, this.roleImg.getDescription());
    			
    			return true;
    		}
    	}
    				
    	else if(direction.equals("��")) {
    		if(panel.battle.map.get(this.rolePosition.setY(this.rolePosition.getY()+1)).equals(PictureName.SPACE)) { //�������������
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
		
		if(direction.equals("��")) {
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
		
		else if(direction.equals("��")) {
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
		
		else if(direction.equals("��")) {
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
		
		else if(direction.equals("��")) {
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
		
		if(relation.equals("����")) {
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
		
		else if(relation.equals("����")) {
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
		
		else if(relation.equals("����")) {
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
		
		else if(relation.equals("����")) {
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