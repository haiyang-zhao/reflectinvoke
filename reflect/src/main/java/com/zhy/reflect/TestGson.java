package com.zhy.reflect;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TestGson {
    static class Response<T> {
        T data;
        String code;
        String message;

        public Response(T data, String code, String message) {
            this.data = data;
            this.code = code;
            this.message = message;
        }

        @Override
        public String toString() {
            return "Response{" +
                    "data=" + data +
                    ", code='" + code + '\'' +
                    ", message='" + message + '\'' +
                    '}';
        }
    }

    static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    static class TypeReference<T> {
        public Type getType() {
            ParameterizedType pType = (ParameterizedType) getClass().getGenericSuperclass();
            return pType.getActualTypeArguments()[0];
        }
    }

    public static void main(String[] args) {
        Response<Person> response = new Response<>(new Person("张三"), "OK", "success");
        Gson gson = new Gson();
        String json = gson.toJson(response);
        System.out.println(json);
        Type typeToken = new TypeReference<Response<Person>>() {
        }.getType();
        Response<Person> resp = gson.fromJson(json, typeToken);
        System.out.println(resp);
    }
}