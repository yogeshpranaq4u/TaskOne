package adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.quantum.taskone.MainActivity;
import com.quantum.taskone.R;

import java.util.ArrayList;
import java.util.List;

import apiPackage.Exercise;
import categoryapipkg.Catlist;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    public static final String TAG="MainCategoryAdapter";

    private List<Catlist> catlists=new ArrayList<>();
    Context context;

    public void setList(List<Catlist> list){
        catlists=list;
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_api_item,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.catid.setText(catlists.get(position).getCatId());
        holder.catname.setText("Category Id "+catlists.get(position).getCatName());
        holder.daycount.setText("Days "+catlists.get(position).getDayCount());
        Glide.with(holder.imageView.getContext()).load(catlists.get(position).getMiniImage())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: "+catlists.size());
        return catlists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView catname, catid,daycount;
        public ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            catid=itemView.findViewById(R.id.cat_id);
            catname=itemView.findViewById(R.id.cat_name);
            daycount=itemView.findViewById(R.id.days);
            imageView=itemView.findViewById(R.id.cat_image);
        }
    }
}
