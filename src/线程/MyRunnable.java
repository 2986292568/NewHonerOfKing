package �߳�;

import ս������.BattleFrame;
import ��ɫ.LiPo;
import ��ɫ.Role;
import ����.Function;

/**
 * �����˽�ɫ���߳�
 * @author ���ӻ�
 *
 */
public class MyRunnable implements Runnable{
	/**
	 * ���߳������Ĵ���
	 */
	public static BattleFrame frame;
	
	/**
	 * �߳�ָ���¼�
	 */
	public void run() {
		 Role tempRole;  LiPo li;
		 String action,direction;
		 
		 //��ȡ��ɫ
		 tempRole = frame.panel.battle.secondRole.getFirst();
		 //��ɫ�����ͼ
		 tempRole.enterMap();
		
		 while(true) {
			 //ԭ���Ľ�ɫ�Ѿ����ˣ��µĽ�ɫ����
			 if(tempRole != frame.panel.battle.secondRole.getFirst()) {
				 tempRole = frame.panel.battle.secondRole.getFirst();
				 
				 if(tempRole != null) {
					 tempRole.enterMap();
				 }
				 
				 else {
					 break;
				 }
				 
			 }
			 
			 //��ȡ�ж�ָ��
			 action = Function.getAction();
			 //��ȡ����
			 direction = Function.getDirection();
				 
			 //��Ҳ�������û�ɹ�
			 if(tempRole != null) {
				 //ֻ������ܸ��ӹ����������
				 if(action.equals("����")) {
					 if(Function.isLiPo(tempRole.roleImg.getDescription())) {
						 li = (LiPo)tempRole;	
						 li.complexAttack(direction);
					 }
				 }
				 
				 else if(action.equals("��")){
					 tempRole.simpleAttack(direction);
				 }
				 
				 else {
					 tempRole.goForward(direction);
				 }
			}
			 
			try {
				Thread.sleep(300);
			} 
			catch (InterruptedException e) {}
		} 

			
	}
}
