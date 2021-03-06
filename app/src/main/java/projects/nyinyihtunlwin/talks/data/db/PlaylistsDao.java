package projects.nyinyihtunlwin.talks.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import projects.nyinyihtunlwin.talks.data.vo.PlaylistsVO;
import projects.nyinyihtunlwin.talks.utils.AppConstants;

/**
 * Created by Dell on 1/26/2018.
 */

@Dao
public interface PlaylistsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertPlaylist(PlaylistsVO playlistsVO);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertPlaylists(List<PlaylistsVO> talksList);

    @Query("SELECT * FROM " + AppConstants.TABLE_PLAYLISTS)
    LiveData<List<PlaylistsVO>> getPlaylists();

    @Query("DELETE FROM " + AppConstants.TABLE_PLAYLISTS)
    void deleteAll();
}
