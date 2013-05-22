package GUI.Game.Schaltflaechen;

import java.awt.event.MouseEvent;


import javax.swing.JLabel;

import GUI.Game.IDInfo;
import GUI.Game.Refreshable;
import Logik.Logikgatter;

public class LogikgatterSchaltflaeche extends SkallierbareSchaltflaeche implements Refreshable
{
	
	private Logikgatter[] logikgatter;

	private int anzahlGrafiken;
	private static final int ANZAHLVERSIONEN = 4;
	private Logikgatter[] logikgatterCache;
	private int refreshCounter;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8457018625255576914L;

	public LogikgatterSchaltflaeche(int xPos,int yPos, int  size, int anzahlGrafiken,Logikgatter[] logikgatter,boolean spiegeln, boolean isVertikal )
	{
		super(xPos, yPos,  size,anzahlGrafiken,LogikgatterSchaltflaeche.ANZAHLVERSIONEN, spiegeln, isVertikal);
		
		this.refreshCounter = 0;
		
		this.anzahlGrafiken = anzahlGrafiken;
		
		this.logikgatter = logikgatter;
		
		this.logikgatterCache = new Logikgatter[logikgatter.length];
		
		this.refresh();
		
		for(int i = 0; i < anzahlGrafiken; i++)
		{
			super.getImage(i).addMouseListener(this);
			this.add(super.getImage(i));
		}		
	}
	
	
	
	public void refresh()
	{
		for(int i = 0; i < this.anzahlGrafiken; i++ )
		{
			if( (this.logikgatterCache[i] != this.logikgatter[i]) || this.refreshCounter == 0 )
			{
				if(this.logikgatter[i] == null)
				{
					this.setImage(i);
				}
				else
				{
					this.setImage(i,this.logikgatter[i]);
					this.setImageToLogikgatterStatus(logikgatter[i], this.getImage(i));
				}
				
				System.out.println("Refresh OK");
			}
			else
			{
				System.out.println("Refresh FAIL");
			}
		}
		
		this.refreshCounter++;
		
		for(int i = 0; i < this.logikgatter.length; i++)
		{
			this.logikgatterCache[i] = this.logikgatter[i];
		}
		
		this.setPressedID(new IDInfo());
	}
	
	public void setImageToLogikgatterStatus(Logikgatter logikgatter, JLabel button)
	{
		if(logikgatter != null)
		{
			if(logikgatter.getIsAktiv())
			{
				this.changeVersion(0, button);
			}
			else
			{
				this.changeVersion(3, button);
			}
		}
		else
		{
			this.changeVersion(0, button);
		}
	}
	
	public void setAllImagesToLogikgatterStatus()
	{
		for(int i = 0; i < this.anzahlGrafiken; i++)
		{
			this.setImageToLogikgatterStatus(this.logikgatter[i],this.getImage(i));
		}
	}
	
	public Logikgatter[] getLogikgatter()
	{
		return this.logikgatter;
	}
	

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		JLabel button = (JLabel)e.getSource();
		if(this.getPressedID().getIsPressed())
		{
			if( button != this.getImage(this.getPressedID().getID()) )
			{
				super.changeVersion(2, (JLabel)e.getSource());
			}
		}
		else
		{
			super.changeVersion(2, (JLabel)e.getSource());
		}
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		JLabel button = (JLabel)e.getSource();
		if(this.getPressedID().getIsPressed())
		{
			if( button != this.getImage(this.getPressedID().getID()) )
			{
				this.changeVersion(0, (JLabel)e.getSource());
			}
		}
		else
		{
			super.changeVersion(0, (JLabel)e.getSource());
		}
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		//this.changeVersion(1, (JLabel)e.getSource());
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		//this.changeVersion(0, (JLabel)e.getSource());
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
			
		JLabel button = (JLabel)e.getSource();
		if( this.getPressedID().getIsPressed() )
		{
			if(button == this.getImage(this.getPressedID().getID()))
			{
				this.changeVersion(0, button);
				this.getPressedID().setIsPressed(false);
			}
			else
			{
				this.changeVersion(0, this.getImage(this.getPressedID().getID()));
				this.changeVersion(1, button);
				this.setPressedID(this.getImageIDInfo( button ));
			}
		}
		else
		{
			this.changeVersion(1, button);
			this.setPressedID(this.getImageIDInfo( button ));
		}

		
	}
}