// Generated code from Butter Knife. Do not modify!
package com.s2start.mybooks.ui;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.s2start.mybooks.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BookActivity_ViewBinding implements Unbinder {
  private BookActivity target;

  private View view2131230906;

  private View view2131230907;

  private View view2131230908;

  private View view2131230909;

  private View view2131230910;

  private View view2131230793;

  private View view2131230746;

  @UiThread
  public BookActivity_ViewBinding(BookActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BookActivity_ViewBinding(final BookActivity target, View source) {
    this.target = target;

    View view;
    target.name = Utils.findRequiredViewAsType(source, R.id.name, "field 'name'", TextView.class);
    target.editora = Utils.findRequiredViewAsType(source, R.id.editora, "field 'editora'", TextView.class);
    target.image = Utils.findRequiredViewAsType(source, R.id.image, "field 'image'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.star1, "field 'star1' and method 'star1s'");
    target.star1 = Utils.castView(view, R.id.star1, "field 'star1'", ImageButton.class);
    view2131230906 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.star1s(Utils.castParam(p0, "doClick", 0, "star1s", 0, ImageButton.class));
      }
    });
    view = Utils.findRequiredView(source, R.id.star2, "field 'star2' and method 'star2s'");
    target.star2 = Utils.castView(view, R.id.star2, "field 'star2'", ImageButton.class);
    view2131230907 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.star2s(Utils.castParam(p0, "doClick", 0, "star2s", 0, ImageButton.class));
      }
    });
    view = Utils.findRequiredView(source, R.id.star3, "field 'star3' and method 'star3s'");
    target.star3 = Utils.castView(view, R.id.star3, "field 'star3'", ImageButton.class);
    view2131230908 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.star3s(Utils.castParam(p0, "doClick", 0, "star3s", 0, ImageButton.class));
      }
    });
    view = Utils.findRequiredView(source, R.id.star4, "field 'star4' and method 'star4s'");
    target.star4 = Utils.castView(view, R.id.star4, "field 'star4'", ImageButton.class);
    view2131230909 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.star4s(Utils.castParam(p0, "doClick", 0, "star4s", 0, ImageButton.class));
      }
    });
    view = Utils.findRequiredView(source, R.id.star5, "field 'star5' and method 'star5s'");
    target.star5 = Utils.castView(view, R.id.star5, "field 'star5'", ImageButton.class);
    view2131230910 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.star5s(Utils.castParam(p0, "doClick", 0, "star5s", 0, ImageButton.class));
      }
    });
    target.descricao = Utils.findRequiredViewAsType(source, R.id.descricao, "field 'descricao'", EditText.class);
    target.list = Utils.findRequiredViewAsType(source, R.id.listcomentarios, "field 'list'", ListView.class);
    view = Utils.findRequiredView(source, R.id.enviar, "method 'enviar'");
    view2131230793 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.enviar();
      }
    });
    view = Utils.findRequiredView(source, R.id.adicionarwishlist, "method 'adicionarwishlist'");
    view2131230746 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.adicionarwishlist();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    BookActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.name = null;
    target.editora = null;
    target.image = null;
    target.star1 = null;
    target.star2 = null;
    target.star3 = null;
    target.star4 = null;
    target.star5 = null;
    target.descricao = null;
    target.list = null;

    view2131230906.setOnClickListener(null);
    view2131230906 = null;
    view2131230907.setOnClickListener(null);
    view2131230907 = null;
    view2131230908.setOnClickListener(null);
    view2131230908 = null;
    view2131230909.setOnClickListener(null);
    view2131230909 = null;
    view2131230910.setOnClickListener(null);
    view2131230910 = null;
    view2131230793.setOnClickListener(null);
    view2131230793 = null;
    view2131230746.setOnClickListener(null);
    view2131230746 = null;
  }
}
