package presenter;

import view.RegisterView;

public interface RegistrationPresenter {
    void registerUser(String email, String password, String passwordConfirm, String mobile);
}
