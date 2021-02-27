package com.google.developers.teapot.paging;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.google.developers.teapot.data.Tea;

/**
 * Implementation of an Paging adapter that shows list of Teas.
 */
public class TeaAdapter extends PagedListAdapter<Tea, TeaViewHolder> {

    private ItemAction mItemOnClickAction;

    public TeaAdapter() {
        super(DIFF_CALLBACK);
    }

    public interface ItemAction {
        void onClick(String teaName);
    }

    public void setItemOnClickAction(ItemAction itemOnClickAction) {
        mItemOnClickAction = itemOnClickAction;
    }

    @NonNull
    @Override
    public TeaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TeaViewHolder holder, int position) {

    }

    private static final DiffUtil.ItemCallback<Tea> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Tea>() {
                @Override
                public boolean areItemsTheSame(@NonNull Tea oldItem, @NonNull Tea newItem) {
                    return oldItem.getName().equals(newItem.getName());
                }

                @Override
                public boolean areContentsTheSame(@NonNull Tea oldItem, @NonNull Tea newItem) {
                    return oldItem == newItem;
                }
            };
}
