package category;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.recyclerview.R;
import android.view.LayoutInflater;
import java.util.List;
import java.util.Locale;

import book.bookAdapter;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private Context mContext;
    private List<Category> mListCategory;

    public CategoryAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Category> list){
        this.mListCategory = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public int getItemCount() {
        if (mListCategory !=null){
            return mListCategory.size();
        }
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = mListCategory.get(position);
        if (category == null) {
            return;
        }
        holder.tvNameCategory.setText(category.getNameCategory());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
        holder.rcvBook.setLayoutManager(linearLayoutManager);

        bookAdapter bookAdapter = new bookAdapter();
        bookAdapter.setData(category.getBooks());

        holder.rcvBook.setAdapter(bookAdapter);
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNameCategory;
        private RecyclerView rcvBook;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameCategory = itemView.findViewById(R.id.tv_name_category);
            rcvBook = itemView.findViewById(R.id.rcv_book);
        }
    }
}
