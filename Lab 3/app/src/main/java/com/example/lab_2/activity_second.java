package com.example.lab_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class activity_second extends AppCompatActivity {
    public class Books{
        List<String> getInfo(String group){
            List<String>info= new ArrayList<>();
            if (group.equals("Peacock")) {
                info.add("Information about Peacocks:");
                info.add("\n- Scientific Name: Pavo cristatus");
                info.add("\n- Description: Large, colorful birds known for their iridescent tail feathers, which are displayed in a fan-like shape.");
                info.add("\n- Habitat: Native to South Asia, found in forests, grasslands, and near human settlements.");
                info.add("\n- Diet: Omnivores, eating plants, insects, and small animals.");
                info.add("\n- Behavior: Known for the male's courtship display with its tail feathers.");
                info.add("\n- Conservation Status: Least concern, though habitat loss and hunting can impact local populations.");
            }

            if (group.equals("Bald Eagle")) {
                info.add("Information about Bald Eagles:");
                info.add("\n- Scientific Name: Haliaeetus leucocephalus");
                info.add("\n- Description: Large raptor with a distinctive white head and tail, and dark brown body and wings.");
                info.add("\n- Habitat: Found near large bodies of open water with abundant food supply, such as lakes and rivers.");
                info.add("\n- Diet: Primarily fish, but also eats birds, small mammals, and carrion.");
                info.add("\n- Behavior: Powerful fliers and skilled hunters, known for their impressive nests.");
                info.add("\n- Conservation Status: Delisted from endangered status, but still protected.");
            }

            if (group.equals("Hummingbird")) {
                info.add("Information about Hummingbirds:");
                info.add("\n- Scientific Name: Various species (e.g., Archilochus colubris)");
                info.add("\n- Description: Tiny birds with iridescent feathers and rapid wing beats that allow them to hover.");
                info.add("\n- Habitat: Found primarily in the Americas, from tropical rainforests to temperate regions.");
                info.add("\n- Diet: Feed on nectar from flowers, supplemented by insects and spiders.");
                info.add("\n- Behavior: Highly territorial and known for their rapid, hovering flight.");
                info.add("\n- Conservation Status: Varies by species, with some being endangered due to habitat loss.");
            }

            if (group.equals("Snowy Owl")) {
                info.add("Information about Snowy Owls:");
                info.add("\n- Scientific Name: Bubo scandiacus");
                info.add("\n- Description: Large, white owl with dark spots, known for its striking appearance.");
                info.add("\n- Habitat: Inhabits Arctic regions and northern parts of North America and Eurasia.");
                info.add("\n- Diet: Primarily lemmings and other small rodents, but will also eat birds and fish.");
                info.add("\n- Behavior: Mostly nocturnal and known for its silent flight and powerful hunting skills.");
                info.add("\n- Conservation Status: Currently not threatened, but population can fluctuate with prey availability.");
            }


            return info;
        }
    }
    private Books expert= new Books();
    public static final String EXTRA_MESSAGE="message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        TextView info2 =(TextView)  findViewById(R.id.infoss);
        Intent intent = getIntent();
        String messageText = intent.getStringExtra(EXTRA_MESSAGE);
        TextView messageView = (TextView)findViewById(R.id.text);
        List<String> infoList =expert.getInfo(messageText);
        StringBuilder infoFormatted = new StringBuilder();
        for(String inf : infoList)
        {
            infoFormatted.append(inf).append('\n');
        }
        info2.setText("Information");
        messageView .setText(infoFormatted);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}