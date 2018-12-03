package ��ɫ;

import ����.Point;

/**
 * ��ɫ��һЩ�����ļ���
 * @author ���ӻ�
 *
 */
public interface ForRole {
	/**
	 * ��ɫ�����ͼ
	 */
	public void enterMap();
    
	/**
	 * ��ɫ�˳���ͼ
	 */
	public void exitMap();

    /**
     * �趨��ɫ����ֵ
     * @param Mp ����ֵ
     */
    public void setMp(int Mp);
	
    /**
     * ����ǰ��
     * @param direction Ӣ��ǰ���ķ���
     * @return ǰ���Ƿ�ɹ�
     */
    boolean goForward(String direction);
    
    /**
     * @param direction ��������
     */
    void simpleAttack(String direction);
    
    /**
     * �жϽ�ɫ�Ƿ�����
     * @return boolean
     */
    boolean isDead();
    
    /**
     * ��ɫѰ��·���ҵ�ĳһ��
     * @param anotherPoint Ŀ���
     */
    public void goTo(Point anotherPoint);
    
}
