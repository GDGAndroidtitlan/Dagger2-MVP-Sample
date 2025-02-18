/**
 * Copyright 2015 Erik Jhordan Rey.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package gdg.androidtitlan.dagger2_demo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class ResponsiveRecyclerView extends RecyclerView {
  private GridLayoutManager manager;
  private int columnWidth = -1;

  public ResponsiveRecyclerView(Context context) {
    super(context);
    init(context, null);
  }

  public ResponsiveRecyclerView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context, attrs);
  }

  public ResponsiveRecyclerView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    init(context, attrs);
  }

  private void init(Context context, AttributeSet attrs) {
    if (attrs != null) {
      int[] attrsArray = {
          android.R.attr.columnWidth
      };
      TypedArray array = context.obtainStyledAttributes(attrs, attrsArray);
      columnWidth = array.getDimensionPixelSize(0, -1);
      array.recycle();
    }

    manager = new GridLayoutManager(getContext(), 1);
    setLayoutManager(manager);
  }

  @Override protected void onMeasure(int widthSpec, int heightSpec) {
    super.onMeasure(widthSpec, heightSpec);
    if (columnWidth > 0) {
      int spanCount = Math.max(1, getMeasuredWidth() / columnWidth);
      manager.setSpanCount(spanCount);
    }
  }
}