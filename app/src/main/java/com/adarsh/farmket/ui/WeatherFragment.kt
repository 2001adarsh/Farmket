package com.adarsh.farmket.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import com.adarsh.farmket.R
import com.adarsh.farmket.R.drawable.*
import com.adarsh.farmket.helperClass.WeatherResponse
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_weather.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request


class WeatherFragment : Fragment() {
    private val locationManager by lazy {
        context?.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    //Checking Permissions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

    lateinit var latLong : String


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        requestPermissionForLocation()


        val view = inflater.inflate(R.layout.fragment_weather, container, false)
        return view
    }

    @SuppressLint("MissingPermission")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<Toolbar>(R.id.toolbar_weather)
        toolbar.setNavigationIcon(ic_arrow_back_black_24dp)
        toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }

        val location = context?.let { FusedLocationProviderClient(it).lastLocation }   //This is
        // because we have already checked the permission before calling this function

        location?.addOnCompleteListener {
            if(it.isSuccessful){

                //Finding current Longitude and Latitude

                val currentLocation = it.result
                latLong = "${currentLocation?.latitude},${currentLocation?.longitude}"

                //Making a call
                val okHttpClient = OkHttpClient()
                val request =Request.Builder()
                        .url("http://api.weatherstack" +
                                ".com/current?access_key=35451e4a1d425e4905283829f50283a5&query=$latLong")
                        .build()
                val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                        .create()

                GlobalScope.launch(Dispatchers.Main) {
                    val response = withContext(Dispatchers.IO) {
                        okHttpClient.newCall(request).execute().body?.string()
                    }

                    Log.i("Networking", response)

                    val weather = gson.fromJson<WeatherResponse>(response, WeatherResponse::class.java)

                    if(weather.current?.isDay == "yes"){
                        frameLayout7.setBackgroundResource(dayr)
                    }
                    else{
                        frameLayout7.setBackgroundResource(nightr)
                    }

                    pleaseWait.visibility = View.GONE
                    visible()


                    city.text = weather.location?.name
                    region.text = weather.location?.region
                    country.text = weather.location?.country


                    temp.text = weather.current?.temperature.toString()
                    desc.text = weather.current?.weatherDescriptions?.get(0) ?: "Internet Not " +
                            "connected!"
                    Picasso.get().load(weather.current?.weatherIcons?.get(0)).into(desc_img)

                    wind.text = weather.current?.windSpeed.toString()
                    rain.text = weather.current?.precip.toString()
                    humidity.text = weather.current?.humidity.toString()
                    pressure.text = weather.current?.pressure.toString()
                    uv.text = weather.current?.uvIndex.toString()
                    feelsLike.text = weather.current?.feelslike.toString()

                }
                }else{
                Toast.makeText(context, "Unable to get current Location", Toast.LENGTH_LONG).show()
            }

        }

    }

    private fun visible() {
        divider18.visibility = View.VISIBLE
        textView131.visibility = View.VISIBLE
        divider19.visibility = View.VISIBLE
        textView136.visibility = View.VISIBLE
        textView138.visibility = View.VISIBLE
        textView140.visibility = View.VISIBLE
        textView145.visibility = View.VISIBLE
        textView142.visibility = View.VISIBLE
        textView152.visibility = View.VISIBLE
        textView149.visibility = View.VISIBLE
        textView151.visibility = View.VISIBLE
        textView148.visibility = View.VISIBLE
        textView143.visibility = View.VISIBLE
    }


    @SuppressLint("MissingPermission")
    private fun setUpLocation() {
        val location = context?.let { FusedLocationProviderClient(it).lastLocation }   //This is
        // because we have already checked the permission before calling this function

        location?.addOnCompleteListener {
            if(it.isSuccessful){
                val currentLocation = it.result
                latLong = "${currentLocation?.latitude},${currentLocation?.longitude}"
            }else{
                Toast.makeText(context, "Unable to get current Location", Toast.LENGTH_LONG).show()
                latLong = "30.772926,76.576455"
            }
        }
    }


    //Checking Permissions
    private fun checkPermission():Boolean = context?.let {
        ActivityCompat.checkSelfPermission(it, android
                .Manifest
                .permission
                .ACCESS_FINE_LOCATION)
    } == PackageManager.PERMISSION_GRANTED


    private fun requestPermissionForLocation() = this.requestPermissions(arrayOf(android.Manifest
            .permission.ACCESS_FINE_LOCATION), 123)

    private fun isLocationEnabled():Boolean = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
            || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when(requestCode){
            123 -> if(checkPermission()){
                when {
                    isLocationEnabled() -> setUpLocation()
                    else -> showDialogBox()
                }
            }
            else -> Toast.makeText(context, "Permission of Location not given", Toast.LENGTH_SHORT)
                    .show()
        }


    }


    private fun showDialogBox(){
        activity?.applicationContext?.let {
            AlertDialog.Builder(it)
                .setTitle("Enable GPS")
                .setCancelable(false)
                .setMessage("GPS is required for Google Map")
                .setPositiveButton( "Enable Now") { dialogInterface: DialogInterface, _: Int ->
                    startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
                    dialogInterface.dismiss()
                }.show()
        }
    }

}