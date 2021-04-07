package com.rezyfr.dicoding.made.ui.list;

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
public final class MovieListViewModel_Factory implements Factory<MovieListViewModel> {
  private final Provider<MovieUseCase> movieUseCaseProvider;

  public MovieListViewModel_Factory(Provider<MovieUseCase> movieUseCaseProvider) {
    this.movieUseCaseProvider = movieUseCaseProvider;
  }

  @Override
  public MovieListViewModel get() {
    return newInstance(movieUseCaseProvider.get());
  }

  public static MovieListViewModel_Factory create(Provider<MovieUseCase> movieUseCaseProvider) {
    return new MovieListViewModel_Factory(movieUseCaseProvider);
  }

  public static MovieListViewModel newInstance(MovieUseCase movieUseCase) {
    return new MovieListViewModel(movieUseCase);
  }
}
