package com.quantum.taskone;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import adapters.DocumentAdapter;

public class DocumentActivity extends AppCompatActivity {
    public static final String TAG="MainDocumentActivity";

    RecyclerView recyclerView;
    DocumentAdapter documentAdapter;
    private List<String> imagePaths;
    private ArrayList<File> mfiles;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.document_activity);
        Log.d(TAG, "onCreate: ");
        recyclerView=findViewById(R.id.document_show);

        imagePaths=new ArrayList<>();
       // getDocuments();
    }

    /*public void getDocuments(){
        ContentResolver contentResolver=getContentResolver();
        Uri uri= MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        if (uri!=null){
            CursorLoader cursorLoader= (CursorLoader) contentResolver.query(uri,null,null,null,null);
            Cursor cursor=cursorLoader.loadInBackground();
            Log.d(TAG, "getImages: "+cursor.getCount());
            if(cursor!=null){
                if(cursor.getCount()>0){
                    while (cursor.moveToNext()){
                        @SuppressLint("Range") String images=cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                        String imageName=cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME));
                        @SuppressLint("Range") Bitmap bitmapFactory= BitmapFactory.decodeFile(cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME)));
                        imagePaths.add(images);
                        documentAdapter=new DocumentAdapter(imagePaths);
                        recyclerView.setAdapter(documentAdapter);
                        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
                        Log.d(TAG, "Images: "+imagePaths);
                    }
                }
            }
        }
    }*/
}
