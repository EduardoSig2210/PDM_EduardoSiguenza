package com.example.laboratorio

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio.ui.theme.LaboratorioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LaboratorioTheme() {
                AppNav()
            }
        }
    }
}

@Composable
fun AppNav(){
    val nav = rememberNavController()

    NavHost(
        navController = nav,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(nav)
        }

        composable("lista") {
            ListScreen(nav)
        }

        composable("sensor") {
            SensorScreen(nav)
        }
    }


}

@Composable
fun HomeScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Spacer(modifier = Modifier.height(15.dp))
        Button(
            onClick = {
                navController.navigate("sensor")
            }
        ){
            Text("Sensores")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                navController.navigate("lista")
            }
        ){
            Text("Lista")
        }
    }
}

@Composable
fun ListScreen(navController: NavController){

}

@Composable
fun SensorScreen(navController: NavController){

        val context = LocalContext.current

        val sensorManager =
            context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

        val acelerometro =
            sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION)

        var x by remember { mutableStateOf(0f) }
        var y by remember { mutableStateOf(0f) }
        var z by remember { mutableStateOf(0f) }

        DisposableEffect(Unit) {

            val listener = object : SensorEventListener {

                override fun onSensorChanged(event: SensorEvent?) {

                    val alpha = 0.8f

                    val newX = event?.values?.get(0) ?: 0f
                    val newY = event?.values?.get(1) ?: 0f
                    val newZ = event?.values?.get(2) ?: 0f


                    x = alpha * x + (1 - alpha) * newX
                    y = alpha * y + (1 - alpha) * newY
                    z = alpha * z + (1 - alpha) * newZ


                }

                override fun onAccuracyChanged(
                    sensor: Sensor?,
                    accuracy: Int
                ) {
                }
            }

            sensorManager.registerListener(
                listener,
                acelerometro,
                500000
            )

            onDispose {
                sensorManager.unregisterListener(listener)
            }
        }

        val fondoSensor = Color(0xFF1E1E2F)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(fondoSensor)
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Sensor",
                color = Color.White
            )

            Spacer(modifier = Modifier.height(30.dp))

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF3949AB)
                ),
                shape = RoundedCornerShape(20.dp)
            ) {

                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "X = %.2f".format(x),
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Y = %.2f".format(y),
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Z = %.2f".format(z),
                        color = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    navController.navigate("home")
                }
            ) {
                Text("Volver")
            }
        }


}

