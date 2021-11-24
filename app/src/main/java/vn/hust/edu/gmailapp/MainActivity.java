package vn.hust.edu.gmailapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ListViewCompat;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView ListView;
    String mTitle[] = {"Adurila.com","Chris Abad","Tuto.com","support","Matt from lonic","Nytheavy"};
    String mDescription[] = {"$19 Only (First 10 spots)-Bestselling...       " +
            "Are you looking to Learn Web Designin...",
            "Help make Campaign Monitor better       " +
            "Let us know your thoughts!No Images...",
            "8h de formation gratuite et les nouvea...      " +
                    "Photoshop, SEO, Blender, CSS, WordPre...",
            "Societe Ovl: suivi vos services- hp...     " +
                    "SAS OVH - http://www.ovh.com2 rue K...",
            "The New lonic Creator Is Here!           " +
                    "Announcing the all-new Creator, build...",
            "Hello! How are you b?"};
    String mTime[] = {"8:32pm","8:03pm","7:55pm","7:00pm","6:45pm","6:10pm"};
    int images[] = {R.drawable.image1_background,R.drawable.image2_background,R.drawable.image3_background,
            R.drawable.image4_background,R.drawable.image5_background,R.drawable.image6_background};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView = findViewById(R.id.ListView_gmail);
        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription,mTime, images);
        ListView.setAdapter(adapter);

    }
    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String rTitle[];
        String rDescription[];
        String rTime[];
        int rImgs[];
        MyAdapter (Context c, String title[], String description[],String time[], int imgs[]){
            super(c, R.layout.row, R.id.Text1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rTime = time;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=(LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image1);
            TextView myTitle = row.findViewById(R.id.Text1);
            TextView myDescription = row.findViewById(R.id.Text2);
            TextView myTime = row.findViewById(R.id.Text_time);
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);
            myTime.setText(rTime[position]);


            return row;
        }
    }
}