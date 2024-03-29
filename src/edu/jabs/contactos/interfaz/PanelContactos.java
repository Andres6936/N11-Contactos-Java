package edu.jabs.contactos.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Collection;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import edu.jabs.contactos.mundo.Contacto;

/**
 * Este es el panel en el cual se muestran los contactos
 */
public class PanelContactos extends JPanel implements ListSelectionListener
{
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Referencia a la ventana principal de la aplicación
	 */
	private InterfazContactos ventanaPrincipal;

	/**
	 * Indica si se está en modo búsqueda
	 */
	private boolean modoBusqueda;

	// -----------------------------------------------------------------
	// Atributos de la Interfaz
	// -----------------------------------------------------------------

	/**
	 * Es la lista en la cual se muestran los contactos que hay en el directorio
	 */
	private JList listaContactos;

	/**
	 * Es el panel con barras de desplazamiento dentro del que se muestra la lista
	 */
	private JScrollPane scroll;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Construye el panel e inicializa sus componentes
	 * 
	 * @param ic Interfaz de los contactos
	 */
	public PanelContactos( InterfazContactos ic )
	{
		ventanaPrincipal = ic;
		setLayout( new BorderLayout( ) );
		setBorder( new TitledBorder( "Contactos" ) );

		scroll = new JScrollPane( );
		scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
		scroll.setPreferredSize( new Dimension( 230, 200 ) );
		listaContactos = new JList( );
		listaContactos.addListSelectionListener( this );
		listaContactos.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		scroll.getViewport( ).add( listaContactos );

		add( scroll, BorderLayout.CENTER );

		modoBusqueda = false;
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Cambia los elementos que se muestran en la lista de contactos. Si se está en
	 * <br>
	 * modo búsqueda y hay contactos se selecciona el primero
	 * 
	 * @param lista Lista de nombres de contactos
	 */
	public void cambiarListaContactos( Collection lista )
	{
		listaContactos.setListData( lista.toArray( ) );

		if ( modoBusqueda && listaContactos.getModel( ).getSize( ) > 0 )
			listaContactos.setSelectedIndex( 0 );
	}

	/**
	 * Retorna el nombre del contacto seleccionado actualmente en la lista.
	 * 
	 * @return Nombre del contacto seleccionado. Si no hay ninguno seleccionado,
	 *         retorna null.
	 */
	public String darContactoSeleccionado( )
	{
		return (String) listaContactos.getSelectedValue( );
	}

	/**
	 * Selecciona en la lista el contacto indicado
	 * 
	 * @param c El contacto que debe quedar seleccionado
	 */
	public void seleccionarContacto( Contacto c )
	{
		listaContactos.setSelectedValue( c.darNombre( ), true );
	}

	/**
	 * Método para manejar los eventos asociados con el cambio de la lista
	 * 
	 * @param e El evento con la información del nuevo elemento seleccionado
	 */
	public void valueChanged( ListSelectionEvent e )
	{
		if ( modoBusqueda )
			ventanaPrincipal.verContacto( );
	}

	/**
	 * Cambia el valor de modoBusqueda para indicar que no se está en ese modo
	 * 
	 */
	public void modoInsercion( )
	{

		modoBusqueda = false;
	}

	/**
	 * Cambia el valor de modoBusqueda para indicar que se está en ese modo
	 */
	public void modoBusqueda( )
	{
		modoBusqueda = true;
		if ( listaContactos.getModel( ).getSize( ) > 0 )
			listaContactos.setSelectedIndex( 0 );

	}
}