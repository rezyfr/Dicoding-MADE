package com.rezyfr.dicoding.made.databinding;
import com.rezyfr.dicoding.made.R;
import com.rezyfr.dicoding.made.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class FragmentDetailBindingImpl extends FragmentDetailBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.container_backdrop, 7);
        sViewsWithIds.put(R.id.btn_back, 8);
        sViewsWithIds.put(R.id.container_header, 9);
        sViewsWithIds.put(R.id.tv_genre, 10);
        sViewsWithIds.put(R.id.btn_favorite, 11);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentDetailBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private FragmentDetailBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageButton) bindings[8]
            , (android.widget.ImageButton) bindings[11]
            , (android.widget.RelativeLayout) bindings[7]
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.RatingBar) bindings[4]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[2]
            );
        this.ivBackdrop.setTag(null);
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.ratingBar.setTag(null);
        this.tvDate.setTag(null);
        this.tvLang.setTag(null);
        this.tvOverview.setTag(null);
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
        float movieVoteAverageFloatValue = 0f;
        java.lang.String movieOriginalLanguage = null;
        java.lang.String movieTitle = null;
        java.lang.String movieReleaseDate = null;
        java.lang.String movieBackdropImage = null;
        com.rezyfr.dicoding.core.domain.model.Movie movie = mMovie;
        java.lang.String movieOverview = null;
        java.lang.Double movieVoteAverage = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (movie != null) {
                    // read movie.originalLanguage
                    movieOriginalLanguage = movie.getOriginalLanguage();
                    // read movie.title
                    movieTitle = movie.getTitle();
                    // read movie.releaseDate
                    movieReleaseDate = movie.getReleaseDate();
                    // read movie.backdropImage
                    movieBackdropImage = movie.getBackdropImage();
                    // read movie.overview
                    movieOverview = movie.getOverview();
                    // read movie.voteAverage
                    movieVoteAverage = movie.getVoteAverage();
                }


                if (movieVoteAverage != null) {
                    // read movie.voteAverage.floatValue()
                    movieVoteAverageFloatValue = movieVoteAverage.floatValue();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.rezyfr.dicoding.core.utils.BindingUtilsKt.loadImageUrl(this.ivBackdrop, movieBackdropImage);
            androidx.databinding.adapters.RatingBarBindingAdapter.setRating(this.ratingBar, movieVoteAverageFloatValue);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvDate, movieReleaseDate);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvLang, movieOriginalLanguage);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvOverview, movieOverview);
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