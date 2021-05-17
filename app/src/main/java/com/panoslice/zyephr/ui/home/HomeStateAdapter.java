package com.panoslice.zyephr.ui.home;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.panoslice.zyephr.ui.home.books.BookFragment;
import com.panoslice.zyephr.ui.home.form.FormFragment;

public class HomeStateAdapter extends FragmentStateAdapter
{
    public HomeStateAdapter(@NonNull FragmentActivity fragmentActivity)
    {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        Fragment fragment= null;

        switch (position)
        {

            case 0:
                fragment = new BookFragment();
                break;

            case 1:
                fragment = new FormFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
