package com.rezyfr.dicoding.made.ui;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MainViewModel_Factory implements Factory<MainViewModel> {
  @Override
  public MainViewModel get() {
    return newInstance();
  }

  public static MainViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static MainViewModel newInstance() {
    return new MainViewModel();
  }

  private static final class InstanceHolder {
    private static final MainViewModel_Factory INSTANCE = new MainViewModel_Factory();
  }
}
