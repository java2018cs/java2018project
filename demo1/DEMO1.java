import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;




public class DEMO1 extends JFrame{
	

    JFrame j = new JFrame("音樂HarHar玩");
    JLabel TableList=new JLabel("列表");
    JButton BDelect=new JButton("删除歌曲");
    JButton BDelectTable=new JButton("清空列表");
    
    JButton BDo=new JButton("Do");
    JButton BRe=new JButton("Re");
    JButton BMi=new JButton("Mi");
    JButton BFa=new JButton("Fa");
    JButton BSol=new JButton("Sol");
    JButton BLa=new JButton("La");
    JButton BSi=new JButton("Si");

    JButton JbtnPlay = new JButton("播放");
    JButton JbtnStop = new JButton("停止");
    JButton JbtnPause = new JButton("暫停");
    JButton JbtnResume = new JButton("繼續");
    JPanel p=new JPanel();
    JPanel p1=new JPanel(); //播放
    JPanel p2=new JPanel(); //列表
    JPanel p3=new JPanel(); //音
    JPanel p4=new JPanel();
    
    JPanel pg=new JPanel(); //guitar panel
    JPanel pp=new JPanel(); //piano panel
    JPanel pd=new JPanel(); //drum panel
    JPanel pb=new JPanel(); //bass panel
    //JTable tb1=new JTable(5,16);
    
    
    private ButtonHandler hbtHandler = new ButtonHandler();  //為按鈕註冊listener,用來處理按鈕事件
    
    JButton BPiano = new JButton("鋼琴");
    JButton BGuitar = new JButton("吉他");
    JButton BBass = new JButton("Bass");
    JButton BDrum = new JButton("鼓組");
    
    Guitar guitar = new Guitar();
    JButton BaddLine = new JButton("新增");
    JButton BdeleteLine = new JButton("刪除");
    JButton BshowLine = new JButton("顯示");
    
    //JTable mTable = new JTable(15, 16);
    
    static DefaultTableModel tableModel = new DefaultTableModel(15,16);
    static JTable tb1 = new JTable(tableModel){
        public boolean isCellEditable(int row, int column)
             {
                        return false;//表格不允许被编辑
             }
    };
    static JTable tb2 = new JTable(tableModel){
        public boolean isCellEditable(int row, int column)
             {
                        return false;//表格不允许被编辑
             }
    }; 
    static JTable tb3 = new JTable(tableModel){
        public boolean isCellEditable(int row, int column)
             {
                        return false;//表格不允许被编辑
             }
    }; 
    static JTable tb4 = new JTable(tableModel){
        public boolean isCellEditable(int row, int column)
             {
                        return false;//表格不允许被编辑
             }
    }; 

