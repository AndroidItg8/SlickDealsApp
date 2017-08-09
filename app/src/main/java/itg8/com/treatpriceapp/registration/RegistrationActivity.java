package itg8.com.treatpriceapp.registration;

import android.animation.Animator;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.rahatarmanahmed.cpv.CircularProgressView;

import butterknife.BindView;
import butterknife.ButterKnife;
import itg8.com.treatpriceapp.R;
import itg8.com.treatpriceapp.common.CommonMethod;
import itg8.com.treatpriceapp.registration.mvp.presenter.LoginViewPresenter;
import itg8.com.treatpriceapp.registration.mvp.presenter.LoginViewPresenterImp;
import itg8.com.treatpriceapp.registration.mvp.view.LoginView;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener, LoginView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.registrationFrameLayout)
    FrameLayout registrationFrameLayout;
    @BindView(R.id.cardView)
    CardView cardView;
    @BindView(R.id.txt_login)
    TextView txtLogin;
    @BindView(R.id.emailInputText)
    TextInputLayout emailInputText;
    @BindView(R.id.input_password)
    TextInputLayout inputPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.rl_login)
    RelativeLayout rlLogin;
    @BindView(R.id.btn_facebook)
    Button btnFacebook;
    @BindView(R.id.btn_google)
    Button btnGoogle;
    @BindView(R.id.ll_btn)
    LinearLayout llBtn;

    @BindView(R.id.txt_forget)
    TextView txtForget;
    @BindView(R.id.input_passwords)
    TextInputLayout inputPasswords;

    @BindView(R.id.progress_views)
    CircularProgressView progressViews;
    @BindView(R.id.lbl_signUp)
    TextView lblSignUp;
    @BindView(R.id.input_first)
    TextInputLayout inputFirst;
    @BindView(R.id.input_last)
    TextInputLayout inputLast;
    @BindView(R.id.txt_password)
    TextInputEditText txtPassword;
    @BindView(R.id.txt_email)
    TextInputEditText txtEmail;
    @BindView(R.id.input_email)
    TextInputLayout inputEmail;
    @BindView(R.id.txt_mobile)
    TextInputEditText txtMobile;
    @BindView(R.id.input_mobile)
    TextInputLayout inputMobile;
    @BindView(R.id.btn_sign_up)
    Button btnSignUp;
    @BindView(R.id.fab_close)
    FloatingActionButton fabClose;
    @BindView(R.id.fab_sign_add)
    FloatingActionButton fabSignAdd;
    @BindView(R.id.progress_view)
    CircularProgressView progressView;
    @BindView(R.id.rl_signUp)
    RelativeLayout rlSignUp;
    @BindView(R.id.rl_connection)
    RelativeLayout rlConnection;
    @BindView(R.id.img_no_connection)
    ImageView imgNoConnection;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.lbl_login)
    TextView lblLogin;
    @BindView(R.id.txt_password_login)
    TextInputEditText txtPasswordLogin;
    @BindView(R.id.txt_name)
    TextInputEditText txtName;
    @BindView(R.id.lbl_by)
    TextView lblBy;
    @BindView(R.id.rbtn_email)
    RadioButton rbtnEmail;
    @BindView(R.id.rbtn_mobile)
    RadioButton rbtnMobile;
    @BindView(R.id.rgb_login)
    RadioGroup rgbLogin;
    LoginViewPresenter presenter;
    private float pixelDensity;
    private Animation alphaAnimation;
    private boolean isFromFabAdd = false;
    private boolean isFromSignUp = false;
    private String type;
    private TextInputEditText edtForgetEmail;
    private Button btnForget;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);
        initWidget();
        presenter = new LoginViewPresenterImp(this);


    }

    private void initWidget() {
        pixelDensity = getResources().getDisplayMetrics().density;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnLogin.setOnClickListener(this);
        txtForget.setOnClickListener(this);
        fabSignAdd.setOnClickListener(this);
        fabClose.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
        alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha_anim);
        isFromFabAdd = false;


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                btnLoginCliked();
                break;
            case R.id.txt_forget:
                openBottomSheetForget();
                break;
            case R.id.fab_sign_add:
                widgetVisibilityGone(true);
                break;
            case R.id.fab_close:
                widgetVisibilityGone(false);
                break;
            case R.id.btn_sign_up:
                sendSignUpData();
                break;


        }
    }

    private void sendSignUpData() {
        if (validateToSignUp()) {
            presenter.onSendSignUpInfoToServer(txtName.getText().toString(), txtEmail.getText().toString(), txtMobile.getText().toString(), txtPassword.getText().toString());
        }
    }

    private boolean validateToSignUp() {
        boolean isValidate = true;
        if (TextUtils.isEmpty(txtEmail.getText().toString())) {
            txtEmail.setError("Field is empty");
            isValidate = false;
        }
        if (TextUtils.isEmpty(txtPassword.getText().toString())) {
            txtPassword.setError("Field is empty");
            isValidate = false;
        }
        if (TextUtils.isEmpty(txtMobile.getText().toString())) {
            txtMobile.setError("Field is empty");
            isValidate = false;
        } else if (txtMobile.getText().toString().length() != 10) {
            txtMobile.setError(" enter only 10 digit number");
            isValidate = false;
        }
        if (TextUtils.isEmpty(txtPassword.getText().toString())) {
            txtPassword.setError("Field is empty");
            isValidate = false;
        } else if (txtPassword.getText().toString().length() < 6) {
            txtPasswordLogin.setError("Please enter minimum six character ");
            isValidate = false;
        }

        if (TextUtils.isEmpty(txtName.getText().toString())) {
            txtName.setError("Field is empty");
            isValidate = false;
        }
        return isValidate;
    }

    private void btnLoginCliked() {
        if (validate()) {
            btnLogin.setVisibility(View.GONE);
            progressViews.setVisibility(View.VISIBLE);
            presenter.onSendLoginInfoToServer(txtLogin.getText().toString(), txtPasswordLogin.getText().toString(), type);
        }



    }

    private boolean validate() {
        boolean Validate = true;

        if (TextUtils.isEmpty(txtLogin.getText().toString())) {
            txtLogin.setError("Field is empty");
            Validate = false;
        } else if (isEmailValid()) {
            type = CommonMethod.FOR_EMAIL;
            Validate = false;
        } else {
            type = CommonMethod.FOR_MOBILE;
            Validate = false;
        }
        if (TextUtils.isEmpty(txtPasswordLogin.getText().toString())) {
            txtPasswordLogin.setError("Field is empty");
            Validate = false;
        } else if (txtPasswordLogin.getText().toString().length() < 6) {
            txtPasswordLogin.setError("Please enter minimum six character ");
            Validate = false;
        }
        return Validate;
    }

    private boolean isEmailValid() {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(txtLogin.getText().toString()).matches();
    }


    private void widgetVisibilityGone(boolean isFromSignUp) {
        if (isFromSignUp) {
            txtForget.setVisibility(View.GONE);
            isFromFabAdd = true;
        } else {
            isFromFabAdd = false;
        }
        reavealAnination(isFromFabAdd);
        this.isFromSignUp = !isFromSignUp;


    }

    private void reavealAnination(boolean isFromFabAdd) {
        int x = rlLogin.getRight();
        int y = rlLogin.getTop();
        x -= ((28 * pixelDensity) + (16 * pixelDensity));

        int hypotenuse = (int) Math.hypot(rlLogin.getWidth(), rlLogin.getHeight());


        if (isFromFabAdd) {

            cardView.setBackgroundColor(getResources().getColor(R.color.colorRed));

            Animator anim = ViewAnimationUtils.createCircularReveal(rlSignUp, x, y, 0, hypotenuse);
            anim.setDuration(700);
            anim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {
                    rlLogin.setVisibility(View.GONE);
                    fabSignAdd.setVisibility(View.GONE);
                    fabClose.setVisibility(View.VISIBLE);


                }

                @Override
                public void onAnimationEnd(Animator animator) {
//                rlSignUp.setVisibility(View.VISIBLE);
//                rlSignUp.startAnimation(alphaAnimation);
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });

            rlSignUp.setVisibility(View.VISIBLE);
            anim.start();
        } else {

            cardView.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            Animator anim = ViewAnimationUtils.createCircularReveal(rlSignUp, x, y, hypotenuse, 0);
            anim.setDuration(700);

            anim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    rlSignUp.setVisibility(View.GONE);
                    fabClose.setVisibility(View.GONE);
                    rlLogin.setVisibility(View.VISIBLE);
                    txtForget.setVisibility(View.VISIBLE);
                    fabSignAdd.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });
            anim.start();
            isFromFabAdd = true;
        }
    }

    private void openBottomSheetForget() {

        final Dialog mBottomSheetDialog = new Dialog(this,
                R.style.MaterialDialogSheet);
        mBottomSheetDialog.setContentView(R.layout.layout_bottom_forget);
        mBottomSheetDialog.setCancelable(true);
        mBottomSheetDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        mBottomSheetDialog.getWindow().setGravity(Gravity.BOTTOM);
     edtForgetEmail = (TextInputEditText) mBottomSheetDialog.findViewById(R.id.txt_forget_email);
      btnForget  = (Button) mBottomSheetDialog.findViewById(R.id.btn_forget);
        btnForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateForget())
                {
                     presenter.onSendFogetEmailToServer(edtForgetEmail.getText().toString());

                }

            }
        });

        mBottomSheetDialog.show();
    }

    private boolean validateForget() {
         boolean isVali = true;
        if(TextUtils.isEmpty(edtForgetEmail.getText().toString()))
        {
            edtForgetEmail.setError("Field is empty");
            isVali= false;
        }
        return isVali;
    }


    @Override
    public void onNetworkAvailable() {

    }

    @Override
    public void onNetworkUnAvailable() {
        hideAllWidget();
        showSnackbar();


    }

    private void hideAllWidget() {
        rlConnection.setVisibility(View.GONE);
        fabClose.setVisibility(View.GONE);
        fabSignAdd.setVisibility(View.GONE);
        imgNoConnection.setVisibility(View.VISIBLE);

    }

    @Override
    public void onProgressHide() {
        progressView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onProgressShow() {
        progressView.setVisibility(View.GONE);
    }

    @Override
    public void onLoginSuccess(String msg) {
        callToast(msg);
    }

    private void callToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        onBackPressed();
    }

    @Override
    public void onLoginFailed(String msg) {
        callToast(msg);
    }

    @Override
    public void onSignUpSuccess(String msg) {

        callToast(msg);
    }

    @Override
    public void onSignUpFailed(String msg) {
        callToast(msg);
    }

    @Override
    public void onResetPassword(String msg) {
        callToast(msg);

    }

    @Override
    public void onNotResetPassword(String msg) {
        callToast(msg);

    }

    public void showSnackbar() {
        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, "No internet connection!", Snackbar.LENGTH_LONG)
                .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });

        snackbar.setActionTextColor(Color.RED);

        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        snackbar.show();
    }


}
