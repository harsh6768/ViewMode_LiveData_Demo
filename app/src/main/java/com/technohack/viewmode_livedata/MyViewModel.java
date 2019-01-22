package com.technohack.viewmode_livedata;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

     private MutableLiveData<Integer> resultValue;

     public MutableLiveData<Integer> getResultValue(){
         if(resultValue==null){
             resultValue=new MutableLiveData<>();

             //setting the by default value
             resultValue.setValue(0);
         }
         return resultValue;
     }

     public void addScore(){
         if(resultValue.getValue()!=null){
             resultValue.setValue(resultValue.getValue()+1);
         }
     }
     public void resetValue(){
         resultValue.setValue(0);
     }
}
