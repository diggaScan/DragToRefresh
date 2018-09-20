package com.concretejungle.dragtorefresh;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {
    private Context mContext;
    private List<String> dataSet;
    private OnListItemClickedListener listener;

    public RvAdapter(Context context, List<String> dataSet, RvAdapter.OnListItemClickedListener listener) {
        super();
        this.mContext = context;
        this.dataSet = dataSet;
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public RvAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.rv_item, parent, false);
        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(RvAdapter.MyViewHolder holder, final int position) {
        holder.test.setText(dataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView test;

        public MyViewHolder(View itemView) {
            super(itemView);
            test=itemView.findViewById(R.id.test_content);
        }
    }

    public interface OnListItemClickedListener {
        void onItemClicked(int newsId, int clickedPos);
    }
}
