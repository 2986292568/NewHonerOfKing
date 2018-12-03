package 角色;

import 辅助.Point;

/**
 * 角色的一些方法的集合
 * @author 蔡子辉
 *
 */
public interface ForRole {
	/**
	 * 角色进入地图
	 */
	public void enterMap();
    
	/**
	 * 角色退出地图
	 */
	public void exitMap();

    /**
     * 设定角色生命值
     * @param Mp 生命值
     */
    public void setMp(int Mp);
	
    /**
     * 人物前进
     * @param direction 英雄前进的方向
     * @return 前进是否成功
     */
    boolean goForward(String direction);
    
    /**
     * @param direction 攻击方向
     */
    void simpleAttack(String direction);
    
    /**
     * 判断角色是否死亡
     * @return boolean
     */
    boolean isDead();
    
    /**
     * 角色寻找路径找到某一点
     * @param anotherPoint 目标点
     */
    public void goTo(Point anotherPoint);
    
}
