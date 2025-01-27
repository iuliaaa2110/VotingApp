package ro.unibuc.votingapp.presentation.view.databinding;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ro.unibuc.votingapp.presentation.VotingAppViewModel;


public final class VoteBindingAdapter {
    @BindingAdapter ( "pollsAdapter" )
    public static void recycleViewSetLocationAdapter( RecyclerView mRecyclerViewGames, LocationAdapter locationAdapter ) {
        if ( mRecyclerViewGames.getAdapter() == null ) {
            // set the adapter to the recycler view
            mRecyclerViewGames.setAdapter( locationAdapter );
            // define and set layout manager
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( mRecyclerViewGames.getContext() );
            mRecyclerViewGames.setLayoutManager( layoutManager );
        }
    }

    @BindingAdapter ( "pollsAdapter" )
    public static void recycleViewSetNewsAdapter( RecyclerView mRecyclerViewGames, NewsAdapter newsAdapter ) {
        if ( mRecyclerViewGames.getAdapter() == null ) {
            // set the adapter to the recycler view
            mRecyclerViewGames.setAdapter( newsAdapter );
            // define and set layout manager
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( mRecyclerViewGames.getContext() );
            mRecyclerViewGames.setLayoutManager( layoutManager );
        }
    }

    @BindingAdapter ( "pollsAdapter" )
    public static void recycleViewSetAlegereAdapter( RecyclerView mRecyclerViewGames, AlegereAdapter alegereAdapter ) {
        if ( mRecyclerViewGames.getAdapter() == null ) {
            // set the adapter to the recycler view
            mRecyclerViewGames.setAdapter( alegereAdapter );
            // define and set layout manager
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( mRecyclerViewGames.getContext() );
            mRecyclerViewGames.setLayoutManager( layoutManager );
        }
    }

    @BindingAdapter ( "pollsAdapter" )
    public static void recycleViewSetCandidatAdapter( RecyclerView mRecyclerViewGames, CandidatAdapter candidatAdapter ) {
        if ( mRecyclerViewGames.getAdapter() == null ) {
            // set the adapter to the recycler view
            mRecyclerViewGames.setAdapter( candidatAdapter );
            // define and set layout manager
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( mRecyclerViewGames.getContext() );
            mRecyclerViewGames.setLayoutManager( layoutManager );
        }
    }

    @BindingAdapter ( { "VoteViewModel" } )
    public static void recycleViewLocationBinding( RecyclerView mRecyclerViewGames, VotingAppViewModel votingAppViewModel ) {
        votingAppViewModel.getLocatii().observeForever( locatii -> {
            LocationAdapter locationAdapter = ( LocationAdapter ) mRecyclerViewGames.getAdapter();
            if ( locationAdapter != null )
                locationAdapter.setGames( locatii );
        } );
    }

    @BindingAdapter ( { "VoteViewModel"} )
    public static void recycleViewNewsBinding( RecyclerView mRecyclerViewGames, VotingAppViewModel votingAppViewModel) {
        votingAppViewModel.getStiri().observeForever( stiri -> {
            NewsAdapter newsAdapter = ( NewsAdapter ) mRecyclerViewGames.getAdapter();
            if ( newsAdapter != null )
                newsAdapter.setGames( stiri );
        } );
    }

    @BindingAdapter ( { "VoteViewModel", "location", "tip" } )
    public static void recycleViewAlegereBinding( RecyclerView mRecyclerViewGames, VotingAppViewModel votingAppViewModel, @NonNull String locationId, @NonNull String tip ) {
        votingAppViewModel.getAlegeri( locationId, tip ).observeForever( alegeri -> {
            //suntem siguri ca adaptorul nostru este de tipul GameAdapter
            AlegereAdapter alegereAdapter = ( AlegereAdapter ) mRecyclerViewGames.getAdapter();
            if ( alegereAdapter != null )
                alegereAdapter.setGames( alegeri );
        } );
    }

    @BindingAdapter ( { "VoteViewModel", "tip", "idAlegere" } )
    public static void recycleViewCandidatBinding( RecyclerView mRecyclerViewGames, VotingAppViewModel votingAppViewModel, @NonNull String tip, @NonNull String idAlegere ) {
        votingAppViewModel.getCandidati( idAlegere ).observeForever( candidati -> {
            //suntem siguri ca adaptorul nostru este de tipul GameAdapter
            CandidatAdapter candidatAdapter = ( CandidatAdapter ) mRecyclerViewGames.getAdapter();
            if ( candidatAdapter != null )
                candidatAdapter.setGames( candidati );
        } );
    }
}
