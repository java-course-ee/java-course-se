package edu.gemini.formlist;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SimpleFrame extends JFrame implements Comparable<SimpleFrame> {
    
    public static final Integer PREF_HEIGHT = 60;
    private ButtonForm manager;
    
    public SimpleFrame(ButtonForm manager) {
        this.manager = manager;
        add(new JLabel("Simple Form " + Math.round(Math.random()*200)));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(1,1, (int)Math.round(Math.random()*500 + 200), PREF_HEIGHT);
        
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosed(WindowEvent e) {
                SimpleFrame.this.manager.removeFrame(SimpleFrame.this);
            }
        });
    }

    @Override
    public int compareTo(SimpleFrame o) {
        return this.getWidth() - o.getWidth();
    }

}
