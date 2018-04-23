package ean.programacionavanzada.tallercomparadores

import ean.collections.IList
import ean.collections.LinkedList
import ean.collections.sort
import ean.collections.sortDescending
import org.testng.Assert.assertFalse
import org.testng.Assert.assertTrue
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import kotlin.test.assertTrue


class ProductoTest {
    private val prod1: Producto = Producto("papa", 450.0, 5)
    private val prod2: Producto = Producto("arroz", 1300.0, 100)
    private val prod3: Producto = Producto("jamón", 7100.0, 20)

    private var listaProductos: IList<Producto> = LinkedList()

    @BeforeTest
    fun crearProductos() {
        with (listaProductos) {
            add(Producto("salchicha", 4670.0, 11))
            add(Producto("berenjena", 150.0, 50))
            add(Producto("queso", 7219.0, 15))
            add(Producto("pan", 30.0, 160))
            add(Producto("carne", 5611.0, 3))
            add(Producto("almendra", 30.0, 60))
            add(prod1)
            add(Producto("teléfono", 30.0, 91))
            add(prod2)
            add(Producto("zapato", 17.0, 8))
            add(prod3)
        }
    }

    @Test
    fun prueba1() {
        assertTrue(prod1 < prod2)
        assertTrue(prod2 < prod3)

        val cmp = ComparadorDeProductosPorNombre()
        assertTrue(cmp.compare(prod1, prod2) > 0)

        assertTrue(comparadorPorNombreYPrecio.compare(prod2, prod3) < 0 )

        val p1 = Producto("ala",1000.0,10)
        val p2 = Producto("ala",150.0,20)
        val p3 = Producto("alita",25.0,1000)

        assertTrue(compNombrePrec.compare(p1,p2)>0)
    }

    @Test
    fun pruebaOrdenamiento() {
        println(listaProductos.sortDescending())

        val comparadorPrecioYCantidad =
                compareBy(Producto::precio).thenBy(Producto::cantidad)

        println(listaProductos.sort(comparadorPrecioYCantidad))

        // Crear un comparador que tenga en cuenta los 3 atributos

    }
}