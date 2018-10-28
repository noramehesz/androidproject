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

public class DetailsProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.profile_detail, container, false);

        TextView tvId = rootView.findViewById(R.id.tvId);
        TextView tvSSN = rootView.findViewById(R.id.tvSSN);
        TextView tvTaxId = rootView.findViewById(R.id.tvTaxId);
        TextView tvRegistrationId = rootView.findViewById(R.id.tvRegistrationId);

        Person person = DataManager.getInstance().getPerson();

        tvId.setText(person.getId());
        tvSSN.setText(person.getSocialSecurityNumber());
        tvTaxId.setText(person.getTaxId());
        tvRegistrationId.setText(person.getRegistrationId());

        return rootView;
    }
}
