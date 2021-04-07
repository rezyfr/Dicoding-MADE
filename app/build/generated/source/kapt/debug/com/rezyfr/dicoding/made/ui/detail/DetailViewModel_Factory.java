package com.rezyfr.dicoding.made.ui.detail;

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
public final class DetailViewModel_Factory implements Factory<DetailViewModel> {
  private final Provider<MovieUseCase> useCaseProvider;

  public DetailViewModel_Factory(Provider<MovieUseCase> useCaseProvider) {
    this.useCaseProvider = useCaseProvider;
  }

  @Override
  public DetailViewModel get() {
    return newInstance(useCaseProvider.get());
  }

  public static DetailViewModel_Factory create(Provider<MovieUseCase> useCaseProvider) {
    return new DetailViewModel_Factory(useCaseProvider);
  }

  public static DetailViewModel newInstance(MovieUseCase useCase) {
    return new DetailViewModel(useCase);
  }
}
