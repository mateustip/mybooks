// Generated code from Butter Knife. Do not modify!
package com.s2start.mybooks.ui;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.s2start.mybooks.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CadastroActivity_ViewBinding implements Unbinder {
  private CadastroActivity target;

  private View view2131230757;

  private View view2131230827;

  @UiThread
  public CadastroActivity_ViewBinding(CadastroActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CadastroActivity_ViewBinding(final CadastroActivity target, View source) {
    this.target = target;

    View view;
    target.usuario = Utils.findRequiredViewAsType(source, R.id.usuario, "field 'usuario'", EditText.class);
    target.senha = Utils.findRequiredViewAsType(source, R.id.senha, "field 'senha'", EditText.class);
    target.email = Utils.findRequiredViewAsType(source, R.id.email, "field 'email'", EditText.class);
    target.nome = Utils.findRequiredViewAsType(source, R.id.nome, "field 'nome'", EditText.class);
    view = Utils.findRequiredView(source, R.id.cadastrar, "method 'cadastro'");
    view2131230757 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.cadastro();
      }
    });
    view = Utils.findRequiredView(source, R.id.login, "method 'login'");
    view2131230827 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.login();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CadastroActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.usuario = null;
    target.senha = null;
    target.email = null;
    target.nome = null;

    view2131230757.setOnClickListener(null);
    view2131230757 = null;
    view2131230827.setOnClickListener(null);
    view2131230827 = null;
  }
}
