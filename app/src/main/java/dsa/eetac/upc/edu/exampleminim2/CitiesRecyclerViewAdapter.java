package dsa.eetac.upc.edu.exampleminim2;

import android.content.Context;
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

import dsa.eetac.upc.edu.exampleminim2.models.Cities;
import dsa.eetac.upc.edu.exampleminim2.models.Element;
import dsa.eetac.upc.edu.exampleminim2.models.User;

public class CitiesRecyclerViewAdapter extends RecyclerView.Adapter<CitiesRecyclerViewAdapter.ViewHolder> {

    private List<Element> dataset;
    private Context context;

    public CitiesRecyclerViewAdapter(Context context) {
        this.context = context;
        this.dataset = new ArrayList<>();
    }

    @Override
    public CitiesRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_follower,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CitiesRecyclerViewAdapter.ViewHolder holder, int position) {
        Element element = dataset.get(position);
        holder.loginFollowerTextView.setText(element.getMunicipiNom());
        Picasso.with(context).load(element.getMunicipiEscut()).into(holder.fotoFollowerImageView);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void addFollowers(List<Element> listElements) {
        dataset.addAll(listElements);
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
