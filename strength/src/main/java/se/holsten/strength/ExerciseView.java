package se.holsten.strength;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ExerciseView extends LinearLayout {
  private TextView mName;
  private TextView mValue;

  public ExerciseView(Context context, AttributeSet attrs) {
    super(context, attrs);

    TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Options, 0, 0);
    String name = a.getString(R.styleable.Options_name);
    String weight = a.getString(R.styleable.Options_weight);
    a.recycle();

    setOrientation(LinearLayout.HORIZONTAL);
    setGravity(Gravity.CENTER_VERTICAL);

    LayoutInflater inflater = (LayoutInflater) context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    inflater.inflate(R.layout.view_exercise, this, true);

    mName = (TextView) getChildAt(0);
    mName.setText(name);

    mValue = (TextView) getChildAt(1);
    mValue.setText(weight);

  }

  public void setValueName(String name) {
    mValue.setText(name);
  }

  public void setValueWeight(String weight) { mValue.setText(weight);  }

} 