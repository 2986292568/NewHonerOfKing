package ѡ�����;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButtonMenuItem;

import ս������.BattleFrame;
import ս������.BattlePanel;
import �߳�.MyRunnable;
import ����.Function;
import ����.PictureName;

/**
 * ѡ������
 * @author ���ӻ�
 *
 */
public class ChooseFrame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7873849994380834947L;

	/**
	 * Ӣ��ͼƬ
	 */
	JLabel rolePictureLabel[];
	/**
	 * ��ʾ���ǩ
	 */
	JLabel roleInformation;
	 /** ��Ҳٿط���ɫѡ��ť
	 */
	LinkedList<JRadioButtonMenuItem> firstRoleButton;		//Ϊ�˷��ʵķ���
	/**
	 * ��Ҳٿط���ɫѡ��ť�飬ʵ�ֵ�ѡ
	 */
	ButtonGroup firstRoleButtonGroup;						//Ϊ��ʵ�ֵ�ѡ
	
	/**
	 * ��ͼͼƬ
	 */
	JLabel mapPictureLabel[];
	/**
	 * ��ͼ��Ϣ
	 */
	JLabel mapInformation;
	/**
	 * ��ͼѡ��ť
	 */
	LinkedList<JRadioButtonMenuItem> mapButton;
	ButtonGroup mapButtonGroup;
	
	/**
	 * ȷ����ť
	 */
	JButton beginToPlayButton;
	/**
	 * ȡ����ť
	 */
	JButton cancelButton;
	
	/**
	 * ��ѡ���Ľ�ɫ������
	 */
	String choosedRole;
	/**
	 * ��ѡ���ĵ�ͼ������
	 */
	String choosedMap;
	
	
	/**
	 * �����ѡ��Ľ�ɫͼƬ
	 */
	private void createRolePicture() {
		int i;
		
		this.rolePictureLabel = new JLabel[4];
		this.rolePictureLabel[0] = new JLabel(new ImageIcon(PictureName.ROLE_A_CHOOSE));
		this.rolePictureLabel[1] = new JLabel(new ImageIcon(PictureName.ROLE_B_CHOOSE));
		this.rolePictureLabel[2] = new JLabel(new ImageIcon(PictureName.ROLE_a_CHOOSE));
		this.rolePictureLabel[3] = new JLabel(new ImageIcon(PictureName.ROLE_b_CHOOSE));
		
		for(i=0 ; i<this.rolePictureLabel.length ; i++) { 
			this.add(this.rolePictureLabel[i]);
			this.rolePictureLabel[i].setBounds(100+i*200, 0, 200, 300);
		}
	}
	/**
	 * �����ɫ��ѡ��
	 */
	private void createFirstRoleButton() {
		//����
		Font font = new Font("",Font.BOLD,20);
		JRadioButtonMenuItem tempButton;
		
		firstRoleButton = new LinkedList<JRadioButtonMenuItem>();
		firstRoleButtonGroup = new ButtonGroup();
		
		tempButton = new JRadioButtonMenuItem("A");
		tempButton.setFont(font);
		tempButton.addActionListener(this);
		firstRoleButton.add(tempButton);
		firstRoleButtonGroup.add(tempButton);
		this.add(tempButton);
		tempButton.setBounds(180, 280, 100, 50);
		
		
		tempButton = new JRadioButtonMenuItem("B");
		tempButton.setFont(font);
		tempButton.addActionListener(this);
		firstRoleButton.add(tempButton);
		firstRoleButtonGroup.add(tempButton);
		this.add(tempButton);
		tempButton.setBounds(380, 280, 100, 50);
		
		
		tempButton = new JRadioButtonMenuItem("a");
		tempButton.setFont(font);
		tempButton.addActionListener(this);
		firstRoleButton.add(tempButton);
		firstRoleButtonGroup.add(tempButton);
		this.add(tempButton);
		tempButton.setBounds(580, 280, 100, 50);
		
		tempButton = new JRadioButtonMenuItem("b");
		tempButton.setFont(font);
		tempButton.addActionListener(this);
		firstRoleButton.add(tempButton);
		firstRoleButtonGroup.add(tempButton);
		this.add(tempButton);
		tempButton.setBounds(780, 280, 100, 50);
	}
	/**
	 * ����ѡ��Ľ�ɫ���������ɫ�����Ϣ
	 * @param aim ѡ���Ľ�ɫ
	 */
	private void selectRole(JRadioButtonMenuItem aim) {
		String information;
		
		//ѡ����ɫ
		aim.setSelected(true);
		this.choosedRole = aim.getText();
		
		//������ʾ��Ϣ
		//�����Ϣ
		if(Function.isLiPo(aim.getText())) {
			information = "<html>"+
								"<p>��ɫ��Ϣ��</p>"+
								"<p>���ƣ�"+aim.getText()+"</p>"+
								"<p>���ͣ�LiPo</p>"+
								"<p>����ֵ��200</p>"+
								"<p>ħ��ֵ��50</p>"+
								"<p>����ֵ��5</p>"+
								"<p>���ܣ��򵥹��������ӹ���</p>"+
						  "</html>";
		}
		//��ͨ��ɫ
		else {
			information = "<html>"+
								"<p>��ɫ��Ϣ��</p>"+
								"<p>���ƣ�"+aim.getText()+"</p>"+
								"<p>���ͣ�Role</p>"+
								"<p>����ֵ��100</p>"+
								"<p>ħ��ֵ��30</p>"+
								"<p>����ֵ��0</p>"+
								"<p>���ܣ��򵥹���</p>"+
							"</html>";
		}
		
		roleInformation.setText(information);
	}
	
	/**
	 * �����ѡ��ĵ�ͼͼƬ
	 */
	private void createMapPicture() {
		int i;
		
		this.mapPictureLabel = new JLabel[2];
		
		this.mapPictureLabel[0] = new JLabel(new ImageIcon(PictureName.MAP_NO_BARRIERS));
		this.mapPictureLabel[1] = new JLabel(new ImageIcon(PictureName.MAP_HAVE_BARRIERS));
		
		for(i=0 ; i<this.mapPictureLabel.length ; i++) {
			this.add(this.mapPictureLabel[i]);
			this.mapPictureLabel[i].setBounds(80+i*430, 550, 400, 160);
		}
	}
	/**
	 * �����ͼ��ѡ��
	 */
	private void createMapButton() {
		//����
		Font font = new Font("",Font.BOLD,20);
		JRadioButtonMenuItem tempButton;
		
		this.mapButton = new LinkedList<JRadioButtonMenuItem>();
		this.mapButtonGroup = new ButtonGroup();
		
		tempButton = new JRadioButtonMenuItem("�򵥵�ͼ");
		tempButton.setFont(font);
		tempButton.addActionListener(this);
		this.mapButton.add(tempButton);
		this.mapButtonGroup.add(tempButton);
		this.add(tempButton);
		tempButton.setBounds(220, 710, 150, 50);
		
		tempButton = new JRadioButtonMenuItem("���ӵ�ͼ");
		tempButton.setFont(font);
		tempButton.addActionListener(this);
		this.mapButton.add(tempButton);
		this.mapButtonGroup.add(tempButton);
		this.add(tempButton);
		tempButton.setBounds(670, 710, 150, 50);
	}
	/**
	 * ����ѡ��ĵ�ͼ���������ͼ�����Ϣ
	 * @param aim ѡ���ĵ�ͼ
	 */
	private void selectMap(JRadioButtonMenuItem aim) {
		String information;
		
		//ѡ����ͼ
		aim.setSelected(true);
		this.choosedMap = aim.getText();
		
		//������ʾ��Ϣ
		//�򵥵�ͼ��Ϣ
		if(aim.getText().equals("�򵥵�ͼ")) {
			information = "<html>"+
								"<p>��ͼ���ܣ�</p>"+
								"<p>�򵥵�ͼû���ϰ��ֻ��������ǽ������������ֱ�ӹ����Է�Ŷ��</p>"+
						  "</html>";
		}
		//���ӵ�ͼ��Ϣ
		else {
			information = "<html>"+
								"<p>��ͼ���ܣ�</p>"+
								"<p>���ӵ�ͼ�����ϰ��������������ܶԷ��Ĺ���Ŷ��</p>"+
							"</html>";
		}
		
		this.mapInformation.setText(information);
	}
	
	/**
	 * ���조��ʼ��Ϸ���롰ȡ������ť
	 */
	private void createElseButton() {
		Font font = new Font("",Font.BOLD,25);
		
		this.beginToPlayButton = new JButton("��ʼ��Ϸ");
		this.beginToPlayButton.addActionListener(this);
		this.beginToPlayButton.setFocusable(false);
		this.add(this.beginToPlayButton);
		this.beginToPlayButton.setFont(font);
		this.beginToPlayButton.setBounds(350, 780, 150, 40);
		
		this.cancelButton = new JButton("ȡ��");
		this.cancelButton.addActionListener(this);
		this.cancelButton.setFocusable(false);
		this.add(this.cancelButton);
		this.cancelButton.setFont(font);
		this.cancelButton.setBounds(530, 780, 100, 40);
	}
	
	/**
	 * ��ʼ��ѡ���Ľ�ɫ
	 */
	private void initialize() {
		Font font = new Font("",Font.BOLD,20);
		
		this.roleInformation = new JLabel();
		this.roleInformation.setFont(font);
		this.roleInformation.setBounds(150, 330, 300, 200);
		this.add(this.roleInformation);
		this.selectRole(this.firstRoleButton.get(0));
		
		this.mapInformation = new JLabel();
		this.mapInformation.setFont(font);
		this.mapInformation.setBounds(580, 330, 300, 200);
		this.add(this.mapInformation);
		this.selectMap(this.mapButton.get(0));
	}
	
	/**
	 * ��ʼ��Ϸ
	 */
	private void playGame() {
		BattleFrame frame;
		
		//�������д���
		this.dispose();
		//�½���Ϸ����
		frame = new BattleFrame(this.choosedMap,Function.translate(this.choosedRole));
		BattlePanel.frame = frame;
		
		//�Է���ɫ
		MyRunnable runnable;
		Thread task;
		
		MyRunnable.frame = frame;
		runnable = new MyRunnable();
		task = new Thread(runnable);
		
		task.start();
	}
	
	/**
	 * ����ѡ����
	 */
	public ChooseFrame() {
		//1�����ô����һЩ����
		this.setLayout(null);
		this.setTitle("Ӣ�۵�ͼѡ��");
		this.setVisible(true);
		this.setSize(1020, 900);
		this.setLocation(100, 0);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//2������Ӣ��ͼƬ
		this.createRolePicture();
		//3������Ӣ�۰�ť
		this.createFirstRoleButton();
		//4�����ص�ͼͼƬ
		this.createMapPicture();
		//5�����ص�ͼ��ť
		this.createMapButton();
		//6������������ť
		this.createElseButton();
		//7����ʼ��ѡ��Ӣ��
		this.initialize();
	}
	
	/**
	 * ������ť�����
	 */
	public void actionPerformed(ActionEvent e) {
		int i;
		
		//ѡ���ɫ
		for(i=0 ; i<this.firstRoleButton.size() ; i++) {
			if(this.firstRoleButton.get(i) == e.getSource()) {
				this.selectRole(this.firstRoleButton.get(i));
				
				break;
			}
		}
		
		//ѡ���ͼ
		for(i=0 ; i<this.mapButton.size() ; i++) {
			if(this.mapButton.get(i) == e.getSource()) {
				this.selectMap(this.mapButton.get(i));
				
				break;
			}
		}
		
		//��
		if(e.getSource() == this.beginToPlayButton) {
			this.playGame();
		}
		
		
		//����
		if(e.getSource() == this.cancelButton) {
			this.dispose();
		}
	}

}
