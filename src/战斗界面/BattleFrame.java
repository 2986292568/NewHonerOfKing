package ս������;

import javax.swing.JFrame;

/**
 * ս��������
 * @author ���ӻ�
 *
 */
public class BattleFrame extends JFrame{
	/**
	 * ���ȱʡ���а汾��ʶ
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ������е����
	 */
	public BattlePanel panel;
	
	/**
	 * ���촰��
	 * @param choosedMap ��ͼ����
	 * @param choosedRoleDescription ��ɫ����
	 */
	public BattleFrame(String choosedMap,String choosedRoleDescription) {
		panel = new BattlePanel(choosedMap,choosedRoleDescription);
		this.setContentPane(panel);
		
		this.getContentPane().setLayout(null);
		
		this.addKeyListener(panel);
		this.addMouseListener(panel);
		
		this.setTitle("������ҫ�ع���");
		this.setVisible(true);
		
		this.setSize(1818, 970);
		this.setLocation(40, 20);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
