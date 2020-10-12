package com.zhy.reflectinvoke;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.zhy.reflectinvoke.inject.BindView;
import com.zhy.reflectinvoke.inject.InjectUtils;
import com.zhy.reflectinvoke.model.Person;
import com.zhy.reflectinvoke.model.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.tv_text)
    TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InjectUtils.injectView(this);
        tvText.setText("Hello BindView.......");
        tvText.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("name", "张三");

        User user = new User("User_zhy", 32);
        intent.putExtra("user", user);

        Person person = new Person("Person_zhy");
        intent.putExtra("person", person);

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        intent.putExtra("userList", userList);

        User[] users = new User[]{user};
        intent.putExtra("users", users);

        ArrayList<Person> personList = new ArrayList<>();
        personList.add(person);
        intent.putExtra("personList", personList);

        Person[] persons = new Person[]{person};
        intent.putExtra("persons", persons);

        startActivity(intent);
    }
}