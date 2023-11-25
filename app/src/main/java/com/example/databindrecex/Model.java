package com.example.databindrecex;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Model extends BaseObservable {
    String name,age;
    int image;

    public Model(String name, String age, int image) {
        this.name = name;
        this.age = age;
        this.image = image;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    @Bindable public int getImage() {

        return image;
    }

    public void setImage(int image) {
        this.image = image;
        notifyPropertyChanged(BR.image);
    }
}
