package io.github.rfonzi.mvptest.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.rfonzi.mvptest.R;
import io.github.rfonzi.mvptest.presenter.MainPresenter;

public class MainView extends AppCompatActivity implements IMainView {

    MainPresenter mainPresenter;
    @BindView(R.id.textView) TextView textView;
    @BindView(R.id.getButton) Button getButton;
    @BindView(R.id.progressBar) ProgressBar progressBar;
    @BindView(R.id.editText) EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainPresenter = new MainPresenter(this);
    }

    @OnClick(R.id.getButton)
    public void getButtonPressed(View view){
        textView.setText("Request received...");
        mainPresenter.doSomethingAndWait5Seconds();
    }

    @OnClick(R.id.sendButton)
    public void sendButtonPressed(View view){
        mainPresenter.sendString(editText.getText().toString());
        Toast toast = Toast.makeText(getApplicationContext(), "\"" + editText.getText().toString() + "\" sent", Toast.LENGTH_SHORT);
        editText.setText("");
        toast.show();
    }

    @Override
    public void loginSuccess(String string){
        textView.setText(string);
    }

    @Override
    public void loginFailed(){
        textView.setText("Error, no strings exist yet");
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void unhideProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

}
