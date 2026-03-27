package com.example.v12t1.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.v12t1.FightMonstersActivity;
import com.example.v12t1.GameManager;
import com.example.v12t1.Monster;
import com.example.v12t1.Player;
import com.example.v12t1.R;
import com.example.v12t1.Vampire;

public class ShowMonsterFragment extends Fragment {
    private ImageView MonsterImage;
    private TextView MonsterNameText;
    private TextView MonsterLifeText;
    private Button AttackMonsterButton;
    private Monster currentMonster;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_monster, container, false);
        MonsterImage = view.findViewById(R.id.MonsterImage);
        MonsterNameText = view.findViewById(R.id.MonsterNameText);
        MonsterLifeText = view.findViewById(R.id.MonsterLifeText);
        AttackMonsterButton = view.findViewById(R.id.AttackMonsterButton);
        currentMonster = GameManager.getInstance().generateMonster();
        updateMonster();
        AttackMonsterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attackMonster();
            }
        });

        return view;
    }

    public void attackMonster() {
        Player player = GameManager.getInstance().getPlayer();
        player.attack(currentMonster);
        updateMonster();

        if (currentMonster.getLife() <= 0) {
            currentMonster = GameManager.getInstance().generateMonster();
            updateMonster();
        }

        if (player.getScore() >= 100) {
            activatingBoss();
        }
    }

    public void updateMonster() {
        MonsterNameText.setText(currentMonster.getName());
        MonsterLifeText.setText("Elämä: " + currentMonster.getLife() + "/" + currentMonster.getMaxLife());

        if (currentMonster instanceof Vampire) {
            MonsterImage.setImageResource(R.drawable.vampire);
        } else {
            MonsterImage.setImageResource(R.drawable.skeleton);
        }
    }

    public void activatingBoss() {
        if (getActivity() instanceof FightMonstersActivity) {
            ((FightMonstersActivity) getActivity()).activateBoss();
        }
    }
}