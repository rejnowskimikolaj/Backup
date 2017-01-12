package com.example.user.personapp;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class PersonListFragment extends Fragment {
     ListView personListView;

    String[] personArr = {"jacek","monia","jessica","Adam","aneta","Agnieszka","Barbara","bartek"};
    List<String> personlist;

    PersonGenerator pg;



    public PersonListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =inflater.inflate(R.layout.fragment_person_list, container, false);

        personlist = new ArrayList<>();
         pg = new PersonGenerator();
        ArrayList<Person>personPersonList = pg.generate(8);
        for(Person p: personPersonList){
            personlist.add(p.toString());
        }



         personListView = (ListView) view.findViewById(R.id.person_list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,personlist);
        personListView.setAdapter(adapter);

        return view;



    }

    public void changeSorting(boolean isChecked){

        if(!isChecked){
            Collections.sort(personlist);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,personlist);
            personListView.setAdapter(adapter);
        }

        else {
            Collections.sort(personlist);
            Collections.reverse(personlist);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,personlist);
            personListView.setAdapter(adapter);
        }
    }

    public void generateNewPeople(){
        ArrayList<Person>personPersonList = pg.generate(8);
        personlist.clear();
        for(Person p: personPersonList){
            personlist.add(p.toString());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,personlist);
        personListView.setAdapter(adapter);
    }


    public class Person{
        private String name;
        private String lastName;

        public Person(String lastName, String name) {
            this.lastName = lastName;
            this.name = name;
        }

        public String toString(){
            return name+" "+lastName;
        }
    }


    public class PersonGenerator{

        ArrayList<String> names;
        ArrayList<String> lastNames;

        public PersonGenerator(){

            names = new ArrayList<>();
            lastNames = new ArrayList<>();

            getNames();
            getLastNames();
        }

        public ArrayList<Person> generate(int size){

            ArrayList<Person> personList = new ArrayList<>();
            Random r = new Random();
            for(int i=0;i<size;i++){

                String name = names.get(r.nextInt(names.size()));
                String lastName = lastNames.get(r.nextInt(names.size()));

                personList.add(new Person(name,lastName));

            }

            return personList;
        }

        private void getNames(){
            String line="";

           InputStream is= getResources().openRawResource(R.raw.names);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            try {
                while((line = br.readLine())!=null){

                    names.add(line);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        private void getLastNames(){
            String line="";
            InputStream is= getResources().openRawResource(R.raw.last_names);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            try {
                while((line = br.readLine())!=null){

                    lastNames.add(line);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
