package justyna.example.com.organizerstudencki.DB;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import justyna.example.com.organizerstudencki.SubjectsOption.Room;

public class RoomDAO extends SubjectsDBDAO {

    private static final String WHERE_ID_EQUALS = DataBaseHelper.ID_COLUMN
            + " =?";

    public RoomDAO(Context context) {
        super(context);
    }

    public long save(Room room) {
        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.ROOM_NAME_COLUMN, room.getNumber());

        return database.insert(DataBaseHelper.ROOM_TABLE, null, values);
    }

    public long update(Room room) {
        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.ROOM_NAME_COLUMN, room.getNumber());

        long result = database.update(DataBaseHelper.ROOM_TABLE, values,
                WHERE_ID_EQUALS,
                new String[] { String.valueOf(room.getId()) });
        Log.d("Update Result:", "=" + result);
        return result;

    }

    public int deleteRoom(Room room) {
        return database.delete(DataBaseHelper.ROOM_TABLE,
                WHERE_ID_EQUALS, new String[] { room.getId() + "" });
    }

    public List<Room> getRooms() {
        List<Room> rooms = new ArrayList<Room>();
        Cursor cursor = database.query(DataBaseHelper.ROOM_TABLE,
                new String[] { DataBaseHelper.ID_COLUMN,
                        DataBaseHelper.ROOM_NAME_COLUMN }, null, null, null, null,
                null);

        while (cursor.moveToNext()) {
            Room room = new Room();
            room.setId(cursor.getInt(0));
            room.setNumber(cursor.getString(1));
            rooms.add(room);
        }
        return rooms;
    }

    public void loadRoom(Room room) {

            ContentValues values = new ContentValues();
            values.put(DataBaseHelper.ROOM_NAME_COLUMN, room.getNumber());
            database.insert(DataBaseHelper.ROOM_TABLE, null, values);

    }
}
