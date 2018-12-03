package ����;

import javax.swing.ImageIcon;

import ս������.BattlePanel;
import ��ɫ.LiPo;
import ��ɫ.Role;

/**
 * ����ը���������Խ�����
 * @author ���ӻ�
 * 
 */
public class ComplexShell {
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
	public LiPo owner;
	
	//���з�������
	/**
	 * ����򵥹�����ը��
	 * @param position ը����ʼλ��
	 * @param description ը��ͼƬ����
	 * @param attackValue ����ֵ
	 * @param owner ը��ӵ����
	 */
	public ComplexShell(Point position,String description,int attackValue,LiPo owner) {
		this.position = new Point(position.getX(),position.getY());
		this.complexShellImg = new ImageIcon(description);
		this.attackValue = attackValue;
		this.owner = owner;
	}
	
	/**
	 * �����Ϸ��ƶ�
	 * @return String ը��ǰ��״��
	 */
	public String leftUp() {
		//������ԭλ�ã�����Ƿ��Ƿ����ߣ������߲�������
		if(Function.isRole(panel.battle.map.get(this.position)) == false) {
			panel.battle.map.sharpReplace(this.position, PictureName.SPACE);
		}
		
		this.position = this.position.setXY(this.position.getX()-1, this.position.getY()-1);
		
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
	 * �����·��ƶ�
	 * @return String ը��ǰ��״��
	 */
	public String leftDown() {
		//������ԭλ�ã�����Ƿ��Ƿ����ߣ������߲�������
		if(Function.isRole(panel.battle.map.get(this.position)) == false) {
			panel.battle.map.sharpReplace(this.position, PictureName.SPACE);
		}
		
		this.position = this.position.setXY(this.position.getX()+1, this.position.getY()-1);
		
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
	 * �����Ϸ��ƶ�
	 * @return String ը��ǰ��״��
	 */
	public String rightUp() {
		//������ԭλ�ã�����Ƿ��Ƿ����ߣ������߲�������
		if(Function.isRole(panel.battle.map.get(this.position)) == false) {
			panel.battle.map.sharpReplace(this.position, PictureName.SPACE);
		}
		
		this.position = this.position.setXY(this.position.getX()-1, this.position.getY()+1);
		
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
	 * �����·��ƶ�
	 * @return String ը��ǰ��״��
	 */
	public String rightDown() {
		//������ԭλ�ã�����Ƿ��Ƿ����ߣ������߲�������
		if(Function.isRole(panel.battle.map.get(this.position)) == false) {
			panel.battle.map.sharpReplace(this.position, PictureName.SPACE);
		}
		
		this.position = this.position.setXY(this.position.getX()+1, this.position.getY()+1);
		
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
