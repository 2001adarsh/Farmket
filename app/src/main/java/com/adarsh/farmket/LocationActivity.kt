package com.adarsh.farmket

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Resources
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.adarsh.farmket.helperClass.ClusterMarkers
import com.adarsh.farmket.helperClass.MyClusterManagerRender
import com.google.android.gms.location.FusedLocationProviderClient

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.clustering.ClusterManager
import kotlinx.android.synthetic.main.activity_location.*

class LocationActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var map: GoogleMap
    private val locationManager by lazy {
        getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }
    private lateinit var clusterManager: ClusterManager<ClusterMarkers>
    private lateinit var myClusterManagerRender : MyClusterManagerRender

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)
        //Toolbar
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        toolbar.setNavigationOnClickListener { finish() }
        supportActionBar?.setDisplayShowTitleEnabled(false)

       val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        setMapStyle(map)
        addMapMarkers()
    }

    override fun onStart() {
        super.onStart()
        requestPermissionForLocation()
        when{
            checkPermission() -> {
                when{
                    isLocationEnabled() -> setUpLocation()  //setUpLocationListener()
                    else -> showDialogBox()
                }
            }
            else -> requestPermissionForLocation()
        }
    }

    private fun addMapMarkers(){
       clusterManager = ClusterManager<ClusterMarkers>(this,map)
        myClusterManagerRender = MyClusterManagerRender(this, map, clusterManager)
        clusterManager.renderer = myClusterManagerRender

        val title = "Rohtak"
        val snippet = "Driver is coming"
        val avatar:Int = R.drawable.logistics
        val ltnlog = LatLng(28.840656, 76.603336)

        val clusterMarkers = ClusterMarkers(ltnlog, title, snippet, avatar)
        clusterManager.addItem(clusterMarkers)

        clusterManager.addItem(ClusterMarkers(LatLng(30.772926, 76.576455), "Chandigarh " +
                "University", "Farmket Headquaters", R.drawable.finish))
        clusterManager.cluster()
    }

    // Styling the Map
    private fun setMapStyle(map: GoogleMap) {
        try {
            val success = map.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(this, R.raw.dark_map_style)  )
            if(!success) {
                Log.e("TAG", "Styling parsing failed.")
            }
        }catch (e: Resources.NotFoundException) {
            Log.e("TAG", "Can't find style. Error: ", e)
        }
    }

    private fun setUpLocation(){
        val location = FusedLocationProviderClient(this).lastLocation
        location.addOnCompleteListener {
            if(it.isSuccessful){
                val currentLocation = it.result
                moveCamera(LatLng(currentLocation!!.latitude, currentLocation.longitude), 15f, "My Location")
                map.isMyLocationEnabled = true
                map.uiSettings.apply {
                    isMyLocationButtonEnabled = true
                    isZoomGesturesEnabled = true
                    isZoomControlsEnabled = true
                    isCompassEnabled = true
                    isRotateGesturesEnabled = true
                }
    //            getRoad(currentLocation);
            }else{
                Toast.makeText(this, "Unable to get current Location", Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun moveCamera(ltnlog:LatLng, zoom:Float, title: String){
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(ltnlog , zoom))
        if(title != "My Location"){
            map.addMarker(MarkerOptions().title(title).position(ltnlog) )
        }
    }

    //Permissions:
    private fun checkPermission(): Boolean = checkSelfPermission(android.Manifest.permission
            .ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED

    private fun requestPermissionForLocation() = this.requestPermissions(arrayOf(android.Manifest
            .permission.ACCESS_FINE_LOCATION), 123)

    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            123 -> if(checkPermission()) {
                when{
                    isLocationEnabled() -> setUpLocation() //setUpLocationListener()
                    else -> showDialogBox()
                }
            }
            else -> Toast.makeText(this, "Permission of Location not given", Toast.LENGTH_SHORT).show()
        }
    }
    private fun isLocationEnabled():Boolean = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

    private fun showDialogBox(){
        AlertDialog.Builder(this)
                .setTitle("Enable GPS")
                .setCancelable(false)
                .setMessage("GPS is required for Google Map")
                .setPositiveButton( "Enable Now") { dialogInterface: DialogInterface, _: Int ->
                    startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
                    dialogInterface.dismiss()
                }.show()
    }
}
