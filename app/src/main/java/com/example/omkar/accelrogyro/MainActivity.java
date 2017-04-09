package com.example.omkar.accelrogyro;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * This is the Service used for receiving the raw sensor values.
 *
 * Accelerometer_X  Gyroscope_X
 * Accelerometer_Y  Gyroscope_Y
 * Accelerometer_Z  Gyroscope_Z are the raw sensor values.
 *
 * Author: Onkar
 */

public class MainActivity extends AppCompatActivity {
    SensorManager sensorManager;
    Sensor sensor_gyro,sensor_acc;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor_gyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor_acc = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        /*textX_G = (TextView) findViewById(R.id.textX_G);
        textY_G = (TextView) findViewById(R.id.textY_G);
        textZ_G = (TextView) findViewById(R.id.textZ_G);

        textX_A = (TextView) findViewById(R.id.textX_A);
        textY_A = (TextView) findViewById(R.id.textY_A);
        textZ_A = (TextView) findViewById(R.id.textZ_A);*/
    }

    public void onResume() {
        super.onResume();
        sensorManager.registerListener(gyroListener, sensor_gyro,
                SensorManager.SENSOR_DELAY_NORMAL);//SensorManager.SENSOR_DELAY_NORMAL
        sensorManager.registerListener(accListener, sensor_acc,
                2000000);
    }

    public void onStop() {
        super.onStop();
        sensorManager.unregisterListener(gyroListener);
        sensorManager.unregisterListener(accListener);
    }

    public SensorEventListener gyroListener = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor_gyro, int acc) { }

        public void onSensorChanged(SensorEvent event1) {
            float Gyroscope_X = event1.values[0];
            float Gyroscope_Y = event1.values[1];
            float Gyroscope_Z = event1.values[2];

            /*textX_G.setText("X : " + x + " rad/s");
            textY_G.setText("Y : " + y + " rad/s");
            textZ_G.setText("Z : " + z + " rad/s");
            Log.d("MainActivity","G_X Value: " + Float.toString(x));
            Log.d("MainActivity","G_Y Value: " + Float.toString(y));
            Log.d("MainActivity","G_Z Value: " + Float.toString(z));*/
        }
    };
    public SensorEventListener accListener = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor_acc, int acc) { }

        public void onSensorChanged(SensorEvent event2) {
            float Accelerometer_X = event2.values[0];
            float Accelerometer_Y = event2.values[1];
            float Accelerometer_Z = event2.values[2];

            /*textX_A.setText("X : " + a + " m/s2");
            textY_A.setText("Y : " + b + " m/s2");
            textZ_A.setText("Z : " + c + " m/s2");

            Log.d("MainActivity","A_X Value: " + Float.toString(a));
            Log.d("MainActivity","A_Y Value: " + Float.toString(b));
            Log.d("MainActivity","A_Z Value: " + Float.toString(c));*/
        }
    };
}
