package ս������;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ����.ComplexShell;
import ����.Function;
import ����.PictureName;
import ����.Point;
import ����.SimpleShell;
import �ϰ������ͼ.Map;
import ս��.Battle;
import ��ɫ.LiPo;
import ��ɫ.Role;

/**
 * ս�������
 * @author ���ӻ�
 *
 */
public class BattlePanel extends JPanel implements KeyListener,ActionListener,MouseListener {
	/**
	 * ���ȱʡ���а汾
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * �������
	 */
	public static BattleFrame frame = null;
	
	
	//ս��
	/**
	 * ս��
	 */
	public Battle battle;
	/**
	 * ��ʾ���ǩ
	 */
	JLabel firstRoleButtonTipLabel;
	
	//�򵥹���
	/**
	 * �򵥹�����ť����
	 */
	Container simpleAttackContainer;
	/**
	 * �򵥹�����ǩ��ʾ��
	 */
	JLabel simpleAttackTipLabel;
	/**
	 * �򵥹�������ť
	 */
	JButton simpleAttackDirectionButton[];
	
	//���ӹ���
	/**
	 * ���ӹ�����ť����
	 */
	Container complexAttackContainer;
	/**
	 * ���ӹ�����ǩ��ʾ��
	 */
	JLabel complexAttackTipLabel;
	/**
	 * ���ӹ�������ť
	 */
	JButton complexAttackDirectionButton[]; 
	
	//��������
	/**
	 * ��ǰ������ڲ����Ľ�ɫ
	 */
	private Role operatingRole;	//��ǰ�ڲ�����Ӣ��
	
	//˽�з�������
	/**
	 * �����������������
	 */
	private void setStaticPanel() {
		Point.panel = this;
		Role.panel = this;
		LiPo.panel = this;
		Map.panel = this;
		Battle.panel = this;
		SimpleShell.panel = this;
		ComplexShell.panel = this;
	}
	
	/**
	 * ����ս��
	 * @param choosedMap ��ͼ����
	 */
	private void createBattle(String choosedMap) {
		battle = new Battle(choosedMap);
	}
	
	/**
	 * ����򵥹�����ť
	 */
	private void createSimpleAttackDirectionButton() {
		//��ʾ��ǩ
		simpleAttackContainer = new Container();
		simpleAttackTipLabel = new JLabel("�򵥹�������");
		simpleAttackDirectionButton = new JButton[4];
		//��
		simpleAttackDirectionButton[0] = new JButton("��");
		simpleAttackDirectionButton[0].addActionListener(this);
		simpleAttackDirectionButton[0].setFocusable(false);
		//��
		simpleAttackDirectionButton[1] = new JButton("��");
		simpleAttackDirectionButton[1].addActionListener(this);
		simpleAttackDirectionButton[1].setFocusable(false);
		//��
		simpleAttackDirectionButton[2] = new JButton("��");
		simpleAttackDirectionButton[2].addActionListener(this);
		simpleAttackDirectionButton[2].setFocusable(false);
		//��
		simpleAttackDirectionButton[3] = new JButton("��");
		simpleAttackDirectionButton[3].addActionListener(this);
		simpleAttackDirectionButton[3].setFocusable(false);
		//װ������
		simpleAttackContainer.add(simpleAttackTipLabel);
		simpleAttackContainer.add(simpleAttackDirectionButton[0]);
		simpleAttackContainer.add(simpleAttackDirectionButton[1]);
		simpleAttackContainer.add(simpleAttackDirectionButton[2]);
		simpleAttackContainer.add(simpleAttackDirectionButton[3]);
		
		//�ӵ���壬���趨λ��
		this.add(simpleAttackContainer);
		simpleAttackContainer.setLayout(new FlowLayout());
		simpleAttackContainer.setBounds(620,810,400,50);
	}
	
	/**
	 * ���������ӹ�����ť
	 */
	private void createComplexAttackDirectionButton() {
		if(Function.isLiPo(this.operatingRole.roleImg.getDescription())) {
			//��ʾ��ǩ
			complexAttackContainer = new Container();
			complexAttackTipLabel = new JLabel("���ӹ�������");
			complexAttackDirectionButton = new JButton[4];
			//��
			complexAttackDirectionButton[0] = new JButton("��");
			complexAttackDirectionButton[0].addActionListener(this);
			complexAttackDirectionButton[0].setFocusable(false);
			//��
			complexAttackDirectionButton[1] = new JButton("��");
			complexAttackDirectionButton[1].addActionListener(this);
			complexAttackDirectionButton[1].setFocusable(false);
			//��
			complexAttackDirectionButton[2] = new JButton("��");
			complexAttackDirectionButton[2].addActionListener(this);
			complexAttackDirectionButton[2].setFocusable(false);
			//��
			complexAttackDirectionButton[3] = new JButton("��");
			complexAttackDirectionButton[3].addActionListener(this);
			complexAttackDirectionButton[3].setFocusable(false);
			//װ������
			complexAttackContainer.add(complexAttackTipLabel);
			complexAttackContainer.add(complexAttackDirectionButton[0]);
			complexAttackContainer.add(complexAttackDirectionButton[1]);
			complexAttackContainer.add(complexAttackDirectionButton[2]);
			complexAttackContainer.add(complexAttackDirectionButton[3]);
			
			//�ӵ���壬���趨λ��
			this.add(complexAttackContainer);
			complexAttackContainer.setLayout(new FlowLayout());
			complexAttackContainer.setBounds(620,860,400,50);
		}
	}
	
