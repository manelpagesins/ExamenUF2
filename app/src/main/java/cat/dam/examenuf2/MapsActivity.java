package cat.dam.examenuf2;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import cat.dam.examenuf2.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static GoogleMap mMap;
    private ActivityMapsBinding binding;
    static LatLng Figueres = new LatLng(42.2642651, 2.9477342);
    static LatLng Bisbal_Empordà = new LatLng(41.9619023, 3.0212748);
    static LatLng Puigcerda = new LatLng(42.4403395, 1.9084863);
    static LatLng Olot = new LatLng(42.1826763, 2.449044);
    static LatLng Girona = new LatLng(41.9803724, 2.7836476);
    static LatLng Banyoles = new LatLng(42.1168503, 2.7488544);
    static LatLng Ripoll = new LatLng(42.1897897, 2.1472019);
    static LatLng SantaColomadeFerners = new LatLng(41.8566426, 2.6519284);
    private static final String[] comarca = new String[]{
            "Alt Empordà",
            "Baix Empordà",
            "Cerdanya",
            "Garrotxa",
            "Gironès",
            "Pla de l’Estany",
            "Ripollès",
            "Selva"
    };
    static String nomComarca = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, comarca); //Adapter per poder introduir el array de noms de comarques dins del AutoCompleteTextView

        Spinner mSpinner = (Spinner)  findViewById(R.id.mSpinner);

        mSpinner.setAdapter(adapter);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //Configuram els markers
        LatLng Figueres = new LatLng(42.2642651, 2.9477342);
        mMap.addMarker(new MarkerOptions().position(Figueres).title("Figueres").snippet("Capital " + comarca[0]));

        LatLng Bisbal_Empordà = new LatLng(41.9619023, 3.0212748);
        mMap.addMarker(new MarkerOptions().position(Bisbal_Empordà).title("La Bisbal d'Empordà").snippet("Capital " + comarca[1]));

        LatLng Puigcerda = new LatLng(42.4403395, 1.9084863);
        mMap.addMarker(new MarkerOptions().position(Puigcerda).title("Puigcerdà").snippet("Capital " + comarca[2]));

        LatLng Olot = new LatLng(42.1826763, 2.449044);
        mMap.addMarker(new MarkerOptions().position(Olot).title("Olot").snippet("Capital " + comarca[3]));

        LatLng Girona = new LatLng(41.9803724, 2.7836476);
        mMap.addMarker(new MarkerOptions().position(Girona).title("Girona").snippet("Capital " + comarca[4]));

        LatLng Banyoles = new LatLng(42.1168503, 2.7488544);
        mMap.addMarker(new MarkerOptions().position(Banyoles).title("Banyoles").snippet("Capital " + comarca[5]));

        LatLng Ripoll = new LatLng(42.1897897, 2.1472019);
        mMap.addMarker(new MarkerOptions().position(Ripoll).title("Ripoll").snippet("Capital " + comarca[6]));

        LatLng SantaColomadeFerners = new LatLng(41.8566426, 2.6519284);
        mMap.addMarker(new MarkerOptions().position(SantaColomadeFerners).title("Santa Coloma de Farners").snippet("Capital " + comarca[7]));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Banyoles, 14f));

    }

    public void redirectTo(){
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Banyoles, 14f));
    }

}