package com.example.brannpark.testapp;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by brannpark on 2016. 4. 22..
 */
public final class FlingBehavior extends AppBarLayout.Behavior {
    private static final int TOP_CHILD_FLING_THRESHOLD = 3;
    private boolean isPositive;

    public FlingBehavior() {
    }

    public FlingBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, float velocityX, float velocityY, boolean consumed) {
        if (velocityY > 0 && !isPositive || velocityY < 0 && isPositive) {
            velocityY = velocityY * -1;
        }
        if (velocityY < 0) {
            View view;
            if (!RecyclerView.class.isInstance(target)) {
                view = target.findViewById(android.R.id.list);
            } else {
                view = target;
            }

            if (view instanceof RecyclerView) {
                final RecyclerView recyclerView = (RecyclerView) view;
                final View firstChild = recyclerView.getChildAt(0);
                final int childAdapterPosition = recyclerView.getChildAdapterPosition(firstChild);
                consumed = childAdapterPosition > TOP_CHILD_FLING_THRESHOLD;
            }
        }
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        isPositive = dy > 0;
    }
}