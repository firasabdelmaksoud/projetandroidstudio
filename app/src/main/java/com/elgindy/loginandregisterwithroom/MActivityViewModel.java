package com.elgindy.loginandregisterwithroom;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.elgindy.loginandregisterwithroom.Data.UserDataBase;
import com.elgindy.loginandregisterwithroom.Data.favoris;
import java.util.List;

public class MActivityViewModel extends AndroidViewModel {

    private MutableLiveData<List<favoris>> Listoffavoris;
    private UserDataBase appDatabase;

    public MActivityViewModel(Application application) {

        super(application);
        Listoffavoris = new MutableLiveData<>();

        appDatabase = UserDataBase.getDBINSTANCE(getApplication().getApplicationContext());

    }

    public MutableLiveData<List<favoris>> getfavorisListObserver() {
        return Listoffavoris;
    }

    public void getAllfavorisList() {

        List<favoris> favorisList = appDatabase.favorisListDao().getAllfavorisList();
        if (favorisList.size() > 0) {
            Listoffavoris.postValue(favorisList);

        } else {
            Listoffavoris.postValue(null);

        }
    }
        public void insertfavoris (String fname)
        {
            favoris f = new favoris();
            f.favorisName = fname;
            appDatabase.favorisListDao().insertfavoris(f);
            getAllfavorisList();
        }
        public void updatefavoris (favoris f)
        {
            appDatabase.favorisListDao().updatefavoris(f);
            getAllfavorisList();
        }
        public void deletefavoris (favoris f)
        {
            appDatabase.favorisListDao().deletefavoris(f);
            getAllfavorisList();
        }



}