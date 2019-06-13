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

  private View view2131230822;

  private View view2131230856;

  private View view2131230759;

  private View view2131230861;

  private View view2131230862;

  private View view2131230866;

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
    view2131230822 = view;
    ((AdapterView<?>) view).setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> p0, View p1, int p2, long p3) {
        target.listaClick(p2);
      }
    });
    target.pesquisalb = Utils.findRequiredViewAsType(source, R.id.pesquisalb, "field 'pesquisalb'", EditText.class);
    target.titulo = Utils.findRequiredViewAsType(source, R.id.titulo, "field 'titulo'", TextView.class);
    view = Utils.findRequiredView(source, R.id.pesquisar, "method 'pesquisar'");
    view2131230856 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.pesquisar();
      }
    });
    view = Utils.findRequiredView(source, R.id.camera, "method 'camera'");
    view2131230759 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.camera();
      }
    });
    view = Utils.findRequiredView(source, R.id.recarregar, "method 'recarregar'");
    view2131230861 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.recarregar();
      }
    });
    view = Utils.findRequiredView(source, R.id.recomendado, "method 'recomendado'");
    view2131230862 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.recomendado();
      }
    });
    view = Utils.findRequiredView(source, R.id.sair, "method 'sair'");
    view2131230866 = view;
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

    ((AdapterView<?>) view2131230822).setOnItemClickListener(null);
    view2131230822 = null;
    view2131230856.setOnClickListener(null);
    view2131230856 = null;
    view2131230759.setOnClickListener(null);
    view2131230759 = null;
    view2131230861.setOnClickListener(null);
    view2131230861 = null;
    view2131230862.setOnClickListener(null);
    view2131230862 = null;
    view2131230866.setOnClickListener(null);
    view2131230866 = null;
  }
}
