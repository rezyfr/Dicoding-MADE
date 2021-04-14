package com.rezyfr.dicoding.made.ui.home;

import com.rezyfr.dicoding.core.domain.usecase.MovieUseCase;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<MovieUseCase> movieUseCaseProvider;

  public HomeViewModel_Factory(Provider<MovieUseCase> movieUseCaseProvider) {
    this.movieUseCaseProvider = movieUseCaseProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(movieUseCaseProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<MovieUseCase> movieUseCaseProvider) {
    return new HomeViewModel_Factory(movieUseCaseProvider);
  }

  public static HomeViewModel newInstance(MovieUseCase movieUseCase) {
    return new HomeViewModel(movieUseCase);
  }
}
