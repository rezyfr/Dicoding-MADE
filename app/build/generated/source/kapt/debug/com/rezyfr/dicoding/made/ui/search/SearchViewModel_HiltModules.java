package com.rezyfr.dicoding.made.ui.search;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.internal.lifecycle.HiltViewModelMap;
import dagger.hilt.codegen.OriginatingElement;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;
import java.lang.String;
import javax.annotation.Generated;

@Generated("dagger.hilt.android.processor.internal.viewmodel.ViewModelProcessor")
@OriginatingElement(
    topLevelClass = SearchViewModel.class
)
public final class SearchViewModel_HiltModules {
  private SearchViewModel_HiltModules() {
  }

  @Module
  @InstallIn(ViewModelComponent.class)
  public abstract static class BindsModule {
    @Binds
    @IntoMap
    @StringKey("com.rezyfr.dicoding.made.ui.search.SearchViewModel")
    @HiltViewModelMap
    public abstract ViewModel binds(SearchViewModel vm);
  }

  @Module
  @InstallIn(ActivityRetainedComponent.class)
  public static final class KeyModule {
    private KeyModule() {
    }

    @Provides
    @IntoSet
    @HiltViewModelMap.KeySet
    public static String provide() {
      return "com.rezyfr.dicoding.made.ui.search.SearchViewModel";
    }
  }
}
