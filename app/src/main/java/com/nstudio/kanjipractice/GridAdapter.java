package com.nstudio.kanjipractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.nstudio.kanjipractice.database.Kanji;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GridAdapter extends BaseAdapter {

    private Context context;
    private List<Kanji> kanjis;
    private boolean[] selected_kanjis;
    private LayoutInflater inflater;

    public GridAdapter(Context context, List<Kanji> kanjis, boolean[] selected_kanjis) {
        this.context = context;
        this.kanjis = kanjis;
        this.selected_kanjis = selected_kanjis;
    }


    @Override
    public int getCount() {
        return kanjis.size();
    }

    @Override
    public Object getItem(int i) {
         return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null){
            convertView = inflater.inflate(R.layout.grid_item, null);
        }

        TextView tv_kanji = convertView.findViewById(R.id.tv_kanji);
        TextView tv_learned = convertView.findViewById(R.id.tv_learned);
        TextView tv_id = convertView.findViewById(R.id.tv_id);

        // Item default view
        tv_kanji.setBackgroundResource(R.color.ligth_gray);
        tv_learned.setBackgroundResource(R.color.ligth_gray);
        tv_id.setBackgroundResource(R.color.ligth_gray);
        tv_kanji.setText(kanjis.get(position).getKanji());
        tv_id.setText(String.format(Locale.getDefault(),"%d", kanjis.get(position).getId()));
        tv_learned.setText("");
        if(kanjis.get(position).getLearned() == 1){
            tv_learned.setText("✔");
        }

        // If this kanji is selected then the color changes
        if(selected_kanjis[position]){
            tv_kanji.setBackgroundResource(R.color.gray);
            tv_learned.setBackgroundResource(R.color.gray);
            tv_id.setBackgroundResource(R.color.gray);
        }


        return convertView;
    }
}
