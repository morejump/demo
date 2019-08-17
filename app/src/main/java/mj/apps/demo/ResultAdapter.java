package mj.apps.demo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ResultHolder> {
    
    List<String> results;
    
    ResultAdapter(List<String> results) {
        this.results = results;
    }
    
    @NonNull
    @Override
    public ResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_result, parent, false);
        return new ResultHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull ResultHolder holder, int position) {
        holder.bindData(results.get(position));
    }
    
    @Override
    public int getItemCount() {
        return results == null ? 0 : results.size();
    }
    
    public void setData(List<String> results) {
        this.results = results;
        notifyDataSetChanged();
    }
    
    class ResultHolder extends RecyclerView.ViewHolder {
        TextView txtResult;
        
        public ResultHolder(@NonNull View itemView) {
            super(itemView);
            txtResult = itemView.findViewById(R.id.txtResult);
        }
        
        public void bindData(String result) {
            txtResult.setText(result);
        }
    }
}
