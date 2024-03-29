package android.jplas.gamingapp.Fragments;


import android.jplas.gamingapp.Activities.ShopItem;
import android.jplas.gamingapp.R;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends Fragment implements View.OnClickListener {

    View view;
    Button submit;
    RadioGroup radioGroup;
    EditText namaText, angkaText;

    public ShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_shop, container, false);

        radioGroup = view.findViewById(R.id.radio_group);
        namaText = view.findViewById(R.id.text_nama);
        angkaText = view.findViewById(R.id.text_jumlah);
        submit = (Button) view.findViewById(R.id.button);
        submit.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        String nama = namaText.getText().toString();
        int item = 0;
        int checkId = radioGroup.getCheckedRadioButtonId();
        if((checkId != -1) && !TextUtils.isEmpty(nama)){
            int jumlah = Integer.parseInt(angkaText.getText().toString());
            if (checkId == R.id.radio_headphone){
                item = ShopItem.HEADPHONE;
            }else if (checkId == R.id.radio_keyboard){
                item = ShopItem.KEYBOARD;
            }else{
                item = ShopItem.MOUSE;
            }
            ShopItem shop = new ShopItem(nama, item, jumlah);
            Bundle args = new Bundle();
            args.putParcelable("shop",shop);
            Fragment TotalItem = new TotalItemFragment();
            TotalItem.setArguments(args);
            FragmentTransaction fragmentTransaction = getActivity()
                    .getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, TotalItem);
            fragmentTransaction.commit();
        }else {
            Toast.makeText(getActivity(), "Please select equipment and your name !", Toast.LENGTH_SHORT).show();
        }
    }
}
