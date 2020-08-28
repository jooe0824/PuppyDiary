package org.techtown.puppydiary;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class DBHelper extends SQLiteOpenHelper {

    Cursor cursor = null;
    Cursor cursor2 = null;

    // DBHelper 생성자로 관리할 DB 이름과 버전 정보를 받음
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    // DB 업그레이드를 위해 버전이 변경될 때 호출되는 함수
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // DB를 새로 생성할 때 호출되는 함수
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 새로운 테이블 생성
        /* 이름은 EDITMEMO, position 나타내는 primary key, 메모 내용 받는 문자열 */
        db.execSQL("CREATE TABLE IF NOT EXISTS AAA (pos INTEGER, text TEXT, image_byte BLOB, waterdrop INTEGER, injection INTEGER);");

    }


    public void insert(int pos, String text, byte[] image_byte, int waterdrop, int injection) {
        // 읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = getWritableDatabase();
        // DB에 입력한 값으로 행 추가
        db.execSQL("INSERT OR REPLACE INTO AAA(pos, text, waterdrop, injection) VALUES(" + pos + ", '" + text + "', " + waterdrop + ", " + injection + ");");
        SQLiteStatement sql = db.compileStatement("INSERT OR REPLACE INTO AAA(image_byte) VALUES(?);");
        if (image_byte != null) {
            sql.bindBlob(1, image_byte);
            sql.executeInsert();
        }
        System.out.println("pos : " + pos + ", text : " + text);
        System.out.println("db insert : " + image_byte);
        db.close();
    }

    public String getResult(int pos) {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용
        cursor = db.rawQuery("SELECT text from AAA WHERE pos = " + pos + ";", null);

        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                result = cursor.getString(cursor.getColumnIndex("text"));
                System.out.println("result : " + result);
            }
        }
        cursor.close();
        db.close();
        return result;
    }

    public int getResult_state(int pos) {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        int resultstate = 0;

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용
        cursor = db.rawQuery("SELECT waterdrop, injection from AAA WHERE pos = " + pos + ";", null);

        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                resultstate = cursor.getInt(cursor.getColumnIndex("waterdrop"));
                resultstate += cursor.getInt(cursor.getColumnIndex("injection"));
            }
        }
        System.out.println("state result : " + resultstate);
        cursor.close();
        db.close();
        return resultstate;
    }

    public byte[] getResultimg(int pos) {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        byte[] resultimg = null;

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용
        cursor2 = db.rawQuery("SELECT image_byte from AAA WHERE pos = " + pos + ";", null);

        cursor2.moveToFirst();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                resultimg = cursor2.getBlob(cursor2.getColumnIndex("image_byte"));
                System.out.println("resultpos : " + pos + ", resultimg : " + resultimg);
            }
        }

        cursor2.close();
        db.close();
        return resultimg;
    }
}