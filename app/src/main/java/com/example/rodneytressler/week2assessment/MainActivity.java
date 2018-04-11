package com.example.rodneytressler.week2assessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.input_name)
    protected EditText nameEdit;
    @BindView(R.id.input_email)
    protected EditText emailEdit;
    private WelcomeFragment welcomeFragment;
    public static final String ACCOUNT_INFO = "account_info";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void toastRegistrationFailure() {
        Toast.makeText(this, "Please enter all fields first!", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.button_register)
    protected void getAccountInformation() {
        if (nameEdit.getText().toString().isEmpty() || emailEdit.getText().toString().isEmpty()) {
            toastRegistrationFailure();
        } else {
            String userFirstName = nameEdit.getText().toString();
            String userLastName = emailEdit.getText().toString();

            Account account = new Account(userFirstName, userLastName);
            welcomeFragment = WelcomeFragment.newInstance();

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, welcomeFragment).commit();


            Bundle bundle = new Bundle();
            bundle.putParcelable(ACCOUNT_INFO, account);
            welcomeFragment.setArguments(bundle);

        }
    }
}
