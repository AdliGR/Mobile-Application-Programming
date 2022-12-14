package id.ac.umn.week11_52738;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MahasiswaListAdapter extends RecyclerView.Adapter<MahasiswaListAdapter.MahasiswaViewHolder> {
    private final LayoutInflater mInflater;
    private List<Mahasiswa> daftarMahsiswa;
    MahasiswaListAdapter(Context context){
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MahasiswaListAdapter.MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.mhs_item_layout,parent,false);
        return new MahasiswaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaListAdapter.MahasiswaViewHolder holder, int position) {
        if(daftarMahsiswa != null){
            Mahasiswa mhs = daftarMahsiswa.get(position);
            holder.tvNim.setText(mhs.getNim());
            holder.tvNama.setText(mhs.getNama());
        }else {
            holder.tvNim.setText("Belum ada Mahasiswa");
        }
    }

    @Override
    public int getItemCount() {
        if(daftarMahsiswa != null){
            return daftarMahsiswa.size();
        }else {
            return 0;
        }
    }

    public Mahasiswa getMahasiswaAtPosition(int posisi){
        return daftarMahsiswa.get(posisi);
    }

    void setDaftarMahsiswa(List<Mahasiswa> mhss){
        daftarMahsiswa = mhss;
        notifyDataSetChanged();
    }

    void hapusData(int posisi){
        daftarMahsiswa.remove(posisi);
        notifyDataSetChanged();
    }

    void tambahData(Mahasiswa mhs){
        daftarMahsiswa.add(mhs);
        notifyDataSetChanged();
    }

    void updateData(int posisi, Mahasiswa mhs){
        daftarMahsiswa.set(posisi,mhs);
        notifyDataSetChanged();
        notifyItemChanged(posisi);
    }

    class MahasiswaViewHolder extends RecyclerView.ViewHolder{
        private final TextView tvNim;
        private final TextView tvNama;

        public MahasiswaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNim = itemView.findViewById(R.id.tvitemNim);
            tvNama = itemView.findViewById(R.id.tvitemNama);
        }
    }
}


