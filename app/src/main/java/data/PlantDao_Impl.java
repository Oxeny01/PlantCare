package data;

import android.database.Cursor;

import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;

import com.example.plantcare.data.PlantDao;
import com.example.plantcare.data.PlantEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class PlantDao_Impl implements PlantDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PlantEntity> __insertionAdapterOfPlantEntity;

  private final EntityDeletionOrUpdateAdapter<PlantEntity> __deletionAdapterOfPlantEntity;

  private final EntityDeletionOrUpdateAdapter<PlantEntity> __updateAdapterOfPlantEntity;

  public PlantDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPlantEntity = new EntityInsertionAdapter<PlantEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `plants` (`id`,`commonName`,`scientificName`,`imageUrl`,`lastWatered`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PlantEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getCommonName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCommonName());
        }
        if (value.getScientificName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getScientificName());
        }
        if (value.getImageUrl() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getImageUrl());
        }
        stmt.bindLong(5, value.getLastWatered());
      }
    };
    this.__deletionAdapterOfPlantEntity = new EntityDeletionOrUpdateAdapter<PlantEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `plants` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PlantEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfPlantEntity = new EntityDeletionOrUpdateAdapter<PlantEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `plants` SET `id` = ?,`commonName` = ?,`scientificName` = ?,`imageUrl` = ?,`lastWatered` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PlantEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getCommonName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCommonName());
        }
        if (value.getScientificName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getScientificName());
        }
        if (value.getImageUrl() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getImageUrl());
        }
        stmt.bindLong(5, value.getLastWatered());
        stmt.bindLong(6, value.getId());
      }
    };
  }

  @Override
  public void insertPlant(final PlantEntity plant) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPlantEntity.insert(plant);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deletePlant(final PlantEntity plant) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPlantEntity.handle(plant);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updatePlant(final PlantEntity plant) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPlantEntity.handle(plant);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<PlantEntity>> getAllPlants() {
    final String _sql = "SELECT * FROM plants";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"plants"}, false, new Callable<List<PlantEntity>>() {
      @Override
      public List<PlantEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCommonName = CursorUtil.getColumnIndexOrThrow(_cursor, "commonName");
          final int _cursorIndexOfScientificName = CursorUtil.getColumnIndexOrThrow(_cursor, "scientificName");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfLastWatered = CursorUtil.getColumnIndexOrThrow(_cursor, "lastWatered");
          final List<PlantEntity> _result = new ArrayList<PlantEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final PlantEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpCommonName;
            if (_cursor.isNull(_cursorIndexOfCommonName)) {
              _tmpCommonName = null;
            } else {
              _tmpCommonName = _cursor.getString(_cursorIndexOfCommonName);
            }
            final String _tmpScientificName;
            if (_cursor.isNull(_cursorIndexOfScientificName)) {
              _tmpScientificName = null;
            } else {
              _tmpScientificName = _cursor.getString(_cursorIndexOfScientificName);
            }
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            _item = new PlantEntity(_tmpId,_tmpCommonName,_tmpScientificName,_tmpImageUrl);
            final long _tmpLastWatered;
            _tmpLastWatered = _cursor.getLong(_cursorIndexOfLastWatered);
            _item.setLastWatered(_tmpLastWatered);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
