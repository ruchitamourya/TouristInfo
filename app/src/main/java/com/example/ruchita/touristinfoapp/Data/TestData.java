package com.example.ruchita.touristinfoapp.Data;

import com.example.ruchita.touristinfoapp.Constants;
import com.example.ruchita.touristinfoapp.Model.City;
import com.example.ruchita.touristinfoapp.Model.CityDetail;
import com.example.ruchita.touristinfoapp.Model.FamousPlace;
import com.example.ruchita.touristinfoapp.R;

import java.util.ArrayList;

/**
 * Created by Ruchita on 24/9/17.
 */
// A class for all hardcoded data.
public class TestData implements DataProvider {

    private static ArrayList<City> mData;

    // Default constructor of class TestData.
    public TestData() {
        mData = prepareCityList();
    }

    // A method to get the ArrayList of city.
    private static ArrayList<City> prepareCityList() {
        ArrayList<City> cityArray = new ArrayList<>();
        String[] cities = {"Delhi", "Mumbai", "Hyderabad", "Chennai", "Kolkata", "Lucknow",
                "Ahmedabad", "Bangalore"};

        ArrayList<CityDetail> cityDetailArrayList = getData();
        ArrayList<ArrayList<FamousPlace>> famousPlacesArrayList = getFamousPlacesData();

        for (int i = 0; i < cities.length; i++) {
            City city = new City();
            city.setCityName(cities[i]);
            CityDetail cityDetail = cityDetailArrayList.get(i);
            city.setCityDetail(cityDetail);
            if (famousPlacesArrayList.size() > i) {
                ArrayList<FamousPlace> famousPlace = famousPlacesArrayList.get(i);
                city.setFamousPlaceList(famousPlace);
            }
            cityArray.add(city);
        }
        City city = new City();
        city.setCityName(Constants.ADD_NEW_CITY);
        cityArray.add(city);
        return cityArray;
    }

    //
    private static ArrayList<CityDetail> getData() {
        ArrayList<CityDetail> dataList = new ArrayList<>();
// A method to get the ArrayList of class CityDetail.
        int[] images = getImages();
        String[] desc = getdesc();

        for (int i = 0; i < images.length; i++) {
            CityDetail cityDetail = new CityDetail();
            cityDetail.setDescription(desc[i]);
            dataList.add(cityDetail);
        }
        return dataList;
    }

    // a method to get Array of images from drawable.
    private static int[] getImages() {
        int[] images = {0, R.drawable.mumbai, R.drawable.hyderabad, R.drawable.chennai,
                R.drawable.kolkata, R.drawable.lucknow, R.drawable.ahmedabad, R.drawable.bangalor,};
        return images;
    }

    // A method to get Array of description about cities.
    private static String[] getdesc() {
        String[] description = {"Delhi, India’s capital territory, is a massive metropolitan area in " +
                "the country’s north. In Old Delhi, a neighborhood dating to the 1600s, stands the imposing" +
                " Mughal-era Red Fort, a symbol of India, and the sprawling Jama Masjid mosque, whose " +
                "courtyard accommodates 25,000 people. Nearby is Chandni Chowk, a vibrant bazaar filled " +
                "with food carts, sweets shops and spice stalls.", "Mumbai (formerly called Bombay) is " +
                "a densely populated city on" +
                " India’s west coast. A financial center, it's India's largest city. On the Mumbai " +
                "Harbour waterfront stands the iconic Gateway of India stone arch, built by the " +
                "British Raj in 1924. Offshore, nearby Elephanta Island holds ancient cave " +
                "temples dedicated to the Hindu god Shiva. The city's also famous as the heart of " +
                "the Bollywood film industry.", "Hyderabad is the capital of southern India's Telangana state." +
                " A major center for the technology industry, it's home to many upscale restaurants and shops. " +
                "Its historic sites include Golconda Fort, a former diamond-trading center that was once the " +
                "Qutb Shahi dynastic capital. The Charminar, a 16th-century mosque whose 4 arches support " +
                "towering minarets, is an old city landmark near the long-standing Laad Bazaar.", "chennai " +
                "city is governed by the Greater Chennai " +
                "Corporation (formerly \"Corporation of Madras\"), which was established in 1688. It " +
                "is the oldest surviving municipal corporation in India and the second oldest " +
                "surviving corporation in the world.", "Kolkata (formerly Calcutta) is the capital of India's West Bengal state." +
                " Founded as an East India Company trading post, it was India's capital under the British Raj from 1773–1911. Today " +
                "it’s known for its grand colonial architecture, art galleries and cultural festivals. It’s also home to Mother House," +
                " headquarters of the Missionaries of Charity, founded by Mother Teresa, whose tomb is on site.", "Lucknow, a large city " +
                "in northern India, is the capital of the state of Uttar Pradesh. Toward its center is Rumi Darwaza, a Mughal gateway. " +
                "Nearby, the 18th-century Bara Imambara shrine has a huge arched hall. Upstairs, Bhool Bhulaiya is a maze of narrow " +
                "tunnels with city views from its upper balconies. Close by, the grand Victorian Husainabad Clock Tower was built " +
                "as a victory column in 1881.", "Ahmedabad, in western India, is the largest city in the state of Gujarat. The Sabarmati" +
                " River runs through its center. On the western bank is the Gandhi Ashram at Sabarmati, which displays the spiritual leader’s" +
                " living quarters and artifacts. Across the river, the Calico Museum of Textiles, once a cloth merchant's mansion, has a " +
                "significant collection of antique and modern fabrics.", "Bengaluru " +
                "(also called Bangalore) is the capital of " +
                "India's southern Karnataka state. The center of India's high-tech industry, the city is also known for " +
                "its parks and nightlife. By Cubbon Park, Vidhana Soudha is a Neo-Dravidian legislative building." +
                " Former royal residences include 19th-century Bangalore Palace, modeled after England’s Windsor Castle," +
                " and Tipu Sultan’s Summer Palace, an 18th-century teak structure."};
        return description;
    }

