package 辅助;

import javax.swing.ImageIcon;

import 战斗界面.BattlePanel;
import 角色.Role;

/**
 * 简单炸弹类，只能直线行走
 * @author 蔡子辉
 *
 */
public class SimpleShell {
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
	public Role owner;
	
	//私有方法区：

	
	//公有方法区：
	/**
	 * 构造简单攻击对应的炸弹
	 * @param position 炸弹位置
	 * @param description 炸弹的描述
	 * @param attackValue 攻击值
	 * @param owner 炸弹拥有者
	 */
	public SimpleShell(Point position,String description,int attackValue,Role owner) {
		this.position = new Point(position.getX(),position.getY());
		this.complexShellImg = new ImageIcon(description);
		this.attackValue = attackValue;
		this.owner = owner;
	}
	
	/**
	 * 炸弹往上攻击
	 * @return String 每走一步的攻击情况
	 */
	public String up() {
		//先清理原位置，检查是否是发出者，发出者不能清理
		if(Function.isRole(panel.battle.map.get(this.position)) == false) {
			panel.battle.map.sharpReplace(this.position, PictureName.SPACE);
		}
		
		this.position = this.position.setXY(this.position.getX()-1, this.position.getY());
		
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
	 * 炸弹往下攻击
	 * @return String 每走一步的攻击情况
	 */
	public String down() {
		//先清理原位置，检查是否是发出者，发出者不能清理
		if(Function.isRole(panel.battle.map.get(this.position)) == false) {
			panel.battle.map.sharpReplace(this.position, PictureName.SPACE);
		}
		
		this.position = this.position.setXY(this.position.getX()+1, this.position.getY());
		
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
	 * 炸弹往左攻击
	 * @return String 每走一步的攻击情况
	 */
	public String left() {
		//先清理原位置，检查是否是发出者，发出者不能清理
		if(Function.isRole(panel.battle.map.get(this.position)) == false) {
			panel.battle.map.sharpReplace(this.position, PictureName.SPACE);
		}
		
		this.position = this.position.setXY(this.position.getX(), this.position.getY()-1);
		
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
	 * 炸弹往右攻击
	 * @return String 每走一步的攻击情况
	 */
	public String right() {
		//先清理原位置，检查是否是发出者，发出者不能清理
		if(Function.isRole(panel.battle.map.get(this.position)) == false) {
			panel.battle.map.sharpReplace(this.position, PictureName.SPACE);
		}
		
		this.position = this.position.setXY(this.position.getX(), this.position.getY()+1);
		
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
