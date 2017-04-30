package org.catan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Artyukov
 */
public class ExitButton extends JButton
{

    public ExitButton()
    {
        super();
        setText("Выход");
        
        addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
    }
    
    
}
