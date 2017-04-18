package justyna.example.com.organizerstudencki.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import justyna.example.com.organizerstudencki.SubjectsOption.Room;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME ="SubjectsDB";
    private static final int DB_VERSION =1;

    private static final String TABLE_ROOMS = "folders";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_ROOM_TABLE = "CREATE TABLE " + TABLE_ROOMS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_NAME + " TEXT" + ")";

        sqLiteDatabase.execSQL(CREATE_ROOM_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_ROOMS);
        // sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_VOCABULARY);
        onCreate(sqLiteDatabase);    }


    public void addRoom(Room room) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_NAME, room.getNumber()); // Contact Name

        db.insert(TABLE_ROOMS, null, values);

        db.close();
    }

    public Room getRoom(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_ROOMS, new String[]{COLUMN_ID,
                        COLUMN_NAME}, COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Room room = new Room(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1));

        return room;
    }

    public List<Room> getAllRooms() {
        List<Room> foldersList = new ArrayList<Room>();

        String selectQuery = "SELECT * FROM " + TABLE_ROOMS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Room room = new Room();
                room.setId(Integer.parseInt(cursor.getString(0)));
                room.setNumber(cursor.getString(1));
                foldersList.add(room);
            } while (cursor.moveToNext());
        }

        // return contact list
        return foldersList;
    }
}