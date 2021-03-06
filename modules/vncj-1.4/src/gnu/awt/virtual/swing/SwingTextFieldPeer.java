package gnu.awt.virtual.swing;

import java.awt.*;
import java.awt.peer.*;
import java.awt.event.*;
import java.awt.image.*;

import javax.swing.*;

/**
* AWT text field peer implemented as a {@link javax.swing.JTextField}.
**/

class SwingTextFieldPeer extends JTextField implements TextFieldPeer
{
	//
	// Construction
	//
	
	public SwingTextFieldPeer( TextField textField )
	{
		super();
		SwingFramePeer.add( textField, this );
	}
	
	//
	// TextFieldPeer
	//
	
	public void setEchoChar( char echoChar )
	{
	}
	
	public Dimension getPreferredSize( int columns )
	{
		return null;
	}
	
	public Dimension getMinimumSize( int columns )
	{
		return null;
	}
	
	// Deprecated
	
	public void setEchoCharacter( char c )
	{
		setEchoChar( c );
	}

	public Dimension preferredSize( int cols )
	{
		return getPreferredSize( cols );
	}
	
	public Dimension minimumSize( int cols )
	{
		return getMinimumSize( cols );
	}
	
	//
	// TextComponentPeer
	//
	
	public int getIndexAtPoint( int x, int y )
	{
		return 0;
	}
	
	public Rectangle getCharacterBounds( int i )
	{
		return null;
	}
	
	public long filterEvents( long mask )
	{
		return 0;
	}
	
	//
	// ComponentPeer
	//
	
	// Events
	
	public void handleEvent( AWTEvent e )
	{
		//System.err.println(e);
	}
	
	public void coalescePaintEvent( PaintEvent e )
	{
		System.err.println(e);
	}
	
	public boolean handlesWheelScrolling()
	{
		return false;
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
	
	public boolean requestFocus( Component lightweightChild, boolean temporary, boolean focusedWindowChangeAllowed, long time )
	{
		return true;
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
	
	// Cursor
	
	public void updateCursorImmediately()
	{
	}
	
	// Misc
	
	public void dispose()
	{
	}
	
	///////////////////////////////////////////////////////////////////////////////////////
	// Private
}
