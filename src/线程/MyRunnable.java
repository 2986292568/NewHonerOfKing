package 线程;

import 战斗界面.BattleFrame;
import 角色.LiPo;
import 角色.Role;
import 辅助.Function;

/**
 * 机器人角色的线程
 * @author 蔡子辉
 *
 */
public class MyRunnable implements Runnable{
	/**
	 * 该线程依附的窗体
	 */
	public static BattleFrame frame;
	
	/**
	 * 线程指定事件
	 */
	public void run() {
		 Role tempRole;  LiPo li;
		 String action,direction;
		 
		 //获取角色
		 tempRole = frame.panel.battle.secondRole.getFirst();
		 //角色进入地图
		 tempRole.enterMap();
		
		 while(true) {
			 //原来的角色已经死了，新的角色出现
			 if(tempRole != frame.panel.battle.secondRole.getFirst()) {
				 tempRole = frame.panel.battle.secondRole.getFirst();
				 
				 if(tempRole != null) {
					 tempRole.enterMap();
				 }
				 
				 else {
					 break;
				 }
				 
			 }
			 
			 //获取行动指令
			 action = Function.getAction();
			 //获取方向
			 direction = Function.getDirection();
				 
			 //玩家操作方还没成功
			 if(tempRole != null) {
				 //只有李白能复杂攻击，需检验
				 if(action.equals("复杂")) {
					 if(Function.isLiPo(tempRole.roleImg.getDescription())) {
						 li = (LiPo)tempRole;	
						 li.complexAttack(direction);
					 }
				 }
				 
				 else if(action.equals("简单")){
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