    public DEMO1(){
        super("播放音樂測試");
        //設定視窗
        
        j.setSize(1200,700);
        j.setLayout(null);
        j.getContentPane().setBackground(Color.BLACK);
        //j.setResizable(false);//視窗放大按鈕無效
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.setBounds(2, 563, 1180, 85);
        p.setLayout(new BorderLayout());
        p.setBackground(new Color(255,255,255));
        
        p1.setLayout(new GridLayout(1,4,20,20));

        p2.setBounds(2, 3, 298, 30);   
        p2.setBackground(new Color(255,255,255));
        TableList.setBounds(30, 100, 200, 50);
        TableList.setFont(new Font("宋體",1, 20));

        p3.setBounds(2, 35, 298, 526);
        p3.setLayout(new GridLayout(5,1,0,10));
        p3.setBackground(new Color(255,255,255));

        //p4.setLayout(new GridLayout(2,0,200,10));
        p4.setBackground(new Color(255,255,255));

        pg.setBounds(302, 48, 880, 76);
        pg.setBackground(new Color(0,0,0));
        pp.setBounds(302, 192, 880, 76);
        pp.setBackground(new Color(0,0,0));
        pd.setBounds(302, 336, 880, 76);
        pd.setBackground(new Color(0,0,0));
        pb.setBounds(302, 480, 880, 76);
        pb.setBackground(new Color(0,0,0));
        pg.setLayout(new GridLayout(1,1));
        pp.setLayout(new GridLayout(1,1));
        pd.setLayout(new GridLayout(1,1));
        pb.setLayout(new GridLayout(1,1));
        	
        p2.add(TableList);
        JbtnPlay.setBackground(new Color(255,255,255));
        JbtnStop.setBackground(new Color(255,255,255));
        JbtnPause.setBackground(new Color(255,255,255));
        p1.add(JbtnPlay);
        p1.add(JbtnResume);
        p1.add(JbtnPause);
        p1.add(JbtnStop);
        p1.setBackground(new Color(255,255,255));
        
        p3.add(p);
        p3.add(BPiano);
        p3.add(BGuitar);
        p3.add(BDrum);
        p3.add(BBass);
        
        p.add(p1,BorderLayout.WEST);
        //p.add(p4,BorderLayout.EAST);
    
        /*pg.add(BaddLine);
        pg.add(BdeleteLine);
        pg.add(BshowLine);*/
        
 
        
        j.add(p);
        j.add(p2);//列表 
        j.add(p3);//列表下方
        j.add(pg);
        j.add(pp);
        j.add(pd);
        j.add(pb);
        pg.add(tb1);
        pd.add(tb2);
        pp.add(tb3);
        pb.add(tb4);

        JbtnResume.addActionListener(hbtHandler);
        JbtnPlay.addActionListener(hbtHandler);
        JbtnPause.addActionListener(hbtHandler);
        JbtnStop.addActionListener(hbtHandler);
        BaddLine.addActionListener(hbtHandler);
        BdeleteLine.addActionListener(hbtHandler);
        BshowLine.addActionListener(hbtHandler);
    }
    
    /*public void setTable() {
    	jTable.setColumnSelectionAllowed(true);
    	jTable.addMouseListener(new MouseAdapter()
    	{
    	    @Override
    	    public void mouseClicked(MouseEvent e)
    	    {
    	        if (e.getModifiers() == MouseEvent.BUTTON3_MASK)
    	        {
    	        	jTable.changeSelection(
    	        		jTable.rowAtPoint(e.getPoint()), 
    	        		jTable.columnAtPoint(e.getPoint()), 
    	                false, false);
    	        	jTable.setSelectionBackground(new Color(0,255,255));
    	        }
    	    }
    	});
    }*/

    private class ButtonHandler implements ActionListener, AudioPlayerCallback{
        AudioPlayer audio = null;

        public void actionPerformed(ActionEvent evtE){
            if(evtE.getSource() == JbtnPlay){//播放
                JbtnPlay.setEnabled(false);
                
                audio = new AudioPlayer();
                Object callbackObj = "你播放的test.wav已播完";//音樂播完時，會傳回來給自己的物件
                audio.setCallbackTartet(this, callbackObj);//設定接收音樂播完事件是目前的class
                String filePath = "123.wav";//test.wav是測試音檔，請自行準備一個檔案
                audio.loadAudio(filePath);
                audio.setPlayCount(2);//一直播放
                audio.play();
                return;
            }
            if(evtE.getSource() == JbtnStop){//結束播放
                JbtnPlay.setEnabled(true);
                audio.stop();
                return;
            }
            
            if(evtE.getSource() == JbtnPause){//暫停
                JbtnPlay.setEnabled(false);
                audio.pause();
                return;
            }
            
            if(evtE.getSource() == JbtnResume){//繼續
                System.out.println("JbtnResume");
                audio.resume();
                return;
            }
            
            if(evtE.getSource() == BaddLine) {
            	guitar.addMeasure();
            }
            
            if(evtE.getSource() == BdeleteLine) {
            	guitar.deleteMeasure();
            }
            
            if(evtE.getSource() == BshowLine) {
            	guitar.showMeasure();
            }
        }
        
        public void audioPlayEnd(Object callbackObj) {
            System.out.println("音樂播完收到訊息==>" + callbackObj);
            JbtnPlay.setEnabled(true);
        }
    }
    
   
    
}
