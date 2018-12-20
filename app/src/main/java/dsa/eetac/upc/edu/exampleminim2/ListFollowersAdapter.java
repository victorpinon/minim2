package dsa.eetac.upc.edu.exampleminim2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import dsa.eetac.upc.edu.exampleminim2.models.Follower;
import dsa.eetac.upc.edu.exampleminim2.models.User;

public class ListFollowersAdapter extends RecyclerView.Adapter<ListFollowersAdapter.ViewHolder> {

    private List<User> dataset;
    private Context context;

    public ListFollowersAdapter(Context context) {
        this.context = context;
        this.dataset = new ArrayList<>();
    }

    @Override
    public ListFollowersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_follower,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ListFollowersAdapter.ViewHolder holder, int position) {
        User user = dataset.get(position);
        holder.loginFollowerTextView.setText(user.getLogin());
        Picasso.with(context).load(user.getAvatar_url()).into(holder.fotoFollowerImageView);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void addFollowers(List<User> listFollowers) {
        dataset.addAll(listFollowers);
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout linearLayout;
        private ImageView fotoFollowerImageView;
        private TextView loginFollowerTextView;

        public ViewHolder(View itemView){
            super(itemView);

            linearLayout = itemView.findViewById(R.id.linearLayout);
            fotoFollowerImageView = itemView.findViewById(R.id.fotoImageView);
            loginFollowerTextView =  itemView.findViewById(R.id.textView_login);
        }
    }
}
