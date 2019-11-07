package com.example.itusatcollege;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import io.particle.android.sdk.cloud.ParticleCloud;
import io.particle.android.sdk.cloud.ParticleCloudSDK;
import io.particle.android.sdk.cloud.ParticleDevice;
import io.particle.android.sdk.cloud.exceptions.ParticleCloudException;
import io.particle.android.sdk.utils.Async;


public class MainActivity extends AppCompatActivity {
    // MARK: Debug info
    private final String TAG="itusatcollege";

    // MARK: Particle Account Info
    private final String PARTICLE_USERNAME = "kaur6363satwinder@gmail.com";
    private final String PARTICLE_PASSWORD = "satprabh1991";

    // MARK: Particle device-specific info
    private final String DEVICE_ID = "380022000f47363333343437";

    // MARK: Particle Publish / Subscribe variables
    private long subscriptionId;

    // MARK: Particle device
    private ParticleDevice mDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMarkingItus = findViewById(R.id.myway);

        txtTimer = findViewById(R.id.textView2);
        btnStrt = findViewById(R.id.button);

        // 1. Initialize your connection to the Particle API
        ParticleCloudSDK.init(this.getApplicationContext());

        // 2. Setup your device variable
        getDeviceFromCloud();
    }


    /**
     * Custom function to connect to the Particle Cloud and get the device
     */
    public void getDeviceFromCloud() {
        // This function runs in the background
        // It tries to connect to the Particle Cloud and get your device
        Async.executeAsync(ParticleCloudSDK.getCloud(), new Async.ApiWork<ParticleCloud, Object>() {

            @Override
            public Object callApi(@NonNull ParticleCloud particleCloud) throws ParticleCloudException, IOException {
                particleCloud.logIn(PARTICLE_USERNAME, PARTICLE_PASSWORD);
                mDevice = particleCloud.getDevice(DEVICE_ID);
                return -1;

            }

            @Override
            public void onSuccess(Object o) {

                Log.d(TAG, "Successfully got device from Cloud");
            }

            @Override
            public void onFailure(ParticleCloudException exception) {
                Log.d(TAG, exception.getBestMessage());
            }
        });
    }
  public void startMoniterMe(View view)
  {
      Toast.makeText(getApplicationContext(), "Start Monitor Me Pressed", Toast.LENGTH_SHORT)
              .show();
      Async.executeAsync(ParticleCloudSDK.getCloud(), new Async.ApiWork<ParticleCloud, Object>() {
          @Override
          public Object callApi(@NonNull ParticleCloud particleCloud) throws ParticleCloudException, IOException {
              // put your logic here to talk to the particle
              // --------------------------------------------

              // what functions are "public" on the particle?
              Log.d(TAG, "Available functions: " + mDevice.getFunctions());


              List<String> functionParameters = new ArrayList<String>();
              //functionParameters.add();
              try {
                  mDevice.callFunction("happyface", functionParameters);

              } catch (ParticleDevice.FunctionDoesNotExistException e1) {
                  e1.printStackTrace();
              }

              return -1;
          }

          @Override
          public void onSuccess(Object o) {
              // put your success message here
              Log.d(TAG, "Success!");
          }

          @Override
          public void onFailure(ParticleCloudException exception) {
              // put your error handling code here
              Log.d(TAG, exception.getBestMessage());
          }
      });
  }
}

