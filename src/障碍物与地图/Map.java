package �ϰ������ͼ;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ս������.BattlePanel;
import ����.PictureName;
import ����.Point;
import ����.Function;

/**
 * ��ͼ��
 * @author ���ӻ�
 *
 */
public class Map {
	/**
	 * ��ͼ���������
	 */
	public static BattlePanel panel = null;
	/**
	 * ��ͼ��ͼƬ
	 */
	public ImageIcon mapImg[][];
	/**
	 * ��ͼ��ͼƬ������--��ǩ
	 */
	public JLabel mapLabel[][];
	
	/**
	 * Ϊ��ͼ���ӵ����ϰ���
	 * @param barrier �ϰ���
	 */
	private void addBarrier(Barrier barrier) {
		int i,j;
		int beginX,beginY;
		
		beginX = barrier.position.getX();
		beginY = barrier.position.getY();
		
		for(i=0 ; i<barrier.height && beginX+i<mapImg.length ; i++) {
			for(j=0 ; j<barrier.width && beginY+j<mapImg[i].length ; j++) {
				mapImg[beginX+i][beginY+j] = new ImageIcon(PictureName.WALL);
				
				mapLabel[beginX+i][beginY+j].setIcon(mapImg[beginX+i][beginY+j]);
			}
		}
	}
	
	/**
	 * �����ͼ
	 * @param width ��ͼ��
	 * @param height ��ͼ��
	 * @param barrier ��ͼ�����е��ϰ���
	 */
	public Map(int width,int height,Barrier barrier[]) {
		int i,j;
		
		mapImg = new ImageIcon[height][width];
		mapLabel = new JLabel[height][width];
		
		for(i=0 ; i<mapImg.length ; i++) {
			//��һ�������һ�����⣬ȫ��ǽ
			if(i==0 || i==mapImg.length-1) {
				for(j=0 ; j<mapImg[i].length ; j++) {
					mapImg[i][j] = new ImageIcon(PictureName.WALL);
					mapLabel[i][j] = new JLabel(mapImg[i][j]);
					
					panel.add(mapLabel[i][j]);
					mapLabel[i][j].setBounds(j*30, i*30, 30, 30);
				}
			}
			
			else {
				for(j=0 ; j<mapImg[i].length ; j++) {
					if(j==0 || j==mapImg[i].length-1) {
						mapImg[i][j] = new ImageIcon(PictureName.WALL);
						mapLabel[i][j] = new JLabel(mapImg[i][j]);
					}
					
					else {
						mapImg[i][j] = new ImageIcon(PictureName.SPACE);
						mapLabel[i][j] = new JLabel(mapImg[i][j]);
					}
					
					panel.add(mapLabel[i][j]);
					mapLabel[i][j].setBounds(j*30, i*30, 30, 30);
				}
			}
		}
		
		//�����ϰ���
		for(i=0 ; i<barrier.length ; i++) {
			this.addBarrier(barrier[i]);
		}
	}
	
	/**
	 * �ж�һ�����Ƿ��ڵ�ͼ��
	 * @param position ���λ��
	 * @return boolean
	 */
	public boolean contains(Point position) {
		if(position.getX() >= 0 && position.getX() < mapImg.length 
		&& position.getY() >= 0 && position.getY() < mapImg[0].length) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * ��ȡָ�����ͼƬ����
	 * @param position ָ����
	 * @return String �õ��ͼƬ����
	 */
	public String get(Point position) {
		if(contains(position)) {
			return mapImg[position.getX()][position.getY()].getDescription();
		}
		
		return null;
	}
	
	/**
	 * ���ĵ�ͼ��ָ�����ͼƬ��ֻ�ܸ��Ŀհ׸�
	 * @param position ָ����
	 * @param description ͼƬ����
	 * @return boolean �����Ƿ�ɹ�����Ϣ
	 */
	public boolean replace(Point position,String description) {
		String tempDescription;
		
		if(contains(position)) {
			tempDescription = get(position);
			
			//����ǽ��Ӣ��
			if(tempDescription.equals(PictureName.WALL)==false && Function.isRole(tempDescription)==false) {
				
				mapImg[position.getX()][position.getY()] = new ImageIcon(description);
				mapLabel[position.getX()][position.getY()].setIcon(mapImg[position.getX()][position.getY()]);
				
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * ���ĵ�ͼ��ָ�����ͼƬ������ǽ�������Ķ��ܸ���
	 * @param position ָ����
	 * @param description ͼƬ����
	 * @return boolean �����Ƿ�ɹ�����Ϣ
	 */
	public boolean sharpReplace(Point position,String description) {
		String tempDescription;
		
		if(contains(position)) {
			tempDescription = get(position);
			
			//����ǽ
			if(tempDescription.equals(PictureName.WALL)==false) {
				mapImg[position.getX()][position.getY()] = new ImageIcon(description);
				mapLabel[position.getX()][position.getY()].setIcon(mapImg[position.getX()][position.getY()]);
				
				return true;
			}
		}
		
		return false;
	}
}
