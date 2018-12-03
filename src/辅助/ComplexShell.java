package 辅助;

import javax.swing.ImageIcon;

import 战斗界面.BattlePanel;
import 角色.LiPo;
import 角色.Role;

/**
 * 复杂炸弹，可往对角线走
 * @author 蔡子辉
 * 
 */
public class ComplexShell {
	//静态数据区：
	/**
	 * 炮弹公用的面板
	 */
	public static BattlePanel panel = null;
	
	//非静态数据区：
	/**
	 * 炮弹位置
	 */
	public Point position;
	/**
	 * 炮弹图片
	 */
	public ImageIcon complexShellImg;
	/**
	 * 炮弹攻击力
	 */
	public int attackValue;
	/**
	 * 炮弹持有者
	 */
	public LiPo owner;
	
	//公有方法区：
	/**
	 * 构造简单攻击的炸弹
	 * @param position 炸弹初始位置
	 * @param description 炸弹图片描述
	 * @param attackValue 攻击值
	 * @param owner 炸弹拥有者
	 */
	public ComplexShell(Point position,String description,int attackValue,LiPo owner) {
		this.position = new Point(position.getX(),position.getY());
		this.complexShellImg = new ImageIcon(description);
		this.attackValue = attackValue;
		this.owner = owner;
	}
	
