package com.hdsxtech.www.mvptestt;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * 作者:丁文 on 2018/4/3.
 * copyright: www.hdsxtech.com
 */

public class LoginAcivity extends Activity implements LoginView , View.OnClickListener{

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(this);
        presenter = new LoginPresenter(this);
        initData();
    }

    private void initData() {

    }


    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showSuccess(String hint) {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this,hint, Toast.LENGTH_SHORT);
    }

    @Override
    public void showFailed(String fail) {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this,fail, Toast.LENGTH_SHORT);
    }

    @Override
    public void onClick(View v) {
        presenter.login(username,password);
    }
}
