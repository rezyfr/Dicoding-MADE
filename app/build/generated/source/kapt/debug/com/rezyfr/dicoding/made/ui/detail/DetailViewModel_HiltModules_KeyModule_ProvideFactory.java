package com.rezyfr.dicoding.made.ui.detail;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DetailViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
  @Override
  public String get() {
    return provide();
  }

  public static DetailViewModel_HiltModules_KeyModule_ProvideFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static String provide() {
    return Preconditions.checkNotNullFromProvides(DetailViewModel_HiltModules.KeyModule.provide());
  }

  private static final class InstanceHolder {
    private static final DetailViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new DetailViewModel_HiltModules_KeyModule_ProvideFactory();
  }
}
