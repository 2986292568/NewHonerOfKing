package 战斗界面;

import javax.swing.JFrame;

/**
 * 战斗窗体类
 * @author 蔡子辉
 *
 */
public class BattleFrame extends JFrame{
	/**
	 * 添加缺省串行版本标识
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 窗体具有的面板
	 */
	public BattlePanel panel;
	
	/**
	 * 构造窗体
	 * @param choosedMap 地图类型
	 * @param choosedRoleDescription 角色描述
	 */
	public BattleFrame(String choosedMap,String choosedRoleDescription) {
		panel = new BattlePanel(choosedMap,choosedRoleDescription);
		this.setContentPane(panel);
		
		this.getContentPane().setLayout(null);
		
		this.addKeyListener(panel);
		this.addMouseListener(panel);
		
		this.setTitle("王者荣耀重构版");
		this.setVisible(true);
		
		this.setSize(1818, 970);
		this.setLocation(40, 20);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
