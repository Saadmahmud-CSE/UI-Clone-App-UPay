// WalletItemDecoration.java
package com.saad.cse.upay.ui.account;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WalletItemDecoration extends RecyclerView.ItemDecoration {
    private final int spacing;

    public WalletItemDecoration(int spacing) {
        this.spacing = spacing;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect,
                               @NonNull View view,
                               @NonNull RecyclerView parent,
                               @NonNull RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        int column = position % 2; // 2 columns

        outRect.left = spacing - column * spacing / 2;
        outRect.right = (column + 1) * spacing / 2;

        if (position >= 2) {
            outRect.top = spacing;
        }
    }
}
