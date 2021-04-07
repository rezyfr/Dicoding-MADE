package com.rezyfr.dicoding.made.ui.search;

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
public final class SearchViewModel_Factory implements Factory<SearchViewModel> {
  private final Provider<MovieUseCase> movieUseCaseProvider;

  public SearchViewModel_Factory(Provider<MovieUseCase> movieUseCaseProvider) {
    this.movieUseCaseProvider = movieUseCaseProvider;
  }

  @Override
  public SearchViewModel get() {
    return newInstance(movieUseCaseProvider.get());
  }

  public static SearchViewModel_Factory create(Provider<MovieUseCase> movieUseCaseProvider) {
    return new SearchViewModel_Factory(movieUseCaseProvider);
  }

  public static SearchViewModel newInstance(MovieUseCase movieUseCase) {
    return new SearchViewModel(movieUseCase);
  }
}
