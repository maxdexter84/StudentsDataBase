package com.maxdexter.studentsdatabase.ui;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.maxdexter.studentsdatabase.R;
import com.maxdexter.studentsdatabase.data.Student;

import java.util.List;

public class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentRecyclerAdapter.ViewHolder> {

     private Activity activity;
    // Источник данных
    private EducationSource dataSource;
    // Позиция в списке, на которой было нажато меню
    private long menuPosition;


    public StudentRecyclerAdapter(Activity activity, EducationSource dataSource) {
        this.activity = activity;
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        List<Student> students = dataSource.getStudents();
        Student student = students.get(position);
        holder.bind(student);
        // Тут определяем, какой пункт меню был нажат
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                menuPosition = position;
                return false;
            }
        });
        if (activity != null){
            activity.registerForContextMenu(holder.itemView);
        }

    }

    @Override
    public int getItemCount() {
        return (int)dataSource.getCountStudents();
    }
    public long getMenuPosition() {
        return menuPosition;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView first_name;
        TextView last_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            first_name = itemView.findViewById(R.id.textStudenFirstName);
            last_name = itemView.findViewById(R.id.textStudentLastName);
        }
        private void bind(Student student){
            first_name.setText(student.firstName);
            last_name.setText(student.lastName);
            // Регистрируем контекстное меню

        }
    }
}
