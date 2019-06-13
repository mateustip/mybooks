// Generated code from Butter Knife. Do not modify!
package com.s2start.mybooks;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131230825;

  private View view2131230859;

  private View view2131230762;

  private View view2131230756;

  private View view2131230864;

  private View view2131230865;

  private View view2131230869;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.list, "field 'list' and method 'listaClick'");
    target.list = Utils.castView(view, R.id.list, "field 'list'", ListView.class);
    view2131230825 = view;
    ((AdapterView<?>) view).setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> p0, View p1, int p2, long p3) {
        target.listaClick(p2);
      }
    });
    target.pesquisalb = Utils.findRequiredViewAsType(source, R.id.pesquisalb, "field 'pesquisalb'", EditText.class);
    target.titulo = Utils.findRequiredViewAsType(source, R.id.titulo, "field 'titulo'", TextView.class);
    view = Utils.findRequiredView(source, R.id.pesquisar, "method 'pesquisar'");
    view2131230859 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.pesquisar();
      }
    });
    view = Utils.findRequiredView(source, R.id.camera, "method 'camera'");
    view2131230762 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.camera();
      }
    });
    view = Utils.findRequiredView(source, R.id.bibliteca, "method 'bbiblioteca'");
    view2131230756 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.bbiblioteca();
      }
    });
    view = Utils.findRequiredView(source, R.id.recarregar, "method 'recarregar'");
    view2131230864 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.recarregar();
      }
    });
    view = Utils.findRequiredView(source, R.id.recomendado, "method 'recomendado'");
    view2131230865 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.recomendado();
      }
    });
    view = Utils.findRequiredView(source, R.id.sair, "method 'sair'");
    view2131230869 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.sair();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.list = null;
    target.pesquisalb = null;
    target.titulo = null;

    ((AdapterView<?>) view2131230825).setOnItemClickListener(null);
    view2131230825 = null;
    view2131230859.setOnClickListener(null);
    view2131230859 = null;
    view2131230762.setOnClickListener(null);
    view2131230762 = null;
    view2131230756.setOnClickListener(null);
    view2131230756 = null;
    view2131230864.setOnClickListener(null);
    view2131230864 = null;
    view2131230865.setOnClickListener(null);
    view2131230865 = null;
    view2131230869.setOnClickListener(null);
    view2131230869 = null;
  }
}
