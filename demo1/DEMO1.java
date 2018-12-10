import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DEMO1 extends JFrame{
    JFrame j = new JFrame("音樂HarHar玩");
    JLabel TableList=new JLabel("列表");
    JButton BAdd=new JButton("添加歌曲");
    JButton BDelect=new JButton("删除歌曲");
    JButton BDelectTable=new JButton("清空列表");

    JButton JbtnPlay = new JButton("播放");
    JButton JbtnStop = new JButton("停止");
    JButton JbtnPause = new JButton("暫停");
    JButton JbtnResume = new JButton("繼續");
    JPanel p=new JPanel();
    JPanel p1=new JPanel(); //按鈕區域
    JPanel p2=new JPanel(); //列表LABEL p1
    JPanel p3=new JPanel(); //列表 p5
    JPanel p4=new JPanel(); 
    private ButtonHandler hbtHandler = new ButtonHandler();  //為按鈕註冊listener,用來處理按鈕事件
   
    

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
        
        p1.setLayout(new GridLayout(2,2,20,20));

        p2.setBounds(2, 3, 298, 30);   
        p2.setBackground(new Color(255,255,255));
        TableList.setBounds(30, 100, 200, 50);
        TableList.setFont(new Font("宋体",1, 20));

        p3.setBounds(2, 35, 298, 526);
        p3.setLayout(null);
        p3.setBackground(new Color(255,255,255));

        //p4.setLayout(new GridLayout(2,0,200,10));
        //p4.setBackground(new Color(255,255,255));

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
        BAdd.setBounds(5,20, 90,30);
        BAdd.setBackground(new Color(255,255,255));
        p3.add(BAdd);
        
        p.add(p1,BorderLayout.WEST);
        //p.add(p4,BorderLayout.CENTER);

        j.add(p);
        j.add(p2);//列表 
        j.add(p3);//列表下方
        

        JbtnResume.addActionListener(hbtHandler);
        JbtnPlay.addActionListener(hbtHandler);
        JbtnPause.addActionListener(hbtHandler);
        JbtnStop.addActionListener(hbtHandler);
    }

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
        }
        
        public void audioPlayEnd(Object callbackObj) {
            System.out.println("音樂播完收到訊息==>" + callbackObj);
            JbtnPlay.setEnabled(true);
        }
    }
    
    public static void main(String [] args){
        DEMO1 id = new DEMO1();
    }

    
}
