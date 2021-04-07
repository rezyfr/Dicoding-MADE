package com.rezyfr.dicoding.made;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rezyfr.dicoding.made.databinding.ActivityMainBindingImpl;
import com.rezyfr.dicoding.made.databinding.FragmentDetailBindingImpl;
import com.rezyfr.dicoding.made.databinding.FragmentHomeBindingImpl;
import com.rezyfr.dicoding.made.databinding.FragmentSearchBindingImpl;
import com.rezyfr.dicoding.made.databinding.ItemMovieGridLayoutBindingImpl;
import com.rezyfr.dicoding.made.databinding.ItemMovieLayoutBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;

@Generated("Android Data Binding")
public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYMAIN = 1;

  private static final int LAYOUT_FRAGMENTDETAIL = 2;

  private static final int LAYOUT_FRAGMENTHOME = 3;

  private static final int LAYOUT_FRAGMENTSEARCH = 4;

  private static final int LAYOUT_ITEMMOVIEGRIDLAYOUT = 5;

  private static final int LAYOUT_ITEMMOVIELAYOUT = 6;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(6);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.rezyfr.dicoding.made.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.rezyfr.dicoding.made.R.layout.fragment_detail, LAYOUT_FRAGMENTDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.rezyfr.dicoding.made.R.layout.fragment_home, LAYOUT_FRAGMENTHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.rezyfr.dicoding.made.R.layout.fragment_search, LAYOUT_FRAGMENTSEARCH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.rezyfr.dicoding.made.R.layout.item_movie_grid_layout, LAYOUT_ITEMMOVIEGRIDLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.rezyfr.dicoding.made.R.layout.item_movie_layout, LAYOUT_ITEMMOVIELAYOUT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTDETAIL: {
          if ("layout/fragment_detail_0".equals(tag)) {
            return new FragmentDetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_detail is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHOME: {
          if ("layout/fragment_home_0".equals(tag)) {
            return new FragmentHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_home is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSEARCH: {
          if ("layout/fragment_search_0".equals(tag)) {
            return new FragmentSearchBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_search is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMMOVIEGRIDLAYOUT: {
          if ("layout/item_movie_grid_layout_0".equals(tag)) {
            return new ItemMovieGridLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_movie_grid_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMMOVIELAYOUT: {
          if ("layout/item_movie_layout_0".equals(tag)) {
            return new ItemMovieLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_movie_layout is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(2);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    result.add(new com.rezyfr.dicoding.core.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(2);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "movie");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(6);

    static {
      sKeys.put("layout/activity_main_0", com.rezyfr.dicoding.made.R.layout.activity_main);
      sKeys.put("layout/fragment_detail_0", com.rezyfr.dicoding.made.R.layout.fragment_detail);
      sKeys.put("layout/fragment_home_0", com.rezyfr.dicoding.made.R.layout.fragment_home);
      sKeys.put("layout/fragment_search_0", com.rezyfr.dicoding.made.R.layout.fragment_search);
      sKeys.put("layout/item_movie_grid_layout_0", com.rezyfr.dicoding.made.R.layout.item_movie_grid_layout);
      sKeys.put("layout/item_movie_layout_0", com.rezyfr.dicoding.made.R.layout.item_movie_layout);
    }
  }
}
