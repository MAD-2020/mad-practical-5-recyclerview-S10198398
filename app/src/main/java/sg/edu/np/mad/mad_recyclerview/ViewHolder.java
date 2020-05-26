package sg.edu.np.mad.mad_recyclerview;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView tasks;
    LinearLayout layout;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        tasks = itemView.findViewById(R.id.textRow);
        layout = itemView.findViewById(R.id.rowLayout);
    }
}
