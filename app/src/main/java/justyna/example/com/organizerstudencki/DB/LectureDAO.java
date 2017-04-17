package justyna.example.com.organizerstudencki.DB;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;

import java.util.ArrayList;
import java.util.List;

import justyna.example.com.organizerstudencki.SubjectsOption.LectureLesson;
import justyna.example.com.organizerstudencki.SubjectsOption.Room;

public class LectureDAO extends SubjectsDBDAO {

    public static final String LECTURE_ID_WITH_PREFIX = "l.id";
    public static final String LECTURE_TEACHER_WITH_PREFIX = "l.teacher";
    public static final String ROOM_NUMBER_WITH_PREFIX = "r.room_name";

    private static final String WHERE_ID_EQUALS = DataBaseHelper.ID_COLUMN + " =?";

    public LectureDAO(Context context) {
        super(context);
    }

    public long save(LectureLesson lectureLesson) {
        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.TEACHER_COLUMN, lectureLesson.getTeacher());
        values.put(DataBaseHelper.ROOM_ID, lectureLesson.getRoom().getId());

        return database.insert(DataBaseHelper.LECTURE_TABLE, null, values);
    }

   /* public ArrayList<LectureLesson> getLectureLessons() {

            ArrayList<LectureLesson> lectures = new ArrayList<>();
            String query = "SELECT " + LECTURE_ID_WITH_PREFIX + ","
                    + DataBaseHelper.TEACHER_COLUMN
                    + "," + DataBaseHelper.ROOM_ID + ","
                    + DataBaseHelper.ROOM_NAME_COLUMN + " FROM "
                    + DataBaseHelper.LECTURE_TABLE + " l, "
                    + DataBaseHelper.ROOM_TABLE + " r WHERE l."
                    + DataBaseHelper.ROOM_ID + " = r."
                    + DataBaseHelper.ID_COLUMN;

        //String query= "SELECT l.id, l.teacher, r.id, r.room_name FROM lecture l, room r WHERE l.room_id=r.id";


        Cursor cursor = database.rawQuery(query, null);
        while (cursor.moveToNext()) {
            LectureLesson lectureLesson = new LectureLesson();
            lectureLesson.setId(cursor.getInt(0));
            lectureLesson.setTeacher(cursor.getString(1));

            Room room = new Room();
            room.setId(cursor.getInt(2));
            room.setNumber(cursor.getString(3));

            lectureLesson.setRoom(room);

            lectures.add(lectureLesson);
        }


        return lectures;
    } */


    public ArrayList<LectureLesson> getLectureLessons() {
        ArrayList<LectureLesson> lectures = new ArrayList<>();
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder
                .setTables(DataBaseHelper.LECTURE_TABLE
                        + " INNER JOIN "
                        + DataBaseHelper.ROOM_TABLE
                        + " ON "
                        + DataBaseHelper.ROOM_ID
                        + " = "
                        + (DataBaseHelper.ROOM_TABLE + "." + DataBaseHelper.ID_COLUMN));

        // Get cursor
        Cursor cursor = queryBuilder.query(database, new String[]{
                        LECTURE_ID_WITH_PREFIX,
                        DataBaseHelper.LECTURE_TABLE + "."
                                + DataBaseHelper.TEACHER_COLUMN,
                        DataBaseHelper.ROOM_ID,
                        DataBaseHelper.ROOM_TABLE + "."
                                + DataBaseHelper.ROOM_NAME_COLUMN}, null, null, null, null,
                null);

        while (cursor.moveToNext()) {
            LectureLesson lectureLesson = new LectureLesson();
            lectureLesson.setId(cursor.getInt(0));
            lectureLesson.setTeacher(cursor.getString(1));

            Room room = new Room();
            room.setId(cursor.getInt(2));
            room.setNumber(cursor.getString(3));

            lectureLesson.setRoom(room);

            lectures.add(lectureLesson);
        }
        return lectures;
    }
}
