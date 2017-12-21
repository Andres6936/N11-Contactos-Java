package edu.jabs.contactos.mundo;

/**
 * Representa un dato estadístico asociado con un dato de la estructura interna
 * de información del directorio
 */
public class DatoEstadistico
{
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Nombre del dato
	 */
	private String nombreDato;

	/**
	 * Valor del dato
	 */
	private Object valorDato;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructor del dato estadístico
	 * 
	 * @param nom Nombre del dato
	 * @param val Valor del dato
	 */
	public DatoEstadistico( String nom, Object val )
	{
		nombreDato = nom;
		valorDato = val;
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Retorna el nombre del dato
	 * 
	 * @return Nombre del dato
	 */
	public String darNombre( )
	{
		return nombreDato;
	}

	/**
	 * Retorna el valor del dato
	 * 
	 * @return Valor del dato
	 */
	public String darValor( )
	{
		return valorDato.toString( );
	}
}