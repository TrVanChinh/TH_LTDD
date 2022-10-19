package book;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.recyclerview.R;
import android.view.LayoutInflater;
import java.util.List;

public class bookAdapter extends RecyclerView.Adapter<bookAdapter.BookViewHolder> {

    private List<Book> mbooks;

    public void setData(List<Book> mbooks) {
        this.mbooks = mbooks;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater. from(parent.getContext ()).inflate(R.layout.item_book, parent, false);

        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book =  mbooks.get(position);
        if (book== null){
            return;
        }
        holder.imgBook.setImageResource(book.getResourceId());
        holder.tvTitle.setText(book.getTitle());

    }

    @Override
    public int getItemCount() {
        if (mbooks != null){
            return mbooks.size();
        }
        return 0;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgBook;
        private TextView tvTitle;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

            imgBook = itemView.findViewById(R.id.img_book);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }
}
