package com.example.masterapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "myDB";
    private static final String TABLE_NAME = "REGISTRATION";
    private static final String REG_NO = "REG_NO";
    private static final String STU_NAME = "STU_NAME";
    private static final String PWD = "PWD";
    private static final String DOB = "DOB";
    private static final String EMAIL = "EMAIL";
    private static final String PH_NO = "PH_NO";
    private static final String STATE = "STATE";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating tables
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createStuRegTable = "CREATE TABLE " + TABLE_NAME + "(" +
                REG_NO + " INT PRIMARY KEY, " +
                STU_NAME + " VARCHAR(100) NOT NULL, " +
                PWD + " VARCHAR(16) NOT NULL, " +
                DOB + " DATE, " +
                EMAIL + " VARCHAR(30) UNIQUE NOT NULL, " +
                PH_NO + " CHAR(10) UNIQUE NOT NULL, " +
                STATE + " VARCHAR(30) " +
                ");";
        sqLiteDatabase.execSQL(createStuRegTable);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME); // dropping tables if they already exist
        onCreate(sqLiteDatabase); // create tables again
    }

    // add new student registration record
    public void addStudentRegistration(StudentRegistration studentRegistration) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(REG_NO, studentRegistration.get_reg_no());
        values.put(STU_NAME, studentRegistration.get_stu_name());
        values.put(PWD, studentRegistration.get_pwd());
        values.put(DOB, studentRegistration.get_dob());
        values.put(EMAIL, studentRegistration.get_email());
        values.put(PH_NO, studentRegistration.get_ph_no());
        values.put(STATE, studentRegistration.get_state());

        database.insert(TABLE_NAME, null, values); // inserting a row
        database.close(); // closing the database
    }

    // retrieving a single contact
    public StudentRegistration getStudentRegistration(int reg_no) {
        SQLiteDatabase database = this.getReadableDatabase();

        Cursor cursor = database.query(TABLE_NAME
                , new String[] {REG_NO, STU_NAME, PWD, DOB, EMAIL, PH_NO, STATE}
                , REG_NO + "=?"
                , new String[] { String.valueOf(reg_no) }
                , null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        assert cursor != null;
        StudentRegistration studentRegistration = new StudentRegistration(
                Integer.parseInt(cursor.getString(0))
                , cursor.getString(1)
                , cursor.getString(2)
                , cursor.getString(3)
                , cursor.getString(4)
                , cursor.getString(5)
                , cursor.getString(6)
        );

        cursor.close();

        return studentRegistration;
    }

    // retrieving all contacts
    public List<StudentRegistration> getAllStudentRegistration() {
        List<StudentRegistration> registrationList = new ArrayList<>();

        // select all query
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);

        // looping through all rows to add to the list
        if (cursor.moveToFirst()) {
            do {
                StudentRegistration studentRegistration = new StudentRegistration();
                studentRegistration.set_reg_no(Integer.parseInt(cursor.getString(0)));
                studentRegistration.set_stu_name(cursor.getString(1));
                studentRegistration.set_pwd(cursor.getString(2));
                studentRegistration.set_dob(cursor.getString(3));
                studentRegistration.set_email(cursor.getString(4));
                studentRegistration.set_ph_no(cursor.getString(5));
                studentRegistration.set_state(cursor.getString(6));

                // add records to list
                registrationList.add(studentRegistration);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return registrationList;
    }

    // code to update the list based on registration number
    public int updateStudentRegistration(StudentRegistration studentRegistration) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(REG_NO, studentRegistration.get_reg_no());
        values.put(STU_NAME, studentRegistration.get_stu_name());
        values.put(PWD, studentRegistration.get_pwd());
        values.put(DOB, studentRegistration.get_dob());
        values.put(EMAIL, studentRegistration.get_email());
        values.put(PH_NO, studentRegistration.get_ph_no());
        values.put(STATE, studentRegistration.get_state());

        // updating a row based on registration number
        return database.update(TABLE_NAME, values, REG_NO + "=?"
                , new String[] { String.valueOf(studentRegistration.get_reg_no())});
    }

    // deleting based on registration number
    public void deleteStudentRegistration(StudentRegistration studentRegistration) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLE_NAME, REG_NO + "=?"
                , new String[] { String.valueOf(studentRegistration.get_reg_no()) });
        database.close();
    }

    // get the count of records
    public int getStudentRegistrationCount() {
        String countQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }
}
