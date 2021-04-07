package com.rezyfr.dicoding.made.databinding;
import com.rezyfr.dicoding.made.R;
import com.rezyfr.dicoding.made.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ItemMovieLayoutBindingImpl extends ItemMovieLayoutBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.iv_poster_alpha, 6);
    }
    // views
    @NonNull
    private final com.google.android.material.card.MaterialCardView mboundView0;
    @NonNull
    private final android.widget.TextView mboundView5;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemMovieLayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private ItemMovieLayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.imageview.ShapeableImageView) bindings[1]
            , (com.google.android.material.imageview.ShapeableImageView) bindings[6]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            );
        this.ivPoster.setTag(null);
        this.mboundView0 = (com.google.android.material.card.MaterialCardView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView5 = (android.widget.TextView) bindings[5];
        this.mboundView5.setTag(null);
        this.tvDate.setTag(null);
        this.tvLang.setTag(null);
        this.tvTitle.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.movie == variableId) {
            setMovie((com.rezyfr.dicoding.core.domain.model.Movie) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setMovie(@Nullable com.rezyfr.dicoding.core.domain.model.Movie Movie) {
        this.mMovie = Movie;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.movie);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String movieOriginalLanguage = null;
        java.lang.String movieTitle = null;
        java.lang.String movieReleaseDate = null;
        com.rezyfr.dicoding.core.domain.model.Movie movie = mMovie;
        java.lang.String moviePosterImage = null;
        java.lang.String movieVoteAverageToString = null;
        java.lang.Double movieVoteAverage = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (movie != null) {
                    // read movie.originalLanguage
                    movieOriginalLanguage = movie.getOriginalLanguage();
                    // read movie.title
                    movieTitle = movie.getTitle();
                    // read movie.releaseDate
                    movieReleaseDate = movie.getReleaseDate();
                    // read movie.posterImage
                    moviePosterImage = movie.getPosterImage();
                    // read movie.voteAverage
                    movieVoteAverage = movie.getVoteAverage();
                }


                if (movieVoteAverage != null) {
                    // read movie.voteAverage.toString()
                    movieVoteAverageToString = movieVoteAverage.toString();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.rezyfr.dicoding.core.utils.BindingUtilsKt.loadShapeableImageUrl(this.ivPoster, moviePosterImage);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, movieVoteAverageToString);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvDate, movieReleaseDate);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvLang, movieOriginalLanguage);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvTitle, movieTitle);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): movie
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}