package com.example.danil.input;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
public class MainActivity extends ListActivity {

    private String[] mMonthArray = { "Январь", "Февраль", "Март", "Апрель", "Май", // Создадим массив строк:


            "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь",
            "Декабрь","January","February","March","April","May","June","July","August","September","October",
            "November","December","Janvier","Fevrier","Mars","Avril","Mai","Juin",
            "Juillet","Aout","Septembre","Octobre","Novembre","Decembre"};

    private String[] mDayOfWeekArray = new String[] { "Понедельник", "Вторник", "Среда", //  Создадим массив строк:


            "Четверг", "Friday", "Суббота", "Воскресенье","Lundi","Mardi","Jeudi","Vendredi","Samedi","Dimanche",
            "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday","El lunes",
            "El martes", "El miercoles","El jueves", "El viernes", "El sabado", "El domingo" };
    private String[] mDayOfMonthArray = new String [] {"1","2","3","4","5","6","7","8","9","10","11", // Создадим массив строк:


            "12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28",
    "29","30","31"};

    // Создадим два адаптера
    private ArrayAdapter<String> mMonthAdapter, mWeekOfDayAdapter, mDayOfMonthAdapter; //адаптера данных и его определение для работы с массивами строк
    private String mMonth, mDayOfWeek, mDayOfMonth;

    @Override
    public void onCreate(Bundle savedInstanceState) {   // ListActivity в качестве текущего контекста  готовый системный идентификатор ресурса и созданный массив строк.
        super.onCreate(savedInstanceState);

        mMonthAdapter = new ArrayAdapter<>(this, //
                android.R.layout.simple_list_item_1, mMonthArray);
        mWeekOfDayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, mDayOfWeekArray);
        mDayOfMonthAdapter = new ArrayAdapter <> (this,
                android.R.layout.simple_list_item_1,mDayOfMonthArray);

        setListAdapter(mMonthAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) { // обраотчик нажатий,position, который указывает на номер выбранного пункта списка. Сначала используем первый адаптер. При выборе элемента списка через метод onListItemClick() подключаем другой адаптер. Чтобы изменения отразились на экране, необходимо вызвать метод notifyDataSetChanged().
        super.onListItemClick(l, v, position, id);
        if (getListAdapter() == mMonthAdapter) {
            mMonth = (String) l.getItemAtPosition(position);
            setListAdapter(mWeekOfDayAdapter);
            mDayOfWeek = (String) l.getItemAtPosition(position);

                mDayOfWeek = (String) l.getItemAtPosition(position);
                setListAdapter(mDayOfMonthAdapter);
                mDayOfMonth = (String) l.getItemAtPosition(position);
        } else {
            mDayOfMonth = (String) l.getItemAtPosition(position);
            Toast.makeText(getBaseContext(), mMonth + ": "    + mDayOfWeek   + mDayOfMonth,
                    Toast.LENGTH_LONG).show();
            setListAdapter(mMonthAdapter);
            mMonthAdapter.notifyDataSetChanged();
        }
    }
}