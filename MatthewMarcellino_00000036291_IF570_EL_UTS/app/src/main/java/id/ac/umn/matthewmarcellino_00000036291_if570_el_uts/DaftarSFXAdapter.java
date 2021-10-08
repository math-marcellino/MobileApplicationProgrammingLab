package id.ac.umn.matthewmarcellino_00000036291_if570_el_uts;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class DaftarSFXAdapter extends RecyclerView.Adapter<DaftarSFXAdapter.ItemSFXViewHolder> {

    private LinkedList<SumberSFX> mDaftarSFX;
    private LayoutInflater mInflater;
    private Context mContext;

    public DaftarSFXAdapter(Context context, LinkedList<SumberSFX> daftarSFX){
        this.mContext = context;
        this.mDaftarSFX = daftarSFX;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ItemSFXViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_sfx, parent, false);
        return new ItemSFXViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull DaftarSFXAdapter.ItemSFXViewHolder holder, int position) {
        SumberSFX mSumberSFX = mDaftarSFX.get(position);
        holder.tv_titleSFX.setText(mSumberSFX.getTitle());
        holder.tv_kategoriSFX.setText(mSumberSFX.getKategori());
    }

    @Override
    public int getItemCount() {
        return mDaftarSFX.size();
    }

    class ItemSFXViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView tv_titleSFX;
        private TextView tv_kategoriSFX;
        DaftarSFXAdapter mAdapter;
        private int mPosisi;
        private SumberSFX mSumberSFX;
        private ImageView delete;

        public ItemSFXViewHolder(@NonNull View itemView, DaftarSFXAdapter adapter) {
            super(itemView);
            mAdapter = adapter;
            delete = (ImageView) itemView.findViewById(R.id.deleteSFX);
            tv_titleSFX = (TextView) itemView.findViewById(R.id.titleSFX);
            tv_kategoriSFX = (TextView) itemView.findViewById(R.id.kategoriSFX);
            itemView.setOnClickListener(this);

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mDaftarSFX.remove(getLayoutPosition());
                    notifyItemRemoved(getLayoutPosition());
                    notifyItemRangeChanged(getLayoutPosition(), mDaftarSFX.size());
                }
            });
        }

        @Override
        public void onClick(View view) {
            mPosisi = getLayoutPosition();
            mSumberSFX = mDaftarSFX.get(mPosisi);
            Intent intentDetail = new Intent(mContext, DetailSFXActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("DetailSFXActivity", mSumberSFX);
            intentDetail.putExtras(bundle);
            mContext.startActivity(intentDetail);
        }
    }
}
