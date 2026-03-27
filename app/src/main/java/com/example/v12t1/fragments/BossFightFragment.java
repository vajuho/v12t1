package com.example.v12t1.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.v12t1.GameManager;
import com.example.v12t1.Monster;
import com.example.v12t1.R;

public class BossFightFragment extends Fragment {

    ImageView BossImage;
    TextView BossText;
    Button AttackBossButton;
    Monster Boss;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_boss_fight, container, false);

        BossImage = view.findViewById(R.id.BossImage);
        BossText = view.findViewById(R.id.BossText);
        AttackBossButton = view.findViewById(R.id.AttackBossButton);
        Boss = new Monster(150, "Robotti") {
            private boolean possibleReturn = false;

            @Override
            public void takeDamage(int damage) {
                super.takeDamage(damage);

                if (!possibleReturn && getLife() < getMaxLife() / 2) {
                    possibleReturn = true;
                    setLife(getMaxLife());
                }
                if (getLife() < 0) {
                    setLife(0);
                }
            }
        };
        BossImage.setImageResource(R.drawable.robot);

        AttackBossButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attackBoss();
            }
        });
        return view;
    }

    public void attackBoss() {
        GameManager.getInstance().getPlayer().attack(Boss);
        updateBoss();
    }

    public void updateBoss() {
        BossText.setText(Boss.getName() + ": " + Boss.getLife() + "/" + Boss.getMaxLife());
    }
}