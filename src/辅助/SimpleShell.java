package ����;

import javax.swing.ImageIcon;

import ս������.BattlePanel;
import ��ɫ.Role;

/**
 * ��ը���ֻ࣬��ֱ������
 * @author ���ӻ�
 *
 */
public class SimpleShell {
	//��̬��������
	/**
	 * �ڵ����õ����
	 */
	public static BattlePanel panel = null;
	
	//�Ǿ�̬��������
	/**
	 * �ڵ�λ��
	 */
	public Point position;
	/**
	 * �ڵ�ͼƬ
	 */
	public ImageIcon complexShellImg;
	/**
	 * �ڵ�������
	 */
	public int attackValue;
	/**
	 * �ڵ�������
	 */
	public Role owner;
	
	//˽�з�������

	
	//���з�������
	/**
	 * ����򵥹�����Ӧ��ը��
	 * @param position ը��λ��
	 * @param description ը��������
	 * @param attackValue ����ֵ
	 * @param owner ը��ӵ����
	 */
	public SimpleShell(Point position,String description,int attackValue,Role owner) {
		this.position = new Point(position.getX(),position.getY());
		this.complexShellImg = new ImageIcon(description);
		this.attackValue = attackValue;
		this.owner = owner;
	}
	
	/**
	 * ը�����Ϲ���
	 * @return String ÿ��һ���Ĺ������
	 */
	public String up() {
		//������ԭλ�ã�����Ƿ��Ƿ����ߣ������߲�������
		if(Function.isRole(panel.battle.map.get(this.position)) == false) {
			panel.battle.map.sharpReplace(this.position, PictureName.SPACE);
		}
		
		this.position = this.position.setXY(this.position.getX()-1, this.position.getY());
		
		//�ڵ����й������������滻�ɹ���
		if(this.attackValue>0 && panel.battle.map.replace(this.position, this.complexShellImg.getDescription())) {
			this.attackValue--;
			
			return "�ɹ�ǰ��";
		}
		
		//ǰ��ʧ�ܣ�����ԭ��
		else {		
			//�ڵ��޹�����
			if(this.attackValue<=0) {	
				return "�ڵ��޹�����";
			}
			
			//�ڵ�ײ��ǽ����ײ��Ӣ��
			else {
				String description = panel.battle.map.get(this.position);
				
				//ײ��ǽ
				if(description.equals(PictureName.WALL)) {
					return "����ǽ";
				}
				
				//���жԷ���ײ���Լ���
				else {
					//��ȡ��ײ���Ķ���
					Role tempRole = Function.searchRole(description,panel.battle.firstRole,panel.battle.secondRole);
					
					//ȷ��ײ������
					if(tempRole != null) {
						//���Ƕ��ѣ������ɹ�
						if(Function.isFriend(owner.roleImg.getDescription(), tempRole.roleImg.getDescription()) == false) {
							this.owner.Exp += this.attackValue;
							tempRole.Mp -= this.attackValue;
							
							//�����������
							if(tempRole.isDead()) {
								//��ɫ�뿪��ͼ�ͼ��ϣ�����������
								tempRole.exitMap();
								Function.remove(tempRole, panel.battle.firstRole, panel.battle.secondRole);
								panel.manageDeath(tempRole.roleImg.getDescription());
								
								//װ����������
								panel.battle.addDeath(tempRole);
							}
							
							return "�ɹ�����";
						}
						
						else {
							return "ײ���Լ���";
						}
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * ը�����¹���
	 * @return String ÿ��һ���Ĺ������
	 */
	public String down() {
		//������ԭλ�ã�����Ƿ��Ƿ����ߣ������߲�������
		if(Function.isRole(panel.battle.map.get(this.position)) == false) {
			panel.battle.map.sharpReplace(this.position, PictureName.SPACE);
		}
		
		this.position = this.position.setXY(this.position.getX()+1, this.position.getY());
		
		//�ڵ����й������������滻�ɹ���
		if(this.attackValue>0 && panel.battle.map.replace(this.position, this.complexShellImg.getDescription())) {
			this.attackValue--;
			
			return "�ɹ�ǰ��";
		}
		
		//ǰ��ʧ�ܣ�����ԭ��
		else {		
			//�ڵ��޹�����
			if(this.attackValue<=0) {	
				return "�ڵ��޹�����";
			}
			
			//�ڵ�ײ��ǽ����ײ��Ӣ��
			else {
				String description = panel.battle.map.get(this.position);
				
				//ײ��ǽ
				if(description.equals(PictureName.WALL)) {
					return "����ǽ";
				}
				
				//���жԷ���ײ���Լ���
				else {
					//��ȡ��ײ���Ķ���
					Role tempRole = Function.searchRole(description,panel.battle.firstRole,panel.battle.secondRole);
					
					//ȷ��ײ������
					if(tempRole != null) {
						//���Ƕ��ѣ������ɹ�
						if(Function.isFriend(owner.roleImg.getDescription(), tempRole.roleImg.getDescription()) == false) {
							this.owner.Exp += this.attackValue;
							tempRole.Mp -= this.attackValue;
							
							//�����������
							if(tempRole.isDead()) {
								//��ɫ�뿪��ͼ�ͼ��ϣ�����������
								tempRole.exitMap();
								Function.remove(tempRole, panel.battle.firstRole, panel.battle.secondRole);
								panel.manageDeath(tempRole.roleImg.getDescription()); 
								
								//װ����������
								panel.battle.addDeath(tempRole);
							}
							
							return "�ɹ�����";
						}
						
						else {
							return "ײ���Լ���";
						}
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * ը�����󹥻�
	 * @return String ÿ��һ���Ĺ������
	 */
	public String left() {
		//������ԭλ�ã�����Ƿ��Ƿ����ߣ������߲�������
		if(Function.isRole(panel.battle.map.get(this.position)) == false) {
			panel.battle.map.sharpReplace(this.position, PictureName.SPACE);
		}
		
		this.position = this.position.setXY(this.position.getX(), this.position.getY()-1);
		
		//�ڵ����й������������滻�ɹ���
		if(this.attackValue>0 && panel.battle.map.replace(this.position, this.complexShellImg.getDescription())) {
			this.attackValue--;
			
			return "�ɹ�ǰ��";
		}
		
		//ǰ��ʧ�ܣ�����ԭ��
		else {		
			//�ڵ��޹�����
			if(this.attackValue<=0) {	
				return "�ڵ��޹�����";
			}
			
			//�ڵ�ײ��ǽ����ײ��Ӣ��
			else {
				String description = panel.battle.map.get(this.position);
				
				//ײ��ǽ
				if(description.equals(PictureName.WALL)) {
					return "����ǽ";
				}
				
				//���жԷ���ײ���Լ���
				else {
					//��ȡ��ײ���Ķ���
					Role tempRole = Function.searchRole(description,panel.battle.firstRole,panel.battle.secondRole);
					
					//ȷ��ײ������
					if(tempRole != null) {
						//���Ƕ��ѣ������ɹ�
						if(Function.isFriend(owner.roleImg.getDescription(), tempRole.roleImg.getDescription()) == false) {
							this.owner.Exp += this.attackValue;
							tempRole.Mp -= this.attackValue;
							
							//�����������
							if(tempRole.isDead()) {
								//��ɫ�뿪��ͼ�ͼ��ϣ�����������
								tempRole.exitMap();
								Function.remove(tempRole, panel.battle.firstRole, panel.battle.secondRole);
								panel.manageDeath(tempRole.roleImg.getDescription()); 
								
								//װ����������
								panel.battle.addDeath(tempRole);
							}
							
							return "�ɹ�����";
						}
						
						else {
							return "ײ���Լ���";
						}
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * ը�����ҹ���
	 * @return String ÿ��һ���Ĺ������
	 */
	public String right() {
		//������ԭλ�ã�����Ƿ��Ƿ����ߣ������߲�������
		if(Function.isRole(panel.battle.map.get(this.position)) == false) {
			panel.battle.map.sharpReplace(this.position, PictureName.SPACE);
		}
		
		this.position = this.position.setXY(this.position.getX(), this.position.getY()+1);
		
		//�ڵ����й������������滻�ɹ���
		if(this.attackValue>0 && panel.battle.map.replace(this.position, this.complexShellImg.getDescription())) {
			this.attackValue--;
			
			return "�ɹ�ǰ��";
		}
		
		//ǰ��ʧ�ܣ�����ԭ��
		else {		
			//�ڵ��޹�����
			if(this.attackValue<=0) {	
				return "�ڵ��޹�����";
			}
			
			//�ڵ�ײ��ǽ����ײ��Ӣ��
			else {
				String description = panel.battle.map.get(this.position);
				
				//ײ��ǽ
				if(description.equals(PictureName.WALL)) {
					return "����ǽ";
				}
				
				//���жԷ���ײ���Լ���
				else {
					//��ȡ��ײ���Ķ���
					Role tempRole = Function.searchRole(description,panel.battle.firstRole,panel.battle.secondRole);
					
					//ȷ��ײ������
					if(tempRole != null) {
						//���Ƕ��ѣ������ɹ�
						if(Function.isFriend(owner.roleImg.getDescription(), tempRole.roleImg.getDescription()) == false) {
							this.owner.Exp += this.attackValue;
							tempRole.Mp -= this.attackValue;
							
							//�����������
							if(tempRole.isDead()) {
								//��ɫ�뿪��ͼ�ͼ��ϣ�����������
								tempRole.exitMap();
								Function.remove(tempRole, panel.battle.firstRole, panel.battle.secondRole);
								panel.manageDeath(tempRole.roleImg.getDescription()); 
								
								//װ����������
								panel.battle.addDeath(tempRole);
							}
							
							return "�ɹ�����";
						}
						
						else {
							return "ײ���Լ���";
						}
					}
				}
			}
		}
		return null;
	}
			
}
