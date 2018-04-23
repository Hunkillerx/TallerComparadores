/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 *
 * Taller Objetos Comparadores
 * Autor: EAN - Abril 23, 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package ean.programacionavanzada.tallercomparadores

import java.util.*

/**
 * Clase que representa la información de un producto
 */

data class Producto(var nombre: String, var precio: Double, var cantidad: Int):
        Comparable<Producto> {

    override fun compareTo(other: Producto): Int {
        if(this.nombre <  other.nombre){
            return -1
        }else if(this.nombre == other.nombre){
            return 0
        }else{
            return +1
        }
    }
}

//--------------------------------------------------------------------

class ComparadorDeProductosPorNombre: Comparator<Producto> {

    // Compara los productos por nombre
    override fun compare(o1: Producto?, o2: Producto?): Int {
        if (o1 != null&& o2 != null) {
            if (o1.nombre > o2.nombre) {
                return 1
            }
            else if (o1.nombre == o2.nombre) {
                return 0
            }
            return -1
        }
        return 0  // En el caso que sean nulos
    }

}

object comparadorPorNombreYPrecio: Comparator<Producto> {

    override fun compare(o1: Producto?, o2: Producto?): Int {
        if (o1 != null && o2 != null) {
            if (o1.nombre < o2.nombre) {
                return -1
            }
            else if (o1.nombre > o2.nombre) {
                return 1
            }
            else { // Son iguales los nombres, vamos al segundo criterio
                if (o1.precio > o2.precio) {
                    return 1
                }
                else if (o1.precio == o2.precio) {
                    return 0
                }
                return -1
            }
        }
        return 0
    }

}

val compNombrePrec: Comparator<Producto> =
        compareBy(Producto::nombre, Producto::precio)
object comparadorPorCantidad: Comparator<Producto> {

    override fun compare(o1: Producto?, o2: Producto?): Int =
            compareValues(o1!!.cantidad, o2!!.cantidad)

}

/**
 * Clase que representa un Reloj
 */
class Reloj: Comparable<Reloj> {


    /**
     * Un reloj tiene horas, minutos y segundos. La hora debe estar entre 0 y 23, los minutos y segundos entre 0 y 59
     * Agregue un constructor que inicialice el reloj en la hora actual del computador (este es el constructor por
     * defecto) y un constructutor que tenga los 3 elementos e inicialice los atributos en esos tres elementos. Use
     * precondiciones para verificar las condiciones sobre los atributos.
     *
     * Agregue una función toString que muestre la hora en formato hh:mm:ss y otra función toAMPMString que muestre
     * el tiempo en hh:mm:ss AMPM
     *
     * Agregue métodos para avanzar el reloj un segundo y otro para retrocederlo un segundo. No olvide el comparador.
     * Pruebe todos los métodos.
     */

    /**
     * La función de comparación
     */
    override fun compareTo(other: Reloj): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    constructor(){
        val fecha = Calendar.getInstance()
        val año = fecha.get(Calendar.YEAR)
        val mes = fecha.get(Calendar.MONTH) +1
        val dia = fecha.get(Calendar.DAY_OF_MONTH)
        val hora = fecha.get(Calendar.HOUR_OF_DAY)
        val minuto = fecha.get(Calendar.MINUTE)
        val segundo = fecha.get(Calendar.SECOND)

    }
}
