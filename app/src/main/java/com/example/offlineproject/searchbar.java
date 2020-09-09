package com.example.offlineproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class searchbar extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    List<String> hotelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.row_main);

        hotelList = new ArrayList<>();
        hotelList.add("Radison,Dhaka");
        hotelList.add("Sheraton Hotel,Dhaka");
        hotelList.add("Pan Pacific Sonargaon,Dhaka");
        hotelList.add("Le Meridien,Dhaka");
        hotelList.add("Long Beach Hotel,Cox's Bazar");
        hotelList.add("Sayeman Beach Resort,Cox's Bazar");
        hotelList.add("Hotel The Cox Today,Cox's Bazar");
        hotelList.add("Ocean Paradise Hotel & Resort,Cox's Bazar");
        hotelList.add("Monu Adom Resort,Rangamati");
        hotelList.add("Hill Taj Resort,Rangamati");
        hotelList.add("Hotel Moti Mahal,Rangamati");
        hotelList.add("Hotel Jum Palace,Rangamati");
        hotelList.add("Aronnak Holiday Resort,Rangamati");
        hotelList.add("Nilachol Nilambori Resort,Bandarban");
        hotelList.add("Sairu Hill Resort,Bandarban");
        hotelList.add("Hotel Night Heaven,Bandarban");
        hotelList.add("Hotel Hillton,Bandarban");
        hotelList.add("Hotel Star Park,Chittagong");
        hotelList.add("Radisson Blu Chattogram Bay View,Chittagong");
        hotelList.add("Hotel Safina Ltd,Chittagong");
        hotelList.add("Well Park Residence,Chittagong");
        hotelList.add("Rose View Hotel,Sylhet");
        hotelList.add("Hotel Grand Surma,Sylhet");
        hotelList.add("Bottom Hill Palace Hotel,Sylhet");
        hotelList.add("Hotel Noorjahan Grand,Sylhet");
        hotelList.add("Tiger Garden Int. Hotel,Khulna");
        hotelList.add("City Inn Ltd,Khulna");
        hotelList.add("Hotel Castle Salam,Khulna");
        hotelList.add("Hotel Royal International,Khulna");
        hotelList.add("Hotel Garver Inn International,Kuakata");
        hotelList.add("Kuakata Grand Hotel & Sea Resorts,Kuakata");
        hotelList.add("Sikder Resort & Villas,Kuakata");
        hotelList.add("Kuakata Guest house,Kuakata");
        hotelList.add("Fantasy Hotel & Resort,Saint Martin");
        hotelList.add("Coral View Resort,Saint Martin");
        hotelList.add("Island Resort,Saint Martin");
        hotelList.add("Sunset Serenity,Saint Martin");
        hotelList.add("Fantasy Hotel & Resort,Saint Martin");
        hotelList.add("Hotel Golden Tulip,Panchagarh");
        hotelList.add("Hotel Rantnadeep,Panchagarh");
        hotelList.add("Hotel Arithi,Panchagarh");
        hotelList.add("Greater Kailash The Palace,Panchagarh");
        hotelList.add("Bulagari Hotel,Beijing China");
        hotelList.add("Bulkari Hotel,Shanghai China");
        hotelList.add("Pengheng Space Capsules Hotel,China");
        hotelList.add("The Marina Phuket Hotel,Thailand");
        hotelList.add("Baiyoke Boutique Hotel,Thailand");
        hotelList.add("Al Meroz Hotel Bangkok,Thailand");
        hotelList.add("Kanita Resort and Vila,Thailand");
        hotelList.add("Berjaya Times Square Hotel,Malaysia");
        hotelList.add("Ohana Kuala Lumpur,Malaysia");
        hotelList.add("Grand Swiss Hotel,Malaysia");
        hotelList.add("Sayang Youth Hostel Riverside,Malaysia");
        hotelList.add("Hotel Dodas Palace Jaipur,India");
        hotelList.add("Swati Hotel,India");
        hotelList.add("Radisson Hotel,Agra India");
        hotelList.add("Hotel Kanhaia Havenli,India");
        hotelList.add("Hotel 81 Orchid,Singapore");
        hotelList.add("Marina Bay Sands,Singapore");
        hotelList.add("Hotel Boss,Singapore");
        hotelList.add("Shangri-La Hotel,Singapore");
        hotelList.add("Gilligan's,Australia");
        hotelList.add("Fitzroy Island Resort,Australia");
        hotelList.add("Kangaroo Island Seafort,Australia");
        hotelList.add("Original Backpakers sydney,Australia");
        hotelList.add("Trump International Hotel Las Vegas,America");
        hotelList.add("The Grand American Hotel,America");
        hotelList.add("Vdara Hotel & Spa,America");
        hotelList.add("Bellagio Hotel Casino,America");
        hotelList.add("108 Golf Resort,Canada");
        hotelList.add("Patrica Hotel,Canada");
        hotelList.add("Pangea Pod Hotel,Canada");
        hotelList.add("Hilton Niagara Fallsview Hotel,Canada");
        hotelList.add("Hotel Sara's Backpackers,Nepal");
        hotelList.add("Himalayan Front Hotel,Nepal");
        hotelList.add("Shangrila Village Resort,Nepal");
        hotelList.add("Hotel Pristine Himalaya,Nepal");
        hotelList.add("Hotel Bhutan,Bhutan");
        hotelList.add("Centennial Hotel,Bhutan");
        hotelList.add("Park Hotel,Bhutan");
        hotelList.add("Gangtey Palace Hotel,Bhutan");
        hotelList.add("Santiago Guesthouse,Kyoto Japan ");
        hotelList.add("Plaza Hotel Tenjin,Japan");
        hotelList.add("Hotel Shin-Imamiya,Japan");
        hotelList.add("Hotel Taiyo,Japan");



        recyclerView = findViewById(R.id.recyclerView);
        recyclerAdapter = new RecyclerAdapter(hotelList);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recyclerAdapter.getFilter().filter(newText);
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }
}














