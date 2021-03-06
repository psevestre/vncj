package gnu.awt.virtual;

import java.awt.*;
import java.awt.peer.*;
import java.awt.event.*;
import java.awt.image.*;

/**
* Base class for virtual component peers. Satisfies the requirements for AWT peers without
* actually displaying anything (hence, they are virtual) or by delegating to the parent component,
* under the assumption is that somewhere up in the hierarchy there is a parent who can produce a
* display.
**/

public abstract class VirtualComponentPeer implements ComponentPeer
{
	//
	// Construction
	//
	
	public VirtualComponentPeer( Toolkit toolkit, Component component )
	{
		this.toolkit = toolkit;
		this.component = component;
		setBounds( component.getX(), component.getY(), component.getWidth(), component.getHeight() );
		
		// Disable double-buffering for Swing components
		//javax.swing.RepaintManager.currentManager( component ).setDoubleBufferingEnabled( false );
	}
	
	//
	// ComponentPeer
	//
	
	// Graphics
	
	public void paint( Graphics g )
	{
		//System.err.println("paint");
	}
	
	public void repaint( long tm, int x, int y, int width, int height )
	{
		//System.err.println("repaint");
	}
	
	public void print( Graphics g )
	{
	}
	
	public Graphics getGraphics()
	{
		Component parent = component.getParent();
		if( parent != null )
		{
			System.err.println("creating graphics");
			return parent.getGraphics().create( location.x, location.y, size.width, size.height );
		}
		else
			throw new Error();	
	}
	
	public GraphicsConfiguration getGraphicsConfiguration()
	{
		//System.err.println("getGraphicsConfiguration");
		return null;
	}
	
	// Bounds
	
	public void setBounds( int x, int y, int width, int height )
	{
		//System.err.println("setBounds "+x+","+y+","+width+","+height);
		size.width = width;
		size.height = height;
	}
	
	public Point getLocationOnScreen()
	{
		Point screen = new Point( location );
		Component parent = component.getParent();
		if( parent != null )
		{
			Point parentScreen = parent.getLocationOnScreen();
			screen.translate( parentScreen.x, parentScreen.y );
		}

		return screen;
	}
	
	public Dimension getPreferredSize()
	{
		return size;
	}
	
	public Dimension getMinimumSize()
	{
		return size;
	}
	
	// State

	public void setVisible( boolean b )
	{
	}
	
	public void setEnabled( boolean b )
	{
	}
	
	// Obscurity
	
	public boolean isObscured()
	{
		return false;
	}
	
	public boolean canDetermineObscurity()
	{
		return false;
	}
	
	// Focus
	
	public boolean isFocusable()
	{
		return true;
	}
	
	public boolean requestFocus( Component lightweightChild, boolean temporary, boolean focusedWindowChangeAllowed, long time )
	{
		return true;
	}
	
	/*public boolean isFocusTraversable()
	{
		return true;
	}*/
	
	/*public void requestFocus()
	{
	}*/
	
	// Events
	
	public void handleEvent( AWTEvent e )
	{
		//System.err.println(e);
	}
	
	public void coalescePaintEvent( PaintEvent e )
	{
		//System.err.println( "coalescePaintEvent: " + e );
	}
	
	public boolean handlesWheelScrolling()
	{
		return false;
	}
	
	// Color
	
	public ColorModel getColorModel()
	{
		return toolkit.getColorModel();
	}
	
	public void setForeground( Color c )
	{
	}
	
	public void setBackground( Color c )
	{
	}
	
	// Fonts
	
	public FontMetrics getFontMetrics( Font font )
	{
		return null;
	}
	
	public void setFont( Font f )
	{
	}
	
	// Cursor
	
	public void updateCursorImmediately()
	{
	}
	
	/*public void setCursor( Cursor cursor )
	{
	}*/
	
	// Misc
	
	public Toolkit getToolkit()
	{
		return toolkit;
	}
	
	public void dispose()
	{
	}
	
	// Buffer
	
	public void createBuffers( int x, BufferCapabilities bufferCapabilities )
	{
	}
	
	public void destroyBuffers()
	{
	}
	
	public void flip( BufferCapabilities.FlipContents flipContents )
	{
	}
	
	public Image getBackBuffer()
	{
		return null;
	}
	
	// Image
	
	public Image createImage( ImageProducer producer )
	{
		System.err.println( "createImage(producer)" );
		return null;
	}
	
	public Image createImage( int width, int height )
	{
		Component parent = component.getParent();
		if( parent != null )
			return parent.createImage( width, height );
		else
			throw new Error();	
	}
	
	public VolatileImage createVolatileImage( int width, int height )
	{
		// These babies are created by hardware
		return null;
	}
	
	public boolean prepareImage( Image img, int w, int h, ImageObserver o )
	{
		System.err.println( "prepareImage" );
		return true;
	}
	
	public int checkImage( Image img, int w, int h, ImageObserver o )
	{
		System.err.println( "checkImage" );
		return ImageObserver.ALLBITS;
	}
	
	// Deprecated

	public Dimension preferredSize()
	{
		return getPreferredSize();
	}

	public Dimension minimumSize()
	{
		return getMinimumSize();
	}

	public void show()
	{
		setVisible( true );
	}

	public void hide()
	{
		setVisible( false );
	}

	public void enable()
	{
		setEnabled( true );
	}

	public void disable()
	{
		setEnabled( false );
	}

	public void reshape( int x, int y, int width, int height )
	{
		setBounds( x, y, width, height );
	}

	///////////////////////////////////////////////////////////////////////////////////////
	// Private
	
	protected Component component;
	protected Toolkit toolkit;
	protected Point location = new Point();
	protected Dimension size = new Dimension();
}
