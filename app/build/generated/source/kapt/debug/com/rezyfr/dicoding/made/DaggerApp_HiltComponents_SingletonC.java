package com.rezyfr.dicoding.made;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.hilt.lifecycle.ViewModelFactoryModules_ActivityModule_ProvideFactoryFactory;
import androidx.hilt.lifecycle.ViewModelFactoryModules_FragmentModule_ProvideFactoryFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.rezyfr.dicoding.core.data.source.local.LocalDataSource;
import com.rezyfr.dicoding.core.data.source.local.room.AppDatabase;
import com.rezyfr.dicoding.core.data.source.local.room.MovieDao;
import com.rezyfr.dicoding.core.data.source.remote.RemoteDataSource;
import com.rezyfr.dicoding.core.data.source.remote.network.TmdbService;
import com.rezyfr.dicoding.core.data.source.repository.MovieRepository;
import com.rezyfr.dicoding.core.di.DatabaseModule;
import com.rezyfr.dicoding.core.di.DatabaseModule_ProvideAppDatabaseFactory;
import com.rezyfr.dicoding.core.di.DatabaseModule_ProvideMovieDaoFactory;
import com.rezyfr.dicoding.core.di.NetworkModule;
import com.rezyfr.dicoding.core.di.NetworkModule_ProvideApiServiceFactory;
import com.rezyfr.dicoding.core.di.NetworkModule_ProvideHeaderInterceptorFactory;
import com.rezyfr.dicoding.core.di.NetworkModule_ProvideOkHttpClientFactory;
import com.rezyfr.dicoding.core.domain.usecase.MovieUseCase;
import com.rezyfr.dicoding.made.di.AppModule;
import com.rezyfr.dicoding.made.di.AppModule_ProvideUseCaseFactory;
import com.rezyfr.dicoding.made.ui.MainActivity;
import com.rezyfr.dicoding.made.ui.MainViewModel;
import com.rezyfr.dicoding.made.ui.MainViewModel_HiltModules_KeyModule_ProvideFactory;
import com.rezyfr.dicoding.made.ui.detail.DetailFragment;
import com.rezyfr.dicoding.made.ui.detail.DetailViewModel;
import com.rezyfr.dicoding.made.ui.detail.DetailViewModel_HiltModules_KeyModule_ProvideFactory;
import com.rezyfr.dicoding.made.ui.home.HomeFragment;
import com.rezyfr.dicoding.made.ui.home.HomeViewModel;
import com.rezyfr.dicoding.made.ui.home.HomeViewModel_HiltModules_KeyModule_ProvideFactory;
import com.rezyfr.dicoding.made.ui.search.SearchFragment;
import com.rezyfr.dicoding.made.ui.search.SearchViewModel;
import com.rezyfr.dicoding.made.ui.search.SearchViewModel_HiltModules_KeyModule_ProvideFactory;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_Lifecycle_Factory;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideApplicationFactory;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.MemoizedSentinel;
import dagger.internal.Preconditions;
import java.util.Map;
import java.util.Set;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerApp_HiltComponents_SingletonC extends App_HiltComponents.SingletonC {
  private final ApplicationContextModule applicationContextModule;

  private volatile Object remoteDataSource = new MemoizedSentinel();

  private volatile Object appDatabase = new MemoizedSentinel();

  private volatile Object movieDao = new MemoizedSentinel();

  private volatile Object localDataSource = new MemoizedSentinel();

  private volatile Object movieRepository = new MemoizedSentinel();

  private DaggerApp_HiltComponents_SingletonC(
      ApplicationContextModule applicationContextModuleParam) {
    this.applicationContextModule = applicationContextModuleParam;
  }

  public static Builder builder() {
    return new Builder();
  }

  private OkHttpClient okHttpClient() {
    return NetworkModule_ProvideOkHttpClientFactory.provideOkHttpClient(NetworkModule_ProvideHeaderInterceptorFactory.provideHeaderInterceptor());
  }

  private TmdbService tmdbService() {
    return NetworkModule_ProvideApiServiceFactory.provideApiService(okHttpClient());
  }

  private RemoteDataSource remoteDataSource() {
    Object local = remoteDataSource;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = remoteDataSource;
        if (local instanceof MemoizedSentinel) {
          local = new RemoteDataSource(tmdbService());
          remoteDataSource = DoubleCheck.reentrantCheck(remoteDataSource, local);
        }
      }
    }
    return (RemoteDataSource) local;
  }

  private AppDatabase appDatabase() {
    Object local = appDatabase;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = appDatabase;
        if (local instanceof MemoizedSentinel) {
          local = DatabaseModule_ProvideAppDatabaseFactory.provideAppDatabase(ApplicationContextModule_ProvideContextFactory.provideContext(applicationContextModule));
          appDatabase = DoubleCheck.reentrantCheck(appDatabase, local);
        }
      }
    }
    return (AppDatabase) local;
  }

  private MovieDao movieDao() {
    Object local = movieDao;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = movieDao;
        if (local instanceof MemoizedSentinel) {
          local = DatabaseModule_ProvideMovieDaoFactory.provideMovieDao(appDatabase());
          movieDao = DoubleCheck.reentrantCheck(movieDao, local);
        }
      }
    }
    return (MovieDao) local;
  }

  private LocalDataSource localDataSource() {
    Object local = localDataSource;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = localDataSource;
        if (local instanceof MemoizedSentinel) {
          local = new LocalDataSource(movieDao());
          localDataSource = DoubleCheck.reentrantCheck(localDataSource, local);
        }
      }
    }
    return (LocalDataSource) local;
  }

  private MovieRepository movieRepository() {
    Object local = movieRepository;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = movieRepository;
        if (local instanceof MemoizedSentinel) {
          local = new MovieRepository(remoteDataSource(), localDataSource());
          movieRepository = DoubleCheck.reentrantCheck(movieRepository, local);
        }
      }
    }
    return (MovieRepository) local;
  }

  private MovieUseCase movieUseCase() {
    return AppModule_ProvideUseCaseFactory.provideUseCase(movieRepository());
  }

  @Override
  public void injectApp(App app) {
  }

  @Override
  public ActivityRetainedComponentBuilder retainedComponentBuilder() {
    return new ActivityRetainedCBuilder();
  }

  @Override
  public ServiceComponentBuilder serviceComponentBuilder() {
    return new ServiceCBuilder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder appModule(AppModule appModule) {
      Preconditions.checkNotNull(appModule);
      return this;
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder databaseModule(DatabaseModule databaseModule) {
      Preconditions.checkNotNull(databaseModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder networkModule(NetworkModule networkModule) {
      Preconditions.checkNotNull(networkModule);
      return this;
    }

    public App_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new DaggerApp_HiltComponents_SingletonC(applicationContextModule);
    }
  }

  private final class ActivityRetainedCBuilder implements App_HiltComponents.ActivityRetainedC.Builder {
    @Override
    public App_HiltComponents.ActivityRetainedC build() {
      return new ActivityRetainedCImpl();
    }
  }

  private final class ActivityRetainedCImpl extends App_HiltComponents.ActivityRetainedC {
    private volatile Object lifecycle = new MemoizedSentinel();

    private ActivityRetainedCImpl() {

    }

    private Object lifecycle() {
      Object local = lifecycle;
      if (local instanceof MemoizedSentinel) {
        synchronized (local) {
          local = lifecycle;
          if (local instanceof MemoizedSentinel) {
            local = ActivityRetainedComponentManager_Lifecycle_Factory.newInstance();
            lifecycle = DoubleCheck.reentrantCheck(lifecycle, local);
          }
        }
      }
      return (Object) local;
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder();
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return (ActivityRetainedLifecycle) lifecycle();
    }

    private final class ActivityCBuilder implements App_HiltComponents.ActivityC.Builder {
      private Activity activity;

      @Override
      public ActivityCBuilder activity(Activity activity) {
        this.activity = Preconditions.checkNotNull(activity);
        return this;
      }

      @Override
      public App_HiltComponents.ActivityC build() {
        Preconditions.checkBuilderRequirement(activity, Activity.class);
        return new ActivityCImpl(activity);
      }
    }

    private final class ActivityCImpl extends App_HiltComponents.ActivityC {
      private final Activity activity;

      private ActivityCImpl(Activity activityParam) {
        this.activity = activityParam;
      }

      private Set<String> keySetSetOfString() {
        return ImmutableSet.<String>of(DetailViewModel_HiltModules_KeyModule_ProvideFactory.provide(), HomeViewModel_HiltModules_KeyModule_ProvideFactory.provide(), MainViewModel_HiltModules_KeyModule_ProvideFactory.provide(), SearchViewModel_HiltModules_KeyModule_ProvideFactory.provide());
      }

      private ViewModelProvider.Factory provideFactory() {
        return ViewModelFactoryModules_ActivityModule_ProvideFactoryFactory.provideFactory(activity, ApplicationContextModule_ProvideApplicationFactory.provideApplication(DaggerApp_HiltComponents_SingletonC.this.applicationContextModule), ImmutableMap.<String, Provider<ViewModelAssistedFactory<? extends ViewModel>>>of());
      }

      private Set<ViewModelProvider.Factory> defaultActivityViewModelFactorySetOfViewModelProviderFactory(
          ) {
        return ImmutableSet.<ViewModelProvider.Factory>of(provideFactory());
      }

      @Override
      public void injectMainActivity(MainActivity mainActivity) {
      }

      @Override
      public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
        return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(ApplicationContextModule_ProvideApplicationFactory.provideApplication(DaggerApp_HiltComponents_SingletonC.this.applicationContextModule), keySetSetOfString(), new ViewModelCBuilder(), defaultActivityViewModelFactorySetOfViewModelProviderFactory(), ImmutableSet.<ViewModelProvider.Factory>of());
      }

      @Override
      public FragmentComponentBuilder fragmentComponentBuilder() {
        return new FragmentCBuilder();
      }

      @Override
      public ViewComponentBuilder viewComponentBuilder() {
        return new ViewCBuilder();
      }

      private final class FragmentCBuilder implements App_HiltComponents.FragmentC.Builder {
        private Fragment fragment;

        @Override
        public FragmentCBuilder fragment(Fragment fragment) {
          this.fragment = Preconditions.checkNotNull(fragment);
          return this;
        }

        @Override
        public App_HiltComponents.FragmentC build() {
          Preconditions.checkBuilderRequirement(fragment, Fragment.class);
          return new FragmentCImpl(fragment);
        }
      }

      private final class FragmentCImpl extends App_HiltComponents.FragmentC {
        private final Fragment fragment;

        private FragmentCImpl(Fragment fragmentParam) {
          this.fragment = fragmentParam;
        }

        private ViewModelProvider.Factory provideFactory() {
          return ViewModelFactoryModules_FragmentModule_ProvideFactoryFactory.provideFactory(fragment, ApplicationContextModule_ProvideApplicationFactory.provideApplication(DaggerApp_HiltComponents_SingletonC.this.applicationContextModule), ImmutableMap.<String, Provider<ViewModelAssistedFactory<? extends ViewModel>>>of());
        }

        private Set<ViewModelProvider.Factory> defaultFragmentViewModelFactorySetOfViewModelProviderFactory(
            ) {
          return ImmutableSet.<ViewModelProvider.Factory>of(provideFactory());
        }

        @Override
        public void injectDetailFragment(DetailFragment detailFragment) {
        }

        @Override
        public void injectHomeFragment(HomeFragment homeFragment) {
        }

        @Override
        public void injectSearchFragment(SearchFragment searchFragment) {
        }

        @Override
        public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
          return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(ApplicationContextModule_ProvideApplicationFactory.provideApplication(DaggerApp_HiltComponents_SingletonC.this.applicationContextModule), ActivityCImpl.this.keySetSetOfString(), new ViewModelCBuilder(), ActivityCImpl.this.defaultActivityViewModelFactorySetOfViewModelProviderFactory(), defaultFragmentViewModelFactorySetOfViewModelProviderFactory());
        }

        @Override
        public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
          return new ViewWithFragmentCBuilder();
        }

        private final class ViewWithFragmentCBuilder implements App_HiltComponents.ViewWithFragmentC.Builder {
          private View view;

          @Override
          public ViewWithFragmentCBuilder view(View view) {
            this.view = Preconditions.checkNotNull(view);
            return this;
          }

          @Override
          public App_HiltComponents.ViewWithFragmentC build() {
            Preconditions.checkBuilderRequirement(view, View.class);
            return new ViewWithFragmentCImpl(view);
          }
        }

        private final class ViewWithFragmentCImpl extends App_HiltComponents.ViewWithFragmentC {
          private ViewWithFragmentCImpl(View view) {

          }
        }
      }

      private final class ViewCBuilder implements App_HiltComponents.ViewC.Builder {
        private View view;

        @Override
        public ViewCBuilder view(View view) {
          this.view = Preconditions.checkNotNull(view);
          return this;
        }

        @Override
        public App_HiltComponents.ViewC build() {
          Preconditions.checkBuilderRequirement(view, View.class);
          return new ViewCImpl(view);
        }
      }

      private final class ViewCImpl extends App_HiltComponents.ViewC {
        private ViewCImpl(View view) {

        }
      }
    }

    private final class ViewModelCBuilder implements App_HiltComponents.ViewModelC.Builder {
      private SavedStateHandle savedStateHandle;

      @Override
      public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
        this.savedStateHandle = Preconditions.checkNotNull(handle);
        return this;
      }

      @Override
      public App_HiltComponents.ViewModelC build() {
        Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
        return new ViewModelCImpl(savedStateHandle);
      }
    }

    private final class ViewModelCImpl extends App_HiltComponents.ViewModelC {
      private volatile Provider<DetailViewModel> detailViewModelProvider;

      private volatile Provider<HomeViewModel> homeViewModelProvider;

      private volatile Provider<MainViewModel> mainViewModelProvider;

      private volatile Provider<SearchViewModel> searchViewModelProvider;

      private ViewModelCImpl(SavedStateHandle savedStateHandle) {

      }

      private DetailViewModel detailViewModel() {
        return new DetailViewModel(DaggerApp_HiltComponents_SingletonC.this.movieUseCase());
      }

      private Provider<DetailViewModel> detailViewModelProvider() {
        Object local = detailViewModelProvider;
        if (local == null) {
          local = new SwitchingProvider<>(0);
          detailViewModelProvider = (Provider<DetailViewModel>) local;
        }
        return (Provider<DetailViewModel>) local;
      }

      private HomeViewModel homeViewModel() {
        return new HomeViewModel(DaggerApp_HiltComponents_SingletonC.this.movieUseCase());
      }

      private Provider<HomeViewModel> homeViewModelProvider() {
        Object local = homeViewModelProvider;
        if (local == null) {
          local = new SwitchingProvider<>(1);
          homeViewModelProvider = (Provider<HomeViewModel>) local;
        }
        return (Provider<HomeViewModel>) local;
      }

      private Provider<MainViewModel> mainViewModelProvider() {
        Object local = mainViewModelProvider;
        if (local == null) {
          local = new SwitchingProvider<>(2);
          mainViewModelProvider = (Provider<MainViewModel>) local;
        }
        return (Provider<MainViewModel>) local;
      }

      private SearchViewModel searchViewModel() {
        return new SearchViewModel(DaggerApp_HiltComponents_SingletonC.this.movieUseCase());
      }

      private Provider<SearchViewModel> searchViewModelProvider() {
        Object local = searchViewModelProvider;
        if (local == null) {
          local = new SwitchingProvider<>(3);
          searchViewModelProvider = (Provider<SearchViewModel>) local;
        }
        return (Provider<SearchViewModel>) local;
      }

      @Override
      public Map<String, Provider<ViewModel>> getHiltViewModelMap() {
        return ImmutableMap.<String, Provider<ViewModel>>of("com.rezyfr.dicoding.made.ui.detail.DetailViewModel", (Provider) detailViewModelProvider(), "com.rezyfr.dicoding.made.ui.home.HomeViewModel", (Provider) homeViewModelProvider(), "com.rezyfr.dicoding.made.ui.MainViewModel", (Provider) mainViewModelProvider(), "com.rezyfr.dicoding.made.ui.search.SearchViewModel", (Provider) searchViewModelProvider());
      }

      private final class SwitchingProvider<T> implements Provider<T> {
        private final int id;

        SwitchingProvider(int id) {
          this.id = id;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T get() {
          switch (id) {
            case 0: // com.rezyfr.dicoding.made.ui.detail.DetailViewModel 
            return (T) ViewModelCImpl.this.detailViewModel();

            case 1: // com.rezyfr.dicoding.made.ui.home.HomeViewModel 
            return (T) ViewModelCImpl.this.homeViewModel();

            case 2: // com.rezyfr.dicoding.made.ui.MainViewModel 
            return (T) new MainViewModel();

            case 3: // com.rezyfr.dicoding.made.ui.search.SearchViewModel 
            return (T) ViewModelCImpl.this.searchViewModel();

            default: throw new AssertionError(id);
          }
        }
      }
    }
  }

  private final class ServiceCBuilder implements App_HiltComponents.ServiceC.Builder {
    private Service service;

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public App_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(service);
    }
  }

  private final class ServiceCImpl extends App_HiltComponents.ServiceC {
    private ServiceCImpl(Service service) {

    }
  }
}
