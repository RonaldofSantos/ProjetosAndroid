package com.example.revisaohj;

import android.os.Parcel;
import android.os.Parcelable;

public class Pessoa  implements Parcelable {
   String nome;
   String email;
    String idade;
   String cpf;
   public Pessoa(String nome,String email,String idade,String cpf){
        this.nome=nome;
        this.email=email;
        this.idade=idade;
        this.cpf=cpf;


   }
   public Pessoa(){

   }


    protected Pessoa(Parcel in) {
        nome = in.readString();
        email = in.readString();
        idade = in.readString();
        cpf = in.readString();
    }

    public static final Creator<Pessoa> CREATOR = new Creator<Pessoa>() {
        @Override
        public Pessoa createFromParcel(Parcel in) {
            return new Pessoa(in);
        }

        @Override
        public Pessoa[] newArray(int size) {
            return new Pessoa[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(email);
        dest.writeString(idade);
        dest.writeString(cpf);
    }
}
