package com.quantum.taskone;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
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



    //   display();
        //getImages();
        new ImageTask().execute();

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

    //@SuppressLint("Range")
 /*   public void getImages(){
        ContentResolver contentResolver=getContentResolver();
        Uri uri= MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        if (uri!=null){
            CursorLoader cursorLoader= (CursorLoader) contentResolver.query(uri,null,null,null,null);
            Cursor cursor=contentResolver.query(uri,null,null,null,null);
            Log.d(TAG, "getImages: "+cursor.getCount());
            if(cursor!=null){
                if(cursor.getCount()>0){
                    while (cursor.moveToNext()){
                        @SuppressLint("Range") String images=cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                        String imageName=cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME));
                        Bitmap bitmapFactory=BitmapFactory.decodeFile(cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME)));
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

    private class ImageTask extends AsyncTask<Void, Void,Cursor>{

        ContentResolver contentResolver=getContentResolver();
        Uri uri= MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        @Override
        protected Cursor doInBackground(Void... voids) {

            Cursor cursor=contentResolver.query(uri,null,null,null,null);
            Log.d(TAG, "getImages: "+cursor.getCount());
            if(cursor!=null){
                if(cursor.getCount()>0){
                    while (cursor.moveToNext()){
                        @SuppressLint("Range") String images=cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                        String imageName=cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME));
                      //  @SuppressLint("Range") Bitmap bitmapFactory=BitmapFactory.decodeFile(cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME)));
                        imagePaths.add(images);
                        Log.d(TAG, "doInBackground: "+imagePaths.add(images));
                    }
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            documentAdapter=new DocumentAdapter(imagePaths);
            recyclerView.setAdapter(documentAdapter);
            recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
            Log.d(TAG, "Images: "+imagePaths);
            super.onPostExecute(cursor);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d(TAG, "onPreExecute: ");
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            Log.d(TAG, "onProgressUpdate: ");
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            Log.d(TAG, "onCancelled: ");
        }

        @Override
        protected void onCancelled(Cursor cursor) {
            super.onCancelled(cursor);
            Log.d(TAG, "onCancelled: ");
        }
    }
}
