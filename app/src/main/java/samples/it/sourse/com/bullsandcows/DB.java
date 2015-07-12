package samples.it.sourse.com.bullsandcows;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DB implements Constants {

    private static final String DB_NAME = "data_base_record";
    private static final int DB_VERSION = 1;
    private static final String DB_TABLE = "record_players";

    private static final String DB_CREATE = " create table " + DB_TABLE +
            "(" + COLUMN_ID + " integer primary key autoincrement, " + COLUMN_NAME_PLAYER +
            " text, " + COLUMN_NUMBER_COWS + " integer," + COLUMN_NUMBER_BULL +
            " integer" + ");";
    private final Context mCtx;

    private DBHelper mDBHelper;
    private SQLiteDatabase mDB;

    public DB(Context ctx) {
        mCtx = ctx;
    }

    public void open() {
        mDBHelper = new DBHelper(mCtx, DB_NAME, null, DB_VERSION);
        mDB = mDBHelper.getWritableDatabase();
    }

    public void close() {
        if (mDBHelper != null) mDBHelper.close();
    }

    public Cursor getAllData() {
        return mDB.query(DB_TABLE, null, null, null, null, null, null);
    }

    public void add(String name, int cows, int bull) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME_PLAYER, name);
        cv.put(COLUMN_NUMBER_COWS, cows);
        cv.put(COLUMN_NUMBER_BULL, bull);
        mDB.insert(DB_TABLE, null, cv);
    }

    private class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name, CursorFactory factory,
                        int version) {
            super(context, name, factory, version);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DB_CREATE);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub

        }

    }

}


