package adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.documentfile.provider.DocumentFile;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.quantum.taskone.R;

import java.io.File;
import java.util.List;

public class DocumentAdapter extends RecyclerView.Adapter<DocumentAdapter.DocumentViewHolder> {
    public static final String TAG="MainDocumentDapter";

    private final List<String> imagepathlist;

    public DocumentAdapter(List<String> imagepathlist) {
        this.imagepathlist = imagepathlist;
    }


    @Override
    public DocumentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.document_item_list,parent,false);
        return new DocumentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DocumentViewHolder holder, int position) {
       holder.imageView.setVisibility(View.VISIBLE);
       /* Bitmap bitmap= BitmapFactory.decodeFile(imagepathlist.get(position));
        holder.imageView.setImageBitmap(bitmap);*/

       // holder.imageView.setImageDrawable(Drawable.createFromPath(imagepathlist.get(position)));
        holder.textView.setText(imagepathlist.get(position));

        Glide.with(holder.imageView.getContext()).load(imagepathlist.get(position))
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return imagepathlist.size();
    }

    public class DocumentViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;


        public DocumentViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.documents_data);
            textView=itemView.findViewById(R.id.image_name);
        }
    }
}
