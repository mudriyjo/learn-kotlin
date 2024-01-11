package generics

fun main() {
    // Exercise 1
    Test<Int>().show(1)
    Test<String>().show("text")
    println()

    // Exercise 2
    val circle =Circle()
    val square = Square()
    Geometry<Square>().printArea(10.0, square)
    Geometry<Circle>().printArea(10.0, circle)
}

/*
Create a class that takes a generic type T,
 and has a function that converts the type to String and prints a message that includes the argument passed.
Instantiate the class with different types and call the function.
 */
class Test<T> {
    fun show(elem: T) = println("Show the element: ${elem.toString()}")
}

/*
Create an abstract class Shape that defines a method getArea which takes an argument size.
 Create two subclasses, Square and Circle, that inherit from Shape, and implement the method.
Square area = size * size
Circle area = size * size * 3.1415
Create another class Geometry that takes a generic argument of type Shape,
 and has a method that prints a message which includes the area of the shape that is passed.
Instantiate the Geometry class and print the area of the shape.
 */

abstract class Shape {
    abstract fun getArea(size: Double): Double
}

class Square: Shape() {
    override fun getArea(size: Double): Double {
        return size * size
    }
}

class Circle: Shape() {
    override fun getArea(size: Double): Double {
        return size * size * 3.1415
    }
}

class Geometry<T: Shape> {
    fun printArea(size: Double, element: T) = println("Area of element is: ${element.getArea(size)}")
}