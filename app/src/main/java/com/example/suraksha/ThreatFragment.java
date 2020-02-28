package com.example.suraksha;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class ThreatFragment extends Fragment {
    Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View V= inflater.inflate(R.layout.threat,container,false);
        button= (Button) V.findViewById(R.id.Button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null, chooser=null;
                intent=new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                String[] to={"ishumehta99@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL,to);
                intent.putExtra(Intent.EXTRA_SUBJECT,"Regarding Threat");
                intent.setType("message/rfc822");
                chooser=Intent.createChooser(intent,"Send Email");
                startActivity(chooser);

            }
        });
        return V;
    }

}
