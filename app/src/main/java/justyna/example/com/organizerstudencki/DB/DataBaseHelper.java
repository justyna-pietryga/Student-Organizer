package justyna.example.com.organizerstudencki.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "subjects.db";
    private static final int DATABASE_VERSION = 1;

    public static final String SUBJECTS_TABLE = "subjects";
    public static final String LESSONS_TABLE = "lessons";
    public static final String LECTURE_TABLE = "lecture";
    public static final String EXERCISE_TABLE = "exercise";
    public static final String LABORATORY_TABLE = "laboratory";
    public static final String ROOM_TABLE = "room";
    public static final String TERM_TABLE = "term";

    public static final String ID_COLUMN = "id";
    public static final String NAME_COLUMN = "name";
    public static final String LESSONS_ID = "lessons_id";
    public static final String LECTURE_ID = "lessons_id";
    public static final String EXERCISE_ID = "lessons_id";
    public static final String LABORATORY_ID = "lessons_id";
    public static final String ROOM_ID = "room_id";
    public static final String TERM_ID = "term_id";
    public static final String TEACHER_COLUMN = "teacher";
    public static final String ROOM_NAME_COLUMN = "room_name";


   /* public static final String CREATE_SUBJECTS_TABLE = "CREATE TABLE "
            + SUBJECTS_TABLE + "(" + ID_COLUMN + " INTEGER PRIMARY KEY, "
            + NAME_COLUMN + " TEXT, " + LESSONS_ID + " INT, "
            + "FOREIGN KEY(" + LESSONS_ID + ") REFERENCES "
            + LESSONS_TABLE + "(id) " + ")";

    public static final String CREATE_LESSONS_TABLE = "CREATE TABLE "
            + LESSONS_TABLE + "(" + ID_COLUMN + " INTEGER PRIMARY KEY, "
            + LECTURE_ID + " INT, "
            + "FOREIGN KEY(" + LECTURE_ID + ") REFERENCES "
            + LECTURE_TABLE + "(id) "
            + EXERCISE_ID + " INT, "
            + "FOREIGN KEY(" + EXERCISE_ID + ") REFERENCES "
            + EXERCISE_TABLE + "(id) "
            + LABORATORY_ID + " INT, "
            + "FOREIGN KEY(" + LABORATORY_ID + ") REFERENCES "
            + LABORATORY_TABLE + "(id) " + ")";

            */

    public static final String CREATE_LECTURE_TABLE = "CREATE TABLE "
            + LECTURE_TABLE + "(" + ID_COLUMN + " INTEGER PRIMARY KEY, "
            + TEACHER_COLUMN + " TEXT, " + ROOM_ID + " INT, "
            + "FOREIGN KEY(" + ROOM_ID + ") REFERENCES "
            + ROOM_TABLE + "(id) "
            //+ TERM_ID + " INT, "
            //+ "FOREIGN KEY(" + TERM_ID + ") REFERENCES "
            //+ TERM_TABLE + "(id) "
            + ")";

   /*  public static final String CREATE_EXERCISE_TABLE = "CREATE TABLE "
            + EXERCISE_TABLE + "(" + ID_COLUMN + " INTEGER PRIMARY KEY, "
            + TEACHER_COLUMN + " TEXT, " + ROOM_ID + " INT, "
            + "FOREIGN KEY(" + ROOM_ID + ") REFERENCES "
            + ROOM_TABLE + "(id) "
            //+ TERM_ID + " INT, "
            //+ "FOREIGN KEY(" + TERM_ID + ") REFERENCES "
            //+ TERM_TABLE + "(id) "
            + ")";

    public static final String CREATE_LABORATORY_TABLE = "CREATE TABLE "
            + LABORATORY_TABLE + "(" + ID_COLUMN + " INTEGER PRIMARY KEY, "
            + TEACHER_COLUMN + " TEXT, " + ROOM_ID + " INT, "
            + "FOREIGN KEY(" + ROOM_ID + ") REFERENCES "
            + ROOM_TABLE + "(id) "
           // + TERM_ID + " INT, "
           // + "FOREIGN KEY(" + TERM_ID + ") REFERENCES "
           // + TERM_TABLE + "(id) "
            + ")"; */

    public static final String CREATE_ROOM_TABLE = "CREATE TABLE "
            + ROOM_TABLE + "(" + ID_COLUMN + " INTEGER PRIMARY KEY, "
            + ROOM_NAME_COLUMN + " TEXT " + ")";

    //public static final String CREATE_TERM_TABLE = "CREATE TABLE "
    //        + TERM_TABLE + "(" + ID_COLUMN + " INTEGER PRIMARY KEY, "
    //        + ROOM_NAME_COLUMN + " TEXT, "
    //        + ")";

    private static DataBaseHelper instance;

    public static synchronized DataBaseHelper getHelper(Context context) {
        if (instance == null)
            instance = new DataBaseHelper(context);
        return instance;
    }

    private DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            // Enable foreign key constraints
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ROOM_TABLE);
        db.execSQL(CREATE_LECTURE_TABLE);
      //  db.execSQL(CREATE_EXERCISE_TABLE);
      //  db.execSQL(CREATE_LABORATORY_TABLE);
       // db.execSQL(CREATE_LESSONS_TABLE);
        //db.execSQL(CREATE_SUBJECTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
