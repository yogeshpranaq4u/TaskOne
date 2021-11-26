package adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.quantum.taskone.R;

import java.util.ArrayList;
import java.util.List;

import apiPackage.ApiModel;
import apiPackage.Exercise;

public class ApiAdapter extends RecyclerView.Adapter<ApiAdapter.ApiViewHolder> {

    public static final String TAG="MainApiAdapter";

    private List<Exercise> exerciseList=new ArrayList<>();

    public void setList(List<Exercise> list){
        exerciseList=list;
    }

    @Override
    public ApiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.api_view_items,parent,false);
        return new ApiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ApiViewHolder holder, int position) {

        Exercise exercise=exerciseList.get(position);

        holder.exercise_heading.setText(exercise.getHeading());
        holder.exercise_set.setText(exercise.getSets());
        holder.exercise_time.setText("Time: "+exercise.getTime());
        holder.exercise_calories.setText("Calories: "+exercise.getCalories());
        holder.lottie_view.setAnimationFromUrl(exercise.getAnimation());

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: "+exerciseList.size());
        return exerciseList.size();
    }

    public class ApiViewHolder extends RecyclerView.ViewHolder {

        public LottieAnimationView lottie_view;
        public TextView exercise_heading, exercise_calories, exercise_set, exercise_time;


        public ApiViewHolder(@NonNull View itemView) {
            super(itemView);

            lottie_view=itemView.findViewById(R.id.lottie_view);
            exercise_heading=itemView.findViewById(R.id.exercise_header);
            exercise_calories=itemView.findViewById(R.id.calories_text);
            exercise_set=itemView.findViewById(R.id.sets_text);
            exercise_time=itemView.findViewById(R.id.time_text);
        }
    }
}
