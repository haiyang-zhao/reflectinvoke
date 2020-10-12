package com.zhy.reflectinvoke;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zhy.reflectinvoke.inject.Autowired;
import com.zhy.reflectinvoke.inject.InjectUtils;
import com.zhy.reflectinvoke.model.Person;
import com.zhy.reflectinvoke.model.User;

import java.util.Arrays;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    @Autowired
    private String name;

    @Autowired
    private User user;

    @Autowired
    private Person person;

    @Autowired
    private List<User> userList;

    @Autowired
    private User[] users;

    @Autowired
    private List<Person> personList;

    @Autowired
    private Person[] persons;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        InjectUtils.injectAutowired(this);

        System.out.println("name : " + name);
        System.out.println("user : " + user);
        System.out.println("person : " + person);
        System.out.println("userList : " + userList);
        System.out.println("users : " + Arrays.toString(users));
        System.out.println("personList : " + personList);
        System.out.println("persons : " + Arrays.toString(persons));
    }
}
