package com.example.android.sunshine.ui.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.android.sunshine.data.SunshineRepository;
import com.example.android.sunshine.data.database.ListViewWeatherEntry;
import com.example.android.sunshine.utilities.SunshineDateUtils;

import java.util.Date;
import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private SunshineRepository mRepository;
    private Date mDate;

    MainActivityViewModel(SunshineRepository repository) {
        mRepository = repository;
        mDate = SunshineDateUtils.getNormalizedUtcDateForToday();
    }

    public LiveData<List<ListViewWeatherEntry>> getForecasts() {
        return mRepository.getForecastsFromDate(mDate);
    }
}
