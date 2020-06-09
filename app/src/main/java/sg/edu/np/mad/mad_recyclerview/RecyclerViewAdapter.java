package sg.edu.np.mad.mad_recyclerview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ArrayList<String>tasksList;
    private Context mContext;
    AlertDialog.Builder deleteAlert;
    TextView deleteTask;
    public RecyclerViewAdapter(ArrayList<String> input, Context context)
    {
        tasksList = input;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tasks,parent,false); //fixed
        final ViewHolder holder = new ViewHolder(view);
        holder.tasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAlert = new AlertDialog.Builder(mContext);
                deleteAlert.setTitle("Delete");

                View view = LayoutInflater.from(mContext).inflate(R.layout.deletealert,null); //fixed
                deleteTask = (TextView) view.findViewById(R.id.deleteTaskName);
                deleteTask.setText(tasksList.get(holder.getAdapterPosition()) + "?");

                deleteAlert.setCancelable(true); // set for cancel
                deleteAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tasksList.remove(holder.getAdapterPosition());
                        notifyDataSetChanged();

                    }
                });
                deleteAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                deleteAlert.setView(view);
                deleteAlert.show();

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String s = tasksList.get(position);
        holder.tasks.setText(s);

    }

    @Override
    public int getItemCount() {
        return tasksList.size();
    }
}
