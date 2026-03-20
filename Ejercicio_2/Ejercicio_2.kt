class calculadora(var num1: Double, var num2: Double){
    fun suma(){
        var result = num1 + num2;
        println("La suma de $num1 y $num2 da como resultado $result")
    }
    fun resta(){
        var result = num1 - num2;
        println("La resta de $num1 y $num2 da como resultado $result")
    }
    fun multiplicacion(){
        var result = num1 * num2;
        println("La multiplicacion de $num1 y $num2 da como resultado $result")
    }
    fun division(){
        var result: Double;
        if(num2 == 0.0){
            println("La operacion no se puede realizar ya que tiende al infinito")
        }else{
            result = num1 / num2;
            println("La division de $num1 y $num2 da como resultado $result")
        }
    }
}

fun main() {
   val calcu = calculadora(5.0,2.0);
   calcu.suma();
   calcu.resta();
   calcu.multiplicacion();
   calcu.division();
}

//Eduardo Siguenza