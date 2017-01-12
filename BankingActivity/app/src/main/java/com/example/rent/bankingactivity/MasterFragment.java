package com.example.rent.bankingactivity;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class MasterFragment extends Fragment {

    Button calcButton;
    Button depoButton;

    public static final int CALCULATOR = 1;
    public static final int DEPOSIT = 2;

    public MasterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_master, container, false);



        calcButton = (Button) view.findViewById(R.id.button_currency);
        depoButton = (Button) view.findViewById(R.id.button_deposit);

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentChangeable main = (FragmentChangeable) getActivity();
                main.changeDetailFragment(CALCULATOR);

            }
        });

        depoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentChangeable main = (FragmentChangeable) getActivity();
                main.changeDetailFragment(DEPOSIT);

            }
        });
        return view;
    }

    public interface FragmentChangeable{

        public void changeDetailFragment(int i);
    }

}
