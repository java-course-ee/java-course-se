package edu.gemini.formlist;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ButtonForm extends JFrame implements ActionListener {
    
    private final static String CREATE = "CREATE";
    private final static String SORT_ASC = "SORT ASC";
    private final static String SORT_DESC = "SORT DESC";
    
    private List<SimpleFrame> formList = new ArrayList();
    
    public ButtonForm() {
        setLayout(new GridLayout(3, 1));
        
        JButton create = new JButton(CREATE);
        create.setActionCommand(CREATE);
        create.addActionListener(this);

        JButton sortAsc = new JButton(SORT_ASC);
        sortAsc.setActionCommand(SORT_ASC);
        sortAsc.addActionListener(this);

        JButton sortDesc = new JButton(SORT_DESC);
        sortDesc.setActionCommand(SORT_DESC);
        sortDesc.addActionListener(this);
        
        add(create);
        add(sortAsc);
        add(sortDesc);
        
        setBounds(500, 500, 200, 300);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton) {
            JButton btn = (JButton)e.getSource();
            if(btn.getActionCommand().equals(CREATE)) {
                for(int i=0; i<7; i++) {
                    formList.add(new SimpleFrame(this));
                }
            }
            if(btn.getActionCommand().equals(SORT_ASC)) {
                Collections.sort(formList);
            }
            if(btn.getActionCommand().equals(SORT_DESC)) {
                Collections.sort(formList);
                Collections.reverse(formList);
            }
            
        }
        showFormList();
    }

    private void showFormList() throws HeadlessException {
        //JOptionPane.showMessageDialog(null, formList.size());
        int y=10;
        for(SimpleFrame frame : formList) {
            frame.setBounds(100, y, frame.getWidth(), 50);
            frame.setVisible(true);
            y += 10 + SimpleFrame.PREF_HEIGHT;
        }
    }

    public void removeFrame(SimpleFrame removedFrame) {
        formList.remove(removedFrame);
        showFormList();
    }
}
