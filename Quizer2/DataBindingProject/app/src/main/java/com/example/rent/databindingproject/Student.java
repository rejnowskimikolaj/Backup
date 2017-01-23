package com.example.rent.databindingproject;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

/**
 * Created by RENT on 2017-01-19.
 */

public class Student extends BaseObservable {

    private  String firstName;
    private  String lastName;
    private  int indexNumber;

    public Student(String firstName, String lastName, int indexNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.indexNumber = indexNumber;
    }
    @Bindable
    public String getFirstName() {
        return firstName;
    }


    @Bindable
    public String getLastName() {
        return lastName;
    }



    @Bindable
    public int getIndexNumber() {
        return indexNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        Log.d("STUDENT", "setFirstName: ");
        notifyPropertyChanged(BR.firstName);

    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
        notifyPropertyChanged(BR.indexNumber);
    }
}
