package io.github.rfonzi.mvptest.view;

/**
 * Created by ryan on 11/25/16.
 */

public interface IMainView {
    void loginSuccess(String string);
    void loginFailed();
    void hideProgressBar();
    void unhideProgressBar();
}