	/**
	 * ��һ�ʤ
	 */
	private void win() {
		//���ٴ���
		frame.dispose();
		
		//����ʤ����ʾ��
		Font font = new Font("",Font.BOLD,40);
		JFrame frame = new JFrame("ʤ��");
		JLabel label = new JLabel("�ۣ�̫���ˣ���ɹ��ˣ�");
		label.setFont(font);
		frame.add(label);
		frame.setSize(480,100);
		frame.setLocation(650, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * ���ʧ��
	 */
	private void beDefeated() {
		//���ٴ���
		frame.dispose();
		
		//����ʧ����ʾ��
		Font font = new Font("",Font.BOLD,40);
		JFrame frame = new JFrame("ʧ��");
		JLabel label = new JLabel("���ź�����ʧ���ˣ�");
		label.setFont(font);
		frame.add(label);
		frame.setSize(400,100);
		frame.setLocation(700, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * �趨�򵥹�����ť��Ӧ���¼�
	 * @param e �������Ķ���
	 */
	private void manageSimpleAttack(ActionEvent e) {
		//��
		if(e.getSource() == simpleAttackDirectionButton[0]) {
			this.operatingRole.simpleAttack("��");
		}
		
		//��
		else if(e.getSource() == simpleAttackDirectionButton[1]) {
			this.operatingRole.simpleAttack("��");
		}
		
		//��
		else if(e.getSource() == simpleAttackDirectionButton[2]) {
			this.operatingRole.simpleAttack("��");
		}	
		
		//��
		else if(e.getSource() == simpleAttackDirectionButton[3]) {
			this.operatingRole.simpleAttack("��");
		}	
	}
	
	/**
	 * �趨���ӹ�����ť��Ӧ���¼�
	 * @param e �������Ķ���
	 */
	private void manageComplexAttack(ActionEvent e) {
		LiPo li;
		
		//���ӹ�����ť--��
		if(e.getSource() == complexAttackDirectionButton[0]){
			//�ж��ǲ������
			if(Function.isLiPo(this.operatingRole.roleImg.getDescription())) {
				li = (LiPo)this.operatingRole;
				
				li.complexAttack("��");
			}
		}
		
		//���ӹ�����ť--��
		else if(e.getSource() == complexAttackDirectionButton[1]){
			//�ж��ǲ������
			if(Function.isLiPo(this.operatingRole.roleImg.getDescription())) {
				li = (LiPo)this.operatingRole;
				
				li.complexAttack("��");
			}
		}		
		
		//���ӹ�����ť--��
		else if(e.getSource() == complexAttackDirectionButton[2]){
			//�ж��ǲ������
			if(Function.isLiPo(this.operatingRole.roleImg.getDescription())) {
				li = (LiPo)this.operatingRole;
				
				li.complexAttack("��");
			}
		}
		
		//���ӹ�����ť--��
		else if(e.getSource() == complexAttackDirectionButton[3]){
			//�ж��ǲ������
			if(Function.isLiPo(this.operatingRole.roleImg.getDescription())) {
				li = (LiPo)this.operatingRole;
				
				li.complexAttack("��");
			}
		}
	}
	
	/**
	 * �������
	 * @param e ������
	 */
	private void manageMouse(MouseEvent e) {
		Point anotherPoint;
		String description;
		
		anotherPoint = new Point(e.getY()/30-1,e.getX()/30);
		description = this.battle.map.get(anotherPoint);
		
		//����ո����Ч
		if(description != null) {
			if(description.equals(PictureName.SPACE)) {
				this.operatingRole.goTo(anotherPoint);
			}
		}
		
		else {
			
		}
	}
	
	/**
	 * ����һ�����
	 * @param choosedMap ����ϵĵ�ͼ����
	 * @param choosedRoleDescription �������ҵĽ�ɫ����
	 */
	BattlePanel(String choosedMap,String choosedRoleDescription) {
		//��һ�����������о�̬���ݳ�Ա--���
		this.setStaticPanel();
		//�ڶ���������ս��
		this.createBattle(choosedMap);
		//��������ָ����ɫ
		this.operatingRole = Function.searchRole(choosedRoleDescription,
				this.battle.firstRole, this.battle.secondRole);
		//���Ĳ��������򵥹�����ť
		this.createSimpleAttackDirectionButton();
		//���岽���������ӹ�����ť
		this.createComplexAttackDirectionButton();
		//��������ָ����ɫ����ս��
		this.operatingRole.enterMap();
	}
	
	//����ʵ�֣�
	//������ǰ�����Ľ�ɫ
	/**
	 * ʵ��ActionListener�ӿڵķ���
	 */
	public void actionPerformed(ActionEvent e) {
		//����򵥹���
		this.manageSimpleAttack(e);
		//�����ӹ���
		this.manageComplexAttack(e);
	}
	
	//����������������
	/**
	 * ʵ��KeyListener�ӿڵķ���
	 */
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			this.operatingRole.goForward("��");
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			this.operatingRole.goForward("��");
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.operatingRole.goForward("��");
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.operatingRole.goForward("��");
		}
		
		else {
			
		}
	}
	/**
	 * ʵ��KeyListener�ӿڵķ���
	 */
	public void keyReleased(KeyEvent e) {}
	/**
	 * ʵ��KeyListener�ӿڵķ���
	 */
	public void keyTyped(KeyEvent e) {}
	
	/**
	 * �ж�����������ж��Ƿ���ֳɹ���ʤ��
	 * @param description �����Ľ�ɫ����
	 */
	public void manageDeath(String description) {
		
		//��������һ��
		if(Function.isFirstRole(description)) {
			this.beDefeated();
		}
		
		//��������û�а�ť�Ļ�����ɫ
		else {
			//ȫ��������ȡ��ʤ��
			if(this.battle.secondRole.size() == 0) {
				this.win();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
		this.manageMouse(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}

}
