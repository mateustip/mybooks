// Generated code from Butter Knife. Do not modify!
package com.s2start.mybooks;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  private View view2131230829;

  private View view2131230761;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(final LoginActivity target, View source) {
    this.target = target;

    View view;
    target.usuario = Utils.findRequiredViewAsType(source, R.id.usuario, "field 'usuario'", EditText.class);
    target.senha = Utils.findRequiredViewAsType(source, R.id.senha, "field 'senha'", EditText.class);
    view = Utils.findRequiredView(source, R.id.logar, "method 'logar'");
    view2131230829 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.logar();
      }
    });
    view = Utils.findRequiredView(source, R.id.cadastro, "method 'cadastro'");
    view2131230761 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.cadastro();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.usuario = null;
    target.senha = null;

    view2131230829.setOnClickListener(null);
    view2131230829 = null;
    view2131230761.setOnClickListener(null);
    view2131230761 = null;
  }
}
