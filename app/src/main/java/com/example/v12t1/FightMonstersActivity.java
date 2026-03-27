package com.example.v12t1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.v12t1.fragments.BossFightFragment;
import com.example.v12t1.fragments.ShowMonsterFragment;

public class FightMonstersActivity extends AppCompatActivity {
    Button BossFightFragmentButton;
    Button ShowMonsterFragmentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fight_monsters);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        BossFightFragmentButton = findViewById(R.id.BossFightFragmentButton);
        ShowMonsterFragmentButton = findViewById(R.id.ShowMonsterFragmentButton);

        BossFightFragmentButton.setEnabled(false);
        checkBossButton();

        ShowMonsterFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentSwapMethod(new ShowMonsterFragment());
            }
        });

        BossFightFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentSwapMethod(new BossFightFragment());
            }
        });
    }

    private void fragmentSwapMethod (Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.FightMonstersFrame, fragment)
                .commit();
    }

    public void activateBoss () {
        BossFightFragmentButton.setEnabled(true);
    }

    public void checkBossButton () {
        int points = GameManager.getInstance().getPlayer().getScore();
        if (points >= 100) {
            BossFightFragmentButton.setEnabled(true);
        }
    }

    public void goToHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}