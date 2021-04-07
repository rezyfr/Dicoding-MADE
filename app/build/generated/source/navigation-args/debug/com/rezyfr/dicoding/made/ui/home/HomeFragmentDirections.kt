package com.rezyfr.dicoding.made.ui.home

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.rezyfr.dicoding.core.domain.model.Movie
import com.rezyfr.dicoding.made.R
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class HomeFragmentDirections private constructor() {
  private data class ActionHomeFragmentToDetailFragment(
    public val movie: Movie
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_homeFragment_to_detailFragment

    @Suppress("CAST_NEVER_SUCCEEDS")
    public override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(Movie::class.java)) {
        result.putParcelable("movie", this.movie as Parcelable)
      } else if (Serializable::class.java.isAssignableFrom(Movie::class.java)) {
        result.putSerializable("movie", this.movie as Serializable)
      } else {
        throw UnsupportedOperationException(Movie::class.java.name +
            " must implement Parcelable or Serializable or must be an Enum.")
      }
      return result
    }
  }

  public companion object {
    public fun actionHomeFragmentToSearchFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_searchFragment)

    public fun actionHomeFragmentToDetailFragment(movie: Movie): NavDirections =
        ActionHomeFragmentToDetailFragment(movie)
  }
}
