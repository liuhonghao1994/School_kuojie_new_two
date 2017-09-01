
package com.kuojie.school.school_kuojie.ui.login;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.kuojie.school.school_kuojie.R;
import com.kuojie.school.school_kuojie.base.BaseActivity;
import com.kuojie.school.school_kuojie.ui.main.MainActivity;

public class LoginActivity extends BaseActivity implements LoginView, View.OnClickListener {

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private LoginPresenter presenter;


    @Override
    protected void initView() {
        setContentLayout(R.layout.activity_login);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        findViewById(R.id.button).setOnClickListener(this);
    }


    @Override
    protected void initData() {
        presenter = new LoginPresenterImpl(this);

    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        username.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        password.setError(getString(R.string.password_error));
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onClick(View v) {
        presenter.validateCredentials(username.getText().toString(), password.getText().toString());
        /*.getInstance().preLogin(username.getText().toString(), password.getText().toString(), "username", "password", "https://www.baidu.com/index.php", new LoginData.PreLoginListener() {
            @Override
            public void success() {
                ToastUtils.showToast(getBaseContext(), "登陆成功");
                login();
            }

            @Override
            public void error() {
                ToastUtils.showToast(getBaseContext(), "登陆失败");
            }
        });*/
    }

    /*private void login() {
        LoginData.getInstance().login(username.getText().toString(), password.getText().toString(), "username", "password", "test", "customerId", "https://www.baidu.com/index.php", new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                
            }

            @Override
            public void onResponse(String response, int id) {

            }
        });
    }*/
}
