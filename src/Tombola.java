import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
	public class Tombola extends JFrame implements ActionListener
	{
		
		JButton sorteggia= new JButton ("Sorteggia");
		JTable tabella = new JTable(9,10);
		
		public Tombola()
		{	
			super ("Tabellone");
			Container c = this.getContentPane();
			c.setLayout(new FlowLayout());
			c.add(tabella);
			tabella.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			for (int i = 0; i < tabella.getColumnCount(); i++) 
			{
			    TableColumn colonna = tabella.getColumnModel().getColumn(i);
			    colonna.setPreferredWidth(190);
			}
			c.add(sorteggia);
			sorteggia.addActionListener(this);
			setSize(1700,700);
			setVisible(true);
		}
		
		public void actionPerformed(ActionEvent e)
		{
			boolean B=true;
			while(B)
			{
				if (e.getSource() == sorteggia) 
				{
				    int numeroCasuale = (int)(Math.random() * 90) + 1;
			        int row = (numeroCasuale - 1) / 10;
			        int col = (numeroCasuale - 1) % 10;
			        Object valoreCella = tabella.getValueAt(row, col);
			        if (valoreCella == null) 
			        {
			            tabella.setValueAt(numeroCasuale, row, col);
			            B=false;
			        } 
			    }
			 }
		}
	}

