package com.example.user.gasoline.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.support.v4.app.DialogFragment;
//import android.support.v4.app.FragmentTransaction;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import com.example.user.gasoline.R;

import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentFillup.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentFillup#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentFillup extends Fragment implements View.OnClickListener {

    private String LOG_TAG = "LOG_TAG";


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private EditText edVolume;
    private EditText edDate;
    private EditText edPrice;
    private EditText edSum;
    private EditText edOdo;

    public Button btnDatePicker;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentFillup() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentFillup.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentFillup newInstance(String param1, String param2) {
        FragmentFillup fragment = new FragmentFillup();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fillup, container, false);

        btnDatePicker = (Button) view.findViewById(R.id.btnDate);
        btnDatePicker.setOnClickListener(this);

        edPrice = (EditText) view.findViewById(R.id.edPrice);
        edVolume = (EditText) view.findViewById(R.id.edVolume);
        edSum = (EditText) view.findViewById(R.id.edSum);
        edOdo = (EditText) view.findViewById(R.id.edOdo);


        edPrice.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                String sVol = edVolume.getText().toString();
                String sPrice = edPrice.getText().toString();

                try {
                    double dVol = Double.parseDouble(sVol);
                    double dPrice = Double.parseDouble(sPrice);
                    double dSum = dVol * dPrice;
                    String sSum = new Double(dSum).toString();
                    edSum.setText(sSum);
                    Log.d("LOG_TAG", "Price");
                }
                catch (Exception e){
                    Log.d("LOG_TAG", e.getMessage());
                }

                return false;
            }
        });

        edSum.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                String sVol = edVolume.getText().toString();
                String sSum = edSum.getText().toString();

                try {
                    double dVol = Double.parseDouble(sVol);
                    double dSum = Double.parseDouble(sSum);
                    double dPrice = dSum/dVol;
                    String sPrice = new Double(dPrice).toString();
                    edPrice.setText(sPrice);
                    Log.d("LOG_TAG", "Sum");
                }
                catch (Exception e){
                    Log.d("LOG_TAG", e.getMessage());
                }

                return false;
            }
        });




        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onStart() {
        Log.d("LOG_TAG", "Start");
        edVolume = (EditText)getView().findViewById(R.id.edVolume);
        edVolume.setText("15");

        edDate = (EditText)getView().findViewById(R.id.edDate);
        Date d = new Date();
        CharSequence s  = DateFormat.format("dd.MM.yyyy", d.getTime());
        edDate.setText(s);

        edPrice = (EditText)getView().findViewById(R.id.edPrice);
        edPrice.setText("37.35");

        super.onStart();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        Log.d(LOG_TAG,"111");
        switch(v.getId()){

            case R.id.btnDate :
                Log.d(LOG_TAG, "Кнопка нажата");

                 break;

            default:
                break;

        }
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
//TODO https://neurobin.org/docs/android/android-date-picker-example/