	/**
	 * 往左上方移动
	 * @return String 炸弹前行状况
	 */
	public String leftUp() {
		//先清理原位置，检查是否是发出者，发出者不能清理
		if(Function.isRole(panel.battle.map.get(this.position)) == false) {
			panel.battle.map.sharpReplace(this.position, PictureName.SPACE);
		}
		
		this.position = this.position.setXY(this.position.getX()-1, this.position.getY()-1);
		
		//炮弹还有攻击力，并且替换成功：
		if(this.attackValue>0 && panel.battle.map.replace(this.position, this.complexShellImg.getDescription())) {
			this.attackValue--;
			
			return "成功前行";
		}
		
		//前行失败，分析原因
		else {		
			//炮弹无攻击力
			if(this.attackValue<=0) {	
				return "炮弹无攻击力";
			}
			
			//炮弹撞到墙或者撞到英雄
			else {
				String description = panel.battle.map.get(this.position);
				
				//撞到墙
				if(description.equals(PictureName.WALL)) {
					return "碰到墙";
				}
				
				//击中对方或撞到自己人
				else {
					//获取被撞到的东西
					Role tempRole = Function.searchRole(description,panel.battle.firstRole,panel.battle.secondRole);
					
					//确定撞到人了
					if(tempRole != null) {
						//不是队友，攻击成功
						if(Function.isFriend(owner.roleImg.getDescription(), tempRole.roleImg.getDescription()) == false) {
							this.owner.Exp += this.attackValue;
							tempRole.Mp -= this.attackValue;
							
							//处理死亡情况
							if(tempRole.isDead()) {
								//角色离开地图和集合，面板管理死亡
								tempRole.exitMap();
								Function.remove(tempRole, panel.battle.firstRole, panel.battle.secondRole);
								panel.manageDeath(tempRole.roleImg.getDescription());
								
								//装入死亡集合
								panel.battle.addDeath(tempRole);
							}
							
							return "成功攻击";
						}
						
						else {
							return "撞到自己人";
						}
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * 往左下方移动
	 * @return String 炸弹前行状况
	 */
	public String leftDown() {
		//先清理原位置，检查是否是发出者，发出者不能清理
		if(Function.isRole(panel.battle.map.get(this.position)) == false) {
			panel.battle.map.sharpReplace(this.position, PictureName.SPACE);
		}
		
		this.position = this.position.setXY(this.position.getX()+1, this.position.getY()-1);
		
		//炮弹还有攻击力，并且替换成功：
		if(this.attackValue>0 && panel.battle.map.replace(this.position, this.complexShellImg.getDescription())) {
			this.attackValue--;
			
			return "成功前行";
		}
		
		//前行失败，分析原因
		else {		
			//炮弹无攻击力
			if(this.attackValue<=0) {	
				return "炮弹无攻击力";
			}
			
			//炮弹撞到墙或者撞到英雄
			else {
				String description = panel.battle.map.get(this.position);
				
				//撞到墙
				if(description.equals(PictureName.WALL)) {
					return "碰到墙";
				}
				
				//击中对方或撞到自己人
				else {
					//获取被撞到的东西
					Role tempRole = Function.searchRole(description,panel.battle.firstRole,panel.battle.secondRole);
					
					//确定撞到人了
					if(tempRole != null) {
						//不是队友，攻击成功
						if(Function.isFriend(owner.roleImg.getDescription(), tempRole.roleImg.getDescription()) == false) {
							this.owner.Exp += this.attackValue;
							tempRole.Mp -= this.attackValue;
							
							//处理死亡情况
							if(tempRole.isDead()) {
								//角色离开地图和集合，面板管理死亡
								tempRole.exitMap();
								Function.remove(tempRole, panel.battle.firstRole, panel.battle.secondRole);
								panel.manageDeath(tempRole.roleImg.getDescription());
								
								//装入死亡集合
								panel.battle.addDeath(tempRole);
							}
							
							return "成功攻击";
						}
						
						else {
							return "撞到自己人";
						}
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * 往右上方移动
	 * @return String 炸弹前行状况
	 */
	public String rightUp() {
		//先清理原位置，检查是否是发出者，发出者不能清理
		if(Function.isRole(panel.battle.map.get(this.position)) == false) {
			panel.battle.map.sharpReplace(this.position, PictureName.SPACE);
		}
		
		this.position = this.position.setXY(this.position.getX()-1, this.position.getY()+1);
		
		//炮弹还有攻击力，并且替换成功：
		if(this.attackValue>0 && panel.battle.map.replace(this.position, this.complexShellImg.getDescription())) {
			this.attackValue--;
			
			return "成功前行";
		}
		
		//前行失败，分析原因
		else {		
			//炮弹无攻击力
			if(this.attackValue<=0) {	
				return "炮弹无攻击力";
			}
			
			//炮弹撞到墙或者撞到英雄
			else {
				String description = panel.battle.map.get(this.position);
				
				//撞到墙
				if(description.equals(PictureName.WALL)) {
					return "碰到墙";
				}
				
				//击中对方或撞到自己人
				else {
					//获取被撞到的东西
					Role tempRole = Function.searchRole(description,panel.battle.firstRole,panel.battle.secondRole);
					
					//确定撞到人了
					if(tempRole != null) {
						//不是队友，攻击成功
						if(Function.isFriend(owner.roleImg.getDescription(), tempRole.roleImg.getDescription()) == false) {
							this.owner.Exp += this.attackValue;
							tempRole.Mp -= this.attackValue;
							
							//处理死亡情况
							if(tempRole.isDead()) {
								//角色离开地图和集合，面板管理死亡
								tempRole.exitMap();
								Function.remove(tempRole, panel.battle.firstRole, panel.battle.secondRole);
								panel.manageDeath(tempRole.roleImg.getDescription()); 
								
								//装入死亡集合
								panel.battle.addDeath(tempRole);
							}
							
							return "成功攻击";
						}
						
						else {
							return "撞到自己人";
						}
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * 往右下方移动
	 * @return String 炸弹前行状况
	 */
	public String rightDown() {
		//先清理原位置，检查是否是发出者，发出者不能清理
		if(Function.isRole(panel.battle.map.get(this.position)) == false) {
			panel.battle.map.sharpReplace(this.position, PictureName.SPACE);
		}
		
		this.position = this.position.setXY(this.position.getX()+1, this.position.getY()+1);
		
		//炮弹还有攻击力，并且替换成功：
		if(this.attackValue>0 && panel.battle.map.replace(this.position, this.complexShellImg.getDescription())) {
			this.attackValue--;
			
			return "成功前行";
		}
		
		//前行失败，分析原因
		else {		
			//炮弹无攻击力
			if(this.attackValue<=0) {	
				return "炮弹无攻击力";
			}
			
			//炮弹撞到墙或者撞到英雄
			else {
				String description = panel.battle.map.get(this.position);
				
				//撞到墙
				if(description.equals(PictureName.WALL)) {
					return "碰到墙";
				}
				
				//击中对方或撞到自己人
				else {
					//获取被撞到的东西
					Role tempRole = Function.searchRole(description,panel.battle.firstRole,panel.battle.secondRole);
					
					//确定撞到人了
					if(tempRole != null) {
						//不是队友，攻击成功
						if(Function.isFriend(owner.roleImg.getDescription(), tempRole.roleImg.getDescription()) == false) {
							this.owner.Exp += this.attackValue;
							tempRole.Mp -= this.attackValue;
							
							//处理死亡情况
							if(tempRole.isDead()) {
								//角色离开地图和集合，面板管理死亡
								tempRole.exitMap();
								Function.remove(tempRole, panel.battle.firstRole, panel.battle.secondRole);
								panel.manageDeath(tempRole.roleImg.getDescription()); 
								
								//装入死亡集合
								panel.battle.addDeath(tempRole);
							}
							
							return "成功攻击";
						}
						
						else {
							return "撞到自己人";
						}
					}
				}
			}
		}
		return null;
	}
		
	
}
