package com.rezyfr.dicoding.made.di;

import com.rezyfr.dicoding.core.data.source.repository.MovieRepository;
import com.rezyfr.dicoding.core.domain.usecase.MovieUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AppModule_ProvideUseCaseFactory implements Factory<MovieUseCase> {
  private final Provider<MovieRepository> repositoryProvider;

  public AppModule_ProvideUseCaseFactory(Provider<MovieRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public MovieUseCase get() {
    return provideUseCase(repositoryProvider.get());
  }

  public static AppModule_ProvideUseCaseFactory create(
      Provider<MovieRepository> repositoryProvider) {
    return new AppModule_ProvideUseCaseFactory(repositoryProvider);
  }

  public static MovieUseCase provideUseCase(MovieRepository repository) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideUseCase(repository));
  }
}
