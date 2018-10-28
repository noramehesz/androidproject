package hu.bme.aut.workplaceapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hu.bme.aut.workplaceapp.data.DataManager;
import hu.bme.aut.workplaceapp.data.Person;

/**
 * Created by mobsoft on 2017. 09. 27..
 */

public class MainProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.profile_main, container, false);

        TextView tvName = rootView.findViewById(R.id.tvName);
        TextView tvEmail = rootView.findViewById(R.id.tvEmail);
        TextView tvAddress = rootView.findViewById(R.id.tvAddress);

        Person person = DataManager.getInstance().getPerson();

        tvName.setText(person.getName());
        tvEmail.setText(person.getEmail());
        tvAddress.setText(person.getAddress());

        return rootView;
    }
}
