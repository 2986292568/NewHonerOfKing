package �ϰ������ͼ;

import ����.Point;

/**
 * �ϰ�����
 * @author ���ӻ�
 *
 */
public class Barrier {
	/**
	 * �ϰ���λ��
	 */
	public Point position;
	/**
	 * �ϰ�������
	 */
	public int width,height;
	
	/**
	 * �����ϰ��� 
	 * @param position �ϰ�������
	 * @param width �ϰ����
	 * @param height �ϰ����
	 */
	public Barrier(Point position,int width,int height) {
		this.position = position;
		this.width = width;
		this.height = height;
	}
}
