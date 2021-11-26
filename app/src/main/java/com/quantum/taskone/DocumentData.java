package com.quantum.taskone;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import adapters.DocumentAdapter;

public class DocumentData extends AppCompatActivity {
    public static final String TAG="MainDocumentData";

    RecyclerView recyclerView;
    DocumentAdapter documentAdapter;
    private List<String> imagePaths;
    private ArrayList<File> mfiles;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.document_activity);

        recyclerView=findViewById(R.id.document_show);

        imagePaths=new ArrayList<>();

        if(ContextCompat.checkSelfPermission(getBaseContext(), "android.permission.READ_EXTERNAL_STORAGE") == PackageManager.PERMISSION_GRANTED)  {

            // Todo : If Permission Granted Then Show SMS


        } else {
            // Todo : Then Set Permission
            final int REQUEST_CODE_ASK_PERMISSIONS = 123;
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, REQUEST_CODE_ASK_PERMISSIONS);
        }

        display();

    }

    private ArrayList<File> findImages(File file) {

        ArrayList<File> arrayList=new ArrayList<>();

        File[] imageFile=file.listFiles();

        if(imageFile!=null) {
            for (File singleImage : imageFile) {
                if (singleImage.isDirectory() && !singleImage.isHidden()) {
                    arrayList.addAll(findImages(singleImage));
                    Log.d(TAG, "findImage: "+singleImage);
                } else {
                    if (singleImage.getName().endsWith(".pdf") ||
                            singleImage.getName().endsWith(".txt") /*||
                            singleImage.getName().endsWith(".webp")*/) {
                        arrayList.add(singleImage);
                        Log.d(TAG, "findImages: "+arrayList.add(singleImage));
                    }
                }
            }
        }
        else{
            Log.d(TAG, "findImages fail ");
        }

        return arrayList;
    }

    public void display(){
        mfiles=findImages(Environment.getExternalStorageDirectory());

        for (int i=0;i<mfiles.size();i++){
            imagePaths.add(String.valueOf(mfiles.get(i)));

            Log.d(TAG, "display: "+imagePaths);
            documentAdapter=new DocumentAdapter(imagePaths);
            recyclerView.setAdapter(documentAdapter);
            recyclerView.setLayoutManager(new GridLayoutManager(this,3));

        }
    }
}
