class Estudiante(var nombre: String, var apellido: String, var carnet: String, var materia String){
    
}


fun main() {
   val estudiante1 = Estudiante("Eduardo","Siguenza","00012523","Analisis numerico");
   val estudiante2 = Estudiante("Sayuri","Reyes","00054724","Programacion de Dispositivos Moviles");
   val estudiante3 = Estudiante("Juan","Acosta","00657825","Analisis numerico");
   val estudiante4 = Estudiante("Josue","Fernandez","00005422","Programacion de Dispositivos Moviles");
   val estudiante5 = Estudiante("Andres","Mejia","00124523","Analisis numerico");
   val estudiante6 = Estudiante("Alexei","Perez","00014525","Programacion de Dispositivos Moviles");
   val estudiante7 = Estudiante("Edgar","Hernandez","00078424","Analisis numerico");

   val ciclo01 = listOf(estudiante1, estudiante2, estudiante3, estudiante4, estudiante5, estudiante6, estudiante7);
   
   val filtro = ciclo01.filter{
       it.materia == "Programacion de Dispositivos Moviles";
   }
   
   filtro.forEach{
       println("${it.carnet}, ${it.apellido}, ${it.nombre}");
   }
}

//Eduardo Siguenza