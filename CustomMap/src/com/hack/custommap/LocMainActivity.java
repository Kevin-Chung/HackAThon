package com.example.geoloct;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
 

public class LocMainActivity extends Activity implements OnMapClickListener,GooglePlayServicesClient.ConnectionCallbacks,
GooglePlayServicesClient.OnConnectionFailedListener ,OnMarkerClickListener  {
	
	private LocationClient mLocationClient;
	private Location mCurrentLocation;
	
	 private GoogleMap mMap;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_loc_main);
	
		
	     
    //    setUpMapIfNeeded();
        
   //     mMap.setOnMapClickListener(this);
        
   
    }
    
    public void onResume() 
    {
        super.onResume();
        setUpMapIfNeeded();
        setUpLocationClientIfNeeded();
		mLocationClient.connect();
    }

	    
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
          
		   mMap = ((MapFragment)getFragmentManager().findFragmentById(R.id.map))
                   .getMap();
		   if (mMap == null) {
				Toast.makeText(this, "Google maps not available",
						Toast.LENGTH_LONG).show();
			}
		
            // Check if we were successful in obtaining the map.
          
        }
    } 
    
    private void setUpLocationClientIfNeeded() {
		if (mLocationClient == null) {
			Toast.makeText(getApplicationContext(), "Waiting for location",
					Toast.LENGTH_SHORT).show();
			mLocationClient = new LocationClient(getApplicationContext(), this, // ConnectionCallbacks
					this); // OnConnectionFailedListener
		}
	}

    /**
     * This is where we can add markers or lines, add listeners or move the camera .
     */

    
    @Override
	public void onConnected(Bundle dataBundle) {
		mCurrentLocation = mLocationClient.getLastLocation();
		if (mCurrentLocation != null) {
			Toast.makeText(getApplicationContext(), "Found!",
					Toast.LENGTH_SHORT).show();
			
			// mMap.addMarker(new MarkerOptions().position(pos).title("Friend"););
			
			mMap.setOnMarkerClickListener((OnMarkerClickListener) this); 
			
			centerInLoc();
		}
	}
    
    private void centerInLoc() {
		LatLng myLaLn = new LatLng(mCurrentLocation.getLatitude(),
				mCurrentLocation.getLongitude());
		CameraPosition camPos = new CameraPosition.Builder().target(myLaLn)
				.zoom(15).bearing(45).tilt(70).build();

		CameraUpdate camUpd3 = CameraUpdateFactory.newCameraPosition(camPos);
		
		mMap.animateCamera(camUpd3);

		MarkerOptions markerOpts = new MarkerOptions().position(myLaLn).title(
				"my Location");
		mMap.addMarker(markerOpts);
	}
    
    
@Override
public void onMapClick(LatLng pos) {
		
	Intent intent = new Intent(this, custommap.class); 
    startActivity(intent);
	
}

@Override
public void onConnectionFailed(ConnectionResult arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void onDisconnected() {
	// TODO Auto-generated method stub
	
}

@Override
public boolean onMarkerClick(Marker arg0) {
	
		 Intent intent = new Intent(this, custommap.class); 
		    startActivity(intent);
	        return true;
	  
	
}
    
}