    // A method to get ArrayList of Class FamousPlaces.
    private static ArrayList<ArrayList<FamousPlace>> getFamousPlacesData() {
        ArrayList<ArrayList<FamousPlace>> listOfData = new ArrayList<>();

// this description variable hold a string value about famous places of cities.
        String[][] description = {{"Red Fort has become a grand and attractive place.", "The India Gate, is a war memorial located astride the Rajpath in delhi.",
                "Akshardham is a Hindu mandir, and a spiritual-cultural campus.", "The Lotus Temple is a Bahá'í House of Worship that was dedicated in December 1986.",
                "The Masjid-i Jahān-Numā, commonly known as the Jama Masjid of Delhi, is one of the largest mosques in India.",
                "Jantar Mantar consists of 13 architectural astronomy instruments.", "Qutub Minar is a UNESCO World Heritage Site in the Mehrauli area of Delhi.",
                "The Rashtrapati Bhavan is the official home of the president in New Delhi."}, {"The Gateway of India is located on the waterfront at Apollo Bunder in South Mumbai.",
                "Marine Drive is a 3.6-kilometre-long boulevard in South Mumbai.", "Chhatrapati Shivaji Terminus is a historic railway station and a UNESCO World Heritage Site in Mumbai,",
                "Mahatma Jyotiba Phule Mandi is one of South Mumbai's most famous markets.", "Elephanta Caves are a network of sculpted caves located on Elephanta " +
                "Island,in Mumbai.", "The Rajabai Clock Tower is located in the confines of the Fort campus of the University of Mumbai.", "The Shree Siddhivinayak Ganapati Mandir " +
                "is a Hindu temple dedicated to Lord Shri Ganesh.", "The Taj Mahal Palace Hotel is a Heritage Grand class five-star hotel in the Colaba region of Mumbai."}};
// Variable title hold array of string value for famous places.
        String[][] title = {{"Red Fort", "India Gate", "Akshardham", "Lotus Temple", "Jama Masjid",
                "Jantar Mantar", "Qutub Minar", "Rashtrapati Bhawan"}, {"Gateway of India", "Marine Drive ", "Chhatrapati Shivaji Terminus",
                "Crawford Market", "Elephanta" +
                " Caves", "Rajabai Clock Tower", "Siddhivinayak Temple", "Tajmahal Palace"}};
// Variable latitude hold array of latitude value of famous places.
        double[][] latitude = {{28.6562, 28.6162, 28.6127, 28.5535, 28.6507, 28.6271, 28.5244, 28.6144}, {18.9220, 18.9430712, 18.9398, 18.9477, 18.9633, 18.9298, 19.0169, 18.9217}};

// Variable latitude hold array of longitude value of famous places.
        double[][] longitude = {{77.2410, 77.2295, 77.2773, 77.2588, 77.2334, 77.2166, 77.1855, 77.1996}, {72.8347, 72.8230638, 72.8355, 72.8342, 72.9315, 72.8301, 72.8303, 72.8330}};

        for (int i = 0; i < description.length; i++) {
            {
                ArrayList<FamousPlace> innerList = new ArrayList<>();
                for (int j = 0; j < description[0].length; j++) {
                    FamousPlace famousPlace = new FamousPlace();
                    //famousPlace.setImgResourceId(famousPlacesOfCities[i][j]);
                    famousPlace.setDescription(description[i][j]);
                    famousPlace.setTitle(title[i][j]);
                    famousPlace.setLatitude(latitude[i][j]);
                    famousPlace.setLongitude(longitude[i][j]);
                    innerList.add(famousPlace);
                }
                listOfData.add(innerList);
            }
        }
        return listOfData;
    }

    @Override
    public ArrayList<City> getCities() {
        return mData;
    }

    @Override
    public String updateCity(City city) {
        throw new UnsupportedOperationException("Readonly data source being used");
    }

    @Override
    public void addCity(City city) {
        throw new UnsupportedOperationException("Readonly data source being used");
    }

    @Override
    public void deleteCity(City city) {
        throw new UnsupportedOperationException("Readonly data source being used");
    }
}
