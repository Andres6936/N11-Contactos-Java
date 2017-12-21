package edu.jabs.contactos.mundo;

/**
 * Representa la excepción asociada con el intento de incluir en el directorio
 * un contacto con el mismo nombre de uno que ya está presente
 */
public class ContactoRepetidoException extends Exception
{
	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------

	/**
	 * Constructor de la excepción
	 * 
	 * @param nombreContacto es el nombre del contacto que se intentó agregar
	 */
	public ContactoRepetidoException( String nombreContacto )
	{
		super( "Ya existe un contacto con ese nombre: " + nombreContacto );
	}
}