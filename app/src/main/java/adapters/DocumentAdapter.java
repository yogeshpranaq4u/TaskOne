package adapters;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.documentfile.provider.DocumentFile;
import androidx.recyclerview.widget.RecyclerView;

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
        //holder.imageView.setImageURI(Uri.parse(imagepathlist.get(position)));


    }

    @Override
    public int getItemCount() {
        return imagepathlist.size();
    }

    public class DocumentViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;


        public DocumentViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.documents_data);
        }
    }
}
