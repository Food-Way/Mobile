package com.example.foodway.presentation.profile.establishment

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.foodway.R
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.MarkerInfoWindow
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun ProductDialog(
//    modifier: Modifier,
//    lat: String,
//    long: String
) {
    Column {
        Text(
            modifier = Modifier
                .padding(bottom = 10.dp),
            text = "Localização"
        )

        Box(
            modifier = Modifier
                .width(300.dp)
                .height(300.dp)
                .border(1.dp, Color.Black, RoundedCornerShape(10.dp))
                .padding(20.dp)
        ) {
            MapScreen(40.9971, 29.1007, "canto do raul", "italiana")
        }
    }
}
@Composable
fun MapScreen(
    lat: Double,
    lng: Double,
    establishmentName: String,
    culinary: String
) {
    val coordinates = LatLng(lat, lng)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(coordinates, 15f)
    }

    var uiSettings by remember {
        mutableStateOf(MapUiSettings(zoomControlsEnabled = true))
    }
    var properties by remember {
        mutableStateOf(MapProperties(mapType = MapType.TERRAIN))
    }

    GoogleMap(
//        modifier = Modifier.matchParentSize(),
        cameraPositionState = cameraPositionState,
        properties = properties,
        uiSettings = uiSettings
    ) {
//        MarkerInfoWindow(
//            state = MarkerState(position = coordinates),
//            icon = BitmapDescriptorFactory.fromResource(R.drawable.location_icon)
//        ) {
//            Column(
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center,
//                modifier = Modifier
//                    .border(
//                        BorderStroke(1.dp, Color.Black),
//                        RoundedCornerShape(10)
//                    )
//                    .clip(RoundedCornerShape(10))
//                    .background(Color.Blue)
//                    .padding(20.dp)
//            ) {
//                Text(establishmentName, fontWeight = FontWeight.Bold, color = Color.White)
//                Text(culinary, fontWeight = FontWeight.Medium, color = Color.White)
//            }
//        }
    }
}